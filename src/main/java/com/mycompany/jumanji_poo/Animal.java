package com.mycompany.jumanji_poo;

public abstract class Animal {

    private static int idAnimalAtualizado;
    private int idAnimal, idade;
    private String nome;
    private double atratividade;

    public Animal(String nome) {
        idAnimal = 0;
        this.nome = nome;
        atratividade = 3000; // €
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

}
