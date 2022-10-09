package com.luizmangerotte.productapi.error.handler;

import com.luizmangerotte.productapi.error.StandardError;
import com.luizmangerotte.productapi.error.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException rnf,
                                                          HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new StandardError(
                Instant.now(),
                status.value(),
                error,
                rnf.getMessage(),
                request.getRequestURI()), status);
    }
}
