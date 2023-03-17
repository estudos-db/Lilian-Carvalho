package com.example.arvoregenealogica;

import com.example.arvoregenealogica.model.Pessoa;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Pessoa ricardo = new Pessoa("Ricardo", 25);

		Pessoa maeRicardo = new Pessoa("Julia", 55);
		ricardo.setMae(maeRicardo);

		Pessoa paiRicardo = new Pessoa("Mario", 60);
		ricardo.setPai(paiRicardo);

		Pessoa avoMaternoRicardo = new Pessoa("Maria", 80);
		Pessoa avoMaternoRicardo1 = new Pessoa("Joao", 85);
		maeRicardo.setMae(avoMaternoRicardo);
		maeRicardo.setPai(avoMaternoRicardo1);

		Pessoa avoPaternoRicardo = new Pessoa("Joana", 87);
		Pessoa avoPaternoRicardo1 = new Pessoa("José", 89);
		paiRicardo.setMae(avoPaternoRicardo);
		paiRicardo.setPai(avoPaternoRicardo1);

	}

}
