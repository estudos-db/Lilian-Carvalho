package com.example.agendatelefonica.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Contato contatoTeste = new Contato("Ester Elza", "82996345148");

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
		assertNull(Agenda.buscaContato("Julia Senna"));
	}

	@Test
	@DisplayName("Deve retornar o contato caso exista na agenda!")
	void buscarContatoCadastrado() {
		Agenda.adicionarContato(contatoTeste);
		Agenda.buscaContato("Ester Elza");

		assertEquals("Ester Elza", contatoTeste.getNome());
		assertEquals("82996345148", contatoTeste.getNumeroContato());
	}

	@Test
	@DisplayName("Remove o contado caso ele exista na agenda")
	void deveRemoverContato() {
		Agenda.adicionarContato(contatoTeste);
		assertTrue(Agenda.removerContato(contatoTeste.getNome()));
	}

	@Test
	@DisplayName("Retorna false caso o contato a ser excluido não exista na agenda")
	void removerContatoNaoCadastrado() {
		assertFalse(Agenda.removerContato("Julia Senna"));
	}
}