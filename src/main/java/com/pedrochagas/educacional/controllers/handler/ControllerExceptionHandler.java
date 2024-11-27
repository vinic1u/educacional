package com.pedrochagas.educacional.controllers.handler;

import com.pedrochagas.educacional.dtos.CustomError;
import com.pedrochagas.educacional.exceptions.RecursoDuplicadoException;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<CustomError> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException exception, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(
                Instant.now(),
                httpStatus.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(httpStatus).body(customError);
    }

    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<CustomError> handleRecursoDuplicadoException(RecursoDuplicadoException exception, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(
                Instant.now(),
                httpStatus.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(httpStatus).body(customError);
    }
}
