import java.math.BigDecimal;

public class Usuario {

	private final String nome;
	private BigDecimal limite;

	public Usuario(String nome, BigDecimal limite) {
		this.nome = nome;
		this.limite = limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public BigDecimal getLimite() {
		return limite;
	}

}
