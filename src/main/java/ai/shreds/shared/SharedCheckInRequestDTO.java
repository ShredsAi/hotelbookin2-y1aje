package ai.shreds.shared; 
  
 import java.util.UUID; 
 import javax.validation.constraints.NotNull; 
 import lombok.Data; 
 import lombok.NoArgsConstructor; 
 import lombok.AllArgsConstructor; 
  
 @Data 
 @NoArgsConstructor 
 @AllArgsConstructor 
 public class SharedCheckInRequestDTO { 
      
     @NotNull 
     private UUID reservationId; 
  
     @NotNull 
     private UUID guestId; 
  
     @NotNull 
     private UUID staffId; 
  
 }