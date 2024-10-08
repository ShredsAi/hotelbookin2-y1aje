package ai.shreds.domain.entities; 
  
 import java.math.BigDecimal; 
 import java.util.ArrayList; 
 import java.util.List; 
 import java.util.UUID; 
  
 import ai.shreds.shared.SharedEnumRoomStatus; 
  
 public class DomainEntityRoom { 
     private UUID roomId; 
     private String roomNumber; 
     private String type; 
     private List<String> amenities; 
     private SharedEnumRoomStatus status; 
     private BigDecimal price; 
  
     public DomainEntityRoom() { 
         this.amenities = new ArrayList<>(); 
     } 
  
     public DomainEntityRoom(UUID roomId, String roomNumber, String type, List<String> amenities, SharedEnumRoomStatus status, BigDecimal price) { 
         this.roomId = roomId; 
         this.roomNumber = roomNumber; 
         this.type = type; 
         this.amenities = amenities; 
         this.status = status; 
         this.price = price; 
     } 
  
     public UUID getRoomId() { 
         return roomId; 
     } 
  
     public void setRoomId(UUID roomId) { 
         this.roomId = roomId; 
     } 
  
     public String getRoomNumber() { 
         return roomNumber; 
     } 
  
     public void setRoomNumber(String roomNumber) { 
         this.roomNumber = roomNumber; 
     } 
  
     public String getType() { 
         return type; 
     } 
  
     public void setType(String type) { 
         this.type = type; 
     } 
  
     public List<String> getAmenities() { 
         return amenities; 
     } 
  
     public void setAmenities(List<String> amenities) { 
         this.amenities = amenities; 
     } 
  
     public SharedEnumRoomStatus getStatus() { 
         return status; 
     } 
  
     public void setStatus(SharedEnumRoomStatus status) { 
         this.status = status; 
     } 
  
     public BigDecimal getPrice() { 
         return price; 
     } 
  
     public void setPrice(BigDecimal price) { 
         this.price = price; 
     } 
 } 
 