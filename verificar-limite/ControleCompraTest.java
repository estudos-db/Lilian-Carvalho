import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControleCompraTest {

	private static ArrayList<Produto> listaCompras;
	private static Usuario cliente;
	private static Usuario clienteLimiteInsuficiente;
	private static ControleCompra controleCompra;
	private static BigDecimal valorTotal;

	@BeforeAll
	static void init() {
		controleCompra = new ControleCompra();
		valorTotal = BigDecimal.valueOf(6.70);

		listaCompras = new ArrayList<>();
		Produto arroz = new Produto("Arroz", BigDecimal.valueOf(6.30));
		Produto feijao = new Produto("Feijao", BigDecimal.valueOf(9.55));
		listaCompras.add(arroz);
		listaCompras.add(feijao);

		cliente = new Usuario("Luan", BigDecimal.valueOf(16.70));
		clienteLimiteInsuficiente = new Usuario("Maria", BigDecimal.valueOf(5.90));

	}

	@Test
	@DisplayName("Calcula o valor total dos produtos na lista de compra do cliente")
	void valorTotal() {

		final BigDecimal expect = BigDecimal.valueOf(15.85);
		final BigDecimal actual = controleCompra.valorTotal(listaCompras);

		assertEquals(expect, actual);
	}

	@Test
	@DisplayName("Reduz do limite do usuario o valor da compra realizada")
	void atualizaLimite() {
		final BigDecimal expect = BigDecimal.valueOf(10.0);
		final BigDecimal actual = controleCompra.atualizaLimite(valorTotal, cliente);

		assertEquals(expect, actual);
	}

	@Test
	@DisplayName("Realiza uma compra quando o limite do usuario é suficiente")
	void realizaCompra() {
		final String expect =
				"Comprar realizada com sucesso!" + "\nValor da compra: 6.7" + "\nLimite atual: 10.0";
		final String actual = controleCompra.realizaCompra(valorTotal, cliente);

		assertEquals(expect, actual);
	}

	@Test
	@DisplayName("Tenta realizar uma compra sem limite suficiente")
	void compraSemLimite() {
		final String expect = "Valor da compra excedeu o limete do usuario :/" + "\nLimite atual: 5.9";
		final String actual = controleCompra.realizaCompra(valorTotal, clienteLimiteInsuficiente);

		assertEquals(expect, actual);
	}
}