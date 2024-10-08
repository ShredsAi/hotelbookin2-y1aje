package ai.shreds.infrastructure.repositories.jpa;

import ai.shreds.infrastructure.entities.InfrastructureCheckInRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface CheckInRecordJpaRepository extends JpaRepository<InfrastructureCheckInRecordEntity, UUID> {

    Optional<InfrastructureCheckInRecordEntity> findByReservationId(UUID reservationId);
}