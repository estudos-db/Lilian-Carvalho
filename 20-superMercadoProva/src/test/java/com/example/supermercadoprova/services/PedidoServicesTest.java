package com.example.supermercadoprova.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.example.supermercadoprova.model.Produto;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PedidoServicesTest {

	private static final Produto foneDeOuvido = new Produto("Fone de Ouvido", 48.45, 9);
	private static final Produto mouse = new Produto("Mouse", 28.21, 13);

	@BeforeEach
	void init() {
		PedidoServices.limparCarrinho();
	}

	@Test
	@DisplayName("Retorna false caso a quantidade do item solicitada não tenha em estoque")
	void adicionaItemEstoqueInsuficiente() {
		assertFalse(PedidoServices.adicionarItemNaLista(foneDeOuvido, 200));

	}

	@Test
	@DisplayName("Deve adicionar um item na lista de compras")
	void adicionarItemNaLista() {
		assertTrue(PedidoServices.adicionarItemNaLista(foneDeOuvido, 2));
		assertEquals(1, PedidoServices.getPedido().getListaDeItens().size());
	}

	@Test
	@DisplayName("Deve imprimir o valor total das compras")
	void imprimeValorTotal() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 1);
		PedidoServices.adicionarItemNaLista(mouse, 3);

		assertEquals("\nVALOR TOTAL = R$ 133.08", PedidoServices.imprimeValorTotal());
	}

	@Test
	@DisplayName("Deve apagar todos os itens do carrinho")
	void limparCarrinho() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 1);
		PedidoServices.adicionarItemNaLista(mouse, 1);
		assertEquals(2, PedidoServices.getPedido().getListaDeItens().size());

		PedidoServices.limparCarrinho();

		assertEquals(0, PedidoServices.getPedido().getListaDeItens().size());
	}

	@Test
	@DisplayName("Deve calcular o valor total dos itens no carrinho")
	void calcularValorTotal() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 4);
		PedidoServices.adicionarItemNaLista(mouse, 6);

		assertEquals(363.06, PedidoServices.calcularValorTotal());
	}

	@Test
	@DisplayName("Deve imprimir itens do pedido do cliente")
	void imprimePedido() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 2);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		PedidoServices.imprimePedido();
		String expect =
				"NOME                           VALOR UNID.     QUANTIDADE      VALOR TOTAL    \n"
						+ "Fone de Ouvido                 48.45           2               96.9           ";

		assertEquals(expect, outContent.toString());
	}

	@Test
	@DisplayName("Deve informar que o carrinho esta vazio")
	void imprimePedidoSemItens() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		PedidoServices.imprimePedido();
		String expect = "Nenhum produto adicionado ao carrinho!\n";

		assertEquals(expect, outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular troco caso valor pago seja maior que o do pedido")
	void calculaTroco() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 1);
		PedidoServices.adicionarItemNaLista(mouse, 1);
		PedidoServices.calcularValorTotal();
		String expect = "\nTROCO = R$ 23.34\n" + "1 nota(s) de R$ 20\n" + "1 nota(s) de R$ 2\n"
				                + "1 moeda(s) de R$ 1\n1 moeda(s) de 25 centavos\n"
				                + "1 moeda(s) de 5 centavos\n";

		assertEquals(expect, PedidoServices.calculaTroco(100));
	}

	@Test
	@DisplayName("Deve informar que o valor pago não é suficiente caso seja menor que o valor do " + "pedido")
	void calculaTrocoValorPagoInsuficiente() {
		PedidoServices.adicionarItemNaLista(foneDeOuvido, 1);
		PedidoServices.adicionarItemNaLista(mouse, 1);
		PedidoServices.calcularValorTotal();
		String expect = "Valor pago é insuficiente!";

		assertEquals(expect, PedidoServices.calculaTroco(50));
	}

}