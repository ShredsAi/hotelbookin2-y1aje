package ai.shreds.shared; 
  
 import lombok.Data; 
 import lombok.AllArgsConstructor; 
 import lombok.NoArgsConstructor; 
  
 import java.util.UUID; 
 import java.util.Map; 
  
 @Data 
 @AllArgsConstructor 
 @NoArgsConstructor 
 public class SharedGuestDTO { 
     private UUID guestId; 
     private String name; 
     private Map<String, String> contactInformation; 
     private Map<String, String> preferences; 
 }