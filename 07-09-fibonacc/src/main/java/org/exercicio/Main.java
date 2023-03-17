package org.exercicio;

import org.exercicio.services.Fibonacci;

public class Main {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.calculaFibonacci(4));
		System.out.println(fibonacci.calculaFibonacci(9));
		System.out.println(fibonacci.calculaFibonacci(25));
	}
}