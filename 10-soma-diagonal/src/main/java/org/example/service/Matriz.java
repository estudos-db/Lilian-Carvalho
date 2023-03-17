package org.example.service;

import java.util.Scanner;

public class Matriz {

	private int valorSoma;

	public String somarDiagonalPrincipal(int[][] matrizEntrada) {
		for (int indexLinha = 0; indexLinha < matrizEntrada.length; indexLinha++) {
			for (int indexColuna = 0; indexColuna < matrizEntrada.length; indexColuna++) {
				if (indexColuna == indexLinha) {
					this.valorSoma += matrizEntrada[indexLinha][indexColuna];
				}
			}
		}
		return "Soma dos valos da diagonal princial: " + this.valorSoma;
	}

	public int[][] lerMatriz() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Qual a oredem da matriz?");
		int ordemDaMatriz = entrada.nextInt();
		int[][] matrizEntrada = new int[ordemDaMatriz][ordemDaMatriz];
		System.out.println("preencha a matriz");

		for (int indexLinha = 0; indexLinha < ordemDaMatriz; indexLinha++) {
			for (int indexColuna = 0; indexColuna < ordemDaMatriz; indexColuna++) {
				System.out.print("[" + indexLinha + "][" + indexColuna + "]: ");
				int valorEntrada = entrada.nextInt();
				matrizEntrada[indexLinha][indexColuna] = valorEntrada;
			}
		}
		return matrizEntrada;
	}

}
