package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Zoo {

    private int saldo, staff;
    private HashMap<Recinto, Animal[]> instalacoes;
    private List<Animal> animaisReserva;
    private List<Animal> animaisPerdidos;
    private List<Animal> animaisErrantes;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.instalacoes = new HashMap<Recinto, Animal[]>();
        this.animaisReserva = new ArrayList<Animal>();
        this.animaisPerdidos = new ArrayList<Animal>();
        this.animaisErrantes = new ArrayList<Animal>();
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
        Animal[] animais = new Animal[rec.getCapacidade()];
        instalacoes.put(rec, animais);
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }
}
