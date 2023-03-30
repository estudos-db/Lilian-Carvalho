package com.example.supermercadoprova.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pedido {

	private static ArrayList<Item> listaDeItens = new ArrayList<>();
	private static double valorTotalDoPedido;
	private static double valorTroco;
	Scanner scanner = new Scanner(System.in);

	public static void calcularValorTotal() {
		listaDeItens.forEach(item -> valorTotalDoPedido += item.defineValorTotal());
	}

	public static boolean adicionarItemNaLista(Produto produto, int quantidade) {
		if (produto.getQuantidadeEmEstoque() >= quantidade) {
			return listaDeItens.add(new Item(produto, quantidade, produto.getPreco()));
		}
		return false;
	}

	public static void imprimePedido() {
		if (listaDeItens.isEmpty()) {
			System.out.println("Nenhum produto adicionado ao carrinho!");
		} else {
			System.out.format("%-30s %-15s %-15s %-15s", "NOME", "VALOR UNID.", "QUANTIDADE",
			                  "VALOR TOTAL");
			listaDeItens.forEach(
					item -> System.out.format("\n%-30s %-15s %-15s %-15s", item.getProduto().getNome(),
					                          item.getValorDoItem(), item.getQuantidade(),
					                          item.getValorDoItem() * item.getQuantidade()));
		}
	}

	public static void imprimeValorTotal() {
		calcularValorTotal();
		System.out.println("\nVALOR TOTAL: " + valorTotalDoPedido);
	}

	public static void limparCarrinho() {
		listaDeItens.clear();
	}

	public static String calculaTroco(double valorPago) {

		if (valorPago >= valorTotalDoPedido) {
			valorTroco = valorPago - valorTotalDoPedido;
			BigDecimal valorTrocoBigDecimal = new BigDecimal(valorTroco).setScale(2,
			                                                                      RoundingMode.HALF_EVEN);
			return "TROCO = R$" + valorTrocoBigDecimal + "\n" + calculaMenorQuantidadeDeNotas()
					       + calculaMenorQuantidadeDeMoedas();
		} else {
			return "Valor pago é insuficiente!";
		}
	}

	public static String calculaMenorQuantidadeDeNotas() {

		int[] notasDisponiveis = {200, 100, 50, 20, 10, 5, 2};
		int[] quantidadeNotas = new int[notasDisponiveis.length];

		String result = "";

		for (int i = 0; i < notasDisponiveis.length; i++) {
			while (valorTroco >= notasDisponiveis[i]) {
				quantidadeNotas[i]++;
				valorTroco -= notasDisponiveis[i];
			}
		}

		for (int index = 0; index < quantidadeNotas.length; index++) {
			if (quantidadeNotas[index] != 0) {
				result =
						result + quantidadeNotas[index] + " nota(s) de R$ " + notasDisponiveis[index] + "\n";
			}
		}

		return result;
	}

	public static String calculaMenorQuantidadeDeMoedas() {
		int[] moedasDisponiveis = {100, 50, 25, 10, 5};
		int[] quantidadeMoedas = new int[moedasDisponiveis.length];

		String result = "";

		if (valorTroco > 1) {
			result = result + "1 moeda(s) de R$ 1\n";
		}
		int valorCentavos = (int) Math.round((valorTroco - (int) valorTroco) * 100);
		for (int i = 0; i < moedasDisponiveis.length; i++) {
			while (valorCentavos >= moedasDisponiveis[i]) {
				quantidadeMoedas[i]++;
				valorCentavos -= moedasDisponiveis[i];
			}
		}
		for (int index = 0; index < quantidadeMoedas.length; index++) {
			if (quantidadeMoedas[index] != 0) {
				result = result + quantidadeMoedas[index] + " moeda(s) de " + moedasDisponiveis[index]
						         + " centavos\n";
			}
		}
		return result;
	}

	public void adicionaItem() {
		Produto produto = Estoque.encontraProdutoNome(recebeNomeDoTeclado());
		int quantidade = recebeQuantidadeDoTeclado();
		if (produto.getQuantidadeEmEstoque() >= quantidade) {
			listaDeItens.add(new Item(produto, quantidade, produto.getPreco()));
		} else {
			System.out.println("Produto insuficiente no estoque");
		}
	}

	public String recebeNomeDoTeclado() {
		System.out.print("Informe o nome do produto: ");
		return scanner.nextLine();
	}

	public int recebeQuantidadeDoTeclado() {
		System.out.print("Informe a quantidade de produtos: ");
		return scanner.nextInt();
	}
}
