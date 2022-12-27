package Animais;

import Mutacoes.Mutacoes;
import java.util.Objects;
import java.util.Random;

public abstract class Animal implements Mutacoes {

    private static final String[] NOMES_ALEATORIOS = { "Johannah", "Kitty", "Von", "Joanne", "Goddart", "Lottie",
            "Lorilee", "Esta", "Phaidra", "Nikos", "Elbert", "Sloane", "Shaun", "Benedikta", "Bea", "Arley", "Jori",
            "Franni", "Isidore", "Dolly", "Hephzibah", "Clarence", "Adelle", "Alasdair", "Adina", "Morganica", "Efren",
            "Jobie", "Jimmi", "Rosco", "Arline", "Jaye", "Stavros", "Zachery", "Derby", "Teressa", "Chane", "Jeanelle",
            "Shelagh", "Sianna", "Annmaria", "Willetta", "Daisi", "Tine", "Yul", "Bunni", "Rhianon", "Jen",
            "Friederike" };

    private static int idAnimalAtualizado;
    private int idAnimal, idade;
    private String nome;
    private final String SEXO;
    private final boolean ALBINISMO, VITILIGO, MELANISMO, HETEROCROMIA, SIAMES;

    public Animal(int idAnimal, int idade, String nome, String SEXO, boolean ALBINISMO, boolean VITILIGO,
            boolean MELANISMO, boolean HETEROCROMIA, boolean SIAMES) {
        this.idAnimal = idAnimal;
        this.idade = idade;
        this.nome = nome;
        this.SEXO = SEXO;
        this.ALBINISMO = ALBINISMO;
        this.HETEROCROMIA = HETEROCROMIA;
        this.VITILIGO = VITILIGO;
        this.MELANISMO = MELANISMO;
        this.SIAMES = SIAMES;
    }

    public Animal(String nome) {
        idAnimal = 0;
        this.nome = nome;
        this.idade = 0;
        this.ALBINISMO = detetAlbinismo();
        this.VITILIGO = detetaVitiligo();
        this.MELANISMO = detetaMelanismo();
        this.HETEROCROMIA = detetaHeterocromia();
        this.SIAMES = detetaSiames();
        this.SEXO = sexoAleatorio();

    }

    public Animal() {
        idAnimal = 0;
        this.nome = NOMES_ALEATORIOS[numAleatorioArray(NOMES_ALEATORIOS.length)];
        this.idade = 0;
        this.ALBINISMO = detetAlbinismo();
        this.VITILIGO = detetaVitiligo();
        this.MELANISMO = detetaMelanismo();
        this.HETEROCROMIA = detetaHeterocromia();
        this.SIAMES = detetaSiames();
        this.SEXO = sexoAleatorio();
    }

    public String getSexo() {
        return SEXO;
    }

    public int numAleatorioArray(int length) {
        Random rand = new Random();
        int num = rand.nextInt(length);
        return num;
    }

    public static int getIdAnimalAtualizado() {
        return idAnimalAtualizado;
    }

    public static void incrementaIdAnimalAtualizado() {
        idAnimalAtualizado++;
    }

    public static void setIdAnimalAtualizado(int idAnimalAtualizado) {
        if (Animal.idAnimalAtualizado < idAnimalAtualizado) {
            Animal.idAnimalAtualizado = idAnimalAtualizado;
        }
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static String[] getNOMES_ALEATORIOS() {
        return NOMES_ALEATORIOS;
    }

    public boolean isAlbinismo() {
        return ALBINISMO;
    }

    public boolean isVitiligo() {
        return VITILIGO;
    }

    public boolean isMelanismo() {
        return MELANISMO;
    }

    public boolean isHeterocromia() {
        return HETEROCROMIA;
    }

    public boolean isSiames() {
        return SIAMES;
    }

    public int numAleatorioObjHash() {
        int num = Objects.hash(idAnimal, nome, idade, NOMES_ALEATORIOS, idAnimalAtualizado);
        if (num < 0) {
            num = num * (-1);
        }
        return num;
    }

    @Override
    public boolean detetAlbinismo() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 15) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaHeterocromia() {
        int num = numAleatorioObjHash();
        if ((num % 100) <= 25) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaMelanismo() {
        if (!isAlbinismo()) {
            int num = numAleatorioObjHash();
            if ((num % 100) <= 35) {
                return true;
            } else
                return false;
        }
        return false;
    }

    @Override
    public boolean detetaSiames() {
        int num = numAleatorioObjHash();
        if ((num % 100) >= 95) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean detetaVitiligo() {
        int num = numAleatorioObjHash();
        if ((num % 100) >= 80 && (num % 100) <= 98) {
            return true;
        } else
            return false;
    }

    public abstract double retornaAtratividade();

    public abstract double retornaCusto();

    public abstract int retornaApetiteReprodutivo();

    public abstract int retornaEsperancaVida();

    @Override
    public String toString() {
        String texto = new String();
        // na hora da compra ainda não tem ID
        if (getIdAnimal() != 0)
            texto += "ID: " + getIdAnimal() + " | ";
        texto += "Espécie: " + this.getClass().getSimpleName();
        texto += " | Nome: " + getNome();
        texto += " | Idade: " + getIdade();
        texto += " | Sexo: " + getSexo();
        // mostrar mutacoes só na hora da compra
        if (getIdAnimal() == 0) {
            texto += " \n-> Albino: " + (isAlbinismo() == true ? "sim" : "não");
            texto += " \n-> Heterocromia: " + (isHeterocromia() == true ? "sim" : "não");
            texto += " \n-> Melanismo: " + (isMelanismo() == true ? "sim" : "não");
            texto += " \n-> Siames: " + (isSiames() == true ? "sim" : "não");
            texto += " \n-> Vitiligo: " + (isVitiligo() == true ? "sim" : "não");
            texto += " \n----> Custo: " + retornaCusto() + "\n"; // retorna o valor com duas casas decimais
        }
        // no caso do animal for comprado
        else {
            texto += " | Atratividade: " + retornaAtratividade();
        }
        return texto;
    }

    public String sexoAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(10);
        if ((num % 2) == 0)
            return "Fêmea";
        else
            return "Macho";
    }

    // public abstract boolean retornaViasExtincao();

}
