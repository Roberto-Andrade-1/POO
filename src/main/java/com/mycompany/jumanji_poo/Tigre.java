package com.mycompany.jumanji_poo;

public class Tigre extends Animal implements Panthera {

    public Tigre(String nome) {
        super(nome);
    }

    @Override
    public void rugir() {
        System.out.println("Roawrrr");
    }
}