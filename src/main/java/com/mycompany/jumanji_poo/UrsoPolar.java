package com.mycompany.jumanji_poo;

public class UrsoPolar extends Animal implements Ursus {

    public UrsoPolar(String nome) {
        super(nome);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

}
