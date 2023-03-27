package com.example.automoveis.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuinchoTest {

	private Guincho guincho;
	private Moto moto;
	private Carro carro;

	@BeforeEach
	void

	init() {
		guincho = new Guincho(6, 120);
		carro = new Carro(200);
		moto = new Moto(235);
	}

	@DisplayName("Não deve carregar um veicolo caso o gincho esteja carregado")
	@Test
	void nãoDeveCarregarUmVeicolo() {
		guincho.carregar(moto);

		assertTrue(guincho.isCarregado());
		assertFalse(guincho.carregar(carro));
	}

	@DisplayName("Deve carregar um veicolo caso o gincho não esteja carregado")
	@Test
	void deveCarregarUmVeicolo() {

		assertFalse(guincho.isCarregado());
		assertTrue(guincho.carregar(moto));
		assertTrue(guincho.isCarregado());
	}
}