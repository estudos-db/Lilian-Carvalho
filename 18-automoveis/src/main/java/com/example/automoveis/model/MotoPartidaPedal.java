package com.example.automoveis.model;

public class MotoPartidaPedal extends Moto {

	public MotoPartidaPedal(int velMax) {
		super(velMax);
	}

	@Override
	public boolean ligar() {
		if (this.isAcelerado()) {
			return super.ligar();
		}
		return this.isLigado();
	}
}
