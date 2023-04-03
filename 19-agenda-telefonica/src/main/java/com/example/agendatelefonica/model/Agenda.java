package com.example.agendatelefonica.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Agenda {

	private static final Set<Contato> contatosCadastrados = new HashSet<>();

	public static Set<Contato> listarContatos() {
		return contatosCadastrados;
	}

	public static void exibirContatos() {
		if (contatosCadastrados.isEmpty()) {
			System.out.println("Nenhum contato cadastrado!");
		} else {
			System.out.format("%-30s%-13s", "\nNOME", " CONTATO");
			contatosCadastrados.forEach(contato -> System.out.format("\n%-30s%-13s", contato.getNome(),
			                                                         contato.getNumeroContato()));
		}
	}

	public static boolean adicionarContato(Contato contato) {
		return contatosCadastrados.add(contato);
	}

	public static Contato buscaContato(String nome) {
		return contatosCadastrados.stream()
		                          .filter(contato -> Objects.equals(contato.getNome(), nome))
		                          .findFirst()
		                          .orElse(null);
	}

	public static boolean removerContato(String nome) {
		return contatosCadastrados.remove(buscaContato(nome));
	}
}
