package com.example.automoveis.model;

public abstract class Automovel {

	private boolean acelerador;
	private boolean ligado;
	private boolean freio;
	private int numRodas;
	private int velMax;

	public Automovel(int numRodas, int velMax) {
		this.numRodas = numRodas;
		this.acelerador = false;
		this.velMax = velMax;
		this.ligado = false;
		this.freio = false;
	}

	public boolean acelerador() {
		return acelerador;
	}

	public boolean isLigado() {
		return ligado;
	}

	public boolean isFreioPressiondo() {
		return freio;
	}

	public boolean ligar() {
		return this.ligado = !this.ligado;
	}

	public boolean freiar() {
		return this.freio = !this.freio;
	}

	public boolean acelerar() {
		return this.acelerador = !this.acelerador;
	}
}
