package Ocorrencias;

import Animais.Animal;
import java.util.List;

public class Nascimento {
    private Animal ani;
    private List<Animal> animaisNascidos;
    private boolean lista;

    public Nascimento(Animal ani) {
        this.ani = ani;
        lista = false;
        this.animaisNascidos = null;
    }

    public Nascimento(List<Animal> animaisNascidos) {
        this.ani = null;
        this.lista = true;
        this.animaisNascidos = animaisNascidos;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!lista) {
            texto += "Nasceu o seguinte animal:\n   ";
            texto += ani;
        } else {
            if (animaisNascidos.isEmpty())
                texto += "\nnNenhum animal nasceu";
            else {
                texto += "\n0s seguintes animais nasceram : ";
                for (Animal animal : animaisNascidos) {
                    System.out.println(animal);
                    texto += "\n" + animal;
                }
            }
        }
        return texto;
    }
}
