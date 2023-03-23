package services;

import java.util.ArrayList;
import java.util.List;

public class TabuadaService implements ITabuadaService {

	public void exibirResultado(List<Integer> resultado, int valor) {
		for (int index = 1; index <= 10; index++) {
			System.out.format("\n%-3dX%3d  =  %-4d", index, valor, resultado.get(index - 1));
		}
	}

	public List<Integer> calcularTabuada(int valor) {
		List<Integer> resultado = new ArrayList<>();
		for (int index = 1; index <= 10; index++) {
			resultado.add(index * valor);
		}
		return resultado;
	}

}
