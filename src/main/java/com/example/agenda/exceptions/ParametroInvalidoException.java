package com.example.agenda.exceptions;

public class ParametroInvalidoException extends RuntimeException {

    public ParametroInvalidoException(String campo) {
        super("O campo de " + campo + " está inválido");
    }    
}
