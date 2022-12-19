package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Zoo {

    private int saldo;
    private HashMap<Recinto, Animal[]> instalacoes;
    private List<Animal> animaisReserva;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.instalacoes = new HashMap<Recinto, Animal[]>();
        this.animaisReserva = new ArrayList<Animal>();
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Animal> getAnimaisReserva() {
        return animaisReserva;
    }

    public void setAnimaisReserva(List<Animal> animaisReserva) {
        this.animaisReserva = animaisReserva;
    }

    public HashMap<Recinto, Animal[]> getInstalcoes() {
        return instalacoes;
    }

    public void setInstalacoes(Recinto rec) {
        instalacoes.put(rec, rec.getAnimaisRecinto());
    }

}
