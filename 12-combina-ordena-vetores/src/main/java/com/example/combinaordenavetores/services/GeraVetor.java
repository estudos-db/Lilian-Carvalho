package com.example.combinaordenavetores.services;

import java.util.Random;

public class GeraVetor {

	public static int[] gerarVetor(int tamanhoVetor) {
		Random gerador = new Random();
		int[] vetorGerado = new int[tamanhoVetor];

		for (int index = 0; index < tamanhoVetor; index++) {
			vetorGerado[index] = gerador.nextInt(101);
		}
		return vetorGerado;
	}

}
