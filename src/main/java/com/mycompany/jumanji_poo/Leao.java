package com.mycompany.jumanji_poo;

public class Leao extends Animal implements Panthera {

    public Leao(String nome) {
        super(nome);
        setAtratividade(5000);
        setEsperancaVida(10);
        setViasExtincao(true);
    }

    @Override
    public void rugir() {
        System.out.println("Roawr");
    }
}