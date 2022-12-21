package com.mycompany.jumanji_poo;

public class Dragao extends Animal {

    private static double atratividadeBase;

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

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Dragao.atratividadeBase = atratividadeBase;
    }

}
