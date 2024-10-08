package ai.shreds.shared; 
  
 import java.util.UUID; 
 import java.util.List; 
 import java.math.BigDecimal; 
  
 import lombok.Data; 
  
 @Data 
 public class SharedRoomDTO { 
     private UUID roomId; 
     private String roomNumber; 
     private String type; 
     private List<String> amenities; 
     private SharedEnumRoomStatus status; 
     private BigDecimal price; 
 } 
 