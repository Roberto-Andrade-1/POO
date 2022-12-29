package Ocorrencias;

import Animais.Animal;
import java.util.List;

public class Fugiu {
    private Animal ani;
    private List<Animal> animaisPerdidos;
    private boolean lista;

    public Fugiu(Animal ani) {
        this.ani = ani;
        this.animaisPerdidos = null;
        lista = false;
    }

    public Fugiu(List<Animal> animaisPerdidos) {
        this.animaisPerdidos = animaisPerdidos;
        ani = null;
        lista = true;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!lista) {
            texto += "\nO seguinte animal fugiu do recinto:\n     ";
            texto += ani + "\n";
        } else {
            if (animaisPerdidos.isEmpty()) {
                texto += "\n->Nenhum animal fugiu\n";
            } else {
                texto += "\n->Os seguintes animais fugiram do zoo\n     ";
                for (Animal animal : animaisPerdidos) {
                    texto += animal + "\n     ";
                }
            }
        }
        return texto;
    }
}
