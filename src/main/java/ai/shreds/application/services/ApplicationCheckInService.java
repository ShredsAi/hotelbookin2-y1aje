package ai.shreds.application.services; 
  
 import ai.shreds.application.ports.ApplicationCheckInServicePort; 
 import ai.shreds.domain.entities.DomainEntityCheckInRecord; 
 import ai.shreds.domain.ports.DomainPortCheckInProcess; 
 import ai.shreds.shared.SharedCheckInRequestDTO; 
 import ai.shreds.shared.SharedCheckInResponseDTO; 
 import ai.shreds.shared.SharedRoomDTO; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Service; 
  
 import java.util.UUID; 
  
 @Service 
 public class ApplicationCheckInService implements ApplicationCheckInServicePort { 
  
     private final DomainPortCheckInProcess domainPortCheckInProcess; 
  
     @Autowired 
     public ApplicationCheckInService(DomainPortCheckInProcess domainPortCheckInProcess) { 
         this.domainPortCheckInProcess = domainPortCheckInProcess; 
     } 
  
     @Override 
     public SharedCheckInResponseDTO checkIn(SharedCheckInRequestDTO request) { 
         // Extract parameters from request 
         UUID reservationId = request.getReservationId(); 
         UUID guestId = request.getGuestId(); 
         UUID staffId = request.getStaffId(); 
  
         // Process check-in 
         DomainEntityCheckInRecord checkInRecord = domainPortCheckInProcess.processCheckIn(reservationId, guestId, staffId); 
  
         // Map to SharedCheckInResponseDTO 
         SharedCheckInResponseDTO responseDTO = mapToSharedCheckInResponseDTO(checkInRecord); 
  
         // Return response 
         return responseDTO; 
     } 
  
     private SharedCheckInResponseDTO mapToSharedCheckInResponseDTO(DomainEntityCheckInRecord checkInRecord) { 
         SharedCheckInResponseDTO responseDTO = new SharedCheckInResponseDTO(); 
         responseDTO.setMessage("Check-in successful"); 
         responseDTO.setCheckInTime(checkInRecord.getCheckInTime()); 
  
         SharedRoomDTO roomDTO = new SharedRoomDTO(); 
         roomDTO.setRoomId(checkInRecord.getRoom().getRoomId()); 
         roomDTO.setRoomNumber(checkInRecord.getRoom().getRoomNumber()); 
         roomDTO.setType(checkInRecord.getRoom().getType()); 
         roomDTO.setAmenities(checkInRecord.getRoom().getAmenities()); 
         roomDTO.setStatus(checkInRecord.getRoom().getStatus()); 
         roomDTO.setPrice(checkInRecord.getRoom().getPrice()); 
  
         responseDTO.setRoomDetails(roomDTO); 
  
         return responseDTO; 
     } 
 } 
 