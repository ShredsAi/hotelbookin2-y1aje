package ai.shreds.infrastructure.mappers;

import ai.shreds.domain.entities.DomainEntityCheckInRecord;
import ai.shreds.infrastructure.entities.InfrastructureCheckInRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InfrastructureCheckInRecordMapper {

    @Mapping(target = "reservation", source = "reservation")
    @Mapping(target = "guest", source = "guest")
    @Mapping(target = "room", source = "room")
    InfrastructureCheckInRecordEntity toEntity(DomainEntityCheckInRecord domainEntity);

    @Mapping(target = "reservation", source = "reservation")
    @Mapping(target = "guest", source = "guest")
    @Mapping(target = "room", source = "room")
    DomainEntityCheckInRecord toDomain(InfrastructureCheckInRecordEntity entity);
}