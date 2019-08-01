package pitalo.web.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import pitalo.persistence.Exceptions.PatientNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(PatientNotFoundException ex, WebRequest request) {
        String uriPath = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiErrorResponse response = ApiErrorResponse
            .builder()
            .path(uriPath)
            .message(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND)
            .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        String uriPath = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiErrorResponse response = ApiErrorResponse
            .builder()
            .path(uriPath)
            .message(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST)
            .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

