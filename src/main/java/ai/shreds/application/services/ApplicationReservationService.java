package ai.shreds.application.services;

import ai.shreds.adapter.primary.AdapterReservationServiceClient;
import ai.shreds.application.ports.ApplicationReservationServicePort;
import ai.shreds.shared.SharedEnumReservationStatus;
import ai.shreds.shared.SharedReservationDTO;
import ai.shreds.domain.exceptions.ReservationNotFoundException;
import ai.shreds.domain.exceptions.InvalidReservationStatusException;
import ai.shreds.domain.exceptions.EarlyCheckInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ApplicationReservationService implements ApplicationReservationServicePort {

    private final AdapterReservationServiceClient reservationServiceClient;

    @Autowired
    public ApplicationReservationService(AdapterReservationServiceClient reservationServiceClient) {
        this.reservationServiceClient = reservationServiceClient;
    }

    @Override
    public SharedReservationDTO validateReservation(UUID reservationId) {
        SharedReservationDTO reservation = reservationServiceClient.validateReservation(reservationId);
        if (reservation == null) {
            throw new ReservationNotFoundException("Reservation with ID " + reservationId + " not found.");
        }
        if (!SharedEnumReservationStatus.BOOKED.equals(reservation.getStatus())) {
            throw new InvalidReservationStatusException("Reservation with ID " + reservationId + " is not eligible for check-in.");
        }
        if (reservation.getCheckInDate().toLocalDateTime().isAfter(LocalDateTime.now())) {
            throw new EarlyCheckInException("Cannot check in before the scheduled check-in date.");
        }
        return reservation;
    }

    @Override
    public void updateReservationStatus(UUID reservationId, SharedEnumReservationStatus status) {
        reservationServiceClient.updateReservationStatus(reservationId, status);
    }
}