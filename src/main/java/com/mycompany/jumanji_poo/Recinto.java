package com.mycompany.jumanji_poo;
import java.util.Random;

public class Recinto {
    
    private static int idRecintoAtualizado;
    private int capacidade, custo,idRecinto;
    private Animal[] animaisRecinto;

    public Recinto() {
        this.capacidade=capacidadeAleatoria();
        this.custo=custoAleatorio();
        idRecinto=0;
        animaisRecinto= new Animal[this.capacidade];
    }

    public final int capacidadeAleatoria(){
        Random rand = new Random();
        return rand.nextInt(20)+1;
    }
    
    public final int custoAleatorio(){
        Random rand = new Random();
        return rand.nextInt(20001)+5000;
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

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(int idRecinto) {
        this.idRecinto = idRecinto;
    }

    public Animal[] getAnimaisRecinto() {
        return animaisRecinto;
    }

    public void setAnimaisRecinto(Animal[] animaisRecinto) {
        this.animaisRecinto = animaisRecinto;
    }
    
    
}
