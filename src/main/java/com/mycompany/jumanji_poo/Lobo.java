package com.mycompany.jumanji_poo;

public class Lobo extends Animal implements Canis {

    public Lobo(String nome) {
        super(nome);
        setAtratividade(3000);
        setEsperancaVida(15);
        setViasExtincao(false);
    }

    @Override
    public void uivar() {
        System.out.println("uuuuuu");
    }

}
