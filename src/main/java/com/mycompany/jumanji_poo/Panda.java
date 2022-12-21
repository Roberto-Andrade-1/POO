package com.mycompany.jumanji_poo;

public class Panda extends Animal implements Ursus {

    public Panda(String nome) {
        super(nome);
        setAtratividadeBase(10000);
        setEsperancaVida(20);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public Panda() {
        setAtratividadeBase(10000);
        setEsperancaVida(20);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }
}