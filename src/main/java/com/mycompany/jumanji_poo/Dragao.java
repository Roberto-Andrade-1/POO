package com.mycompany.jumanji_poo;

public class Dragao extends Animal {

    public Dragao(String nome) {
        super(nome);
        setAtratividadeBase(3500);
        setEsperancaVida(30);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Dragao() {
        setAtratividadeBase(3500);
        setEsperancaVida(30);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

}
