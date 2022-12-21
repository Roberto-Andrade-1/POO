package com.mycompany.jumanji_poo;

public class Rato extends Animal {

    public Rato(String nome) {
        super(nome);
        setAtratividadeBase(2000);
        setEsperancaVida(2);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Rato() {
        setAtratividadeBase(2000);
        setEsperancaVida(2);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

}
