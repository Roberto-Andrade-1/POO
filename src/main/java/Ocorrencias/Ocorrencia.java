package Ocorrencias;

import java.util.ArrayList;
import java.util.List;

public class Ocorrencia {
    private List<String> historico;

    public Ocorrencia() {
        historico = new ArrayList<String>();
        historico.add("------INÍCIO------");
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setHistorico(String ocor) {
        historico.add(ocor);
    }

    @Override
    public String toString() {
        String texto = new String();
        for (String string : historico) {
            texto += string;
        }
        return texto;
    }

}
