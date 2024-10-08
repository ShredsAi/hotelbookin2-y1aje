package ai.shreds.application.ports; 
  
 import ai.shreds.shared.SharedEnumRoomStatus; 
 import ai.shreds.shared.SharedRoomDTO; 
 import java.util.UUID; 
  
 /** 
  * ApplicationRoomServicePort defines the interface for room-related operations in the application layer. 
  */ 
 public interface ApplicationRoomServicePort { 
  
     /** 
      * Updates the status of a room. 
      * 
      * @param roomId the unique identifier of the room 
      * @param status the new status to set for the room 
      */ 
     void updateRoomStatus(UUID roomId, SharedEnumRoomStatus status); 
  
     /** 
      * Retrieves the details of a specific room. 
      * 
      * @param roomId the unique identifier of the room 
      * @return the room details in a SharedRoomDTO object 
      */ 
     SharedRoomDTO getRoomDetails(UUID roomId); 
 } 
 