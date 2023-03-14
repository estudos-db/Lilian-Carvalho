import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Elementos {

	private Set<Integer> numeros;
	private int valorEsperado;

	public Elementos(Set<Integer> numeros, int valorEsperado) {
		this.numeros = numeros;
		this.valorEsperado = valorEsperado;
	}

	public boolean verifica() {
		final Map<Integer, Boolean> map = new HashMap<>();
		numeros.forEach(numero -> {
			map.put(valorEsperado - numero, true);
		});

		for (Integer numero : numeros) {
			if (Boolean.TRUE.equals(map.get(Integer.valueOf(numero)))) {
				return true;
			}
		}

		return false;
	}
}
