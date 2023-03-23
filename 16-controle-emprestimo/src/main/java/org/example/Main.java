package org.example;

import org.example.services.BibliotecaServices;

public class Main {

	public static void main(String[] args) {

		BibliotecaServices bibliotecaServices = new BibliotecaServices();
		bibliotecaServices.cadastrarLivro("O poder do hábito", "Charles Duhigg", 3);
		bibliotecaServices.cadastrarLivro("Antes que o café esfrie", "Toshikazu Kawaguchi", 5);
		bibliotecaServices.cadastrarCliente("Lucas Amaral");
		bibliotecaServices.cadastrarCliente("Joana Silva");
		bibliotecaServices.listarLivrosDisponiveis();
		bibliotecaServices.listarClientesCadastrados();
		bibliotecaServices.realizarEmprestimo(1, 2);
		bibliotecaServices.listarLivrosDisponiveis();
		bibliotecaServices.listarEmprestimos();

	}
}