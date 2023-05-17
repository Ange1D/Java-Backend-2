package org.bedu.starter;

import org.bedu.starter.utils.Calculadora;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StarterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Hello world");

		Scanner sc = new Scanner(System.in);
		Calculadora c = new Calculadora();

		System.out.println("Calculadora");
		System.out.println("1. Sumar");
		System.out.println("1. Restar");
		System.out.println("1. Multiplicar");
		int opcion = sc.nextInt();

		if (opcion >3 || opcion <1){
			System.out.println("Opcion invalida");
			return;
		}

		System.out.println("Ingresa el primer numero");
		int a = sc.nextInt();
		System.out.println("Ingresa el segundo numero");
		int b = sc.nextInt();

		int respuesta = 0;

		switch (opcion){
			case 1:
				respuesta = c.sumar(a,b);
				break;
			case 2:
				respuesta = c.restar(a,b);
				break;
			case 3:
				respuesta = c.multiplicar(a,b);
				break;
		}

		System.out.println("La respuesta es "+ respuesta);
	}
}
