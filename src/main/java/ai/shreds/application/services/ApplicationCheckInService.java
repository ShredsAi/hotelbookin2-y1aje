package ai.shreds.application.services;

import ai.shreds.application.ports.ApplicationCheckInServicePort;
import ai.shreds.domain.entities.DomainEntityCheckInRecord;
import ai.shreds.domain.ports.DomainPortCheckInProcess;
import ai.shreds.shared.SharedCheckInRequestDTO;
import ai.shreds.shared.SharedCheckInResponseDTO;
import ai.shreds.shared.SharedRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.UUID;
import java.sql.Timestamp;

@Service
public class ApplicationCheckInService implements ApplicationCheckInServicePort {

    private final DomainPortCheckInProcess domainPortCheckInProcess;

    @Autowired
    public ApplicationCheckInService(DomainPortCheckInProcess domainPortCheckInProcess) {
        this.domainPortCheckInProcess = Objects.requireNonNull(domainPortCheckInProcess);
    }

    @Override
    public SharedCheckInResponseDTO checkIn(SharedCheckInRequestDTO request) {
        UUID reservationId = Objects.requireNonNull(request).getReservationId();
        UUID guestId = Objects.requireNonNull(request).getGuestId();
        UUID staffId = Objects.requireNonNull(request).getStaffId();

        DomainEntityCheckInRecord checkInRecord = Objects.requireNonNull(domainPortCheckInProcess.processCheckIn(reservationId, guestId, staffId));

        return mapToSharedCheckInResponseDTO(checkInRecord);
    }

    private SharedCheckInResponseDTO mapToSharedCheckInResponseDTO(DomainEntityCheckInRecord checkInRecord) {
        SharedRoomDTO roomDTO = new SharedRoomDTO();
        roomDTO.setRoomId(checkInRecord.getRoom().getRoomId());
        roomDTO.setRoomNumber(checkInRecord.getRoom().getRoomNumber());
        roomDTO.setType(checkInRecord.getRoom().getType());
        roomDTO.setAmenities(checkInRecord.getRoom().getAmenities());
        roomDTO.setStatus(checkInRecord.getRoom().getStatus());
        roomDTO.setPrice(checkInRecord.getRoom().getPrice());

        SharedCheckInResponseDTO responseDTO = new SharedCheckInResponseDTO();
        responseDTO.setMessage("Check-in successful");
        responseDTO.setCheckInTime(new Timestamp(checkInRecord.getCheckInTime().getTime()));
        responseDTO.setRoomDetails(roomDTO);

        return responseDTO;
    }
}