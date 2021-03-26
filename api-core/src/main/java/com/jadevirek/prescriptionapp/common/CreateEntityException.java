package src.main.java.com.jadevirek.prescriptionapp.common;

/**
 * Class for handling exception on creating data
 */
public class CreateEntityException extends RuntimeException {
    public CreateEntityException(Throwable cause) {
        super("Creating Entity - failed .There is an error with object fields", cause);
    }
}

