package com.mycompany.jumanji_poo;

import java.util.Objects;

public abstract class Animal implements Mutacoes {

    private static int idAnimalAtualizado;
    private int idAnimal, idade, esperancaVida;
    private String nome;
    private double atratividade;
    private boolean viasExtincao;
    private final boolean albinismo, vitiligo, melanismo, heterocromia, siames;

    public Animal(String nome) {
        idAnimal = 0;
        this.nome = nome;
        atratividade = 0; // €
        this.albinismo = detetAlbinismo();
        this.vitiligo = detetaVitiligo();
        this.melanismo = detetaMelanismo();
        this.heterocromia = detetaHeterocromia();
        this.siames = detetaSiames();

    }

    public static int getIdAnimalAtualizado() {
        return idAnimalAtualizado;
    }

    public static void setIdAnimalAtualizado() {
        idAnimalAtualizado++;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAtratividade() {
        return atratividade;
    }

    public void setAtratividade(double atratividade) {
        this.atratividade = atratividade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getEsperancaVida() {
        return esperancaVida;
    }

    public void setEsperancaVida(int esperancaVida) {
        this.esperancaVida = esperancaVida;
    }

    public boolean isViasExtincao() {
        return viasExtincao;
    }

    public void setViasExtincao(boolean viasExtincao) {
        this.viasExtincao = viasExtincao;
        if (isViasExtincao()) {
            setAtratividade(getAtratividade() + (getAtratividade() * 0.5));
        }
    }

    public boolean isAlbinismo() {
        return albinismo;
    }

    public boolean isVitiligo() {
        return vitiligo;
    }

    public boolean isMelanismo() {
        return melanismo;
    }

    public boolean isHeterocromia() {
        return heterocromia;
    }

    public boolean isSiames() {
        return siames;
    }

    @Override
    public boolean detetAlbinismo() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 15) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaHeterocromia() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 50) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaMelanismo() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 25) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaSiames() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 10) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaVitiligo() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 50) <= 75) {
            return true;
        } else
            return false;
    }

}
