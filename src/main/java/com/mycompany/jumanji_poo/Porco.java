package com.mycompany.jumanji_poo;

public class Porco extends Animal {

    public Porco(String nome) {
        super(nome);
        setAtratividadeBase(200);
        setEsperancaVida(14);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Porco() {
        setAtratividadeBase(200);
        setEsperancaVida(14);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

}
