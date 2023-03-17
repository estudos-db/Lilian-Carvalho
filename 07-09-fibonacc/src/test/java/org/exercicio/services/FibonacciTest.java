package org.exercicio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FibonacciTest {

	private static Fibonacci fibonacci;
	private static List<Integer> expect;

	@BeforeAll
	static void init() {
		fibonacci = new Fibonacci();
		expect = new ArrayList<>(List.of(0, 1, 1, 2, 3, 5, 8));

	}

	@Test
	void deveCalcularFibonacciDoNumero() {
		List<Integer> actual = fibonacci.calculaFibonacci(9);

		assertNotNull(actual);
		assertEquals(expect, actual);
	}

	@Test
	void deveRetornarUmArrayVazioCasoONumeroSejaNegativo() {
		List<Integer> expect = new ArrayList<>();
		List<Integer> actual = fibonacci.calculaFibonacci(-6);

		assertEquals(expect, actual);
	}

}