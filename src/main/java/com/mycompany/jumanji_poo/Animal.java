package com.mycompany.jumanji_poo;

import java.util.Objects;
import java.util.Random;

public abstract class Animal implements Mutacoes {

    private static final String[] nomesAleatorios = { "Johannah", "Kitty", "Von", "Joanne", "Goddart", "Lottie",
            "Lorilee", "Esta", "Phaidra", "Nikos", "Elbert", "Sloane", "Shaun", "Benedikta", "Bea", "Arley", "Jori",
            "Franni", "Isidore", "Dolly", "Hephzibah", "Clarence", "Adelle", "Alasdair", "Adina", "Morganica", "Efren",
            "Jobie", "Jimmi", "Rosco", "Arline", "Jaye", "Stavros", "Zachery", "Derby", "Teressa", "Chane", "Jeanelle",
            "Shelagh", "Sianna", "Annmaria", "Willetta", "Daisi", "Tine", "Yul", "Bunni", "Rhianon", "Jen",
            "Friederike" };

    private static int idAnimalAtualizado;
    private int idAnimal, idade, esperancaVida;
    private String nome;
    private boolean viasExtincao;
    private final boolean albinismo, vitiligo, melanismo, heterocromia, siames;

    public Animal(String nome) {
        idAnimal = 0;
        this.nome = nome;
        this.idade = 0;
        esperancaVida = 0;
        this.albinismo = detetAlbinismo();
        this.vitiligo = detetaVitiligo();
        this.melanismo = detetaMelanismo();
        this.heterocromia = detetaHeterocromia();
        this.siames = detetaSiames();

    }

    public Animal(boolean albinismo) {
        idAnimal = 0;
        this.nome = nomesAleatorios[numAleatorioArray(nomesAleatorios.length)];
        this.idade = 0; // €
        esperancaVida = 0;
        this.albinismo = detetAlbinismo();
        this.vitiligo = detetaVitiligo();
        this.melanismo = detetaMelanismo();
        this.heterocromia = detetaHeterocromia();
        this.siames = detetaSiames();
    }

    public Animal() {
        idAnimal = 0;
        this.nome = nomesAleatorios[numAleatorioArray(nomesAleatorios.length)];
        this.idade = 0;
        esperancaVida = 0;
        this.albinismo = detetAlbinismo();
        this.vitiligo = detetaVitiligo();
        this.melanismo = detetaMelanismo();
        this.heterocromia = detetaHeterocromia();
        this.siames = detetaSiames();
    }

    public int numAleatorioArray(int length) {
        Random rand = new Random();
        int num = rand.nextInt(length);
        return num;
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

    public String[] getNomesAleatorios() {
        return nomesAleatorios;
    }

    public void setViasExtincao(boolean viasExtincao) {
        this.viasExtincao = viasExtincao;
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

    public int numAleatorioObjHash() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, viasExtincao, idade, nomesAleatorios, idAnimalAtualizado);
        if (num < 0) {
            num = num * (-1);
        }
        return num;
    }

    @Override
    public boolean detetAlbinismo() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 15) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaHeterocromia() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 40) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaMelanismo() {
        if (!isAlbinismo()) {
            int num = numAleatorioObjHash();
            if ((num % 100) <= 35) {
                return true;
            } else
                return false;
        }
        return false;
    }

    @Override
    public boolean detetaSiames() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 10) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaVitiligo() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 40) {
            return true;
        } else
            return false;
    }

    public abstract double retornaAtratividade();

}
