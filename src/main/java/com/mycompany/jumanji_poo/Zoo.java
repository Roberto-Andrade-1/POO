package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Zoo {

    private int saldo, staff;
    private HashMap<Recinto, Animal[]> instalacoes;
    private List<Animal> animaisPerdidos;
    private List<Animal> animaisErrantes;
    private List<Animal> animaisMortos;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.instalacoes = new HashMap<Recinto, Animal[]>();
        this.animaisPerdidos = new ArrayList<Animal>();
        this.animaisErrantes = new ArrayList<Animal>();
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public HashMap<Recinto, Animal[]> getInstalcoes() {
        return instalacoes;
    }

    public void setInstalacoes(Recinto rec) {
        Animal[] animais = new Animal[rec.getCapacidade()];
        instalacoes.put(rec, animais);
    }

    public HashMap<Recinto, Animal[]> getInstalacoes() {
        return instalacoes;
    }

    public void setInstalacoes(HashMap<Recinto, Animal[]> instalacoes) {
        this.instalacoes = instalacoes;
    }

    public List<Animal> getAnimaisPerdidos() {
        return animaisPerdidos;
    }

    public void setAnimaisPerdidos(List<Animal> animaisPerdidos) {
        this.animaisPerdidos = animaisPerdidos;
    }

    public List<Animal> getAnimaisErrantes() {
        return animaisErrantes;
    }

    public void setAnimaisErrantes(List<Animal> animaisErrantes) {
        this.animaisErrantes = animaisErrantes;
    }

    public List<Animal> getAnimaisMortos() {
        return animaisMortos;
    }

    public void setAnimaisMortos(List<Animal> animaisMortos) {
        this.animaisMortos = animaisMortos;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public int calculaDespesas() {
        return (getStaff() * 800) + (getCapacidade() * 2000);
    }

}
