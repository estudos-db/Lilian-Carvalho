package org.exercicio.services;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public List<Integer> calculaFibonacci(int numero) {
		List<Integer> arrayResultado = new ArrayList<>();
		arrayResultado.add(0);

		int primeiroNumero = 0, segundoNumero = 1, proximo;

		if (numero > 0) {
			for (int index = 0; index < numero; index++) {
				proximo = primeiroNumero + segundoNumero;
				primeiroNumero = segundoNumero;
				segundoNumero = proximo;
				if (primeiroNumero <= numero) {
					arrayResultado.add(primeiroNumero);
				}
			}
			return arrayResultado;
		}
		return new ArrayList<>();
	}
}
