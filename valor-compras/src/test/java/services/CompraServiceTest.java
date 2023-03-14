package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import model.Produto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompraServiceTest {

	private static Produto foneDeOuvido;
	private static Produto notebook;
	private static Produto teclado;
	private static Produto mouse;

	@BeforeAll
	static void init() {
		foneDeOuvido = new Produto("Fone de Ouvido", BigDecimal.valueOf(35.80), 12);
		notebook = new Produto("Notebook", BigDecimal.valueOf(3100), 3);
		teclado = new Produto("Teclado", BigDecimal.valueOf(59.99), 55);
		mouse = new Produto("Mouse", BigDecimal.valueOf(39.90), 30);

		CompraService.criarListaDecompras(foneDeOuvido);
		CompraService.criarListaDecompras(notebook);
		CompraService.criarListaDecompras(teclado);
		CompraService.criarListaDecompras(mouse);


	}

	@BeforeEach
	void calcularValorTotal() {
		CompraService.calcularValorTotal();
	}

	@Test
	void deveCalcularValorTotalDoProdutoNaListaDeComprasPelaSuaQuantidade() {
		CompraService.aplicarDesconto();

		BigDecimal expect = new BigDecimal("9300.00");
		BigDecimal actual = notebook.getValorTotal();

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularOValorTotalDaCompraSemDescontosAplicados() {
		BigDecimal expect = new BigDecimal("14226.05");
		BigDecimal actual = CompraService.calcularValorTotalDaCompra();

		assertEquals(expect, actual);
	}

	@Test
	void deveCalcularOValorTotalDaCompraComOsDescontosAplicados() {
		CompraService.aplicarDesconto();
		BigDecimal expect = new BigDecimal("13118.83");
		BigDecimal actual = CompraService.calcularValorTotalDaCompra();

		assertEquals(expect, actual);
	}

	@Test
	void deveAplicarDescontoDe10PorCentoQuandoAQuantidadeDeProdutosCompradosForMaiorQue11EMenorQue20() {
		CompraService.aplicarDesconto();

		BigDecimal expect = new BigDecimal("386.64");
		BigDecimal actual = foneDeOuvido.getValorTotal();

		assertEquals(expect, actual);

	}

	@Test
	void deveAplicarDescontoDe20PorCentoQuandoAQuantidadeDeProdutosCompradosForMaiorQue21ENãoPasseDe50() {
		CompraService.aplicarDesconto();

		BigDecimal expect = new BigDecimal("957.60");
		BigDecimal actual = mouse.getValorTotal();

		assertEquals(expect, actual);

	}

	@Test
	void deveAplicarDescontoDe25PorCentoQuandoAQuantidadeDeProdutosCompradosForMaiorQue50() {
		CompraService.aplicarDesconto();

		BigDecimal expect = new BigDecimal("2474.59");
		BigDecimal actual = teclado.getValorTotal();

		assertEquals(expect, actual);

	}
}