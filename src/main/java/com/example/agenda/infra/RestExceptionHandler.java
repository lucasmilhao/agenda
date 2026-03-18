package com.example.agenda.infra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.agenda.dto.ErroResponseDTO;
import com.example.agenda.exceptions.ContatoExistenteException;
import com.example.agenda.exceptions.ContatoNaoEncontradoException;
import com.example.agenda.exceptions.ParametroInvalidoException;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContatoNaoEncontradoException.class)
    private ResponseEntity<String> contatoBadRequest(ContatoNaoEncontradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ParametroInvalidoException.class)
    private ResponseEntity<String> parametroBadRequest(ParametroInvalidoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    
    @ExceptionHandler(ContatoExistenteException.class)
        private ResponseEntity<ErroResponseDTO> contatoBadRequest(ContatoExistenteException e) {
            return ResponseEntity.badRequest().body(new ErroResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.toString()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
        HttpHeaders headers,
        HttpStatusCode statusCode,
        WebRequest request
    ){
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}