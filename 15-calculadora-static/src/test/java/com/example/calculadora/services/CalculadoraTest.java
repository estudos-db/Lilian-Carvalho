package com.example.calculadora.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void deveSomarDoisNumeros() {
		int actual = Calculadora.somar(13, 5);

		assertEquals(18, actual);
	}

	@Test
	void deveSubtrairOPrimeiroValorDoSegundoValor() {
		int actual = Calculadora.subtrair(9, 4);

		assertEquals(5, actual);
	}

	@Test
	void deveMultiplicacarDoisValores() {
		int actual = Calculadora.multiplicacar(7, 3);

		assertEquals(21, actual);
	}

	@Test
	void deveDividirOPrimeiroValorPeloSegundo() {
		double actual = Calculadora.dividir(100, 4);

		assertEquals(25.0, actual);
	}

	@Test
	void deveCalcularPotenciaDaBasSobExpoenteInformado() {
		double actual = Calculadora.calcularPotencia(2, 3);

		assertEquals(8.0, actual);
	}
}