import java.math.BigDecimal;
import java.util.ArrayList;

public class ControleCompra {

	private ArrayList<Produto> listaDeProdutos;
	private Usuario cliente;

	public BigDecimal valorTotal(ArrayList<Produto> listaDeProdutos) {
		BigDecimal valorTotal = BigDecimal.valueOf(0);
		for (Produto produto : listaDeProdutos) {
			valorTotal = valorTotal.add(produto.getValor());
		}

		return valorTotal;
	}

	public BigDecimal atualizaLimite(BigDecimal valorTotal, Usuario cliente) {
		return cliente.getLimite().subtract(valorTotal);
	}

	public String realizaCompra(BigDecimal valorTotal, Usuario cliente) {
		if (cliente.getLimite().doubleValue() >= valorTotal.doubleValue()) {
			cliente.setLimite(atualizaLimite(valorTotal, cliente));
			return "Comprar realizada com sucesso!" + "\nValor da compra: " + valorTotal
					       + "\nLimite atual: " + cliente.getLimite();
		} else {
			return "Valor da compra excedeu o limete do usuario :/" + "\nLimite atual: "
					       + cliente.getLimite();
		}

	}
}
