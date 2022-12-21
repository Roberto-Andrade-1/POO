package com.mycompany.jumanji_poo;

public class Galo extends Animal {

    public Galo(String nome) {
        super(nome);
        setAtratividadeBase(900);
        setEsperancaVida(9);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Galo() {
        setAtratividadeBase(900);
        setEsperancaVida(9);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

}
