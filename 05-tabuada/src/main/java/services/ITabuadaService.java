package services;

import java.util.List;

public interface ITabuadaService {

	List<Integer> calcularTabuada(int valor);

	void exibirResultado(List<Integer> resultado, int valor);
}
