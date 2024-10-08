package ai.shreds.shared; 
  
 import java.sql.Timestamp; 
 import java.util.UUID; 
  
 import ai.shreds.shared.SharedEnumReservationStatus; 
  
 import lombok.AllArgsConstructor; 
 import lombok.Builder; 
 import lombok.Data; 
 import lombok.NoArgsConstructor; 
  
 @Data 
 @Builder 
 @NoArgsConstructor 
 @AllArgsConstructor 
 public class SharedReservationDTO { 
  
     private UUID reservationId; 
     private UUID guestId; 
     private UUID roomId; 
     private Timestamp checkInDate; 
     private Timestamp checkOutDate; 
     private SharedEnumReservationStatus status; 
  
 }