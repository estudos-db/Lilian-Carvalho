package org.example;

import org.example.service.Matriz;

public class Main {

	public static void main(String[] args) {

		Matriz matriz = new Matriz();
		int[][] matrizEntrada = matriz.lerMatriz();
		String resultado = matriz.somarDiagonalPrincipal(matrizEntrada);
		System.out.println(resultado);

	}
}