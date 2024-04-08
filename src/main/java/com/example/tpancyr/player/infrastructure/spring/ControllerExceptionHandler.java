package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<?> handleNotFoundException(NotFoundException e){
        return ResponseEntity.notFound().build();
    }
}
