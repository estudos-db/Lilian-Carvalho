package com.example.combinaordenavetores.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinaVetoresTest {

	private static int[] primeiroVetorTeste;
	private static int[] segundoVetorTeste;
	private static int[] vetoresCombinados;

	@BeforeEach
	void setUp() {
		primeiroVetorTeste = new int[3];
		primeiroVetorTeste[0] = 4;
		primeiroVetorTeste[1] = 6;
		primeiroVetorTeste[2] = 2;
		segundoVetorTeste = new int[3];
		segundoVetorTeste[0] = 8;
		segundoVetorTeste[1] = 3;
		segundoVetorTeste[2] = 9;

		vetoresCombinados = new int[6];
		vetoresCombinados[0] = 4;
		vetoresCombinados[1] = 6;
		vetoresCombinados[2] = 2;
		vetoresCombinados[3] = 8;
		vetoresCombinados[4] = 3;
		vetoresCombinados[5] = 9;

	}

	@Test
	void deveCombinarDoisVetores() {
		int[] expect = vetoresCombinados;
		int[] actual = CombinaVetores.combinarVetores(primeiroVetorTeste,segundoVetorTeste);

		assertEquals(expect[0], actual[0]);
		assertEquals(expect[1], actual[1]);
		assertEquals(expect[2], actual[2]);
		assertEquals(expect[3], actual[3]);
		assertEquals(expect[4], actual[4]);
		assertEquals(expect[5], actual[5]);

		assertArrayEquals(expect,actual);

	}
}