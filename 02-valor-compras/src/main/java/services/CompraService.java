package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import model.Produto;

public abstract class CompraService {

	private static final ArrayList<Produto> produtos = new ArrayList<>();
	private static BigDecimal percentualDesconto;
	private static BigDecimal valorDesconto;

	public static void criarListaDecompras(Produto produto) {
		produtos.add(produto);
	}

	public static void calcularValorTotal() {
		produtos
		        .forEach(produto -> produto.setValorTotal(
				        produto.getValorUnitario().multiply(new BigDecimal(produto.getQuantidade()))));

	}

	public static BigDecimal calcularValorTotalDaCompra() {
		return produtos.stream()
		               .map(Produto::getValorTotal)
		               .reduce(BigDecimal::add)
		               .orElse(BigDecimal.ZERO);
	}

	public static void aplicarDesconto() {
		produtos.forEach(produto -> {
			Integer quantidade = produto.getQuantidade();
			if (quantidade >= 11 && quantidade <= 20) {
				calcularDesconto(0.10, produto);
			} else if (quantidade >= 21 && quantidade <= 50) {
				calcularDesconto(0.20, produto);
			} else if (quantidade > 50) {
				calcularDesconto(0.25, produto);
			}
		});
	}

	public static void calcularDesconto(double valor, Produto produto) {
		percentualDesconto = new BigDecimal(valor);
		valorDesconto = produto.getValorTotal().multiply(percentualDesconto);
		produto.setValorTotal(produto.getValorTotal().subtract(valorDesconto));
	}

	public static void realizarCompra() {
		calcularValorTotal();
		aplicarDesconto();

	}

	public static void gerarNotaFiscal() {
		System.out.println(
				"-----------------------------------------------------------------------------");
		System.out.printf("%-25s %-15s %10s %20s", "NOME", "VALOR UNITARIO", "QUANTIDADE",
		                  "VALOR TOTAL");
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------");
		for (Produto produto : produtos) {
			System.out.format("%-25s %-20.2f %-2d %20.2f", produto.getNome(), produto.getValorUnitario(),
			                  produto.getQuantidade(), produto.getValorTotal());
			System.out.println();
		}
		System.out.println(
				"-----------------------------------------------------------------------------");
		System.out.format("VALOR TOTAL DA COMPRA: %2.2f", calcularValorTotalDaCompra());
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------");

	}
}
