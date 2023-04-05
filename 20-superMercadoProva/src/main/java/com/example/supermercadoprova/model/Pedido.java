package com.example.supermercadoprova.model;

import com.example.supermercadoprova.utils.DoubleDuasCasasDecimais;
import java.util.ArrayList;

public class Pedido {

	private final ArrayList<Item> listaDeItens = new ArrayList<>();
	private double valorTotalDoPedido;
	private double valorTroco;

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}

	public void setValorTotalDoPedido(double valorTotalDoPedido) {
		DoubleDuasCasasDecimais.converterDoubleDoisDecimais(valorTotalDoPedido);
		this.valorTotalDoPedido = valorTotalDoPedido;
	}

	public ArrayList<Item> getListaDeItens() {
		return listaDeItens;
	}

	public double getValorTotalDoPedido() {
		return DoubleDuasCasasDecimais.converterDoubleDoisDecimais(valorTotalDoPedido);
	}

	public double getValorTroco() {
		return DoubleDuasCasasDecimais.converterDoubleDoisDecimais(valorTroco);
	}
}
