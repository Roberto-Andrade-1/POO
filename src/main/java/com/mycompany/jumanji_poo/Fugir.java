package com.mycompany.jumanji_poo;

import java.util.List;

public class Fugir {
    private Animal ani;
    private List<Animal> animaisPerdidos;
    private boolean lista;

    public Fugir(Animal ani) {
        this.ani = ani;
        this.animaisPerdidos = null;
        lista = false;
    }

    public Fugir(List<Animal> animaisPerdidos) {
        this.animaisPerdidos = animaisPerdidos;
        ani = null;
        lista = true;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!lista) {
            texto += "\nO seguinte animal fugiu do recinto:\n    ";
            texto += ani;
        } else {
            if (animaisPerdidos.isEmpty()) {
                texto += "\n->Nenhum animal fugiu\n";
            } else {
                texto += "\n->Os seguintes animais fugiram do zoo";
                for (Animal animal : animaisPerdidos) {
                    texto += "\n " + animal;
                }
            }
        }
        return texto;
    }
}
