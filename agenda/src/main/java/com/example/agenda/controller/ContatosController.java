package com.example.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.dto.ContatoResponseDTO;
import com.example.agenda.service.ContatosService;

@RestController
@RequestMapping("contatos")
public class ContatosController {
    
    @Autowired
    private ContatosService service;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> getContatos() {
        List<ContatoResponseDTO> contatos = service.getTodosContatos();

        return ResponseEntity.ok(contatos);
    }

}
