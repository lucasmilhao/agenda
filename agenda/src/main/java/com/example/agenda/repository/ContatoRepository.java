package com.example.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
