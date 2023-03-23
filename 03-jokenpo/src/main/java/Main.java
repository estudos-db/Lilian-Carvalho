import service.Jogo;

public class Main {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();

		System.out.println(jogo.inicarPartida("Papel"));
		System.out.println(jogo.inicarPartida("Tesoura"));
		System.out.println(jogo.inicarPartida("Pedra"));


	}
}
