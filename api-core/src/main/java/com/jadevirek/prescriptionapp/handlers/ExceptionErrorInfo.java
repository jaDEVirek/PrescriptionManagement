package src.main.java.com.jadevirek.prescriptionapp.handlers;

import src.main.java.com.jadevirek.prescriptionapp.common.CreateEntityException;

/**
 * ExceptionErrorInfo immutable class is used to holding output information about an Error
 */
public final class ExceptionErrorInfo {

    private static ExceptionErrorInfo thisInstance;
    private final String error;
    public ExceptionErrorInfo(String error) {
        this.error = error;
    }

    public static ExceptionErrorInfo getInstance(String cause) {
        if (thisInstance == null) {
            synchronized (CreateEntityException.class) {
                if (thisInstance == null) {
                    thisInstance = new ExceptionErrorInfo(cause);
                }
            }
        }
        return thisInstance;
    }

    public String getError() {
        return error;
    }
}
