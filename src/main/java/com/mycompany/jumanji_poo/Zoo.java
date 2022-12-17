package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private int saldo;
    private List<Recinto> recintos;
    private List<Animal> animaisReserva;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.recintos = new ArrayList<Recinto>();
        this.animaisReserva = new ArrayList<Animal>();
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(List<Recinto> recintos) {
        this.recintos = recintos;
    }

    public List<Animal> getAnimaisReserva() {
        return animaisReserva;
    }

    public void setAnimaisReserva(List<Animal> animaisReserva) {
        this.animaisReserva = animaisReserva;
    }

}
