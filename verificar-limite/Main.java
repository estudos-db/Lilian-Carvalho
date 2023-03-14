import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Produto> listaCompras = new ArrayList<>();

		Produto arroz = new Produto("Arroz", BigDecimal.valueOf(6.70));
		Produto feijao = new Produto("Feijao", BigDecimal.valueOf(7.90));
		Produto sabonete = new Produto("Sabonete", BigDecimal.valueOf(3.50));

		listaCompras.add(arroz);
		listaCompras.add(feijao);
		listaCompras.add(sabonete);

		Usuario cliente = new Usuario("Lilian", BigDecimal.valueOf(25.10));
		Usuario cliente2 = new Usuario("Tales", BigDecimal.valueOf(10.10));
		ControleCompra controleCompra = new ControleCompra();
		String result = controleCompra.realizaCompra(controleCompra.valorTotal(listaCompras), cliente);
		System.out.println(result);
		String result2 = controleCompra.realizaCompra(controleCompra.valorTotal(listaCompras),
		                                              cliente2);
		System.out.println(result2);

	}
}
