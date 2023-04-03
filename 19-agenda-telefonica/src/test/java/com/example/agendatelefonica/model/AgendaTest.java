package com.example.agendatelefonica.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.agendatelefonica.services.Agenda;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private final Endereco enderecoTeste = new Endereco("88350720", "Rua Guilherme Alberto "
			                                                                + "Frederico "
			                                                                + "Hoeffelmann", "779",
	                                                    "Rio Branco", "Brusque", "SC");

	private final Contato contatoTeste = new Contato("Ester", "Soares", "82996345148",
	                                                 "ester.soares@gmail.com", enderecoTeste);

	@BeforeEach
	void beforeTest() {
		Agenda.removerContato(contatoTeste.getNome());
	}

	@Test
	@DisplayName("Deve retornar os contatos cadastrados na agenda")
	void listarContatos() {
		Agenda.adicionarContato(contatoTeste);
		Set<Contato> contatosCadastrados = Agenda.listarContatos();

		contatosCadastrados.forEach(contato -> {
			assertEquals("Ester", contato.getNome());
			assertEquals("82996345148", contato.getNumeroContato());
		});
		assertEquals(1, contatosCadastrados.size());
	}

	@Test
	@DisplayName("Deve informar que não a nenhum contato cadastrado")
	void exibirContatosAgendaVazia() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		Set<Contato> contatosCadastrados = Agenda.listarContatos();
		System.setOut(new PrintStream(outContent));
		Agenda.exibirContatos();

		assertEquals(0, contatosCadastrados.size());
		assertEquals("Nenhum contato cadastrado!\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve exibir contato(s) cadastrado(s)")
	void exibirContatos() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		Agenda.adicionarContato(contatoTeste);
		Set<Contato> contatosCadastrados = Agenda.listarContatos();
		System.setOut(new PrintStream(outContent));
		Agenda.exibirContatos();

		String expect = "\nNOME                          CONTATO     \n"
				                + "Ester                         82996345148  ";

		assertEquals(1, contatosCadastrados.size());
		assertEquals(expect, outContent.toString());
	}

	@Test
	@DisplayName("Adiciona um novo contato na agenda")
	void adicionarContato() {
		assertTrue(Agenda.adicionarContato(contatoTeste));
	}

	@Test
	@DisplayName("Não adiciona um novo contato na agenda caso ele já exista")
	void nãoDeveAdicionarContatoRepetido() {
		assertTrue(Agenda.adicionarContato(contatoTeste));
		assertFalse(Agenda.adicionarContato(contatoTeste));
	}

	@Test
	@DisplayName("Deve retornar null caso contato buscado não exista na agenda!")
	void buscarContatoNãoCadastrado() {
		assertNull(Agenda.buscaContato("Julia"));
	}

	@Test
	@DisplayName("Deve retornar o contato caso exista na agenda!")
	void buscarContatoCadastrado() {
		Agenda.adicionarContato(contatoTeste);
		Agenda.buscaContato("Ester");

		assertEquals("Ester", contatoTeste.getNome());
		assertEquals("82996345148", contatoTeste.getNumeroContato());
		assertEquals("Brusque", contatoTeste.getEndereco().getCidade());
		assertEquals("SC", contatoTeste.getEndereco().getEstado());
	}

	@Test
	@DisplayName("Remove o contado caso ele exista na agenda")
	void deveRemoverContato() {
		Agenda.adicionarContato(contatoTeste);
		assertTrue(Agenda.removerContato(contatoTeste.getNome()));
	}

	@Test
	@DisplayName("Retorna false caso o contato a ser excluído não exista na agenda")
	void removerContatoNaoCadastrado() {
		assertFalse(Agenda.removerContato("Julia"));
	}
}