package com.mycompany.jumanji_poo;

public class Cavalo extends Animal implements Equus {

    public Cavalo() {
        setAtratividadeBase(3000);
        setEsperancaVida(28);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Cavalo(String nome) {
        super(nome);
        setAtratividadeBase(3000);
        setEsperancaVida(28);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    @Override
    public void galopar() {
        System.out.println("pocotó");
    }

    @Override
    public void montar() {
        System.out.println("Cacalo foi montado");
    }

}
