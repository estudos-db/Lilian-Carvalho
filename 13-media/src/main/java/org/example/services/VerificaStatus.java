package org.example.services;

public class VerificaStatus {

	public static String verificarStatusDoAluno(double media) {
		if (media >= 6) {
			return "Aprovado";
		} else if (media >= 4) {
			return "Verificação Suplementar";
		}
		return "Reprovado";
	}
}
