package com.mycompany.jumanji_poo;

public class Lobo extends Animal implements Canis {

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

}
