package com.mycompany.jumanji_poo;

public class Tigre extends Animal implements Panthera {

    public Tigre(String nome) {
        super(nome);
        setAtratividade(5000);
        setEsperancaVida(10);
        setViasExtincao(true);
    }

    @Override
    public void rugir() {
        System.out.println("Roawrrr");
    }
}