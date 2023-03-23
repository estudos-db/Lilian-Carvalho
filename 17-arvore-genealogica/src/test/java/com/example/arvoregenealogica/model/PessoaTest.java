package com.example.arvoregenealogica.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PessoaTest {

	private Pessoa filho;

	@BeforeEach
	void init() {
		filho = new Pessoa("Marcela", 28);
	}

	@DisplayName("Registra nome e idade do pai da pessoa")
	@Test
	void deveRegistrarOPai() {
		Pessoa pai = new Pessoa("João", 60);
		filho.setPai(pai);

		assertEquals("Marcela", filho.getNome());
		assertEquals("João", filho.getPai().getNome());
		assertEquals(60, filho.getPai().getIdade());
	}

	@DisplayName("Registra nome e idade da mãe da pessoa")
	@Test
	void deveRegistrarAMãe() {
		Pessoa mae = new Pessoa("Maria", 55);
		filho.setMae(mae);

		assertEquals("Marcela", filho.getNome());
		assertEquals("Maria", filho.getMae().getNome());
		assertEquals(55, filho.getMae().getIdade());
	}
}