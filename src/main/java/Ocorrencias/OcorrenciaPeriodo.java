package Ocorrencias;

public class OcorrenciaPeriodo {
    private double despesas, proveitos;

    public OcorrenciaPeriodo(double despesas, double proveitos) {
        this.despesas = despesas;
        this.proveitos = proveitos;
    }

    @Override
    public String toString() {
        String texto = new String();
        texto += "\n------Período Contabilistico------\n";
        texto += "\n->As suas despesas foram as seguintes: " + despesas + "€\n";
        texto += "\n->Os seus proveitos foram os seguintes: " + proveitos + "€\n";
        if (proveitos < despesas) {
            texto += "\nHouve prejuizo no seu zoo neste periodo contabilistico:";
        }
        return texto;
    }
}