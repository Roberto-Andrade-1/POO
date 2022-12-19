package com.mycompany.jumanji_poo;

public class Raposa extends Animal implements Canis {

    public Raposa(String nome) {
        super(nome);
    }

    @Override
    public void uivar() {
        System.out.println("auuu");
    }

}
