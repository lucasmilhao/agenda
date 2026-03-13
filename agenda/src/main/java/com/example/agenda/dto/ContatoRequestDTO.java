package com.example.agenda.dto;

import java.time.LocalDate;

public record ContatoRequestDTO(String nome, String telefone, String email, LocalDate dataNascimento ) {
    
}
