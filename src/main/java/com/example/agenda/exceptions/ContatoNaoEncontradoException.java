package com.example.agenda.exceptions;

public class ContatoNaoEncontradoException extends RuntimeException {
    
    public ContatoNaoEncontradoException(String message) {
        super(message);
    }

    public ContatoNaoEncontradoException() {
        super("Contato não pode ser encontrado!");
    }
}
