package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo implements iJogo {

	private String escolhaDoJogador;
	private String escolhaDaMaquina;

	@Override
	public String pedra() {

		if (escolhaDoJogador.equals("Pedra") && escolhaDaMaquina.equals("Tesoura")) {
			return "Jogador Venceu!";
		} else if (escolhaDoJogador.equals("Pedra") && escolhaDaMaquina.equals("Papel")) {
			return "Maquina Venceu!";
		} else {
			return "Houve um empate!";
		}

	}

	@Override
	public String papel() {

		if (escolhaDoJogador.equals("Papel") && escolhaDaMaquina.equals("Pedra")) {
			return "Jogador Venceu!";
		} else if (escolhaDoJogador.equals("Papel") && escolhaDaMaquina.equals("Tesoura")) {
			return "Maquina Venceu!";
		} else {
			return "Houve um empate!";
		}

	}

	@Override
	public String tesoura() {

		if (escolhaDoJogador.equals("Tesoura") && escolhaDaMaquina.equals("Papel")) {
			return "Jogador Venceu!";
		} else if (escolhaDoJogador.equals("Tesoura") && escolhaDaMaquina.equals("Pedra")) {
			return "Maquina Venceu!";
		} else {
			return "Houve um empate!";
		}

	}

	@Override
	public String inicarPartida(String escolhaDoJogador) {
		this.escolhaDaMaquina = gerarEscolhaAutomatica();
		this.escolhaDoJogador = escolhaDoJogador;
		if (escolhaDoJogador.equals("Pedra")) {
			return pedra();
		}
		if (escolhaDoJogador.equals("Papel")) {
			return papel();
		}
		if (escolhaDoJogador.equals("Tesoura")) {
			return tesoura();
		}

		return "Erro ao iniciar o jogo!";

	}

	public String gerarEscolhaAutomatica() {
		List<String> opcoes = new ArrayList<>(List.of("Pedra", "Papel", "Tesoura"));
		Random random = new Random();
		this.escolhaDaMaquina = opcoes.get(random.nextInt(opcoes.size()));
		return escolhaDaMaquina;
	}

	public String getEscolhaDoJogador() {
		return escolhaDoJogador;
	}

	public String getEscolhaDaMaquina() {
		return escolhaDaMaquina;
	}

}
