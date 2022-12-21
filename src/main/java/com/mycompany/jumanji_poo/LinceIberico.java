package com.mycompany.jumanji_poo;

public class LinceIberico extends Animal {

    private static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        LinceIberico.atratividadeBase = atratividadeBase;
    }
}