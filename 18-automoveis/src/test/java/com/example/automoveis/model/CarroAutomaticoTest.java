package com.example.automoveis.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarroAutomaticoTest {

	private CarroAutomatico carroAutomatico;

	@BeforeEach
	public void init() {
		carroAutomatico = new CarroAutomatico(160);
	}

	@DisplayName("Não deve ligar o carro caso o freio não esteja pressionado")
	@Test
	void ligarCarroSemFreioPressionado() {
		carroAutomatico.ligar();
		assertFalse(carroAutomatico.isLigado());
	}

	@DisplayName("Deve ligar o carro caso o freio esteja pressionado")
	@Test
	void ligarCarroComFreioPressionado() {
		carroAutomatico.freiar();
		carroAutomatico.ligar();
		assertTrue(carroAutomatico.isLigado());
	}
}