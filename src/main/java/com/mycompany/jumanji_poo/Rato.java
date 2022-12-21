package com.mycompany.jumanji_poo;

public class Rato extends Animal {

    public static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Rato.atratividadeBase = atratividadeBase;
    }

}
