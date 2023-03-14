package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MatrizTest {

	static Matriz matriz = new Matriz();
	static int[][] matrizTeste;

	@BeforeAll
	public static void init() {
		matrizTeste = new int[2][2];
		matrizTeste[0][0] = 1;
		matrizTeste[0][1] = 2;
		matrizTeste[1][0] = 1;
		matrizTeste[1][1] = 2;
	}

	@Test
	void deveSomarDiagonalPrincipalDaMatriz() {

		String expect = "Soma dos valos da diagonal princial: 3";
		String actual = matriz.somarDiagonalPrincipal(matrizTeste);

		assertEquals(expect, actual);
	}
}