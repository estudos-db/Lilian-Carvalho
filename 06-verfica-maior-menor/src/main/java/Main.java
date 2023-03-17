import services.Services;
//import services.Services;

public class Main {

	public static void main(String[] args) {

		Services services = new Services();
		System.out.println(services.gerarArray());
		System.out.println(services.menorValor());
		System.out.println(services.maiorValor());
	}
}
