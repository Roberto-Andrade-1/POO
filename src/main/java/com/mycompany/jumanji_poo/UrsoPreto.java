package com.mycompany.jumanji_poo;

public class UrsoPreto extends Animal implements Ursus {

    public static double atratividadeBase;

    public UrsoPreto(String nome) {
        super(nome);
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public UrsoPreto() {
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        UrsoPreto.atratividadeBase = atratividadeBase;
    }
}
