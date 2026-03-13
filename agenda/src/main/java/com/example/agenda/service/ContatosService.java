package com.example.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agenda.dto.ContatoResponseDTO;
import com.example.agenda.repository.ContatoRepository;

@Service
public class ContatosService {
    
    @Autowired
    private ContatoRepository contatoRepository;

    public List<ContatoResponseDTO> getTodosContatos() {
        return contatoRepository.findAll().stream().map(ContatoResponseDTO::new).toList();
    }
}
