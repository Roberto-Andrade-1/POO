package com.mycompany.jumanji_poo;

public class Chita extends Animal {

    private static double atratividadeBase;

    public Chita(String nome) {
        super(nome);
        setAtratividadeBase(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public Chita() {
        setAtratividadeBase(5000);
        setEsperancaVida(12);
        setViasExtincao(true);
        setIdade(numAleatorioArray(getEsperancaVida()));
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Chita.atratividadeBase = atratividadeBase;
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