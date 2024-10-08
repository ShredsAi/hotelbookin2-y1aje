package ai.shreds.adapter.primary;

import ai.shreds.application.ports.ApplicationRoomServicePort;
import ai.shreds.shared.SharedRoomDTO;
import ai.shreds.shared.SharedEnumRoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import lombok.Data;

@Component
public class AdapterRoomServiceClient implements ApplicationRoomServicePort {

    @Autowired
    private RoomServiceFeignClient roomServiceFeignClient;

    @Override
    public void updateRoomStatus(UUID roomId, SharedEnumRoomStatus status) {
        RoomStatusUpdateRequest request = new RoomStatusUpdateRequest();
        request.setStatus(status);
        roomServiceFeignClient.updateRoomStatus(roomId, request);
    }

    @Override
    public SharedRoomDTO getRoomDetails(UUID roomId) {
        return roomServiceFeignClient.getRoomDetails(roomId);
    }
}

@FeignClient(name = "room-service")
interface RoomServiceFeignClient {

    @PutMapping("/rooms/{roomId}/status")
    void updateRoomStatus(@PathVariable("roomId") UUID roomId, @RequestBody RoomStatusUpdateRequest request);

    @GetMapping("/rooms/{roomId}")
    SharedRoomDTO getRoomDetails(@PathVariable("roomId") UUID roomId);
}

@Data
class RoomStatusUpdateRequest {
    private SharedEnumRoomStatus status;
}