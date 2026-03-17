package com.example.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.dto.ContatoRequestDTO;
import com.example.agenda.dto.ContatoResponseDTO;
import com.example.agenda.model.Contato;
import com.example.agenda.service.ContatosService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/contatos")
public class ContatosController {
    
    @Autowired
    private ContatosService service;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> getContatos() {
        List<ContatoResponseDTO> contatos = service.getTodosContatos();

        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/aniversariantes")
    public ResponseEntity<List<ContatoResponseDTO>> getTodosAniversariantes() {
        List<ContatoResponseDTO> aniversariantes = service.getAniversariantes();

        return ResponseEntity.ok(aniversariantes);
    }

    @GetMapping("/nome/{nomeContato}")
    public ResponseEntity<List<ContatoResponseDTO>> getContatoPorNome(@PathVariable String nomeContato) {
        List<ContatoResponseDTO> listaContatos = service.getContatoPorNome(nomeContato).stream().map(ContatoResponseDTO::new).toList();
        return ResponseEntity.ok(listaContatos);
    }

    @PutMapping("{idContato}")
    public ResponseEntity<ContatoResponseDTO> editarContato(@PathVariable Long idContato, @RequestBody ContatoRequestDTO data) {
        Contato contato = service.editarContato(idContato, data);

        return ResponseEntity.ok(new ContatoResponseDTO(contato));
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> criarContato(@RequestBody @Valid ContatoRequestDTO data){
        Contato contato = service.criarContato(data);

        return ResponseEntity.ok(new ContatoResponseDTO(contato));
        
    }

    @DeleteMapping("{idContato}")
    public ResponseEntity<ContatoResponseDTO> removerContato(@PathVariable Long idContato) {
        Contato c = service.deletarContato(idContato);

        return ResponseEntity.ok(new ContatoResponseDTO(c));
    }

}
