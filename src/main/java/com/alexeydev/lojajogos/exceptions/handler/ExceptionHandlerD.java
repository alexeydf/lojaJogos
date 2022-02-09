package com.alexeydev.lojajogos.exceptions.handler;

import com.alexeydev.lojajogos.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerD {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handle(MethodArgumentNotValidException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMensagem(e.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setDataHora(LocalDateTime.now());

        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }
}
