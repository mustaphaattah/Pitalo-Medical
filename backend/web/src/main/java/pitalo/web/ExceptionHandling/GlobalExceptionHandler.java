package pitalo.web.ExceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pitalo.persistence.Exceptions.NurseNotFoundException;
import pitalo.persistence.Exceptions.PatientNotFoundException;
import pitalo.persistence.Exceptions.VisitationNotFoundException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        PatientNotFoundException.class,
        VisitationNotFoundException.class,
        NurseNotFoundException.class
    })
    public ResponseEntity<?> handlePatientNotFound(Exception ex, WebRequest request) {
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



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleArgumentTypeMismatch(Exception ex, WebRequest request) {
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




    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();
        Map<String, Object> errors = bindingResult
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(err -> err.getField(), err -> err.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

