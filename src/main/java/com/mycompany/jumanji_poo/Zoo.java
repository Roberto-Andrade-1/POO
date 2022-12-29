package com.mycompany.jumanji_poo;

import Animais.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Zoo {

    private double saldo;
    private int staff;
    private final int PAGAMENTO_STAFF = 600;
    private final int PAGAMENTO_RACAO = 150;
    private final int MANUTENCAO = 200;
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

    public void setAnimaisPerdidos(Animal ani) {
        animaisPerdidos.add(ani);
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

    /*
     * Este método irá retornar as despesas do zoo. Este método irá retornar um
     * double que é o total de despesas do zoo, pagamento de ração para todos os
     * animais, manutenção dos recintos e pagamento da staff.
     */
    public double calculaDespesas() {
        double total = 0;
        int animaisRecinto = 0;

        total += getStaff() * PAGAMENTO_STAFF; // pagamento da staff
        for (Recinto rec : getRecintos().keySet()) {
            animaisRecinto += rec.getOcupacao();
        }
        total += animaisRecinto * PAGAMENTO_RACAO;
        total += animaisErrantes.size() * PAGAMENTO_RACAO;
        total += getRecintos().size() * MANUTENCAO;
        return total;
    }

    /*
     * Este método serve para verificar a ocupação de cada recinto, basicamente
     * percorre o array e se alguma posição não for null incrementa o número total.
     * Depois de percorrer o array, este metodo, define a ocupação do recinto face à
     * variável total
     */
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
        listarAnimaisErrantes();
        listarAnimaisRecintos();
    }

    public void listarAnimaisMortos() {
        for (Animal animal : animaisMortos) {
            System.out.println(animal);
        }

    }

    /*
     * Como para inserirmos animais nos recintos só podemos escolher animais que são
     * errantes optamos por fazer este metodo para depois lançar a exeção no jumanji
     */
    public boolean verificaIdAnimal(int id) {
        boolean verr = false;
        for (Animal animal : getAnimaisErrantes()) {
            if (animal.getIdAnimal() == id)
                verr = true;
        }
        return verr;
    }

    /*
     * Para inserirmos os animais nos recintos precisamos de um método que verifique
     * se existe algum recinto com o id fornecido
     */
    public boolean verificaIdRecinto(int id) {
        boolean verr = false;
        for (Recinto rec : getRecintos().keySet()) {
            if (rec.getIdRecinto() == id)
                verr = true;
        }
        return verr;
    }

}
