package src.main.java.com.jadevirek.prescriptionapp.common;

/**
 *
 */
public class NoEtityFoundException extends RuntimeException {

    public NoEtityFoundException() {
        super("There is no Entity in database with given id.");
    }

    public NoEtityFoundException(String message) {
        super(message,null,false,false);
    }

    public NoEtityFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEtityFoundException(Throwable cause) {
        super(cause);
    }

    protected NoEtityFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
