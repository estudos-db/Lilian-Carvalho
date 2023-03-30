package com.example.supermercadoprova;

import com.example.supermercadoprova.model.Estoque;
import com.example.supermercadoprova.model.Pedido;
import com.example.supermercadoprova.model.Produto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Produto foneDeOuvido = new Produto("Fone de Ouvido", 98.45, 9);
		Produto mouse = new Produto("Mouse", 28.20, 3);

		Pedido.adicionarItemNaLista(foneDeOuvido, 2);
		Pedido.adicionarItemNaLista(mouse, 2);
		Pedido.imprimePedido();
		Pedido.imprimeValorTotal();
		System.out.println(Pedido.calculaTroco(302.25));
		System.out.println(Pedido.calculaMenorQuantidadeDeNotas());
		Pedido.limparCarrinho();
		Pedido.imprimePedido();

		Estoque.cadastrarProduto(foneDeOuvido);
		Estoque.cadastrarProduto(mouse);
		Estoque.imprimirCatalagoDoEstoque();
		System.out.println("\n" + Estoque.encontraProdutoNome("Fone de Ouvido").getPreco());
		System.out.println(Estoque.encontraProdutoID(2).getNome());
		System.out.println(Estoque.darBaixaEmEstoquePeloNome("Mouse", 1));
		System.out.println(Estoque.darBaixaEmEstoquePeloNome("Mouse", 3));
		System.out.println(Estoque.darBaixaEmEstoquePeloID(1, 7));
		System.out.println(Estoque.darBaixaEmEstoquePeloID(1, 3));
		System.out.println(Estoque.getQuantidadeAtualEmEstoque(foneDeOuvido));
		System.out.println(Estoque.getPosicaoDoProdutoNaLista(mouse));
		System.out.println(Estoque.temEstoqueOuNao(foneDeOuvido,1));
		System.out.println(Estoque.temEstoqueOuNao(foneDeOuvido,10));
	}

}
