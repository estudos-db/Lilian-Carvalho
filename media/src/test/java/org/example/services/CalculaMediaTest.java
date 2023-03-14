package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculaMediaTest {

	private static double calculaMedia;
	private static DecimalFormat decimalFormat;

	@BeforeEach
	void init() {
		decimalFormat = new DecimalFormat("0.00");

		calculaMedia = CalculaMedia.calcularMedia(new ArrayList<>(List.of(5.6, 7.8, 6.9)));


	}

	@Test
	void DeveCalcularAMediaDasNotasInformadas() {
		String actual = decimalFormat.format(calculaMedia);
		assertEquals("6,77", actual);
	}
}