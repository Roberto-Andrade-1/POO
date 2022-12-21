package com.mycompany.jumanji_poo;

public class Lobo extends Animal implements Canis {

    private static double atratividadeBase;

    public Lobo(String nome) {
        super(nome);
        setAtratividadeBase(3000);
        setEsperancaVida(15);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Lobo() {
        setAtratividadeBase(3000);
        setEsperancaVida(15);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    @Override
    public void uivar() {
        System.out.println("uuuuuu");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Lobo.atratividadeBase = atratividadeBase;
    }

}
