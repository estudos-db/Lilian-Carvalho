package com.example.hrminseg.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConversorTest {

	private static int horas;
	private static int minutos;
	private static int segundos;

	@BeforeAll
	public static void init() {
		horas = Conversor.calcularHoras(7023);
		Conversor.setHoras(horas);
		minutos = Conversor.calcularMinutos(7023);
		Conversor.setMinutos(minutos);
		segundos = Conversor.calcularSegundos(7023);
		Conversor.setSegundos(minutos);
	}

	@Test
	void deveCalcularHoras() {
		int expect = 1;
		int actual = horas;

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularMinutos() {
		int expect = 57;
		int actual = minutos;

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularSegundos() {
		int expect = 3;
		int actual = segundos;

		assertEquals(expect, actual);
	}
}