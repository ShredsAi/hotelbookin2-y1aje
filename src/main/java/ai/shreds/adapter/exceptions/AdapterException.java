package ai.shreds.adapter.exceptions;

/**
 * AdapterException is a custom exception class that extends RuntimeException.
 * It is used to encapsulate exceptions that occur within the adapter layer,
 * providing a mechanism to include both a descriptive message and the original
 * cause of the exception.
 */
public class AdapterException extends RuntimeException {

    /**
     * Constructs a new AdapterException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link Throwable#getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method). 
     *              (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public AdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}