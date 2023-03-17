package org.example.model;

import java.time.LocalDate;

public class Emprestimo {

	private LocalDate dataDeSaida;
	private LocalDate dataDeRetorno;
	private Livro livro;
	private Pessoa cliente;

	public Emprestimo(Livro livro, Pessoa cliente) {
		this.dataDeSaida = LocalDate.now();
		this.dataDeRetorno = LocalDate.now().plusDays(8);
		this.livro = livro;
		this.cliente = cliente;
	}

	public LocalDate getDataDeSaida() {
		return dataDeSaida;
	}

	public LocalDate getDataDeRetorno() {
		return dataDeRetorno;
	}

	public Livro getLivro() {
		return livro;
	}

	public Pessoa getCliente() {
		return cliente;
	}
}
