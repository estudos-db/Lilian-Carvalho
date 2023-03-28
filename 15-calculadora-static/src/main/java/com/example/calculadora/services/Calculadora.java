package com.example.calculadora.services;

public abstract class Calculadora {

	public static int somar(int primeiroValor, int segundoValor) {
		return primeiroValor + segundoValor;
	}

	public static int subtrair(int primeiroValor, int segundoValor) {
		return primeiroValor - segundoValor;
	}

	public static int multiplicacar(int primeiroValor, int segundoValor) {
		return primeiroValor * segundoValor;
	}

	public static double dividir(int primeiroValor, int segundoValor) {
		return primeiroValor / segundoValor;
	}

	public static double calcularPotencia(int base, int expoente) {
		return Math.pow(base, expoente);
	}
}
