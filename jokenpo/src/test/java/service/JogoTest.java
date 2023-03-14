package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoTest {

	private static Jogo jogo;

	@BeforeEach
	void init() {
		jogo = new Jogo();

	}

	@Test
	void jogodorDevePerderAPartidaQuandoSuaEscolhaForPapelSeAGeradaParaAMaquinaForTesoura() {

		String expect = "Maquina Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Papel");
		}
		while ((jogo.getEscolhaDaMaquina() != "Tesoura"));

		assertEquals(expect, actual);

	}

	@Test
	void jogodorDeveVencerAPartidaQuandoSuaEscolhaForPapelSeAGeradaParaAMaquinaForPedra() {

		String expect = "Jogador Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Papel");

		}
		while ((jogo.getEscolhaDaMaquina() != "Pedra"));

		assertEquals(expect, actual);

	}

	@Test
	void jogodorDevePerderAPartidaQuandoSuaEscolhaForPedraSeAGeradaParaAMaquinaForPapel() {

		String expect = "Maquina Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Pedra");

		}
		while ((jogo.getEscolhaDaMaquina() != "Papel"));

		assertEquals(expect, actual);

	}

	@Test
	void jogodorDeveVencerAPartidaQuandoSuaEscolhaForPedraSeAGeradaParaAMaquinaForTesoura() {

		String expect = "Jogador Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Pedra");

		}
		while ((jogo.getEscolhaDaMaquina() != "Tesoura"));

		assertEquals(expect, actual);

	}

	@Test
	void jogodorDeveVencerAPartidaQuandoSuaEscolhaForTesouraSeAGeradaParaAMaquinaForPapel() {

		String expect = "Jogador Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Tesoura");

		}
		while ((jogo.getEscolhaDaMaquina() != "Papel"));
		assertEquals(expect, actual);

	}

	@Test
	void jogodorDevePerderAPartidaQuandoSuaEscolhaForTesouraSeAGeradaParaAMaquinaForPedra() {

		String expect = "Maquina Venceu!";
		String actual;

		do {
			actual = jogo.inicarPartida("Tesoura");
		}
		while ((jogo.getEscolhaDaMaquina() != "Pedra"));

		assertEquals(expect, actual);

	}

	@Test
	void jogoDeveTerminarEmpatadoQuandoAEscolhaDoJogadorForIgualAGeradaParaAMaquina() {

		String expect = "Houve um empate!";
		String actual;

		do {
			actual = jogo.inicarPartida(jogo.gerarEscolhaAutomatica());
		}
		while ((jogo.getEscolhaDaMaquina() != jogo.getEscolhaDoJogador()));

		assertEquals(expect, actual);

	}

	@Test
	void deveGerarUmaEscolhaParaAMaquina() {
		String actual = jogo.gerarEscolhaAutomatica();
		String expect = jogo.getEscolhaDaMaquina();

		assertNotNull(expect);
		assertEquals(expect, actual);
	}
}