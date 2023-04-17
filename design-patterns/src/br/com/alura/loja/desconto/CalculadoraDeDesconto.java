package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class CalculadoraDeDesconto {

	public BigDecimal calcular(Orcamento orcamento) {
		Desconto cadeiaDeDesconto = new DescontoQuantidade(new DescontoValor(new SemDesconto()));

		return cadeiaDeDesconto.calcular(orcamento);
	}

}
