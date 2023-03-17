package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperacoesTest {

	private static Operacoes operacoes;
	private BigDecimal actual;
	private BigDecimal expect;

	@BeforeAll
	static void inicia() {
		operacoes = new Operacoes();

	}

	@Test
	void DeveSomarDoisNumerosPositios() {
		operacoes.soma(2.60, 2.80);
		actual = operacoes.getResultado();
		expect = new BigDecimal("5.40");
		assertEquals(actual, expect);

		operacoes.soma(25, 12);
		actual = operacoes.getResultado();
		expect = new BigDecimal("37.00");

		assertEquals(actual, expect);

	}

	@Test
	void DeveSomarDoisNumerosNegativos() {
		operacoes.soma(-3.3, -2.8);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-6.10");

		assertEquals(actual, expect);

		operacoes.soma(-86, -100);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-186.00");
		assertEquals(actual, expect);
	}

	@Test
	void DeveSomarNumerosNegativoComPositovo() {
		operacoes.soma(-2.60, 5.90);
		actual = operacoes.getResultado();
		expect = new BigDecimal("3.30");

		assertEquals(actual, expect);

		operacoes.soma(-86, 25);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-61.00");

		assertEquals(actual, expect);
	}

	@Test
	void deveSubtrairDoisNumerosPositios() {
		operacoes.subtracao(10.5, 3.53);
		actual = operacoes.getResultado();
		expect = new BigDecimal("6.97");
		assertEquals(actual, expect);

		operacoes.soma(25, 12);
		actual = operacoes.getResultado();
		expect = new BigDecimal("37.00");

		assertEquals(actual, expect);
	}

	@Test
	void deveSubtrairDoisNumerosNegativos() {
		operacoes.subtracao(-5.8, -8.6);
		actual = operacoes.getResultado();
		expect = new BigDecimal("2.80");
		assertEquals(actual, expect);

		operacoes.subtracao(-8, -2);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-6.00");

		assertEquals(actual, expect);
	}

	@Test
	void deveSubtrairNumeroNegativoDeNumeroPositivo() {
		operacoes.subtracao(-5.8, 10);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-15.80");
		assertEquals(actual, expect);

		operacoes.subtracao(-8, 2);
		actual = operacoes.getResultado();
		expect = new BigDecimal("-10.00");

		assertEquals(actual, expect);
	}

	@Test
	void deveSubtrairNumeroPositivoDeNumeroNegativo() {
		operacoes.subtracao(5.8, -10);
		actual = operacoes.getResultado();
		expect = new BigDecimal("15.80");
		assertEquals(actual, expect);

		operacoes.subtracao(8, -2);
		actual = operacoes.getResultado();
		expect = new BigDecimal("10.00");

		assertEquals(actual, expect);
	}

	@Test
	void deveMultiplicarDoisNumerosPositivos() {
		operacoes.multiplicacao(6, 3);
		expect = new BigDecimal("18.00");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);

		operacoes.multiplicacao(2.6, 5.9);
		expect = new BigDecimal("15.34");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);
	}

	@Test
	void deveMultiplicarNumeroPositivoPorNumeroNegatvo() {
		operacoes.multiplicacao(6, -3);
		expect = new BigDecimal("-18.00");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);

		operacoes.multiplicacao(2.6, -5.9);
		expect = new BigDecimal("-15.34");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);
	}

	@Test
	void deveDividirDoisNumerosPositivos() {
		operacoes.divisao(13, 8);
		expect = new BigDecimal("1.63");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);

		operacoes.divisao(26.87, 32.54);
		expect = new BigDecimal("0.83");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);
	}

	@Test
	void deveDividirNumeroPositivoPorNumeroNegativo() {
		operacoes.divisao(13, -8);
		expect = new BigDecimal("-1.63");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);

		operacoes.divisao(26.87, -32.54);
		expect = new BigDecimal("-0.83");
		actual = operacoes.getResultado();

		assertEquals(expect, actual);
	}
}