package com.mycompany.jumanji_poo;

public class Leao extends Animal implements Panthera {

    public Leao(String nome) {
        super(nome);
        setAtratividadeBase(5000);
        setEsperancaVida(10);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public Leao() {
        setAtratividadeBase(5000);
        setEsperancaVida(10);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    @Override
    public void rugir() {
        System.out.println("Roawr");
    }
}