package com.example.hrminseg.services;

import java.util.Scanner;

public abstract class Conversor {

	private static final Scanner scanner = new Scanner(System.in);
	private static int segundos;
	private static int minutos;
	private static int horas;

	public static void lerHoraEmSegundos() {
		System.out.print("Informe os segundos: ");
		segundos = scanner.nextInt();
		horas = calcularHoras(segundos);
		minutos = calcularMinutos(segundos);
		segundos = calcularSegundos(segundos);
	}

	public static int calcularHoras(int segundos) {
		return segundos / 3600;
	}

	public static int calcularMinutos(int segundos) {
		return (segundos - (getHoras() * 3600)) / 60;
	}

	public static int calcularSegundos(int segundos) {
		return segundos - (getHoras() * 3600) - (getMinutos() * 60);
	}

	public static void mostarHorario() {
		System.out.println(getHoras() + "h" + getMinutos() + "min" + getSegundos() + "seg");
	}

	public static int getSegundos() {
		return segundos;
	}

	public static int getMinutos() {
		return minutos;
	}

	public static int getHoras() {
		return horas;
	}

	public static void setHoras(int horas) {
		Conversor.horas = horas;
	}

	public static void setSegundos(int segundos) {
		Conversor.segundos = segundos;
	}

	public static void setMinutos(int minutos) {
		Conversor.minutos = minutos;
	}
}
