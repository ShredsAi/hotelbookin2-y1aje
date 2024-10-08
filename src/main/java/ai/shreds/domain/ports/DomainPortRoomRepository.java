package ai.shreds.domain.ports; 
  
 import ai.shreds.domain.entities.DomainEntityRoom; 
 import ai.shreds.shared.SharedEnumRoomStatus; 
 import java.util.Optional; 
 import java.util.UUID; 
  
 /** 
  * DomainPortRoomRepository defines the repository interface for Room entities in the domain layer. 
  * It provides methods for retrieving and manipulating room data without exposing infrastructure details. 
  */ 
 public interface DomainPortRoomRepository { 
  
     /** 
      * Finds a room by its unique identifier. 
      * 
      * @param roomId the UUID of the room to find 
      * @return an Optional containing the DomainEntityRoom if found, or empty if not found 
      */ 
     Optional<DomainEntityRoom> findById(UUID roomId); 
  
     /** 
      * Saves a new Room entity or updates an existing one. 
      * 
      * @param room the DomainEntityRoom to save 
      */ 
     void save(DomainEntityRoom room); 
  
     /** 
      * Updates the status of the room identified by roomId. 
      * 
      * @param roomId the UUID of the room to update 
      * @param status the new status of the room 
      */ 
     void updateStatus(UUID roomId, SharedEnumRoomStatus status); 
 } 
 