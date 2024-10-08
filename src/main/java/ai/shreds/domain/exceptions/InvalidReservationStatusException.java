package ai.shreds.domain.exceptions;

/**
 * Exception thrown when a reservation has an invalid status for the requested operation.
 */
public class InvalidReservationStatusException extends RuntimeException {

    /**
     * Constructs a new InvalidReservationStatusException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public InvalidReservationStatusException(String message) {
        super(message);
    }
}