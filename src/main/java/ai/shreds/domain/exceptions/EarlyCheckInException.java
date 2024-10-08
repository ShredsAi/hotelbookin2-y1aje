package ai.shreds.domain.exceptions;

/**
 * Exception thrown when an attempt is made to check in before the scheduled check-in date and time.
 */
public class EarlyCheckInException extends RuntimeException {

    /**
     * Constructs a new EarlyCheckInException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public EarlyCheckInException(String message) {
        super(message);
    }
}