package ai.shreds.infrastructure.repositories; 
  
 import ai.shreds.domain.entities.DomainEntityRoom; 
 import ai.shreds.domain.exceptions.DomainExceptionRoomUnavailable; 
 import ai.shreds.domain.ports.DomainPortRoomRepository; 
 import ai.shreds.infrastructure.repositories.entities.RoomEntity; 
 import ai.shreds.infrastructure.repositories.jpa.JpaRoomRepository; 
 import ai.shreds.infrastructure.repositories.mappers.RoomMapper; 
 import ai.shreds.shared.enums.SharedEnumRoomStatus; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Repository; 
  
 import java.util.Optional; 
 import java.util.UUID; 
  
 @Repository 
 public class InfrastructureRoomRepositoryImpl implements DomainPortRoomRepository { 
  
     private final JpaRoomRepository jpaRoomRepository; 
     private final RoomMapper roomMapper; 
  
     @Autowired 
     public InfrastructureRoomRepositoryImpl(JpaRoomRepository jpaRoomRepository, RoomMapper roomMapper) { 
         this.jpaRoomRepository = jpaRoomRepository; 
         this.roomMapper = roomMapper; 
     } 
  
     @Override 
     public Optional<DomainEntityRoom> findById(UUID roomId) { 
         Optional<RoomEntity> roomEntityOptional = jpaRoomRepository.findById(roomId); 
         return roomEntityOptional.map(roomMapper::toDomainEntityRoom); 
     } 
  
     @Override 
     public void save(DomainEntityRoom room) { 
         RoomEntity roomEntity = roomMapper.toRoomEntity(room); 
         jpaRoomRepository.save(roomEntity); 
     } 
  
     @Override 
     public void updateStatus(UUID roomId, SharedEnumRoomStatus status) { 
         Optional<RoomEntity> roomEntityOptional = jpaRoomRepository.findById(roomId); 
         if (roomEntityOptional.isPresent()) { 
             RoomEntity roomEntity = roomEntityOptional.get(); 
             roomEntity.setStatus(status.name()); 
             jpaRoomRepository.save(roomEntity); 
         } else { 
             throw new DomainExceptionRoomUnavailable("Room not found with id: " + roomId); 
         } 
     } 
 } 
 