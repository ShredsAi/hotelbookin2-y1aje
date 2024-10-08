package ai.shreds.shared; 
  
 import lombok.Data; 
 import lombok.AllArgsConstructor; 
 import lombok.NoArgsConstructor; 
 import java.time.Instant; 
  
 @Data 
 @AllArgsConstructor 
 @NoArgsConstructor 
 public class SharedCheckInResponseDTO { 
     private String message; 
     private SharedRoomDTO roomDetails; 
     private Instant checkInTime; 
 }