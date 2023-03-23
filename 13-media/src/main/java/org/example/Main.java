package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.services.CalculaMedia;
import org.example.services.VerificaStatus;

public class Main {

	public static void main(String[] args) {
		double calculaMedia = CalculaMedia.calcularMedia(new ArrayList<>(List.of(5.6, 7.8, 6.9)));

		System.out.println(calculaMedia);
		System.out.println(VerificaStatus.verificarStatusDoAluno(calculaMedia));

	}
}