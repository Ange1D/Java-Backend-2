package org.bedu.starter;

import org.bedu.starter.utils.Calculadora;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationConfig {

    @Bean
    public Calculadora crearCalculadora(){
        return new Calculadora("calculadora");
    }

    @Bean
    public Scanner crearScanner(){
        return new Scanner(System.in);
    }

    /*
    @Bean No es correcto porque dependemos que ya existan
    public MainApplication crearMainApplication(){
        return new MainApplication(this.Calculadora,this);
    }
    */
}
