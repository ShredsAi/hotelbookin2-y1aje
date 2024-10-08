package ai.shreds.domain.entities; 
  
 import lombok.Data; 
 import lombok.NoArgsConstructor; 
 import lombok.AllArgsConstructor; 
  
 import java.util.UUID; 
 import java.sql.Timestamp; 
  
 @Data 
 @NoArgsConstructor 
 @AllArgsConstructor 
 public class DomainEntityCheckInRecord { 
     private UUID checkInId; 
     private DomainEntityReservation reservation; 
     private DomainEntityGuest guest; 
     private DomainEntityRoom room; 
     private Timestamp checkInTime; 
     private UUID staffId; 
 }