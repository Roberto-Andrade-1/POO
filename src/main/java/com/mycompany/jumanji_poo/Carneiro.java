package com.mycompany.jumanji_poo;

public class Carneiro extends Animal implements Ovis {

    public Carneiro(String nome) {
        super(nome);
        setAtratividade(3100);
        setEsperancaVida(10);
        setViasExtincao(true);
    }

    @Override
    public void regurgitar() {
        System.out.println("urrrrrr");
    }

}
