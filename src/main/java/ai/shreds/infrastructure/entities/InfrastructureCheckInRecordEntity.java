package ai.shreds.infrastructure.entities;

import ai.shreds.domain.entities.DomainEntityReservation;
import ai.shreds.domain.entities.DomainEntityGuest;
import ai.shreds.domain.entities.DomainEntityRoom;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "check_in_records")
public class InfrastructureCheckInRecordEntity {

    @Id
    private UUID checkInId;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private DomainEntityReservation reservation;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private DomainEntityGuest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private DomainEntityRoom room;

    private Timestamp checkInTime;

    private UUID staffId;

    // Getters and Setters

    public UUID getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(UUID checkInId) {
        this.checkInId = checkInId;
    }

    public DomainEntityReservation getReservation() {
        return reservation;
    }

    public void setReservation(DomainEntityReservation reservation) {
        this.reservation = reservation;
    }

    public DomainEntityGuest getGuest() {
        return guest;
    }

    public void setGuest(DomainEntityGuest guest) {
        this.guest = guest;
    }

    public DomainEntityRoom getRoom() {
        return room;
    }

    public void setRoom(DomainEntityRoom room) {
        this.room = room;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public UUID getStaffId() {
        return staffId;
    }

    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }
}