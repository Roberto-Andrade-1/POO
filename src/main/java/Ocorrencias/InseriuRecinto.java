package Ocorrencias;

import com.mycompany.jumanji_poo.Recinto;

public class InseriuRecinto {
    private Recinto rec;

    public InseriuRecinto(Recinto rec) {
        this.rec = rec;
    }

    @Override
    public String toString() {
        String texto = new String();
        texto += "\nFoi adicionado ao seu zoo o seguinte recinto:\n    ";
        texto += rec + "\n";
        return texto;
    }
}
