package com.example.agenda.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
public record ContatoRequestDTO(
    @NotBlank(message="Preencha o nome!")
    String nome, 
    
    @NotBlank(message="Preencha o email!")
    String telefone, String email, 
    
    LocalDate dataNascimento ) {
    
}
