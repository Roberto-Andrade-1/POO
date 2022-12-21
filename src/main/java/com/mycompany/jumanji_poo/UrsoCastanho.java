package com.mycompany.jumanji_poo;

public class UrsoCastanho extends Animal implements Ursus {

    private static double atratividadeBase;

    public UrsoCastanho(String nome) {
        super(nome);
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    public UrsoCastanho() {
        setAtratividadeBase(3500);
        setEsperancaVida(25);
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(false);
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        UrsoCastanho.atratividadeBase = atratividadeBase;
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
        else if (getIdade() < Math.round(getEsperancaVida() * (3 / 4))) {
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