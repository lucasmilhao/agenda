package com.example.agenda.exceptions;

public class ContatoExistenteException extends RuntimeException {
    public ContatoExistenteException(String message){
        super(message);
    }

    public ContatoExistenteException() {
        super("Contato já existe.");
    }
}
