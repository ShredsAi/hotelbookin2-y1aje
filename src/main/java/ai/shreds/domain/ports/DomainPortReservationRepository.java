package ai.shreds.domain.ports; 
  
 import ai.shreds.domain.entities.DomainEntityReservation; 
 import ai.shreds.shared.enums.SharedEnumReservationStatus; 
 import java.util.Optional; 
 import java.util.UUID; 
  
 public interface DomainPortReservationRepository { 
  
     Optional<DomainEntityReservation> findById(UUID reservationId); 
  
     void save(DomainEntityReservation reservation); 
  
     void updateStatus(UUID reservationId, SharedEnumReservationStatus status); 
  
 }