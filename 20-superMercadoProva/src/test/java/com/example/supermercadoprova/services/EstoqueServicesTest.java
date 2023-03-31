package com.example.supermercadoprova.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.supermercadoprova.model.Estoque;
import com.example.supermercadoprova.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EstoqueServicesTest {

	private static final Produto teclado = new Produto("Teclado", 48.96, 25);
	private static final Produto mouse = new Produto("Mouse", 27.69, 10);

	@BeforeAll
	static void init() {
		EstoqueServices.cadastrarProduto(teclado);
		EstoqueServices.cadastrarProduto(mouse);
	}
	@Test
	@DisplayName("Deve buscar um produto na lista pelo nome")
	void encontraProdutoNome() {
		Produto actual = EstoqueServices.encontraProdutoNome("Teclado");

		assertNotNull(actual);
		assertEquals(1, actual.getId());
		assertEquals("Teclado", actual.getNome());
		assertEquals(48.96, actual.getPreco());
		assertEquals(25, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve retornar null caso o produto buscado nao exista no estoque")
	void naoEncontraProdutoNome() {
		Produto actual = EstoqueServices.encontraProdutoNome("Cadeira");

		assertNull(actual);
	}

	@Test
	@DisplayName("Deve buscar um produto na lista pelo ID")
	void encontraProdutoID() {
		Produto actual = EstoqueServices.encontraProdutoID(2);

		assertNotNull(actual);
		assertEquals(2, actual.getId());
		assertEquals("Mouse", actual.getNome());
		assertEquals(27.69, actual.getPreco());
		assertEquals(8, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve retornar null caso o produto buscado nao exista no estoque")
	void naoEncontraProdutoID() {
		assertNull(EstoqueServices.encontraProdutoID(3));
	}

	@Test
	@DisplayName("Deve cadastrar um novo produto no estoque")
	void cadastrarProduto() {
		assertNull(EstoqueServices.encontraProdutoNome("Fone de ouvido"));
		EstoqueServices.cadastrarProduto(new Produto("Fone de ouvido", 36.58, 13));
		Produto actual = EstoqueServices.encontraProdutoNome("Fone de ouvido");
		assertNotNull(actual);
		assertEquals(3, actual.getId());
		assertEquals("Fone de ouvido", actual.getNome());
		assertEquals(36.58, actual.getPreco());
		assertEquals(13, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve dar baixar na quantidade de um produto em estoque pelo seu nome")
	void darBaixaEmEstoquePeloNome() {
		assertTrue(EstoqueServices.darBaixaEmEstoquePeloNome("Teclado", 10));
		Produto actual = EstoqueServices.encontraProdutoNome("Teclado");
		assertEquals(15, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve retornar false caso a quantidade para dar baixa seja maior que a quantidade "
			             + "em estoque")
	void naoDarBaixaEmEstoquePeloNome() {
		assertFalse(EstoqueServices.darBaixaEmEstoquePeloNome("Teclado", 55));
		Produto actual = EstoqueServices.encontraProdutoNome("Teclado");
		assertEquals(25, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve dar baixar na quantidade de um produto em estoque pelo seu ID")
	void darBaixaEmEstoquePeloID() {
		assertTrue(EstoqueServices.darBaixaEmEstoquePeloID(2, 2));
		Produto actual = EstoqueServices.encontraProdutoID(2);
		assertEquals(8, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve retornar false caso a quantidade para dar baixa seja maior que a quantidade "
			             + "em estoque")
	void naoDarBaixaEmEstoquePeloID() {
		assertFalse(EstoqueServices.darBaixaEmEstoquePeloID(2, 15));
		Produto actual = EstoqueServices.encontraProdutoID(2);
		assertEquals(10, actual.getQuantidadeEmEstoque());
	}

	@Test
	@DisplayName("Deve retornar a quantidade do produto em estoque")
	void getQuantidadeAtualEmEstoque() {
		assertEquals(25, EstoqueServices.getQuantidadeAtualEmEstoque(teclado));
		assertEquals(10, EstoqueServices.getQuantidadeAtualEmEstoque(mouse));
	}

	@Test
	@DisplayName("Deve retornar a posição do produto no estoque")
	void getPosicaoDoProdutoNaLista() {
		int actual = EstoqueServices.getPosicaoDoProdutoNaLista(teclado);
		System.out.println(actual);

//		assertEquals(0, );
		assertEquals(1, EstoqueServices.getPosicaoDoProdutoNaLista(mouse));
	}

	@Test
	@DisplayName("Verifica se o produto tem ou não em estoque na quantidade informada")
	void temEstoqueOuNao() {
		assertTrue(EstoqueServices.temEstoqueOuNao(teclado, 10));
		assertFalse(EstoqueServices.temEstoqueOuNao(teclado, 30));
		assertTrue(EstoqueServices.temEstoqueOuNao(mouse, 7));
		assertFalse(EstoqueServices.temEstoqueOuNao(mouse, 15));
	}
}