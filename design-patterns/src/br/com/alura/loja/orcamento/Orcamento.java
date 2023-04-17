package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;
import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;
	private int quantidadeIntes;
	private SituacaoOrcamento situacao;

	public Orcamento(BigDecimal valor, int quantidadeIntes) {
		this.valor = valor;
		this.quantidadeIntes = quantidadeIntes;
		this.situacao = new EmAnalise();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}

	public void aprovar() {
		this.situacao.aprovar(this);
	}

	public void reprovar() {
		this.situacao.reprovar(this);
	}

	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public int getQuantidadeIntes() {
		return quantidadeIntes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}
}
