package src.main.java.com.jadevirek.prescriptionapp.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import src.main.java.com.jadevirek.prescriptionapp.common.CreateEntityException;
import src.main.java.com.jadevirek.prescriptionapp.common.NoEtityFoundException;

/**
 * GlobalExceptionHandler class
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex,
            WebRequest request) {

        return handleExceptionInternal(ex, new NoEtityFoundException(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NoEtityFoundException.class)
    public ResponseEntity<Object> handleNoEntityFoundException(NoEtityFoundException ex,
            WebRequest request) {
        return handleExceptionInternal(ex, new NoEtityFoundException(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(CreateEntityException.class)
    public ResponseEntity<Object> handleCreateEntityException(CreateEntityException ex,
            WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionErrorInfo(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex,
            WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionErrorInfo(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }
}
