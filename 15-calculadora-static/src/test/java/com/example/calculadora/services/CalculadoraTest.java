package com.example.calculadora.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void deveSomarDoisNumeros() {
		int expect = 18;
		int actual = Calculadora.somar(13, 5);

		assertEquals(expect, actual);
	}

	@Test
	void deveSubtrairOPrimeiroValorDoSegundoValor() {
		int expect = 5;
		int actual = Calculadora.subtrair(9, 4);

		assertEquals(expect, actual);
	}

	@Test
	void deveMultiplicacarDoisValores() {
		int expect = 21;
		int actual = Calculadora.multiplicacar(7, 3);

		assertEquals(expect, actual);
	}

	@Test
	void deveDividirOPrimeiroValorPeloSegundo() {
		double expect = 25.0;
		double actual = Calculadora.dividir(100, 4);

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularPotenciaDaBasSobExpoenteInformado() {
		double expect = 8.0;
		double actual = Calculadora.calcularPotencia(2, 3);

		assertEquals(expect, actual);
	}
}