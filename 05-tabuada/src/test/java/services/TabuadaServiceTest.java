package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TabuadaServiceTest {

	TabuadaService tabuadaService;

	@BeforeEach
	void init() {
		tabuadaService = new TabuadaService();
	}

	@Test
	void exibirResultado() {
	}

	@Test
	void DeveCalcularATabuadaDoValorEnviadoPeloUsusario() {
		List<Integer> expect = new ArrayList<>(List.of(4, 8, 12, 16, 20, 24, 28, 32, 36, 40));
		List<Integer> acual = tabuadaService.calcularTabuada(4);

		assertEquals(expect, acual);
	}
}