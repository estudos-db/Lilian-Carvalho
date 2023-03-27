package com.example.automoveis.model;

import java.util.HashSet;
import java.util.Set;

public class Guincho extends Automovel {

	private Set<Automovel> veiculosCarregados = new HashSet<>();
	private boolean carregado;

	public Guincho(int numRodas, int velMax) {
		super(numRodas, velMax);
		this.carregado = false;
	}

	public boolean carregar(Automovel automovel) {
		if (!this.carregado) {
			this.veiculosCarregados.add(automovel);
			return this.carregado = true;
		}
		return false;
	}

	public boolean isCarregado() {
		return carregado;
	}
}
