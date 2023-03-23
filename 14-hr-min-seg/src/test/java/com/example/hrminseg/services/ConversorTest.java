package com.example.hrminseg.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConversorTest {

	private static final int TEMPO_PARA_CALCULAR = 7023;
	private static int horas;
	private static int minutos;

	@Test
	void deveCalcularHoras() {
		int expect = 1;
		int actual = Conversor.calcularHoras(TEMPO_PARA_CALCULAR);

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularMinutos() {
		horas = Conversor.calcularHoras(TEMPO_PARA_CALCULAR);
		Conversor.setHoras(horas);
		int expect = 57;
		int actual = Conversor.calcularMinutos(TEMPO_PARA_CALCULAR);

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularSegundos() {
		horas = Conversor.calcularHoras(TEMPO_PARA_CALCULAR);
		Conversor.setHoras(horas);
		minutos = Conversor.calcularMinutos(TEMPO_PARA_CALCULAR);
		Conversor.setMinutos(minutos);
		int expect = 3;
		int actual = Conversor.calcularSegundos(TEMPO_PARA_CALCULAR);

		assertEquals(expect, actual);
	}
}