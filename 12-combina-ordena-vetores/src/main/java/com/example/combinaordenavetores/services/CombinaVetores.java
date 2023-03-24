package com.example.combinaordenavetores.services;

public class CombinaVetores {

	public static int[] combinarVetores(int[] primeiroVetor, int[] segundoVetor) {
		int tamanhoVetorCombinado = primeiroVetor.length + segundoVetor.length;
		int index;
		int segundoIndex = 0;
		int[] vetorCombinado = new int[tamanhoVetorCombinado];

		for (index = 0; index < primeiroVetor.length; index++) {
			vetorCombinado[index] = primeiroVetor[index];
		}

		for (index = primeiroVetor.length; index < vetorCombinado.length; index++, segundoIndex++) {
			vetorCombinado[index] = segundoVetor[segundoIndex];
		}
		return vetorCombinado;
	}
}
