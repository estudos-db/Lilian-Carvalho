package services;

import java.util.Scanner;

public class LeitorDeNumeros {

	public static void lerNumero() {
		Scanner scanner = new Scanner(System.in);
		int numero;
		do {
			System.out.println("Digite um valor diferente de 10: ");
			numero = scanner.nextInt();
		}
		while (numero != 10);
	}
}
