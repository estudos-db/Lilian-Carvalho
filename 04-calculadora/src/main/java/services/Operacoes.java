package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operacoes implements IOperacoes {

	private BigDecimal resultado;

	public BigDecimal getResultado() {
		return resultado.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String soma(double primeiroNumero, double segundoNumero) {

		resultado = BigDecimal.valueOf(primeiroNumero + segundoNumero);

		return primeiroNumero + " + " + segundoNumero + " = " + getResultado();
	}

	@Override
	public String subtracao(double primeiroNumero, double segundoNumero) {
		resultado = BigDecimal.valueOf(primeiroNumero - segundoNumero);

		return primeiroNumero + " - " + segundoNumero + " = " + getResultado();
	}

	@Override
	public String multiplicacao(double primeiroNumero, double segundoNumero) {
		resultado = BigDecimal.valueOf(primeiroNumero * segundoNumero);
		return primeiroNumero + " * " + segundoNumero + " = " + getResultado();
	}

	@Override
	public String divisao(double primeiroNumero, double segundoNumero) {
		resultado = BigDecimal.valueOf(primeiroNumero / segundoNumero);
		return segundoNumero + " / " + primeiroNumero + " = " + getResultado();
	}
}

