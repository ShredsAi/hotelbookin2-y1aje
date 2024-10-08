package ai.shreds.domain.entities;

import ai.shreds.domain.entities.DomainEntityReservation;
import ai.shreds.domain.entities.DomainEntityGuest;
import ai.shreds.domain.entities.DomainEntityRoom;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEntityCheckInRecord {
    private UUID checkInId;
    private DomainEntityReservation reservation;
    private DomainEntityGuest guest;
    private DomainEntityRoom room;
    private Timestamp checkInTime;
    private UUID staffId;
}