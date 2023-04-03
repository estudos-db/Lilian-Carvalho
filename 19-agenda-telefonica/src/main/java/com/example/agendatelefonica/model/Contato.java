package com.example.agendatelefonica.model;

public class Contato {

	private String nome;

	private String numeroContato;

	public Contato(String nome, String numeroContato) {
		this.nome = nome;
		this.numeroContato = numeroContato;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroContato() {
		return numeroContato;
	}
}
