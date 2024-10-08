package ai.shreds.infrastructure.mappers;

import ai.shreds.domain.entities.DomainEntityGuest;
import ai.shreds.infrastructure.entities.GuestEntity;

public interface GuestMapper {

    /**
     * Maps a GuestEntity to a DomainEntityGuest.
     *
     * @param guestEntity the GuestEntity to map
     * @return the mapped DomainEntityGuest
     */
    DomainEntityGuest toDomain(GuestEntity guestEntity);

    /**
     * Maps a DomainEntityGuest to a GuestEntity.
     *
     * @param domainEntityGuest the DomainEntityGuest to map
     * @return the mapped GuestEntity
     */
    GuestEntity toEntity(DomainEntityGuest domainEntityGuest);
}