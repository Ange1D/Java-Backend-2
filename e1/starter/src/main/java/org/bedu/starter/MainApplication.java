package org.bedu.starter;

import org.bedu.starter.utils.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainApplication {


    private Scanner sc;
    private Calculadora c;

    @Autowired
    public  MainApplication(Calculadora c, Scanner sc) {
        this.c = c;
        this.sc = sc;
    }

    public void start(){
        System.out.println("Hello world");



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
