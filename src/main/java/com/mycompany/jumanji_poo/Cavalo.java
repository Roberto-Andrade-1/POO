package com.mycompany.jumanji_poo;

public class Cavalo extends Animal implements Equus {

    private static double atratividadeBase;

    public Cavalo() {
        setAtratividadeBase(3000);
        setEsperancaVida(28);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Cavalo(String nome) {
        super(nome);
        setAtratividadeBase(3000);
        setEsperancaVida(28);
        setViasExtincao(false);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    @Override
    public void galopar() {
        System.out.println("pocotó");
    }

    @Override
    public void montar() {
        System.out.println("Cacalo foi montado");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Cavalo.atratividadeBase = atratividadeBase;
    }

    @Override
    public double retornaAtratividade() {
        double total = getAtratividadeBase();

        if (isViasExtincao()) {
            total += getAtratividadeBase() * 0.5;
        }

        // bebe
        if (getIdade() <= Math.round(getEsperancaVida() / 5)) {
            total += getAtratividadeBase() * 0.5;
        }

        // velho
        else if (getIdade() > Math.round(getEsperancaVida() * (3 / 4))) {
            total -= getAtratividadeBase() - (getAtratividadeBase() * 0.25);
        }

        // Mutações
        if (isAlbinismo()) {
            total += getAtratividadeBase() * 0.5;
        }
        if (isHeterocromia()) {
            total += getAtratividadeBase() * 0.35;
        }
        if (isMelanismo()) {
            total += getAtratividadeBase() * 0.5;
        }
        if (isVitiligo()) {
            total += getAtratividadeBase() * 0.25;
        }
        if (isSiames()) {
            total += getAtratividadeBase() * 0.1;
        }

        return total;
    }

}
