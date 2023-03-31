package com.example.supermercadoprova;

import com.example.supermercadoprova.model.Produto;
import com.example.supermercadoprova.services.EstoqueServices;
import com.example.supermercadoprova.services.PedidoServices;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Produto foneDeOuvido = new Produto("Fone de Ouvido", 98.45, 9);
		Produto mouse = new Produto("Mouse", 28.21, 3);

		PedidoServices.adicionarItemNaLista(foneDeOuvido, 2);
		PedidoServices.adicionarItemNaLista(mouse, 2);
		PedidoServices.imprimePedido();
		System.out.println(PedidoServices.imprimeValorTotal());
		System.out.println(PedidoServices.calculaTroco(302.25));
		System.out.println(PedidoServices.calculaMenorQuantidadeDeNotas());
		PedidoServices.limparCarrinho();
		PedidoServices.imprimePedido();

		EstoqueServices.cadastrarProduto(foneDeOuvido);
		EstoqueServices.cadastrarProduto(mouse);
		EstoqueServices.imprimirCatalagoDoEstoque();
		System.out.println("\n" + EstoqueServices.encontraProdutoNome("Fone de Ouvido").getPreco());
		System.out.println(EstoqueServices.encontraProdutoID(2).getNome());
		System.out.println(EstoqueServices.darBaixaEmEstoquePeloNome("Mouse", 1));
		System.out.println(EstoqueServices.darBaixaEmEstoquePeloNome("Mouse", 3));
		System.out.println(EstoqueServices.darBaixaEmEstoquePeloID(1, 7));
		System.out.println(EstoqueServices.darBaixaEmEstoquePeloID(1, 3));
		System.out.println(EstoqueServices.getQuantidadeAtualEmEstoque(foneDeOuvido));
		System.out.println(EstoqueServices.getPosicaoDoProdutoNaLista(mouse));
		System.out.println(EstoqueServices.temEstoqueOuNao(foneDeOuvido, 1));
		System.out.println(EstoqueServices.temEstoqueOuNao(foneDeOuvido, 10));
	}

}
