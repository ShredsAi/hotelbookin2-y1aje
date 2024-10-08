package ai.shreds.domain.exceptions;

/**
 * Exception thrown when a reservation with a specified ID cannot be found.
 */
public class ReservationNotFoundException extends RuntimeException {

    /**
     * Constructs a new ReservationNotFoundException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public ReservationNotFoundException(String message) {
        super(message);
    }
}