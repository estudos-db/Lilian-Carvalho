package br.com.alura.loja.acao;

import br.com.alura.loja.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoApoisGerarPedido {

	public void executarAcao(Pedido pedido) {
		System.out.println("Salvando dados do pedido no banco de dados");
	}
}
