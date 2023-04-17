package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDesconto;
import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class TesteDescontos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("200"), 6);
		Orcamento orcamentoSegundo = new Orcamento(new BigDecimal("1000"), 1);

		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		System.out.println(calculadoraDeDesconto.calcular(orcamento));
		System.out.println(calculadoraDeDesconto.calcular(orcamentoSegundo));


	}
}
