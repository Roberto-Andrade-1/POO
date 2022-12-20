package com.mycompany.jumanji_poo;

public class Panda extends Animal implements Ursus {

    public Panda(String nome) {
        super(nome);
        setAtratividade(10000);
        setEsperancaVida(20);
        setViasExtincao(true);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }
}