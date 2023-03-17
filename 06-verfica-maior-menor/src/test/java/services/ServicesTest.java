package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ServicesTest {
	private static Set<Integer> arrayTeste;
	private static Services servicesArrayTeste;
	private static Services services;

	@BeforeAll
	static void init(){
		services = new Services();
		arrayTeste = new HashSet<>(List.of(96, 24, 57, 11, 25, 93, 51, 4, 6, 20));
		servicesArrayTeste = new Services(arrayTeste);

	}

	@Test
	void deveEcontrarOMaiorValorNoArray() {
		int expect = 96;
		int atual = servicesArrayTeste.maiorValor();

		assertEquals(expect,atual);
	}

	@Test
	void deveEcontrarOMenorValorNoArray() {
		int expect = 4;
		int atual = servicesArrayTeste.menorValor();

		assertEquals(expect,atual);
	}

	@Test
	void deveGerarUmArray() {
		assertNotNull(services.gerarArray());
	}

	@Test
	void deveGerarUmArrayCom10Elementos() {
		int expect = 10;
		int actual = services.gerarArray().size();

		assertEquals(expect,actual);

	}
}