package com.mycompany.jumanji_poo;

public class Serpente extends Animal implements Naja {

    public Serpente(String nome) {
        super(nome);
    }

    @Override
    public void encantar() {
        System.out.println("A serpente foi encantada");
    }

    @Override
    public void veneno() {
        System.out.println("Serpente matou uma presa com veneno");
    }

}
