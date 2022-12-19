package com.mycompany.jumanji_poo;

public class Cao extends Animal implements Canis {

    public Cao(String nome) {
        super(nome);
    }

    @Override
    public void uivar() {
        System.out.println("auuuu");
    }

}
