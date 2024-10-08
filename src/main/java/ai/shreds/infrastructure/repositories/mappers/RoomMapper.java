package ai.shreds.infrastructure.repositories.mappers;

import ai.shreds.domain.entities.DomainEntityRoom;
import ai.shreds.infrastructure.repositories.entities.RoomEntity;
import ai.shreds.shared.SharedEnumRoomStatus;
import java.util.ArrayList;
import java.util.List;

public class RoomMapper {

    public DomainEntityRoom toDomainEntityRoom(RoomEntity roomEntity) {
        if (roomEntity == null) {
            return null;
        }
        DomainEntityRoom domainEntityRoom = new DomainEntityRoom();
        domainEntityRoom.setRoomId(roomEntity.getRoomId());
        domainEntityRoom.setRoomNumber(roomEntity.getRoomNumber());
        domainEntityRoom.setType(roomEntity.getType());
        domainEntityRoom.setAmenities(new ArrayList<>(roomEntity.getAmenities()));
        domainEntityRoom.setStatus(Enum.valueOf(SharedEnumRoomStatus.class, roomEntity.getStatus()));
        domainEntityRoom.setPrice(roomEntity.getPrice());
        return domainEntityRoom;
    }

    public RoomEntity toRoomEntity(DomainEntityRoom domainEntityRoom) {
        if (domainEntityRoom == null) {
            return null;
        }
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(domainEntityRoom.getRoomId());
        roomEntity.setRoomNumber(domainEntityRoom.getRoomNumber());
        roomEntity.setType(domainEntityRoom.getType());
        roomEntity.setAmenities(new ArrayList<>(domainEntityRoom.getAmenities()));
        roomEntity.setStatus(domainEntityRoom.getStatus().name());
        roomEntity.setPrice(domainEntityRoom.getPrice());
        return roomEntity;
    }
}