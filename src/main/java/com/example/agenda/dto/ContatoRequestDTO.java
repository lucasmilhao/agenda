package com.example.agenda.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record ContatoRequestDTO(
    @NotBlank(message="Preencha o nome!")
    String nome, 
    
    @NotBlank(message="Preencha o telefone!")
    String telefone, 

    @Email(message="Digite um email válido!")
    String email, 
    
    @NotNull(message="Preencha a data de Nascimento!")
    LocalDate dataNascimento ) {
    
}
