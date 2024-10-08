package ai.shreds.infrastructure.repositories.jpa;

import ai.shreds.infrastructure.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, UUID> {
    // Additional query methods can be defined here if needed
}