package br.com.alura.loja.pedido;

import br.com.alura.loja.acao.AcaoApoisGerarPedido;
import br.com.alura.loja.orcamento.Orcamento;
import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {

	private List<AcaoApoisGerarPedido> acoes;

	public GeraPedidoHandler(List<AcaoApoisGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidade());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		acoes.forEach(acaoApoisGerarPedido -> acaoApoisGerarPedido.executarAcao(pedido));

	}
}
