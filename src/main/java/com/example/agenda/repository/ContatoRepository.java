package com.example.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
    List<Contato> findByNomeContaining(String nome);
    Boolean existsByEmail(String email);
    Boolean existsByTelefone(String telefone);    
}
