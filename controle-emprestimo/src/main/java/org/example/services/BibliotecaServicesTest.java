package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.example.model.Livro;
import org.example.model.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaServicesTest {

    private BibliotecaServices bibliotecaServices;

    @BeforeEach
    void init() {
        bibliotecaServices = new BibliotecaServices();
    }

    @AfterEach
    void exit() {
        bibliotecaServices = null;
    }

    @Test
    void deveCadastrarUmLivro() {
        bibliotecaServices.cadastrarLivro("Java", "James Gosling", 5);
        assertFalse(bibliotecaServices.getLivrosCadastrados().isEmpty());
    }

    @Test
    void deveCadastrarUmCliente() {
        bibliotecaServices.cadastrarCliente("Marcela");
        assertFalse(bibliotecaServices.getClientesCadastrados().isEmpty());
    }

    @Test
    void buscarCliente() {
        bibliotecaServices.cadastrarCliente("Jeorge");
        Pessoa clienteCadastrado = bibliotecaServices.buscarCliente(3);

        assertEquals("Jeorge", clienteCadastrado.getNome());

    }

    @Test
    void buscarLivro() {
        bibliotecaServices = null;
        bibliotecaServices = new BibliotecaServices();
        bibliotecaServices.cadastrarLivro("Java", "James Gosling", 5);
        Livro livroCadastrado = bibliotecaServices.buscarLivro(3);
        assertEquals(3, livroCadastrado.getId());
        assertEquals("Java", livroCadastrado.getNomeDoLivro());
        assertEquals("James Gosling", livroCadastrado.getAutor());
        assertEquals(5, livroCadastrado.getQuantidade());
    }

    @Test
    void DeveReduzirAQuantidadeDoLivroQueFoiPegoEmprestado() {
        bibliotecaServices.cadastrarLivro("Java", "James Gosling", 5);
        bibliotecaServices.cadastrarCliente("Jeorge");

        bibliotecaServices.realizarEmprestimo(2, 1);
        Livro livroEmprestado = bibliotecaServices.buscarLivro(1);

        assertEquals(1, livroEmprestado.getId());
        assertEquals("Java", livroEmprestado.getNomeDoLivro());
        assertEquals("James Gosling", livroEmprestado.getAutor());
        assertEquals(4, livroEmprestado.getQuantidade());
    }
}
