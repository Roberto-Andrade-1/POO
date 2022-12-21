package com.mycompany.jumanji_poo;

public class Chita extends Animal {

    public static double atratividadeBase;

    public Chita(String nome) {
        super(nome);
        setAtratividadeBase(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Chita() {
        setAtratividadeBase(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Chita.atratividadeBase = atratividadeBase;
    }
}