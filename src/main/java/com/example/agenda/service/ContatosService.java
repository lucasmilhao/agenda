package com.example.agenda.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agenda.dto.ContatoRequestDTO;
import com.example.agenda.dto.ContatoResponseDTO;
import com.example.agenda.exceptions.ContatoNaoEncontradoException;
import com.example.agenda.exceptions.ParametroInvalidoException;
import com.example.agenda.model.Contato;
import com.example.agenda.repository.ContatoRepository;

@Service
public class ContatosService {
    
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato criarContato(ContatoRequestDTO data) {
        if((data.dataNascimento() == null) || data.dataNascimento().isAfter(LocalDate.now())) throw new ParametroInvalidoException("data nascimento");
        Contato contato = new Contato(data);

        contatoRepository.save(contato);

        return contato;
    }

    public List<ContatoResponseDTO> getTodosContatos() {
        return contatoRepository.findAll().stream().map(ContatoResponseDTO::new).sorted(Comparator.comparing(ContatoResponseDTO::nome)).toList();
    }

    public List<Contato> getContatoPorNome(String nome) {
        return contatoRepository.findByNomeContaining(nome).stream().sorted(Comparator.comparing(Contato::getNome)).toList();
    }

    public Contato deletarContato(Long id) {
        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new ContatoNaoEncontradoException());

        contatoRepository.delete(contato);

        return contato;
    }

    public Contato editarContato(Long id, ContatoRequestDTO data) {
        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new ContatoNaoEncontradoException());

        contato.setNome(data.nome());
        contato.setDataNascimento(data.dataNascimento());
        contato.setEmail(data.email());
        contato.setTelefone(data.telefone());

        contatoRepository.save(contato);
        return contato;
    }

    public List<ContatoResponseDTO> getAniversariantes() {
        Integer mesAtual = LocalDate.now().getMonthValue();
        return getTodosContatos().stream().filter(e -> e.dataNascimento().getMonthValue() == mesAtual).toList();
    }
}
