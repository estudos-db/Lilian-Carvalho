package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {

		paginaDeLogin.preecheFormularioDeLogin("fulano", "pass");

		paginaDeLogin.efetuaLogin();

		assertFalse(paginaDeLogin.isPaginaDeLogin());
		assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {

		paginaDeLogin.preecheFormularioDeLogin("invalido", "1234");
		paginaDeLogin.efetuaLogin();

		assertTrue(paginaDeLogin.isPaginaDeLoginComDadosIvalidos());
		assertNull(paginaDeLogin.getNomeUsuarioLogado());
		assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();

		assertTrue(paginaDeLogin.isPaginaDeLogin());
		assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}

}
