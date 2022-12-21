package com.mycompany.jumanji_poo;

public class Raposa extends Animal implements Canis {

    private static double atratividadeBase;

    public Raposa(String nome) {
        super(nome);
        setAtratividadeBase(3000);
        setEsperancaVida(15);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public Raposa() {
        setAtratividadeBase(3000);
        setEsperancaVida(15);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    @Override
    public void uivar() {
        System.out.println("auuu");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Raposa.atratividadeBase = atratividadeBase;
    }

}
