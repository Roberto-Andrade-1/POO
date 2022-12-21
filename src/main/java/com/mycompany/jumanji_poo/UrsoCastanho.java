package com.mycompany.jumanji_poo;

public class UrsoCastanho extends Animal implements Ursus {

    public UrsoCastanho(String nome) {
        super(nome);
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public UrsoCastanho() {
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

}