package com.mycompany.jumanji_poo;

public class UrsoPolar extends Animal implements Ursus {

    private static double atratividadeBase;
    private final int esperancaVida;

    public UrsoPolar(String nome) {
        super(nome);
        setAtratividadeBase(4000);
        esperancaVida = 30;
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public UrsoPolar() {
        setAtratividadeBase(4000);
        esperancaVida = 30;
        setIdade(numAleatorioArray(getEsperancaVida()));
        setViasExtincao(true);
    }

    public int getEsperancaVida() {
        return esperancaVida;
    }

    @Override
    public void hibernar() {
        System.out.println("mimir");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        UrsoPolar.atratividadeBase = atratividadeBase;
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

    @Override
    public double retornaCusto() {
        // Random rand=new Random();
        double total = getAtratividadeBase() / 10 + custoUrsus;
        if (isAlbinismo())
            total += getAtratividadeBase() / 5;
        if (isSiames())
            total += getAtratividadeBase() / 8;
        if (isHeterocromia())
            total += getAtratividadeBase() / 6;
        if (isMelanismo())
            total += getAtratividadeBase() / 6;
        if (isVitiligo())
            total += getAtratividadeBase() / 8;
        if (isViasExtincao())
            total += getAtratividadeBase() / 3;
        if (getIdade() <= Math.round(getEsperancaVida() / 5))
            total += getAtratividadeBase() / 4;
        else if (getIdade() > Math.round(getEsperancaVida() * (3 / 4)))
            total -= getAtratividadeBase() / 4;
        return total;
    }

}
