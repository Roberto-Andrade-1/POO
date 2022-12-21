package com.mycompany.jumanji_poo;

public class Coelho extends Animal {

    public static double atratividadeBase;

    public Coelho(String nome) {
        super(nome);
        setAtratividadeBase(500);
        setEsperancaVida(8);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Coelho() {
        setAtratividadeBase(500);
        setEsperancaVida(8);
        // num aleatorio de 0 a 17
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Coelho.atratividadeBase = atratividadeBase;
    }
}
