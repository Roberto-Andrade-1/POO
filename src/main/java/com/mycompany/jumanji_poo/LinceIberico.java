package com.mycompany.jumanji_poo;

public class LinceIberico extends Animal {

    public LinceIberico(String nome) {
        super(nome);
        setAtratividadeBase(5500);
        setEsperancaVida(13);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public LinceIberico() {
        setAtratividadeBase(5500);
        setEsperancaVida(13);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }
}