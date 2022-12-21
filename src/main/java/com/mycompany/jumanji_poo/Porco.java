package com.mycompany.jumanji_poo;

public class Porco extends Animal {

    private static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Porco.atratividadeBase = atratividadeBase;
    }

}
