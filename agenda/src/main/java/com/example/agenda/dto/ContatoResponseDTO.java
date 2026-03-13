package com.example.agenda.dto;

import java.time.LocalDate;

import com.example.agenda.model.Contato;

public record ContatoResponseDTO(Long id, String nome, String telefone, String email, LocalDate dataNascimento) {
    public ContatoResponseDTO(Contato c) {
        this(c.getId(), c.getNome(), c.getTelefone(), c.getEmail(), c.getDataNascimento());
    }
    
}
