package com.example.arvoregenealogica.model;

public class Pessoa {

	private String nome;
	private int idade;
	private Pessoa pai;
	private Pessoa mae;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public Pessoa getPai() {
		return pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}
}
