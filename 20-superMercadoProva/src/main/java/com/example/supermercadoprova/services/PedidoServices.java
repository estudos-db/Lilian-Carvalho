package com.example.supermercadoprova.services;

import static java.lang.System.in;
import static java.lang.System.out;

import com.example.supermercadoprova.model.Item;
import com.example.supermercadoprova.model.Pedido;
import com.example.supermercadoprova.model.Produto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public abstract class PedidoServices {

	private static final Pedido pedido = new Pedido();
	static Scanner scanner = new Scanner(in);

	public static double calcularValorTotal() {
		double valorTotalDoPedido = pedido.getListaDeItens()
		                                  .stream()
		                                  .mapToDouble(item -> item.defineValorTotal())
		                                  .sum();
		pedido.setValorTotalDoPedido(valorTotalDoPedido);

		return valorTotalDoPedido;
	}

	public static boolean adicionarItemNaLista(Produto produto, int quantidade) {
		if (produto.getQuantidadeEmEstoque() >= quantidade) {
			return pedido.getListaDeItens().add(new Item(produto, quantidade, produto.getPreco()));
		}
		return false;
	}

	public static void imprimePedido() {
		if (pedido.getListaDeItens().isEmpty()) {
			out.print("Nenhum produto adicionado ao carrinho!");
		} else {
			out.format("%-30s %-15s %-15s %-15s", "NOME", "VALOR UNID.", "QUANTIDADE", "VALOR TOTAL");
			pedido.getListaDeItens()
			      .forEach(item -> out.format("\n%-30s %-15s %-15s %-15s", item.getProduto().getNome(),
			                                  item.getValorDoItem(), item.getQuantidade(),
			                                  item.getValorDoItem() * item.getQuantidade()));
		}
	}

	public static String imprimeValorTotal() {
		calcularValorTotal();
		return "\nVALOR TOTAL = R$ " + pedido.getValorTotalDoPedido();
	}

	public static void limparCarrinho() {
		pedido.getListaDeItens().clear();
	}

	public static String calculaTroco(double valorPago) {

		if (valorPago >= pedido.getValorTotalDoPedido()) {
			pedido.setValorTroco(valorPago - pedido.getValorTotalDoPedido());
			BigDecimal valorTrocoBigDecimal = BigDecimal.valueOf(pedido.getValorTroco())
			                                            .setScale(2, RoundingMode.HALF_EVEN);
			return "\nTROCO = R$ " + valorTrocoBigDecimal + "\n" + calculaMenorQuantidadeDeNotas()
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
			while (pedido.getValorTroco() >= notasDisponiveis[i]) {
				quantidadeNotas[i]++;
				pedido.setValorTroco(pedido.getValorTroco() - notasDisponiveis[i]);
			}
		}
		int index = 0;
		for (int contQuantidade : quantidadeNotas) {
			if (quantidadeNotas[index] != 0) {
				result =
						result + quantidadeNotas[index] + " nota(s) de R$ " + notasDisponiveis[index] + "\n";
			}
			index++;
		}

		return result;
	}

	public static String calculaMenorQuantidadeDeMoedas() {
		int[] moedasDisponiveis = {100, 50, 25, 10, 5};
		int[] quantidadeMoedas = new int[moedasDisponiveis.length];

		String result = "";

		if (pedido.getValorTroco() > 1) {
			result = result + "1 moeda(s) de R$ 1\n";
		}
		int valorCentavos = (int) Math.round(
				(pedido.getValorTroco() - (int) pedido.getValorTroco()) * 100);
		for (int i = 0; i < moedasDisponiveis.length; i++) {
			while (valorCentavos >= moedasDisponiveis[i]) {
				quantidadeMoedas[i]++;
				valorCentavos -= moedasDisponiveis[i];
			}
		}
		int index = 0;
		for (int contQuantidade : quantidadeMoedas) {
			if (quantidadeMoedas[contQuantidade] != 0) {
				result = result + quantidadeMoedas[index] + " moeda(s) de " + moedasDisponiveis[index]
						         + " centavos\n";
			}
			index++;
		}
		return result;
	}

	public static Pedido getPedido() {
		return pedido;
	}

	public static boolean adicionaItem() {
		String nomeDoProduto = recebeNomeDoTeclado();
		Produto produto = EstoqueServices.encontraProdutoNome(nomeDoProduto);
		int quantidade = recebeQuantidadeDoTeclado();
		if (produto.getQuantidadeEmEstoque() >= quantidade) {
			return pedido.getListaDeItens().add(new Item(produto, quantidade, produto.getPreco()));
		} else {
			return false;
		}
	}

	public static String recebeNomeDoTeclado() {
		out.print("Informe o nome do produto: ");
		return scanner.nextLine();
	}

	public static int recebeQuantidadeDoTeclado() {
		out.print("Informe a quantidade de produtos: ");
		return scanner.nextInt();
	}

}
