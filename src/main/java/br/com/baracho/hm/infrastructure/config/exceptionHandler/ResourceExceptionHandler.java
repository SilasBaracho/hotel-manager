package br.com.baracho.hm.infrastructure.config.exceptionHandler;

import br.com.baracho.hm.infrastructure.config.exceptionHandler.model.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(
        IllegalArgumentException e,
        HttpServletRequest request
    ){
        var httpStatus = HttpStatus.BAD_REQUEST;
        var exception = new StandardError(
            httpStatus.value(),
            httpStatus.name(),
            e.getMessage(),
            request.getServletPath(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(httpStatus).body(exception);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(
        BadRequestException e,
        HttpServletRequest request
    ){
        var httpStatus = HttpStatus.BAD_REQUEST;
        var exception = new StandardError(
            httpStatus.value(),
            httpStatus.name(),
            e.getMessage(),
            request.getServletPath(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(httpStatus).body(exception);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(
        NotFoundException e,
        HttpServletRequest request
    ){
        var httpStatus = HttpStatus.NOT_FOUND;
        var exception = new StandardError(
            httpStatus.value(),
            httpStatus.name(),
            e.getMessage(),
            request.getServletPath(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(httpStatus).body(exception);
    }
}
