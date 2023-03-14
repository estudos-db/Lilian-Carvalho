package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import main.java.org.exercicio.services.GeraVetor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeraVetorTest {

	private static int[] vetorGerado;

	@BeforeEach
	void init() {
		GeraVetor geradorVetor = new GeraVetor();
		vetorGerado = geradorVetor.gerarVetor(100);
	}

	@Test
	void deveGerarUmVetorCom100NumerosAleatorios() {
		int tamanhoVetor = vetorGerado.length;

		assertEquals(tamanhoVetor, 100);
	}

	@Test
	void deveGerarUmVetor() {

		assertNotNull(vetorGerado);
	}
}