package com.example.agenda.model;

import java.time.LocalDate;

import com.example.agenda.dto.ContatoRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Long id;

    private String nome;
    
    private String telefone;

    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    public Contato(ContatoRequestDTO request) {
        this.nome = request.nome();
        this.telefone = request.telefone();
        this.email = request.email();
        this.dataNascimento = request.dataNascimento();
    }


}
