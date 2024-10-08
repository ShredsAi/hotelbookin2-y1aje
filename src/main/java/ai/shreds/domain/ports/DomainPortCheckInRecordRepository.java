package ai.shreds.domain.ports; 
  
 import ai.shreds.domain.entities.DomainEntityCheckInRecord; 
 import java.util.Optional; 
 import java.util.UUID; 
  
 public interface DomainPortCheckInRecordRepository { 
  
     void save(DomainEntityCheckInRecord checkInRecord); 
  
     Optional<DomainEntityCheckInRecord> findById(UUID checkInId); 
  
     Optional<DomainEntityCheckInRecord> findByReservationId(UUID reservationId); 
  
 }