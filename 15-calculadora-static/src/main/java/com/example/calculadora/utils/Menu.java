package com.example.calculadora.utils;

import com.example.calculadora.services.Calculadora;
import java.util.Scanner;

public abstract class Menu {

	public static void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		int base = 0;
		int expoente = 0;
		int primeiroValor = 0;
		int segundoValor = 0;

		System.out.println("Escolha a operação que deseja fazer");
		System.out.println("1. SOMA");
		System.out.println("2. SUBTRAÇÃO");
		System.out.println("3. MULTIPLICAÇÃO");
		System.out.println("4. DIVISÃO");
		System.out.println("5. POTENCIAÇÃO");
		System.out.print("QUAL OPERAÇÃO DESEJA FAZER: ");
		int operacao = scanner.nextInt();
		if (operacao == 5) {
			System.out.print("Infome a base: ");
			base = scanner.nextInt();
			System.out.print("Informe o expoente: ");
			expoente = scanner.nextInt();
		} else {
			System.out.println("Primeiro valor: ");
			primeiroValor = scanner.nextInt();
			System.out.println("Segundo valor: ");
			segundoValor = scanner.nextInt();
		}

		switch (operacao) {
			case 1:
				System.out.println("Resultado: " + Calculadora.somar(primeiroValor, segundoValor));
				break;
			case 2:
				System.out.println("Resultado: " + Calculadora.subtrair(primeiroValor, segundoValor));
				break;
			case 3:
				System.out.println("Resultado: " + Calculadora.multiplicacar(primeiroValor, segundoValor));
				break;
			case 4:
				System.out.println("Resultado: " + Calculadora.dividir(primeiroValor, segundoValor));
				break;
			case 5:
				System.out.println("Resultado: " + Calculadora.calcularPotencia(base, expoente));
				break;
			default:
				System.out.println("Operação invalida!");
		}
	}
}
