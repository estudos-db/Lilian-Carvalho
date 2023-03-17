package services;

import java.util.Scanner;

public class Calculadora {

	public void menu() {
		Scanner entrada = new Scanner(System.in);
		double primeiroNumero;
		double segundoNumero;
		int numeroOperacao;

		do {
			System.out.print("\nPrimeio Numero: ");
			primeiroNumero = entrada.nextDouble();
			System.out.print("Segundo Numero: ");
			segundoNumero = entrada.nextDouble();
			System.out.println("\n1.Soma");
			System.out.println("2.Subtração");
			System.out.println("3.Divisão");
			System.out.println("4.Multiplicaçõa");
			System.out.println("0.SAIR");
			System.out.print("Operação: ");
			numeroOperacao = entrada.nextInt();
			System.out.println();

			Operacoes operacoes = new Operacoes();

			switch (numeroOperacao) {
				case 1:
					System.out.print(operacoes.soma(primeiroNumero, segundoNumero));
					break;
				case 2:
					System.out.println(operacoes.subtracao(primeiroNumero, segundoNumero));
					break;
				case 3:
					System.out.println(operacoes.divisao(primeiroNumero, segundoNumero));
					break;
				case 4:
					System.out.println(operacoes.multiplicacao(primeiroNumero, segundoNumero));
					break;
				case 0:
					break;
				default:
					System.out.println("Operação Invalida");

			}
		}
		while (numeroOperacao != 0);
	}
}
