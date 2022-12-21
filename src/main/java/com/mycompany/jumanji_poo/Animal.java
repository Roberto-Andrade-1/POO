package com.mycompany.jumanji_poo;

import java.util.Objects;
import java.util.Random;

public abstract class Animal implements Mutacoes {

    String[] nomesAleatorios = { "Johannah", "Kitty", "Von", "Joanne", "Goddart", "Lottie", "Lorilee",
            "Esta", "Phaidra", "Nikos", "Elbert", "Sloane", "Shaun", "Benedikta", "Bea", "Arley",
            "Jori", "Franni", "Isidore", "Dolly", "Hephzibah", "Clarence", "Adelle", "Alasdair", "Adina",
            "Morganica", "Efren", "Jobie", "Jimmi", "Rosco", "Arline", "Jaye", "Stavros", "Zachery", "Derby",
            "Teressa", "Chane", "Jeanelle", "Shelagh", "Sianna", "Annmaria", "Willetta", "Daisi", "Tine", "Yul",
            "Bunni", "Rhianon", "Jen", "Friederike" };

    private static int idAnimalAtualizado;
    private int idAnimal, idade, esperancaVida;
    private String nome;
    private double atratividade;
    private int atratividadeBase;
    private boolean viasExtincao;
    private final boolean albinismo, vitiligo, melanismo, heterocromia, siames;

    public Animal(String nome) {
        idAnimal = 0;
        this.nome = nome;
        this.idade = 0;
        atratividade = 0; // €
        atratividadeBase = 0;
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
        this.idade = 0;
        atratividade = 0; // €
        atratividadeBase = 0;
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
        atratividade = 0; // €
        atratividadeBase = 0;
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

    public void setNomesAleatorios(String[] nomesAleatorios) {
        this.nomesAleatorios = nomesAleatorios;
    }

    public int getAtratividadeBase() {
        return atratividadeBase;
    }

    public void setAtratividadeBase(int atratividadeBase) {
        this.atratividadeBase = atratividadeBase;
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

    @Override
    public boolean detetAlbinismo() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 5) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaHeterocromia() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 25) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaMelanismo() {
        if (!isAlbinismo()) {
            int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
            if ((num % 100) <= 25) {
                return true;
            } else
                return false;
        }
        return false;
    }

    @Override
    public boolean detetaSiames() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 100) <= 3) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaVitiligo() {
        int num = Objects.hash(idAnimal, nome, esperancaVida, atratividade, viasExtincao, idade);
        if ((num % 50) <= 35) {
            return true;
        } else
            return false;
    }

    public double getAtratividade() {
        return atratividade;
    }

    public void setAtratividade(double atratividade) {
        this.atratividade = atratividade;
    }

    public void atualizaAtratividade() {

        // vias de extinção
        if (isViasExtincao()) {
            setAtratividade(getAtratividade() + (getAtratividade() * 0.5));
        }

        // bebe
        if (idade <= Math.round(getEsperancaVida() / 5)) {
            setAtratividade(getAtratividade() + (getAtratividade() * 0.5));
        }

        // adolescente
        else if (idade > Math.round(getEsperancaVida() / 5) && idade < Math.round(getEsperancaVida() * (3 / 4))) {
            setAtratividade(getAtratividade() - (getAtratividade() * 0.25));
        }

        // velho
        else {
            setAtratividade(getAtratividade() - (getAtratividade() * 0.25));
        }

        // Mutações
        if (isAlbinismo()) {
            setAtratividade(getAtratividade() + (getAtratividade() * 0.5));
        }
        if (isHeterocromia()) {

        }
        if (isMelanismo()) {

        }
        if (isVitiligo()) {

        }
        if (isSiames()) {

        }

    }

}
