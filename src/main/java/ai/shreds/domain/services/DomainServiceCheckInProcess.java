package ai.shreds.domain.services;

import ai.shreds.domain.entities.DomainEntityCheckInRecord;
import ai.shreds.domain.entities.DomainEntityGuest;
import ai.shreds.domain.entities.DomainEntityReservation;
import ai.shreds.domain.entities.DomainEntityRoom;
import ai.shreds.domain.exceptions.DomainExceptionInvalidReservation;
import ai.shreds.domain.exceptions.DomainExceptionRoomUnavailable;
import ai.shreds.domain.ports.DomainPortCheckInProcess;
import ai.shreds.domain.ports.DomainPortCheckInRecordRepository;
import ai.shreds.domain.ports.DomainPortGuestRepository;
import ai.shreds.domain.ports.DomainPortReservationRepository;
import ai.shreds.domain.ports.DomainPortRoomRepository;
import ai.shreds.shared.SharedEnumReservationStatus;
import ai.shreds.shared.SharedEnumRoomStatus;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

public class DomainServiceCheckInProcess implements DomainPortCheckInProcess {

    private final DomainPortReservationRepository reservationRepository;
    private final DomainPortGuestRepository guestRepository;
    private final DomainPortRoomRepository roomRepository;
    private final DomainPortCheckInRecordRepository checkInRecordRepository;

    public DomainServiceCheckInProcess(DomainPortReservationRepository reservationRepository,
                                       DomainPortGuestRepository guestRepository,
                                       DomainPortRoomRepository roomRepository,
                                       DomainPortCheckInRecordRepository checkInRecordRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.checkInRecordRepository = checkInRecordRepository;
    }

    @Override
    public DomainEntityCheckInRecord processCheckIn(UUID reservationId, UUID guestId, UUID staffId) throws DomainExceptionInvalidReservation, DomainExceptionRoomUnavailable {
        Optional<DomainEntityReservation> reservationOpt = reservationRepository.findById(reservationId);
        if (!reservationOpt.isPresent()) {
            throw new DomainExceptionInvalidReservation("Reservation not found.");
        }
        DomainEntityReservation reservation = reservationOpt.get();

        if (reservation.getStatus() != SharedEnumReservationStatus.BOOKED) {
            throw new DomainExceptionInvalidReservation("Reservation is not eligible for check-in.");
        }

        if (!reservation.getGuestId().equals(guestId)) {
            throw new DomainExceptionInvalidReservation("Guest ID does not match the reservation.");
        }

        LocalDateTime scheduledCheckInDate = reservation.getCheckInDate().toLocalDateTime();
        LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        if (currentDateTime.isBefore(scheduledCheckInDate)) {
            throw new DomainExceptionInvalidReservation("Check-in is not allowed before the scheduled check-in date and time.");
        }

        Optional<DomainEntityGuest> guestOpt = guestRepository.findById(guestId);
        if (!guestOpt.isPresent()) {
            throw new DomainExceptionInvalidReservation("Guest not found.");
        }
        DomainEntityGuest guest = guestOpt.get();

        UUID roomId = reservation.getRoomId();
        Optional<DomainEntityRoom> roomOpt = roomRepository.findById(roomId);
        if (!roomOpt.isPresent()) {
            throw new DomainExceptionRoomUnavailable("Room not found.");
        }
        DomainEntityRoom room = roomOpt.get();

        if (room.getStatus() != SharedEnumRoomStatus.AVAILABLE) {
            throw new DomainExceptionRoomUnavailable("Room is not available.");
        }

        reservation.setStatus(SharedEnumReservationStatus.CHECKED_IN);
        reservationRepository.save(reservation);

        room.setStatus(SharedEnumRoomStatus.OCCUPIED);
        roomRepository.save(room);

        DomainEntityCheckInRecord checkInRecord = new DomainEntityCheckInRecord();
        checkInRecord.setCheckInId(UUID.randomUUID());
        checkInRecord.setReservation(reservation);
        checkInRecord.setGuest(guest);
        checkInRecord.setRoom(room);
        checkInRecord.setCheckInTime(Timestamp.from(Instant.now()));
        checkInRecord.setStaffId(staffId);

        checkInRecordRepository.save(checkInRecord);

        return checkInRecord;
    }
}