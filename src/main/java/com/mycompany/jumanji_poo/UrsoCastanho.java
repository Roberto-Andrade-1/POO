package com.mycompany.jumanji_poo;

public class UrsoCastanho extends Animal implements Ursus {

    public UrsoCastanho(String nome) {
        super(nome);
        setAtratividade(3500);
        setEsperancaVida(25);
        setViasExtincao(false);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

}