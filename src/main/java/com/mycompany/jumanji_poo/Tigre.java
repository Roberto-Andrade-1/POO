package com.mycompany.jumanji_poo;

public class Tigre extends Animal implements Panthera {

    public Tigre(String nome) {
        super(nome);
        setAtratividadeBase(5000);
        setEsperancaVida(10);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public Tigre() {
        setAtratividadeBase(5000);
        setEsperancaVida(10);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    @Override
    public void rugir() {
        System.out.println("Roawrrr");
    }
}