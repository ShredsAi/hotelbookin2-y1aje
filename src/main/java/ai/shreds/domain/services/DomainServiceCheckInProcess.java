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
         // Step 1: Retrieve reservation 
         Optional<DomainEntityReservation> reservationOpt = reservationRepository.findById(reservationId); 
         if (!reservationOpt.isPresent()) { 
             throw new DomainExceptionInvalidReservation("Reservation not found."); 
         } 
         DomainEntityReservation reservation = reservationOpt.get(); 
  
         // Step 2: Validate reservation status 
         if (reservation.getStatus() != SharedEnumReservationStatus.BOOKED) { 
             throw new DomainExceptionInvalidReservation("Reservation is not eligible for check-in."); 
         } 
  
         // Step 3: Verify guest 
         if (!reservation.getGuestId().equals(guestId)) { 
             throw new DomainExceptionInvalidReservation("Guest ID does not match the reservation."); 
         } 
  
         // Step 4: Check check-in date 
         LocalDateTime scheduledCheckInDate = reservation.getCheckInDate().toLocalDateTime(); 
         LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC")); 
         if (currentDateTime.isBefore(scheduledCheckInDate)) { 
             throw new DomainExceptionInvalidReservation("Check-in is not allowed before the scheduled check-in date and time."); 
         } 
  
         // Step 5: Retrieve guest 
         Optional<DomainEntityGuest> guestOpt = guestRepository.findById(guestId); 
         if (!guestOpt.isPresent()) { 
             throw new DomainExceptionInvalidReservation("Guest not found."); 
         } 
         DomainEntityGuest guest = guestOpt.get(); 
  
         // Step 6: Retrieve room 
         UUID roomId = reservation.getRoomId(); 
         Optional<DomainEntityRoom> roomOpt = roomRepository.findById(roomId); 
         if (!roomOpt.isPresent()) { 
             throw new DomainExceptionRoomUnavailable("Room not found."); 
         } 
         DomainEntityRoom room = roomOpt.get(); 
  
         // Step 7: Validate room status 
         if (room.getStatus() != SharedEnumRoomStatus.AVAILABLE) { 
             throw new DomainExceptionRoomUnavailable("Room is not available."); 
         } 
  
         // Step 8: Update reservation status 
         reservation.setStatus(SharedEnumReservationStatus.CHECKED_IN); 
         reservationRepository.save(reservation); 
  
         // Step 9: Update room status 
         room.setStatus(SharedEnumRoomStatus.OCCUPIED); 
         roomRepository.save(room); 
  
         // Step 10: Create check-in record 
         DomainEntityCheckInRecord checkInRecord = new DomainEntityCheckInRecord(); 
         checkInRecord.setCheckInId(UUID.randomUUID()); 
         checkInRecord.setReservation(reservation); 
         checkInRecord.setGuest(guest); 
         checkInRecord.setRoom(room); 
         checkInRecord.setCheckInTime(Timestamp.from(Instant.now())); 
         checkInRecord.setStaffId(staffId); 
  
         // Step 11: Save check-in record 
         checkInRecordRepository.save(checkInRecord); 
  
         // Step 12: Return check-in record 
         return checkInRecord; 
     } 
 } 
 