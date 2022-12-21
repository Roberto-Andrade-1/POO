package com.mycompany.jumanji_poo;

public class Cao extends Animal implements Canis {

    private static double atratividadeBase;

    public Cao(String nome) {
        super(nome);
        setAtratividadeBase(1500);
        setEsperancaVida(15);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Cao() {
        setAtratividadeBase(1500);
        setEsperancaVida(15);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    @Override
    public void uivar() {
        System.out.println("auuuu");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Cao.atratividadeBase = atratividadeBase;
    }

}
