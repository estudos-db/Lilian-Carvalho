package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.org.exercicio.services.OrdenaVetor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenaVetorTest {

	private static OrdenaVetor ordenaVetor;
	private static int[] vetorTeste;

	@BeforeEach
	void init() {
		ordenaVetor = new OrdenaVetor();
		vetorTeste = new int[3];
		vetorTeste[0] = 5;
		vetorTeste[1] = 2;
		vetorTeste[2] = 4;
	}

	@Test
	void DeveOrdenarVetor() {
		int[] actual = ordenaVetor.ordenarVetor(vetorTeste);
		int[] expect = new int[3];
		expect[0] = 2;
		expect[1] = 4;
		expect[2] = 5;

		assertEquals(expect[0], actual[0]);
		assertEquals(expect[1], actual[1]);
		assertEquals(expect[2], actual[2]);

	}
}