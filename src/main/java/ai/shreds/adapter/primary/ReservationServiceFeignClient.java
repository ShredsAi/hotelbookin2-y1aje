package ai.shreds.adapter.primary;

import ai.shreds.shared.SharedReservationDTO;
import ai.shreds.shared.SharedEnumReservationStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;

@FeignClient(name = "ReservationServiceFeignClient")
public interface ReservationServiceFeignClient {

    @GetMapping("/reservations/{reservationId}")
    SharedReservationDTO getReservationById(@PathVariable("reservationId") UUID reservationId);

    @PutMapping("/reservations/{reservationId}/status")
    void updateReservationStatus(@PathVariable("reservationId") UUID reservationId, 
                                 @RequestBody SharedEnumReservationStatus status);
}