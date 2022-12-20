package com.mycompany.jumanji_poo;

public class UrsoPreto extends Animal implements Ursus {

    public UrsoPreto(String nome) {
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
