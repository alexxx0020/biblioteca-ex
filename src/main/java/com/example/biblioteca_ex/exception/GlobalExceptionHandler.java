package com.example.biblioteca_ex.exception;

import com.example.biblioteca_ex.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> findException(ResourceNotFountException er){
        ErrorResponse e = new ErrorResponse(er.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> findGenericException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> findSpecialException(MethodArgumentNotValidException exception){
        StringBuilder sb = new StringBuilder();

        exception.getBindingResult().getFieldErrors().forEach(e );

        return null;
    }
}
