package ai.shreds.infrastructure.repositories;

import ai.shreds.domain.entities.DomainEntityReservation;
import ai.shreds.domain.exceptions.DomainExceptionInvalidReservation;
import ai.shreds.domain.ports.DomainPortReservationRepository;
import ai.shreds.shared.SharedEnumReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InfrastructureReservationRepositoryImpl implements DomainPortReservationRepository {

    private final ReservationJpaRepository reservationJpaRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public InfrastructureReservationRepositoryImpl(ReservationJpaRepository reservationJpaRepository,
                                                   ReservationMapper reservationMapper) {
        this.reservationJpaRepository = reservationJpaRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Optional<DomainEntityReservation> findById(UUID reservationId) {
        return reservationJpaRepository.findById(reservationId).map(reservationMapper::toDomain);
    }

    @Override
    public void save(DomainEntityReservation reservation) {
        ReservationEntity reservationEntity = reservationMapper.toEntity(reservation);
        reservationJpaRepository.save(reservationEntity);
    }

    @Override
    @Transactional
    public void updateStatus(UUID reservationId, SharedEnumReservationStatus status) {
        ReservationEntity reservationEntity = reservationJpaRepository.findById(reservationId).orElseThrow(() ->
            new DomainExceptionInvalidReservation("Reservation not found with ID: " + reservationId));
        reservationEntity.setStatus(status.name());
        reservationJpaRepository.save(reservationEntity);
    }
}