package com.example.agenda;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.agenda.dto.ContatoRequestDTO;
import com.example.agenda.framework.utils.FakersGeneration;
import com.example.agenda.framework.utils.FileOperations;
import com.example.agenda.model.Contato;
import com.example.agenda.service.ContatosService;

@SpringBootTest
class AgendaApplicationTests {
	
	@Autowired
	private ContatosService contatoService;

	@Autowired
	private FakersGeneration faker;

	@Test
	void contextLoads() {
	}

	@Test
	void testaAniversariantes() {
		Long quantidadeAniversariantes = contatoService.getAniversariantes().stream().count();

		Long quantidadeEsperada = Long.parseLong(FileOperations
		.getProperties("test")
		.getProperty("aniversariantes"));
		
		assertEquals(quantidadeEsperada, quantidadeAniversariantes);
	}

	@Test
	void testaPesquisa(){
		List<Contato> contatoComUcas = contatoService.getContatoPorNome("ucas");

		assertEquals(2, contatoComUcas.size());
	}

	@Test
	void testaOrdemAlfabetica() {
		String nomePrimeiro = contatoService.getTodosContatos().getFirst().nome();
		String nomeUltimo = contatoService.getTodosContatos().getLast().nome();

		assertEquals(
			FileOperations.getProperties("test")
			.getProperty("primeiro-nome"), 
			nomePrimeiro
		);

		assertEquals(
			FileOperations.getProperties("test")
			.getProperty("ultimo-nome"), 
			nomeUltimo
		);
	}

	@Test
	void testaExcluirUsuario() {
		contatoService.deletarContato((long) faker.getNumero(contatoService.getTodosContatos().size() - 1));
	}

	@Test
	void testaCriarContato() {
		ContatoRequestDTO contato = new ContatoRequestDTO(faker.getNome(), faker.getTelefone(), faker.getEmail(), 
		LocalDate.of(
			faker.getAno(),
			faker.getMes(),
			faker.getDia()
		));
		contatoService.criarContato(contato);
	}
}