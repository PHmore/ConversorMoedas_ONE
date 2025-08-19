package br.com.conversor;

import br.com.conversor.principal.Principal;

public class ConversorApp {
    public static void main(String[] args) {
        System.out.println("Início projeto");

        Principal principal = new Principal();
        principal.exibeMenu();

    }
}
