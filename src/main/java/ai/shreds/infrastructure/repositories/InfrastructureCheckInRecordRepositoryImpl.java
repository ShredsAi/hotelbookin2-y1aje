package ai.shreds.infrastructure.repositories; 
  
 import ai.shreds.domain.entities.DomainEntityCheckInRecord; 
 import ai.shreds.domain.ports.DomainPortCheckInRecordRepository; 
 import ai.shreds.infrastructure.entities.InfrastructureCheckInRecordEntity; 
 import ai.shreds.infrastructure.mappers.InfrastructureCheckInRecordMapper; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Repository; 
  
 import java.util.Optional; 
 import java.util.UUID; 
  
 @Repository 
 public class InfrastructureCheckInRecordRepositoryImpl implements DomainPortCheckInRecordRepository { 
  
     private final CheckInRecordJpaRepository checkInRecordJpaRepository; 
     private final InfrastructureCheckInRecordMapper checkInRecordMapper; 
  
     @Autowired 
     public InfrastructureCheckInRecordRepositoryImpl(CheckInRecordJpaRepository checkInRecordJpaRepository, 
                                                      InfrastructureCheckInRecordMapper checkInRecordMapper) { 
         this.checkInRecordJpaRepository = checkInRecordJpaRepository; 
         this.checkInRecordMapper = checkInRecordMapper; 
     } 
  
     @Override 
     public void save(DomainEntityCheckInRecord checkInRecord) { 
         InfrastructureCheckInRecordEntity entity = checkInRecordMapper.toEntity(checkInRecord); 
         checkInRecordJpaRepository.save(entity); 
     } 
  
     @Override 
     public Optional<DomainEntityCheckInRecord> findById(UUID checkInId) { 
         Optional<InfrastructureCheckInRecordEntity> entityOptional = checkInRecordJpaRepository.findById(checkInId); 
         return entityOptional.map(checkInRecordMapper::toDomain); 
     } 
  
     @Override 
     public Optional<DomainEntityCheckInRecord> findByReservationId(UUID reservationId) { 
         Optional<InfrastructureCheckInRecordEntity> entityOptional = checkInRecordJpaRepository.findByReservationId(reservationId); 
         return entityOptional.map(checkInRecordMapper::toDomain); 
     } 
 } 
 