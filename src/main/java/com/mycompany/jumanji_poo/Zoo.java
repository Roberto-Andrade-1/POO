package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class Zoo {

    private double saldo;
    private int staff;
    private final int PAGAMENTO_STAFF = 1000;
    private final int PAGAMENTO_RACAO = 3000;
    private final int MANUTENCAO = 2500;
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
        this.animaisMortos = new ArrayList<Animal>();
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

    public void setAnimaisMortos(Animal ani) {
        this.animaisMortos.add(ani);
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public int calculaDespesas() {
        int total = 0;
        total += getStaff() * PAGAMENTO_STAFF; // pagamento da staff
        for (Map.Entry<Recinto, Animal[]> instalacoes : recintos.entrySet()) {
            Recinto rec = instalacoes.getKey();
            total += total + (rec.getCapacidade() * MANUTENCAO);
            Animal[] animais = instalacoes.getValue();
            total += total + (animais.length * PAGAMENTO_RACAO);
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

    public ArrayList<Animal> probabilidadeMorrer() {
        ArrayList<Animal> animaisMortosNumPeriodo = new ArrayList<Animal>();
        Random rand = new Random();
        int num = rand.nextInt(101);
        for (int i = 0; i < animaisErrantes.size(); i++) {
            if (animaisErrantes.get(i) != null) {
                if (animaisErrantes.get(i).getIdade() >= animaisErrantes.get(i).retornaEsperancaVida()) { // 90% de
                                                                                                          // animal
                                                                                                          // morrer
                    if (num < 90) {
                        animaisMortosNumPeriodo.add(animaisErrantes.get(i));
                        setAnimaisMortos(animaisErrantes.get(i));
                        animaisErrantes.remove(animaisErrantes.get(i));
                    }
                } else if (animaisErrantes.get(i).getIdade() >= 0.8 * animaisErrantes.get(i).retornaEsperancaVida()) {// 75$
                                                                                                                      // do
                                                                                                                      // animal
                                                                                                                      // morrer
                    if (num < 75) {
                        animaisMortosNumPeriodo.add(animaisErrantes.get(i));
                        setAnimaisMortos(animaisErrantes.get(i));
                        animaisErrantes.remove(animaisErrantes.get(i));
                    }
                } else if (animaisErrantes.get(i).getIdade() >= 0.6 * animaisErrantes.get(i).retornaEsperancaVida()) {// 40%
                                                                                                                      // do
                                                                                                                      // animal
                                                                                                                      // morrer
                    if (num < 40) {
                        animaisMortosNumPeriodo.add(animaisErrantes.get(i));
                        setAnimaisMortos(animaisErrantes.get(i));
                        animaisErrantes.remove(animaisErrantes.get(i));
                    }
                } else if (animaisErrantes.get(i).getIdade() >= 0.4 * animaisErrantes.get(i).retornaEsperancaVida()) {// 15%
                                                                                                                      // do
                                                                                                                      // animal
                                                                                                                      // morrer
                    if (num < 15) {
                        animaisMortosNumPeriodo.add(animaisErrantes.get(i));
                        setAnimaisMortos(animaisErrantes.get(i));
                        animaisErrantes.remove(animaisErrantes.get(i));
                    }
                } else { // 5% de morrer
                    if (num < 3) {
                        animaisMortosNumPeriodo.add(animaisErrantes.get(i));
                        setAnimaisMortos(animaisErrantes.get(i));
                        animaisErrantes.remove(animaisErrantes.get(i));
                    }
                }
            }
        }

        for (Animal[] animais : recintos.values()) {
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {
                    if (animais[i].getIdade() >= animais[i].retornaEsperancaVida()) { // 90% de o animal morrer
                        if (num < 90) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.8 * animais[i].retornaEsperancaVida()) {// 75$ do animal
                                                                                                  // morrer
                        if (num < 75) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.6 * animais[i].retornaEsperancaVida()) {// 40% do animal
                                                                                                  // morrer
                        if (num < 40) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.4 * animais[i].retornaEsperancaVida()) {// 15% do animal
                                                                                                  // morrer
                        if (num < 15) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else { // 5% de morrer
                        if (num < 3) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    }
                }
            }
        }

        return animaisMortosNumPeriodo;
    }

}
