package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {

	private String cliente;

	private BigDecimal valorOrcamento;

	private int quantidade;

	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidade) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidade = quantidade;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
