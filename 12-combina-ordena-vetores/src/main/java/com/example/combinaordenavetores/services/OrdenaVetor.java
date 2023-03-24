package com.example.combinaordenavetores.services;

public class OrdenaVetor {
	public static int[] ordenarVetor(int[] vetorGerado) {
		int maior;
		for (int index = 0; index < vetorGerado.length; index++) {
			for (int segundoIndex = 0; segundoIndex < vetorGerado.length - 1; segundoIndex++) {
				if (vetorGerado[segundoIndex] > vetorGerado[segundoIndex + 1]) {
					maior = vetorGerado[segundoIndex];
					vetorGerado[segundoIndex] = vetorGerado[segundoIndex + 1];
					vetorGerado[segundoIndex + 1] = maior;
				}
			}
		}
		return vetorGerado;
	}
}
