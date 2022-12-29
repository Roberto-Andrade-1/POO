package Ocorrencias;

import Animais.Animal;
import java.util.List;

public class Morte {
    private Animal ani;
    private List<Animal> animaisMortos;
    private boolean lista;

    public Morte(Animal ani) {
        this.ani = ani;
        lista = false;
        this.animaisMortos = null;
    }

    public Morte(List<Animal> animaisMortos) {
        this.ani = null;
        lista = true;
        this.animaisMortos = animaisMortos;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!lista) {
            texto += "\nMorreu o seguinte animal:\n   ";
            texto += ani + "\n";
        } else {
            if (animaisMortos.isEmpty())
                texto += "\n->Não morreram animais";
            else {
                texto += "\nOs seguintes animais morreram";
                for (Animal animal : animaisMortos) {
                    System.out.println(animal);
                    texto += "\n" + animal;
                }
            }
        }
        return texto;
    }
}
