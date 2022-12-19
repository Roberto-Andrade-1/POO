package com.mycompany.jumanji_poo;

public class Lobo extends Animal implements Canis {

    public Lobo(String nome) {
        super(nome);
    }

    @Override
    public void uivar() {
        System.out.println("uuuuuu");
    }

}
