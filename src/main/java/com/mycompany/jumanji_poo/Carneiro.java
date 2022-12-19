package com.mycompany.jumanji_poo;

public class Carneiro extends Animal implements Ovis {

    public Carneiro(String nome) {
        super(nome);
    }

    @Override
    public void regurgitar() {
        System.out.println("urrrrrr");
    }

}
