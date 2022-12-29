package Ocorrencias;

import Animais.Animal;

public class InserirAnimalNoRecinto {
    private Animal ani, aniMover;
    private int idRecinto;
    private boolean necessarioMover;

    public InserirAnimalNoRecinto(Animal ani, int idRecinto) {
        this.ani = ani;
        this.idRecinto = idRecinto;
        necessarioMover = false;
        this.aniMover = null;
    }

    public InserirAnimalNoRecinto(Animal ani, int idRecinto, Animal aniMover) {
        this.ani = ani;
        this.idRecinto = idRecinto;
        this.necessarioMover = true;
        this.aniMover = aniMover;
    }

    @Override
    public String toString() {
        String texto = new String();
        if (!necessarioMover) {
            texto += "\nO seguinte animal foi adicionado no recinto com id " + idRecinto + ":\n     ";
            texto += ani + "\n";
        } else {
            texto += "\nO seguinte animal foi adicionado no recinto com id " + idRecinto + ":\n    ";
            texto += ani;
            texto += "\n-->Para este entrar o seguinte animal teve que sair, assim sendo o animal tornou-se errante:\n    ";
            texto += aniMover + "\n";
        }
        return texto;
    }
}
