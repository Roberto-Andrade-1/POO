package com.mycompany.jumanji_poo;

public class Panda extends Animal implements Ursus {

    public Panda(String nome) {
        super(nome);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }
}