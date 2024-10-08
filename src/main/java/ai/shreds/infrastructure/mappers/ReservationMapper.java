package ai.shreds.infrastructure.mappers;

import ai.shreds.domain.entities.DomainEntityReservation;
import ai.shreds.infrastructure.entities.ReservationEntity;
import ai.shreds.shared.SharedEnumReservationStatus;

public class ReservationMapper {

    public DomainEntityReservation toDomain(ReservationEntity entity) {
        if (entity == null) {
            return null;
        }
        DomainEntityReservation domain = new DomainEntityReservation();
        domain.setReservationId(entity.getReservationId());
        domain.setGuestId(entity.getGuestId());
        domain.setRoomId(entity.getRoomId());
        domain.setCheckInDate(entity.getCheckInDate());
        domain.setCheckOutDate(entity.getCheckOutDate());
        // Convert status from String to SharedEnumReservationStatus
        domain.setStatus(SharedEnumReservationStatus.valueOf(entity.getStatus()));
        return domain;
    }

    public ReservationEntity toEntity(DomainEntityReservation domain) {
        if (domain == null) {
            return null;
        }
        ReservationEntity entity = new ReservationEntity();
        entity.setReservationId(domain.getReservationId());
        entity.setGuestId(domain.getGuestId());
        entity.setRoomId(domain.getRoomId());
        entity.setCheckInDate(domain.getCheckInDate());
        entity.setCheckOutDate(domain.getCheckOutDate());
        // Convert status from SharedEnumReservationStatus to String
        entity.setStatus(domain.getStatus().name());
        return entity;
    }
}