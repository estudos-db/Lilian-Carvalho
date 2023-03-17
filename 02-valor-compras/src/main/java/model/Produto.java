package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

	private final String nome;
	private final BigDecimal valorUnitario;
	private final Integer quantidade;
	private BigDecimal valorTotal;

	public Produto(String nome, BigDecimal valorUnitario, Integer quantidade) {
		this.nome = nome;
		this.valorUnitario = valorUnitario.setScale(2, RoundingMode.HALF_UP);
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		this.valorTotal = this.valorTotal.setScale(2, RoundingMode.HALF_UP);
	}
	public String getNome() {
		return nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}


}

