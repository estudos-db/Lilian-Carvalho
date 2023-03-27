package com.example.automoveis.model;

public class CarroAutomatico extends Carro {

	public CarroAutomatico(int velMaxima) {
		super(velMaxima);
	}

	@Override
	public boolean ligar() {
		if (this.isFreioPressiondo()) {
			return super.ligar();
		}
		return this.isLigado();
	}
}
