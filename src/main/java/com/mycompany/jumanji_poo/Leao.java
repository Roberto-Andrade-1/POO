package com.mycompany.jumanji_poo;

public class Leao extends Animal implements Panthera {

    public Leao(String nome) {
        super(nome);
    }

    @Override
    public void rugir() {
        System.out.println("Roawr");
    }
}