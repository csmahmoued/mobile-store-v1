package net.store.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDestails> handleApiException(BaseException ex, WebRequest request){

        ErrorDestails errors=new ErrorDestails(ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<>(errors,ex.getStatusCode());
    }


}