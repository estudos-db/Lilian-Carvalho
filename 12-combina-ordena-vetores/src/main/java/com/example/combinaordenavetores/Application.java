package com.example.combinaordenavetores;

import com.example.combinaordenavetores.services.CombinaVetores;
import com.example.combinaordenavetores.services.GeraVetor;
import com.example.combinaordenavetores.services.OrdenaVetor;
import java.util.Arrays;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		int[] vetor1 = GeraVetor.gerarVetor(50);
		int[] vetor2 = GeraVetor.gerarVetor(50);
		System.out.println(Arrays.toString(vetor1));
		System.out.println(Arrays.toString(vetor2));

		System.out.println(Arrays.toString(CombinaVetores.combinarVetores(vetor1, vetor2)));
		System.out.println(
				Arrays.toString(OrdenaVetor.ordenarVetor(CombinaVetores.combinarVetores(vetor1, vetor2))));

	}

}
