package com.example.supermercadoprova.model;

public class Item {

	private Produto produto;
	private int quantidade;
	private double valorDoItem;

	public Item(Produto produto, int quantidade, double valorDoItem) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorDoItem = valorDoItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorDoItem() {
		return valorDoItem;
	}

	public Produto getProduto() {
		return produto;
	}

	public double defineValorTotal() {
		return this.valorDoItem * this.quantidade;
	}
}
