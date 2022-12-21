package com.mycompany.jumanji_poo;

public class UrsoPolar extends Animal implements Ursus {

    private static double atratividadeBase;

    public UrsoPolar(String nome) {
        super(nome);
        setAtratividadeBase(4000);
        setEsperancaVida(30);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public UrsoPolar() {
        setAtratividadeBase(4000);
        setEsperancaVida(30);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        UrsoPolar.atratividadeBase = atratividadeBase;
    }

}
