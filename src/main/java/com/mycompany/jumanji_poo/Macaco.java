package com.mycompany.jumanji_poo;

public class Macaco extends Animal {

    private static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Macaco.atratividadeBase = atratividadeBase;
    }
}