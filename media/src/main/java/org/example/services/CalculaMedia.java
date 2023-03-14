package org.example.services;

import java.util.ArrayList;

public class CalculaMedia {

	public static double calcularMedia(ArrayList<Double> notas) {
		double somaNotas = notas.stream().mapToDouble(Double::doubleValue).sum();
		double media = somaNotas / notas.size();
		return Math.round(media * 100.0) / 100.0;

	}
}
