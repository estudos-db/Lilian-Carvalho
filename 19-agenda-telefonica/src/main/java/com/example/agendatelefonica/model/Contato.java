package com.example.agendatelefonica.model;

public class Contato {

	private String nome;
	private String sobrenome;
	private String numeroContato;

	private String email;
	private Endereco endereco;

	public Contato(String nome, String sobrenome, String numeroContato, String email,
	               Endereco endereco) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroContato = numeroContato;
		this.email = email;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public Endereco getEndereco() {
		return endereco;
	}
}
