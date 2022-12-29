package Ocorrencias;

import Animais.Animal;

public class Adicionar {
    private Animal ani;
    private boolean carGent;
    private String escolha;

    public Adicionar(Animal ani) {
        this.ani = ani;
        carGent = false;
        escolha = "";
    }

    public Adicionar(Animal ani, String escolha) {
        this.ani = ani;
        carGent = true;
        this.escolha = escolha;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!carGent) {
            texto += "\nO seguinte animal foi adicioando ao zoo como animal errante\n     ";
            texto += ani + "\n";
        } else {
            texto += "\nO seguinte animal foi comprado através de uma pesquisa pela caracteristica genética " + escolha
                    + " e inserido no zoo como animal errante:\n    ";
            texto += ani + "\n";
        }
        return texto;
    }
}
