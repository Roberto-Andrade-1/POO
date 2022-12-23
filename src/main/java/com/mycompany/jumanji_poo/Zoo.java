package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Zoo {

    private double saldo;
    private int staff;
    private HashMap<Recinto, Animal[]> recintos;
    private List<Animal> animaisPerdidos;
    private List<Animal> animaisErrantes;
    private List<Animal> animaisMortos;
    private Scanner scan;

    public Zoo(int saldo) {
        this.saldo = saldo;
        this.staff = 0;
        this.recintos = new HashMap<Recinto, Animal[]>();
        this.animaisPerdidos = new ArrayList<Animal>();
        this.animaisErrantes = new ArrayList<Animal>();
    }

    public double getSaldo() {
        return Math.round(saldo * 100) / 100;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
            Recinto rec = instalacoes.getKey();
        }
        return total;
    }

    public void verificaOcupacaoRec() {
        for (Map.Entry<Recinto, Animal[]> recintos : recintos.entrySet()) {
            int total = 0;
            Recinto rec = recintos.getKey();
            Animal[] animais = recintos.getValue();
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null)
                    total++;
            }
            rec.setOcupacao(total);
        }
    }

    public void listarRecintos() {
        verificaOcupacaoRec();
        System.out.println("\nRECINTOS");
        for (Recinto i : getRecintos().keySet()) {
            System.out.println(i);
        }
    }

    public void listarAnimaisErrantes() {
        for (Animal animal : animaisErrantes) {
            System.out.println(animal);
        }
    }

    public void listarAnimaisRecintos() {
        for (Animal[] ani : recintos.values()) {
            for (Animal animal : ani) {
                if (animal != null) {
                    System.out.println(animal);
                }
            }

        }
    }

    public void listarAnimais() {
        System.out.println("\nAnimais errantes:");
        listarAnimaisErrantes();
        System.out.println("\nAnimais em recintos");
        listarAnimaisRecintos();
    }

    public void listarAnimaisCarGenetica() {
        scan = new Scanner(System.in);
        System.out.println("""

                Qual a característica genetica que pretende?
                1.Canis
                2.Equus
                3.Naja
                4.Ovis
                5.Phantera
                6.Ursus

                """);
        int escolha = scan.nextInt();
        switch (escolha) {
            case 1:
                for (Animal animal : animaisErrantes) {
                    if (Canis.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Canis.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 2:
                for (Animal animal : animaisErrantes) {
                    if (Equus.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Equus.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 3:
                for (Animal animal : animaisErrantes) {
                    if (Naja.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Naja.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 4:
                for (Animal animal : animaisErrantes) {
                    if (Ovis.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Ovis.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 5:
                for (Animal animal : animaisErrantes) {
                    if (Panthera.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Panthera.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 6:
                for (Animal animal : animaisErrantes) {
                    if (Ursus.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : recintos.values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Ursus.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
        }
    }

    public void listarDadaMutacao() {
        scan = new Scanner(System.in);
        System.out.println("""

                Qual a mutação pretende?
                1.Albino
                2.Heterocromia
                3.Melanismo
                4.Siames
                5.Vitiligo

                """);
        int escolha = scan.nextInt();
        switch (escolha) {
            case 1:
                for (Animal animal : animaisErrantes) {
                    if (animal.isAlbinismo())
                        System.out.println(animal);
                }
                for (Animal[] animal : recintos.values()) {
                    for (Animal ani : animal) {
                        if (ani.isAlbinismo())
                            System.out.println(animal);
                    }
                }
                break;
            case 2:
                for (Animal animal : animaisErrantes) {
                    if (animal.isHeterocromia())
                        System.out.println(animal);
                }
                for (Animal[] animal : recintos.values()) {
                    for (Animal ani : animal) {
                        if (ani.isHeterocromia())
                            System.out.println(animal);
                    }
                }
                break;
            case 3:
                for (Animal animal : animaisErrantes) {
                    if (animal.isMelanismo())
                        System.out.println(animal);
                }
                for (Animal[] animal : recintos.values()) {
                    for (Animal ani : animal) {
                        if (ani.isMelanismo())
                            System.out.println(animal);
                    }
                }
                break;
            case 4:
                for (Animal animal : animaisErrantes) {
                    if (animal.isSiames())
                        System.out.println(animal);
                }
                for (Animal[] animal : recintos.values()) {
                    for (Animal ani : animal) {
                        if (ani.isSiames())
                            System.out.println(animal);
                    }
                }
                break;
            case 5:
                for (Animal animal : animaisErrantes) {
                    if (animal.isVitiligo())
                        System.out.println(animal);
                }
                for (Animal[] animal : recintos.values()) {
                    for (Animal ani : animal) {
                        if (ani.isVitiligo())
                            System.out.println(animal);
                    }
                }
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}
