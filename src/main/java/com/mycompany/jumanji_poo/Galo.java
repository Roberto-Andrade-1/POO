package com.mycompany.jumanji_poo;

public class Galo extends Animal {

    private static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Galo.atratividadeBase = atratividadeBase;
    }

}
