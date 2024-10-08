package ai.shreds.infrastructure.repositories;

import ai.shreds.domain.entities.DomainEntityCheckInRecord;
import ai.shreds.domain.ports.DomainPortCheckInRecordRepository;
import ai.shreds.infrastructure.entities.InfrastructureCheckInRecordEntity;
import ai.shreds.infrastructure.mappers.InfrastructureCheckInRecordMapper;
import ai.shreds.infrastructure.repositories.jpa.CheckInRecordJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityNotFoundException;
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
        return checkInRecordJpaRepository.findById(checkInId)
                .map(checkInRecordMapper::toDomain);
    }

    @Override
    public Optional<DomainEntityCheckInRecord> findByReservationId(UUID reservationId) {
        return checkInRecordJpaRepository.findByReservationId(reservationId)
                .map(checkInRecordMapper::toDomain);
    }
}