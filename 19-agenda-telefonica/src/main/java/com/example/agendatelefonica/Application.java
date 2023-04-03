package com.example.agendatelefonica;

import static java.lang.System.out;

import com.example.agendatelefonica.model.Contato;
import com.example.agendatelefonica.model.Endereco;
import com.example.agendatelefonica.services.Agenda;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Endereco endereco = new Endereco("88350720", "Rua Guilherme Alberto Frederico Hoeffelmann",
		                                 "779", "Rio Branco", "Brusque", "SC");
		Endereco endereco2 = new Endereco("45991004", "Travessa 10", "546", "Urbis II",
		                                  "Teixeira de Freitas", "BA");
		Agenda.adicionarContato(
				new Contato("Daniela", "Lavínia", "71992125729", "daniela_lavinia@gmail.com", endereco));
		Agenda.adicionarContato(
				new Contato("Rebeca", "Galvão", "66989270970", "rebeca_galvao@gmail.com", endereco2));
		Agenda.exibirContatos();
		Agenda.removerContato("Daniela");
		Agenda.exibirContatos();
		out.println("\n" + Agenda.removerContato("Daniela"));
	}

}
