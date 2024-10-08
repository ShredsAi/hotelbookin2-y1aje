package ai.shreds.infrastructure.repositories.jpa;

import ai.shreds.infrastructure.entities.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface GuestJpaRepository extends JpaRepository<GuestEntity, UUID> {
}