package Animais;

import Genoma.Panthera;

public class Tigre extends Animal implements Panthera {

    private static double atratividadeBase;
    private static boolean viasExtincao;
    private static final int ESPERANCA_VIDA = 10;
    private static final int APETITE_REPRODUTIVO = 43;

    public Tigre(int idAnimal, int idade, String nome, String SEXO, boolean ALBINISMO, boolean VITILIGO,
            boolean MELANISMO, boolean HETEROCROMIA, boolean SIAMES) {
        super(idAnimal, idade, nome, SEXO, ALBINISMO, VITILIGO, MELANISMO, HETEROCROMIA, SIAMES);
        setAtratividadeBase(5000);
        setIdade(numAleatorioArray(getEsperancaVida()));
        viasExtincao = true;
    }

    public Tigre() {
        setAtratividadeBase(5000);
        setIdade(numAleatorioArray(getEsperancaVida()));
        viasExtincao = true;
    }

    public Tigre(int idade) {
        setAtratividadeBase(5000);
        // num aleatorio de 0 a 10
        setIdade(idade);
        viasExtincao = true;
    }

    public static void setViasExtincao(boolean viasExtincao) {
        Tigre.viasExtincao = viasExtincao;
    }

    public static int getApetiteReprodutivo() {
        return APETITE_REPRODUTIVO;
    }

    public int getEsperancaVida() {
        return ESPERANCA_VIDA;
    }

    /*
     * Override do método rugir da interface Panthera que faz o output na consola
     * "Roawrrr"
     */
    @Override
    public void rugir() {
        System.out.println("Roawrrr");
    }

    public static double getAtratividadeBase() {
        return atratividadeBase;
    }

    public static void setAtratividadeBase(double atratividadeBase) {
        Tigre.atratividadeBase = atratividadeBase;
    }

    /*
     * É rescrito o método retornaAtratividadeBase em que é alterada a atratividade
     * do animal caso tenha
     * as condiões para tal como a sua idade e se tem mutações
     */
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

    /*
     * Override do método que retorna o custo do animal aquando da sua compra
     * que varia de preço conforme as mutações, idade e vias de extinção
     */
    @Override
    public double retornaCusto() {
        // Random rand=new Random();
        double total = getAtratividadeBase() / 5 + CUSTO_PHANTERA;
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
            total -= getAtratividadeBase() / 10;
        return Math.round(total * 100) / 100;
    }

    /*
     * Override do método que retorna a esperança de vida do animal
     */
    @Override
    public int retornaEsperancaVida() {
        return ESPERANCA_VIDA;
    }

    /*
     * Override do método que retorna o apetite reprodutivo do animal
     */
    @Override
    public int retornaApetiteReprodutivo() {
        return APETITE_REPRODUTIVO;
    }

    public static boolean isViasExtincao() {
        return viasExtincao;
    }
}