package com.example.supermercadoprova.model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Estoque {

	private static final ArrayList<Produto> listaDeProdutos = new ArrayList<>();
	private int id = 1;

	public static Produto encontraProdutoNome(String nome) {
		return listaDeProdutos.stream()
		                      .filter(produto -> Objects.equals(produto.getNome(), nome))
		                      .findFirst()
		                      .orElse(null);
	}

	public static Produto encontraProdutoID(int id) {
		return listaDeProdutos.stream()
		                      .filter(produto -> produto.getId() == id)
		                      .findFirst()
		                      .orElse(null);
	}

	public static boolean cadastrarProduto(Produto produto) {
		return listaDeProdutos.add(produto);
	}

	public static void imprimirCatalagoDoEstoque() {
		System.out.format("%-5s %-30s %-10s %-10s", "ID", "PRODUTO", "PREÇO", "QUANTIDADE");
		listaDeProdutos.forEach(
				produto -> System.out.format("\n%-5s %-30s %-10s %-10s", produto.getId(),
				                             produto.getNome(),
				                             produto.getPreco(), produto.getQuantidadeEmEstoque()));

	}

	public static boolean darBaixaEmEstoquePeloNome(String nome, int quantidadeParaDarBaixa) {
		Produto produto = encontraProdutoNome(nome);
		if (produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa) {
			produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
			return true;
		}
		return false;
	}

	public static boolean darBaixaEmEstoquePeloID(int id, int quantidadeParaDarBaixa) {
		Produto produto = encontraProdutoID(id);
		if (produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa) {
			produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
			return true;
		}
		return false;
	}

	public static int getQuantidadeAtualEmEstoque(Produto produto) {
		return encontraProdutoNome(produto.getNome()).getQuantidadeEmEstoque();
	}

	public static int getPosicaoDoProdutoNaLista(Produto produto) {
		int possicaoDoProduto = -1;
		for (int index = 0; index < listaDeProdutos.size(); index++) {
			if (Objects.equals(listaDeProdutos.get(index).getNome(), produto.getNome())) {
				possicaoDoProduto = index;
			}
		}
		return possicaoDoProduto;
	}

	public static boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixar) {
		return encontraProdutoNome(produto.getNome()).getQuantidadeEmEstoque()
				       >= quantidadeParaDarBaixar;
	}

}
