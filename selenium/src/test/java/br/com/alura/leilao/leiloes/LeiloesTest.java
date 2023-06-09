package br.com.alura.leilao.leiloes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.alura.leilao.login.LoginPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeiloesTest {

	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;

	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preecheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		this.paginaDeCadastro = this.paginaDeLeiloes.carregarFormulario();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}

	@Test
	public void deveriaCadastrarLeilao() {

		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";

		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}

	@Test
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = this.paginaDeCadastro.cadastrarLeilao("", "", "");
		assertFalse(this.paginaDeCadastro.isPaginaAtual());
		assertTrue(this.paginaDeLeiloes.isPaginaAtual());
		assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());


	}

}
