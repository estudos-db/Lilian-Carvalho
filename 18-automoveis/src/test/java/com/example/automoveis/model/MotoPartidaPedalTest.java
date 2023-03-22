package com.example.automoveis.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MotoPartidaPedalTest {

	private MotoPartidaPedal motoPartidaPedal;

	@BeforeEach
	void init() {
		motoPartidaPedal = new MotoPartidaPedal(180);
	}

	@DisplayName("Não deve ligar a moto caso o acelerador não esteja puxado")
	@Test
	void ligarMotoSemAceleradorPuxado() {
		motoPartidaPedal.ligar();
		assertFalse(motoPartidaPedal.isLigado());
	}

	@DisplayName("Deve ligar a moto caso o acelerador esteja puxado")
	@Test
	void ligarMotoAceleradorPuxado() {
		motoPartidaPedal.acelerar();
		motoPartidaPedal.ligar();
		assertTrue(motoPartidaPedal.isLigado());
	}
}