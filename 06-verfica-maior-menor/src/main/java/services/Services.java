package services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Services {

	Set<Integer> numeros = new HashSet<>();

	public Services(Set<Integer> numeros) {
		this.numeros = numeros;
	}

	public Services() {
	}

	public int maiorValor() {
		return Collections.max(this.numeros);
	}

	public int menorValor() {
		return Collections.min(this.numeros);
	}

	public Set<Integer> gerarArray() {

		while (numeros.size() < 10) {
			numeros.add(new Random().nextInt(101));
		}
		return this.numeros;
	}

}
