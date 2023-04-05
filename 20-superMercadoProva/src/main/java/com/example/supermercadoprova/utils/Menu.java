package com.example.supermercadoprova.utils;

import static java.lang.System.out;

import com.example.supermercadoprova.model.Produto;
import com.example.supermercadoprova.services.EstoqueServices;
import java.util.Scanner;

public abstract class Menu {

	Scanner scanner = new Scanner(System.in);
	String nomeProduto;
	int quantidade;

	public void controlaMenu() {
		out.println("1. Mostrar estoque");
		out.println("2. Buscas produto por nome");
		out.println("3. Buscas produto por ID");
		out.println("4. Cadastrar produto no estoque");
		out.println("5. Dar baixa em produto do estoque pelo nome");
		out.println("6. Dar baixa em produto do estoque pelo ID");
		out.println("7. Ver quantidade do produto em estoque");
		out.println("8. Ver posição do produto no estoque");
		out.println("9. Verificar disponibilidade do produto no estoque");
		int opcao = scanner.nextInt();

		switch (opcao) {
			case 1:
				EstoqueServices.imprimirCatalagoDoEstoque();
				break;
			case 2:
				out.print("Qual nome do produto que deseja buscar?");
				nomeProduto = scanner.nextLine();
				EstoqueServices.exibirProduto(EstoqueServices.encontraProdutoNome(nomeProduto));
			case 3:
				out.print("Qual ID do produto que deseja buscar?");
				int id = scanner.nextInt();
				EstoqueServices.exibirProduto(EstoqueServices.encontraProdutoID(id));
				break;
			case 4:
				out.print("Nome do produto que deseja cadastrar: ");
				nomeProduto = scanner.nextLine();
				out.print("Valor do produto: ");
				double valorProduto = scanner.nextDouble();
				out.print("Quantidade do produtos: ");
				quantidade = scanner.nextInt();
				EstoqueServices.cadastrarProduto(new Produto(nomeProduto, valorProduto, quantidade));
				break;
			case 5:
				out.print("Nome do produto para dar baixa: ");
				nomeProduto = scanner.nextLine();
				out.print("Quantidade para dar baixa: ");
				quantidade = scanner.nextInt();
				EstoqueServices.darBaixaEmEstoquePeloNome(nomeProduto, quantidade);
				break;
			case 6:
				out.print("ID do produto para dar baixa: ");
				int iDProduto = scanner.nextInt();
				out.print("Quantidade para dar baixa: ");
				quantidade = scanner.nextInt();
				out.println(EstoqueServices.darBaixaEmEstoquePeloID(iDProduto, quantidade));
				break;
			case 7:
				out.print("Nome do produto que deseja ver a quantidade em estoque: ");
				nomeProduto = scanner.nextLine();
				out.println(EstoqueServices.getQuantidadeAtualEmEstoque(
						EstoqueServices.encontraProdutoNome(nomeProduto)));
				break;
			case 8:
				out.print("Nome do produto que deseja ver sua posição no estoque: ");
				nomeProduto = scanner.nextLine();
				out.println(EstoqueServices.getPosicaoDoProdutoNaLista(
						EstoqueServices.encontraProdutoNome(nomeProduto)));
				break;
			case 9:
				out.print("Nome do produto que deseja ver a disponibilidade em estoque: ");
				nomeProduto = scanner.nextLine();
				out.print("Quantidade de produtos que deseja ver a disponibilidade em estoque: ");
				quantidade = scanner.nextInt();
				out.println(
						EstoqueServices.temEstoqueOuNao(EstoqueServices.encontraProdutoNome(nomeProduto),
						                                quantidade));
				break;
			default:
				out.print("Opção invalida!");
		}

	}
}
