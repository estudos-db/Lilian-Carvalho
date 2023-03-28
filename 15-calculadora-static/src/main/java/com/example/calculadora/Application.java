package com.example.calculadora;

import com.example.calculadora.utils.Menu;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Menu.exibirMenu();
	}

}
