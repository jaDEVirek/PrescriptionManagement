package src.main.java.com.jadevirek.prescriptionapp.common;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("There is no Entity in database with given id.");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
