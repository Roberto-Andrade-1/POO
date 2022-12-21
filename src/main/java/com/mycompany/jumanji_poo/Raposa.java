package com.mycompany.jumanji_poo;

public class Raposa extends Animal implements Canis {

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

}
