package utils;

import java.util.List;
import java.util.Scanner;
import services.TabuadaService;

public abstract class Menu {

	public static void exibirMenu() {
		Scanner entrada = new Scanner(System.in);
		TabuadaService tabuadaService = new TabuadaService();

		System.out.print("\nDe qual numero deseja gerar a tabuada? ");
		int valor = entrada.nextInt();
		List<Integer> resultado = tabuadaService.calcularTabuada(valor);
		tabuadaService.exibirResultado(resultado, valor);
	}

}
