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
            texto += "\nNasceu o seguinte animal:\n   ";
            texto += ani + "\n";
        } else {
            if (animaisNascidos.isEmpty())
                texto += "\n->Nenhum animal nasceu";
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
