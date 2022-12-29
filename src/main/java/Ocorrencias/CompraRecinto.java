package Ocorrencias;

import com.mycompany.jumanji_poo.Recinto;

public class ComprarRecinto {
    private Recinto rec;
    private int numCandidato;

    public ComprarRecinto(Recinto rec, int numCandidato) {
        this.rec = rec;
        this.numCandidato = numCandidato;
    }

    @Override
    public String toString() {
        String texto = new String();
        texto = "\nO utilizador escolheu o seguinte recinto do candidato " + numCandidato + ":\n    ";
        texto += rec + "\n";
        return texto;
    }
}
