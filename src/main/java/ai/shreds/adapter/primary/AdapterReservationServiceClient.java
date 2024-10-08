package ai.shreds.adapter.primary;

import ai.shreds.application.ports.ApplicationReservationServicePort;
import ai.shreds.shared.SharedReservationDTO;
import ai.shreds.shared.SharedEnumReservationStatus;
import ai.shreds.adapter.exceptions.AdapterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class AdapterReservationServiceClient implements ApplicationReservationServicePort {

    private final ReservationServiceFeignClient reservationServiceFeignClient;

    @Autowired
    public AdapterReservationServiceClient(ReservationServiceFeignClient reservationServiceFeignClient) {
        this.reservationServiceFeignClient = reservationServiceFeignClient;
    }

    @Override
    public SharedReservationDTO validateReservation(UUID reservationId) {
        try {
            return reservationServiceFeignClient.getReservationById(reservationId);
        } catch (Exception e) {
            throw new AdapterException("Error validating reservation with ID: " + reservationId, e);
        }
    }

    @Override
    public void updateReservationStatus(UUID reservationId, SharedEnumReservationStatus status) {
        try {
            reservationServiceFeignClient.updateReservationStatus(reservationId, status);
        } catch (Exception e) {
            throw new AdapterException("Error updating reservation status for ID: " + reservationId, e);
        }
    }
}