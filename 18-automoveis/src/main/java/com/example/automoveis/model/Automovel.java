package com.example.automoveis.model;

public abstract class Automovel {

	private boolean isAcelerado;
	private boolean isLigado;
	private boolean isFreioPressiondo;
	private int numRodas;
	private int velMax;

	public Automovel(int numRodas, int velMax) {
		this.numRodas = numRodas;
		this.isAcelerado = false;
		this.velMax = velMax;
		this.isLigado = false;
		this.isFreioPressiondo = false;
	}

	public boolean isAcelerado() {
		return isAcelerado;
	}
	public boolean isLigado() {
		return isLigado;
	}
	public boolean isFreioPressiondo() {
		return isFreioPressiondo;
	}
	public boolean ligar() {
		return this.isLigado = true;
	}
	public boolean freiar() {
		return this.isFreioPressiondo = true;
	}

	public boolean acelerar() {
		return this.isAcelerado = true;
	}
}
