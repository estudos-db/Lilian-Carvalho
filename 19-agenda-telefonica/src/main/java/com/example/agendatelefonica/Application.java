package com.example.agendatelefonica;

import com.example.agendatelefonica.model.Agenda;
import com.example.agendatelefonica.model.Contato;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Agenda.adicionarContato(new Contato("Alessandra Sueli", "71992125729"));
		Agenda.adicionarContato(new Contato("Melissa Pietra", "66989270970"));
		Agenda.listarContatos();
		Agenda.removerContato("Melissa Pietra");
		Agenda.listarContatos();
		Agenda.removerContato("Melissa Pietra");
	}

}
