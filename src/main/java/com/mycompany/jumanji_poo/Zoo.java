package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Zoo {

    private double saldo;
    private int staff;
    private HashMap<Recinto, Animal[]> recintos;
    private List<Animal> animaisPerdidos;
    private List<Animal> animaisErrantes;
    private List<Animal> animaisMortos;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.staff = 0;
        this.recintos = new HashMap<Recinto, Animal[]>();
        this.animaisPerdidos = new ArrayList<Animal>();
        this.animaisErrantes = new ArrayList<Animal>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public HashMap<Recinto, Animal[]> getInstalcoes() {
        return recintos;
    }

    public void setRecintos(Recinto rec) {
        Animal[] animais = new Animal[rec.getCapacidade()];
        recintos.put(rec, animais);
        setStaff(getStaff() + 10);
    }

    public HashMap<Recinto, Animal[]> getRecintos() {
        return recintos;
    }

    public void setrecintos(HashMap<Recinto, Animal[]> recintos) {
        this.recintos = recintos;
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

    public void setAnimaisErrantes(Animal ani) {
        animaisErrantes.add(ani);
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
        int total = 0;
        total += getStaff() * 800; // pagamento da staff
        for (Map.Entry<Recinto, Animal[]> instalacoes : recintos.entrySet()) {

        }
        return total;
    }

    public void listarAnimaisErrantes() {
        System.out.println("Animais errantes");
        for (Animal animal : animaisErrantes) {
            System.out.println(animal);
        }
    }

}
