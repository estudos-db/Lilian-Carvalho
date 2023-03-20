package com.example.combinaordenavetores.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GeraVetorTest {

	@Test
	void deveGerarVetorCom50NumerosAleatorios() {
		int expect = 50;
		int[] vetorGerado = GeraVetor.gerarVetor(50);
		int actual = vetorGerado.length;

		assertNotNull(vetorGerado);
		assertEquals(expect, actual);
	}
}