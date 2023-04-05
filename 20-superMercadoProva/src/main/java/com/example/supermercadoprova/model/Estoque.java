package com.example.supermercadoprova.model;

import java.util.ArrayList;

public class Estoque {

	private ArrayList<Produto> listaDeProdutos = new ArrayList<>();
	private int id;
	public Estoque() {
		this.id = 1;
	}

	public ArrayList<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

}
