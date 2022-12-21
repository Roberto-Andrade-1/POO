package com.mycompany.jumanji_poo;

public class Chita extends Animal {

    public Chita(String nome) {
        super(nome);
        setAtratividade(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Chita() {
        setAtratividade(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }
}