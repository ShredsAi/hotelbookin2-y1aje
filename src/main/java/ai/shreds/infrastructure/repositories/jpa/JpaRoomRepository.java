package ai.shreds.infrastructure.repositories.jpa;

import ai.shreds.infrastructure.repositories.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaRoomRepository extends JpaRepository<RoomEntity, UUID> {
    // No additional methods are required unless specified by business logic.
}