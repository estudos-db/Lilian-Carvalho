package com.example.supermercadoprova.model;

public class Produto {

	private static int sequence = 1;
	private int id;
	private String nome;
	private double preco;
	private int quantidadeEmEstoque;

	public Produto(String nome, double preco, int quantidadeEmEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.id = sequence++;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public long getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
}
