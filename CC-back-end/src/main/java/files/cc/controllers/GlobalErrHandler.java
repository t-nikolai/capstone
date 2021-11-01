package files.cc.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalErrHandler {
    @ExceptionHandler
    public ResponseEntity<String> handle(Exception ex) {
        return new ResponseEntity<>("our fault. sorry :(",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("data integrity violation.",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handle(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
                List.of(ex.getMostSpecificCause().getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
