package com.example.agendatelefonica.model;

public class Endereco {

	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco(String cep, String rua, String numero, String bairro, String cidade,
	                String estado) {
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
