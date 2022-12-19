package com.mycompany.jumanji_poo;

public class UrsoPreto extends Animal implements Ursus {

    public UrsoPreto(String nome) {
        super(nome);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }
}
