package com.mycompany.jumanji_poo;

public class Cobra extends Animal implements Naja {

    public static double atratividadeBase;

    public Cobra(String nome) {
        super(nome);
        setAtratividadeBase(4000);
        setEsperancaVida(23);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public Cobra() {
        setAtratividadeBase(4000);
        setEsperancaVida(23);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    @Override
    public void encantar() {
        System.out.println("A serpente foi encantada");
    }

    @Override
    public void veneno() {
        System.out.println("Serpente matou uma presa com veneno");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Cobra.atratividadeBase = atratividadeBase;
    }

}
