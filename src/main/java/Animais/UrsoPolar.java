package Animais;

import Genoma.Ursus;

public class UrsoPolar extends Animal implements Ursus {

    private static double atratividadeBase;
    private static boolean viasExtincao;
    private static final int ESPERANCA_VIDA = 30;
    private static final int APETITE_REPRODUTIVO = 24;

    public UrsoPolar(int idAnimal, int idade, String nome, String SEXO, boolean ALBINISMO, boolean VITILIGO,
            boolean MELANISMO, boolean HETEROCROMIA, boolean SIAMES) {
        super(idAnimal, idade, nome, SEXO, ALBINISMO, VITILIGO, MELANISMO, HETEROCROMIA, SIAMES);
        setAtratividadeBase(4000);
        setIdade(numAleatorio(getEsperancaVida()));
        setViasExtincao(true);
        ;
    }

    public UrsoPolar() {
        setAtratividadeBase(4000);
        setIdade(numAleatorio(getEsperancaVida()));
        setViasExtincao(true);
        ;
    }

    public UrsoPolar(int idade) {
        super(idade);
        setAtratividadeBase(4000);
        setViasExtincao(true);
        ;
    }

    public int getEsperancaVida() {
        return ESPERANCA_VIDA;
    }

    /*
     * Override do método hibernar da interface Ursus que faz o output na consola
     * "mimir"
     */
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

    /*
     * É rescrito o método retornaAtratividade da superclasse e este retorna um
     * valor double sendo maior ou menor dependendo
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
        double total = getAtratividadeBase() / 5 + CUSTO_URSUS;
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

    public static void setViasExtincao(boolean viasExtincao) {
        UrsoPolar.viasExtincao = viasExtincao;
    }

    public static int getApetiteReprodutivo() {
        return APETITE_REPRODUTIVO;
    }
}
