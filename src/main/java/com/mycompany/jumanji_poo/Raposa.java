package com.mycompany.jumanji_poo;

public class Raposa extends Animal implements Canis {

    public Raposa(String nome) {
        super(nome);
        setAtratividade(3000);
        setEsperancaVida(15);
        setViasExtincao(false);
    }

    @Override
    public void uivar() {
        System.out.println("auuu");
    }

}
