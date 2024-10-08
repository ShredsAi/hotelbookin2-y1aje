package ai.shreds.domain.exceptions;

public class DomainExceptionInvalidReservation extends DomainException {

    public DomainExceptionInvalidReservation(String message) {
        super(message);
    }

    public DomainExceptionInvalidReservation(String message, Throwable cause) {
        super(message, cause);
    }
}