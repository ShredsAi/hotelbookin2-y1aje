package ai.shreds.domain.ports; 
  
 import ai.shreds.domain.entities.DomainEntityGuest; 
  
 import java.util.Optional; 
 import java.util.UUID; 
  
 public interface DomainPortGuestRepository { 
      
     /** 
      * Retrieves a guest entity by its unique identifier. 
      *  
      * @param guestId the UUID of the guest to retrieve 
      * @return an Optional containing the DomainEntityGuest if found, otherwise empty 
      */ 
     Optional<DomainEntityGuest> findById(UUID guestId); 
  
     /** 
      * Saves or updates a guest entity in the data store. 
      *  
      * @param guest the DomainEntityGuest to save 
      */ 
     void save(DomainEntityGuest guest); 
 } 
 