package ai.shreds.application.services; 
  
 import ai.shreds.adapter.primary.AdapterRoomServiceClient; 
 import ai.shreds.application.ports.ApplicationRoomServicePort; 
 import ai.shreds.shared.SharedEnumRoomStatus; 
 import ai.shreds.shared.SharedRoomDTO; 
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
 import org.springframework.stereotype.Service; 
  
 import java.util.UUID; 
  
 @Service 
 public class ApplicationRoomService implements ApplicationRoomServicePort { 
  
     private static final Logger logger = LoggerFactory.getLogger(ApplicationRoomService.class); 
  
     private final AdapterRoomServiceClient adapterRoomServiceClient; 
  
     public ApplicationRoomService(AdapterRoomServiceClient adapterRoomServiceClient) { 
         this.adapterRoomServiceClient = adapterRoomServiceClient; 
     } 
  
     @Override 
     public void updateRoomStatus(UUID roomId, SharedEnumRoomStatus status) { 
         if (roomId == null || status == null) { 
             throw new IllegalArgumentException("roomId and status must not be null"); 
         } 
         logger.debug("Updating room status for roomId: {} to status: {}", roomId, status); 
         adapterRoomServiceClient.updateRoomStatus(roomId, status); 
     } 
  
     @Override 
     public SharedRoomDTO getRoomDetails(UUID roomId) { 
         if (roomId == null) { 
             throw new IllegalArgumentException("roomId must not be null"); 
         } 
         logger.debug("Retrieving room details for roomId: {}", roomId); 
         return adapterRoomServiceClient.getRoomDetails(roomId); 
     } 
 } 
 