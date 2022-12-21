package com.mycompany.jumanji_poo;

public class Carneiro extends Animal implements Ovis {

    public Carneiro(String nome) {
        super(nome);
        setAtratividadeBase(3100);
        setEsperancaVida(10);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Carneiro() {
        setAtratividadeBase(3100);
        setEsperancaVida(10);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    @Override
    public void regurgitar() {
        System.out.println("urrrrrr");
    }

}
