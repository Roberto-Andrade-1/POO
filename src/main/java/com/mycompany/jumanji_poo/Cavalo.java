package com.mycompany.jumanji_poo;

public class Cavalo extends Animal implements Equus {

    public Cavalo(String nome) {
        super(nome);
    }

    @Override
    public void galopar() {
        System.out.println("txtxtxt");
    }

    @Override
    public void montar() {
        System.out.println("Cacalo foi montado");
    }

}
