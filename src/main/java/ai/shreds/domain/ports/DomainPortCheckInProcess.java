package ai.shreds.domain.ports; 
  
 import java.util.UUID; 
 import ai.shreds.domain.entities.DomainEntityCheckInRecord; 
  
 public interface DomainPortCheckInProcess { 
     DomainEntityCheckInRecord processCheckIn(UUID reservationId, UUID guestId, UUID staffId); 
 } 
 