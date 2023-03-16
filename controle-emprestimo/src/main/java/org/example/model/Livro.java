package org.example.model;

public class Livro {

	private static long sequence = 1;
	private long id;
	private String nomeDoLivro;
	private String autor;
	private int quantidade;
	private boolean disponivel;

	public Livro(String nomeDoLivro, String autor, int quantidade) {
		this.nomeDoLivro = nomeDoLivro;
		this.autor = autor;
		this.quantidade = quantidade;
		this.disponivel = true;
		this.id = sequence++;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public long getId() {
		return id;
	}

	public String getNomeDoLivro() {
		return nomeDoLivro;
	}

	public String getAutor() {
		return autor;

	}

	public int getQuantidade() {
		return quantidade;
	}

	public boolean isDisponivel() {
		return disponivel;
	}
}
