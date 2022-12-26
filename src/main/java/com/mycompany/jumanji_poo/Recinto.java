package com.mycompany.jumanji_poo;

import java.util.Random;

public class Recinto {

    private static int idRecintoAtualizado;
    private final int capacidade, custo;
    private int ocupacao;
    private int idRecinto;

    public Recinto() {
        this.capacidade = capacidadeAleatoria();
        this.custo = custoAleatorio();
        idRecinto = 0;
        this.ocupacao = 0;
    }

    public final int capacidadeAleatoria() {
        Random rand = new Random();
        return rand.nextInt(20) + 1;
    }

    public final int custoAleatorio() {
        Random rand = new Random();
        return rand.nextInt(20001) + 5000;
    }

    public static int getIdRecintoAtualizado() {
        return idRecintoAtualizado;
    }

    public static void setIdRecintoAtualizado() {
        idRecintoAtualizado++;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCusto() {
        return custo;
    }

    public int getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(int idRecinto) {
        this.idRecinto = idRecinto;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (idRecinto == 0) {
            texto += "capacidade: " + getCapacidade();
            texto += " | custo: " + getCusto() + "€";
        } else {
            texto = "ID: " + getIdRecinto();
            texto += " | capacidade: " + getCapacidade();
            texto += " | Ocupação: " + getOcupacao();
        }
        return texto;
    }

}
