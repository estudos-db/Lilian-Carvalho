package org.example.model;

import java.util.Set;

public class Pessoa {

	private static long sequence = 1;
	private long id;
	private String nome;
	private Set<Livro> livrosPegosEmprestados = new HashSet<>();


	public Pessoa(String nome) {
		this.nome = nome;
		this.id = sequence++;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setLivrosPegosEmprestados(Livro livroPegoEmprestado) {
		this.livrosPegosEmprestados.add(livroPegoEmprestado);
	}
}
