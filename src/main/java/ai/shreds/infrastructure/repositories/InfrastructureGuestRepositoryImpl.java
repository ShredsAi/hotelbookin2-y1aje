package ai.shreds.infrastructure.repositories;

import ai.shreds.domain.entities.DomainEntityGuest;
import ai.shreds.domain.ports.DomainPortGuestRepository;
import ai.shreds.infrastructure.entities.GuestEntity;
import ai.shreds.infrastructure.mappers.GuestMapper;
import ai.shreds.infrastructure.repositories.jpa.GuestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InfrastructureGuestRepositoryImpl implements DomainPortGuestRepository {

    private final GuestJpaRepository guestJpaRepository;
    private final GuestMapper guestMapper;

    @Autowired
    public InfrastructureGuestRepositoryImpl(GuestJpaRepository guestJpaRepository, GuestMapper guestMapper) {
        this.guestJpaRepository = guestJpaRepository;
        this.guestMapper = guestMapper;
    }

    @Override
    public Optional<DomainEntityGuest> findById(UUID guestId) {
        return guestJpaRepository.findById(guestId).map(guestMapper::toDomain);
    }

    @Override
    public void save(DomainEntityGuest guest) {
        GuestEntity guestEntity = guestMapper.toEntity(guest);
        guestJpaRepository.save(guestEntity);
    }
}