package com.mycompany.jumanji_poo;

public class UrsoCastanho extends Animal implements Ursus {

    public UrsoCastanho(String nome) {
        super(nome);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

}