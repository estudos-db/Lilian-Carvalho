package com.example.automoveis;

import com.example.automoveis.model.Automovel;
import com.example.automoveis.model.CarroAutomatico;
import com.example.automoveis.model.Guincho;
import com.example.automoveis.model.MotoPartidaPedal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Automovel carroAutomatico = new CarroAutomatico(160);
		System.out.println("CARRO AUTOMATICO");
		carroAutomatico.ligar();
		System.out.println(carroAutomatico.isLigado());
		carroAutomatico.freiar();
		carroAutomatico.ligar();
		System.out.println(carroAutomatico.isLigado());

		Automovel motoPartidaPedal = new MotoPartidaPedal(180);
		System.out.println("MOTO PEDAL");
		motoPartidaPedal.ligar();
		System.out.println(motoPartidaPedal.isLigado());
		motoPartidaPedal.acelerar();
		motoPartidaPedal.ligar();
		System.out.println(motoPartidaPedal.isLigado());

		System.out.println("GUINCHO");

		Guincho guincho = new Guincho(6, 150);
		System.out.println(guincho.isCarregado());
		System.out.println(guincho.carregar(motoPartidaPedal));
		System.out.println(guincho.isCarregado());
		System.out.println(guincho.carregar(carroAutomatico));
		System.out.println(guincho.isCarregado());
	}

}
