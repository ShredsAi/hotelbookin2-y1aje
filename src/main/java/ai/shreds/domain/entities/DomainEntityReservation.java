package ai.shreds.domain.entities; 
  
 import lombok.Data; 
 import java.util.UUID; 
 import java.sql.Timestamp; 
 import ai.shreds.shared.SharedEnumReservationStatus; 
  
 @Data 
 public class DomainEntityReservation { 
     private UUID reservationId; 
     private UUID guestId; 
     private UUID roomId; 
     private Timestamp checkInDate; 
     private Timestamp checkOutDate; 
     private SharedEnumReservationStatus status; 
 } 
 