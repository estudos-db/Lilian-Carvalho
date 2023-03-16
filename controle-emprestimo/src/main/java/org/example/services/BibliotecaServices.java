package org.example.services;

import java.util.HashSet;
import java.util.Set;

import org.example.exceptions.ExceptionCliente;
import org.example.exceptions.ExceptionLivro;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.model.Pessoa;

public class BibliotecaServices {

    private Set<Livro> livrosCadastrados = new HashSet<>();
    private Set<Pessoa> clientesCadastrados = new HashSet<>();
    private Set<Emprestimo> emprestimos = new HashSet<>();

    public void cadastrarLivro(String nomeDoLivro, String nomeAutor, int quantidade) {
        this.livrosCadastrados.add(new Livro(nomeDoLivro, nomeAutor, quantidade));
    }

    public void listarLivrosDisponiveis() {
        try {
            if (this.livrosCadastrados.isEmpty()) {
                throw new ExceptionLivro("\nNenhum Livro Cadastrado no Sistema!");
            }
            System.out.format("%-3s %-30s %-30s %-4s", "\nID", "NOME DO LIVRO", "AUTOR",
                    "QTD. DISPONIVEL");
            this.livrosCadastrados.stream()
                    .filter(Livro::isDisponivel)
                    .forEach(
                            livro -> System.out.format("\n%-3s %-30s %-30s %-4s",
                                    livro.getId(),
                                    livro.getNomeDoLivro(),
                                    livro.getAutor(),
                                    livro.getQuantidade()));
        } catch (ExceptionLivro nenhumLivroCadastrado) {
            System.out.println(nenhumLivroCadastrado.getMessage());
        }
    }

    public void cadastrarCliente(String nome) {
        this.clientesCadastrados.add(new Pessoa(nome));
    }

    public void listarClientesCadastrados() {
        try {
            if (this.clientesCadastrados.isEmpty()) {
                throw new ExceptionCliente("\nNenhum Cliente Cadastrado no Sistema!");
            }
            System.out.format("\n\n%-3s %-30s", "ID", "NOME");
            this.clientesCadastrados.forEach(
                    cliente -> System.out.format("\n%-3s %-30s", cliente.getId(), cliente.getNome()));
        } catch (ExceptionCliente nenhumClienteCadastrado) {
            System.out.println(nenhumClienteCadastrado.getMessage());
        }
    }

    public Pessoa buscarCliente(long id) {
        return this.clientesCadastrados.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElseThrow();

    }

    public Livro buscarLivro(long id) {
        return this.livrosCadastrados.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElseThrow();

    }

    public Set<Livro> getLivrosCadastrados() {
        return livrosCadastrados;
    }

    public Set<Pessoa> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public Set<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void realizarEmprestimo(long idCliente, long idLivro) {
        Pessoa cliente = buscarCliente(idCliente);
        Livro livro = buscarLivro(idLivro);
        livro.setQuantidade(livro.getQuantidade() - 1);

        if (livro.getQuantidade() == 0) {
            livro.setDisponivel(false);
        }

        cliente.setLivrosPegosEmprestados(livro);

        emprestimos.add(new Emprestimo(livro, cliente));

    }

    public void listarEmprestimos() {
        System.out.format("%-30s %-30s %-15s %-15s", "\nCLIENTE", "LIVRO", "DATA SAIDA",
                "DATA RETORNO");
        this.emprestimos.forEach(emprestimo -> System.out.format("\n%-30s %-30s %-15s %-15s",
                emprestimo.getCliente().getNome(),
                emprestimo.getLivro().getNomeDoLivro(),
                emprestimo.getDataDeSaida(),
                emprestimo.getDataDeRetorno()));
    }

}
