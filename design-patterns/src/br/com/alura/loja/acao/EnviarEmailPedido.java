package br.com.alura.loja.acao;

import br.com.alura.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoApoisGerarPedido {

	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando email com dados do pedido");
	}
}
