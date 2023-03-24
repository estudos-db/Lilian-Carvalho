package com.example.combinaordenavetores.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenaVetorTest {

	private static int[] vetorTeste;
	private static int[] vetorTesteOrdenado;

	@BeforeEach
	void setUp() {
		vetorTeste = new int[3];
		vetorTeste[0] = 4;
		vetorTeste[1] = 5;
		vetorTeste[2] = 1;

		vetorTesteOrdenado = new int[3];
		vetorTesteOrdenado[0] = 1;
		vetorTesteOrdenado[1] = 4;
		vetorTesteOrdenado[2] = 5;
	}

	@Test
	void deveOrdenarVetor() {

		int[] expect = vetorTesteOrdenado;
		int[] actual = OrdenaVetor.ordenarVetor(vetorTeste);

		assertEquals(expect[0], actual[0]);
		assertEquals(expect[1], actual[1]);
		assertEquals(expect[2], actual[2]);

		assertArrayEquals(expect, actual);
	}
}