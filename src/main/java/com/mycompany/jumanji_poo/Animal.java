package com.mycompany.jumanji_poo;

public class Animal {
    
    private static int id;
    private String nome;
    private  double atratividade;
    
    
    public Animal(String nome) {
        id++;
        this.nome=nome;
        atratividade=0.30;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Animal.id = id;
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

    
}
