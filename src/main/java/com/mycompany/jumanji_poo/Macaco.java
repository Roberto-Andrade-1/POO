package com.mycompany.jumanji_poo;

public class Macaco extends Animal {

    public Macaco(String nome) {
        super(nome);
        setAtratividadeBase(3500);
        setEsperancaVida(17);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Macaco() {
        setAtratividadeBase(3500);
        setEsperancaVida(17);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }
}