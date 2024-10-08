package ai.shreds.adapter.primary; 
  
 import ai.shreds.application.ports.ApplicationRoomServicePort; 
 import ai.shreds.shared.SharedRoomDTO; 
 import ai.shreds.shared.SharedEnumRoomStatus; 
  
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Component; 
  
 import org.springframework.cloud.openfeign.FeignClient; 
 import org.springframework.web.bind.annotation.*; 
  
 import java.util.UUID; 
  
 import lombok.Data; 
  
 @Component 
 public class AdapterRoomServiceClient implements ApplicationRoomServicePort { 
  
     @Autowired 
     private RoomServiceFeignClient roomServiceFeignClient; 
  
     @Override 
     public void updateRoomStatus(UUID roomId, SharedEnumRoomStatus status) { 
         // Create a request object with the new status 
         RoomStatusUpdateRequest request = new RoomStatusUpdateRequest(); 
         request.setStatus(status); 
  
         // Call the FeignClient method to update room status 
         roomServiceFeignClient.updateRoomStatus(roomId, request); 
     } 
  
     @Override 
     public SharedRoomDTO getRoomDetails(UUID roomId) { 
         // Call the FeignClient method to retrieve room details 
         return roomServiceFeignClient.getRoomDetails(roomId); 
     } 
  
     // FeignClient interface for communicating with the Room Service 
     @FeignClient(name = 'room-service') 
     interface RoomServiceFeignClient { 
  
         @PutMapping('/rooms/{roomId}/status') 
         void updateRoomStatus(@PathVariable('roomId') UUID roomId, @RequestBody RoomStatusUpdateRequest request); 
  
         @GetMapping('/rooms/{roomId}') 
         SharedRoomDTO getRoomDetails(@PathVariable('roomId') UUID roomId); 
     } 
  
     // DTO for the room status update request 
     @Data 
     static class RoomStatusUpdateRequest { 
         private SharedEnumRoomStatus status; 
     } 
 } 
 