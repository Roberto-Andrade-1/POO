package com.mycompany.jumanji_poo;

public class UrsoPolar extends Animal implements Ursus {

    public UrsoPolar(String nome) {
        super(nome);
        setEsperancaVida(30);
        setAtratividade(4000);
        setViasExtincao(true);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

}
