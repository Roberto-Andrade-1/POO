package com.mycompany.jumanji_poo;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    public static void main(String[] args) {

        boolean sair = false;
        Scanner scan = new Scanner(System.in);
        Zoo zoo = new Zoo(1000000);

        while (!sair) {
            System.out.println("""

                    MENU:
                    1.Adquirir animal aleatório
                    2.Adquirir animal com característica genética
                    3.Construir instalação
                    4.Colocar animal em instalação
                    5.Calendário chinês
                    6.Listar animais
                    7.Listar animais com dada característica genética
                    8.Listar animais com dada mutação
                    9.Listar instalações
                    10.Retrato de família animal
                    11.Obituário
                    12.Histórico
                    13.Período contabilístico
                    14.Jumanji
                    15.Sair da aplicação
                    """);
            System.out.println("Escolha uma opção: ");
            int escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    animaisAleatorios(zoo);
                    break;
                case 2:
                    break;
                case 3:
                    recintosAleatorio(zoo);
                    break;
                case 4:
                    break;
                case 5:
                    calendarioChines();
                    break;
                case 6:
                    zoo.listarAnimais();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    listarRecintos(zoo);
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    sair = true;
                    break;
                default:
                    System.out.println("Número inválido");
                    break;
            }
        }
    }

    public static void animaisAleatorios(Zoo zoo) /* throws IOException */ {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int totalAnimais = 21;

        Animal[] treAnimaisAleat = new Animal[3];
        // cria 3 animais
        for (int i = 0; i < treAnimaisAleat.length; i++) {
            int numAleatorio = rand.nextInt(totalAnimais);
            switch (numAleatorio) {
                case 0:
                    treAnimaisAleat[i] = new Boi();
                    break;
                case 1:
                    treAnimaisAleat[i] = new Cao();
                    break;
                case 2:
                    treAnimaisAleat[i] = new Carneiro();
                    break;
                case 3:
                    treAnimaisAleat[i] = new Cavalo();
                    break;
                case 4:
                    treAnimaisAleat[i] = new Chita();
                    break;
                case 5:
                    treAnimaisAleat[i] = new Coelho();
                    break;
                case 6:
                    treAnimaisAleat[i] = new Dragao();
                    break;
                case 7:
                    treAnimaisAleat[i] = new Galo();
                    break;
                case 8:
                    treAnimaisAleat[i] = new Leao();
                    break;
                case 9:
                    treAnimaisAleat[i] = new LinceIberico();
                    break;
                case 10:
                    treAnimaisAleat[i] = new Lobo();
                    break;
                case 11:
                    treAnimaisAleat[i] = new Macaco();
                    break;
                case 12:
                    treAnimaisAleat[i] = new Panda();
                    break;
                case 13:
                    treAnimaisAleat[i] = new Porco();
                    break;
                case 14:
                    treAnimaisAleat[i] = new Raposa();
                    break;
                case 15:
                    treAnimaisAleat[i] = new Rato();
                    break;
                case 16:
                    treAnimaisAleat[i] = new Serpente();
                    break;
                case 17:
                    treAnimaisAleat[i] = new Tigre();
                    break;
                case 18:
                    treAnimaisAleat[i] = new UrsoCastanho();
                    break;
                case 19:
                    treAnimaisAleat[i] = new UrsoPolar();
                    break;
                case 20:
                    treAnimaisAleat[i] = new UrsoPreto();
                    break;
            }
        }

        System.out.println("\nAnimais para comprar:");
        int i = 1;

        for (Animal animal : treAnimaisAleat) {
            System.out.println(i + ".Espécie: " + animal.getClass().getSimpleName() +
                    " | Nome: " + animal.getNome() +
                    " | Idade: " + animal.getIdade() +
                    " | Albino: " + (animal.isAlbinismo() == true ? "sim" : "não") +
                    " | Heterocromia: " + (animal.isHeterocromia() == true ? "sim" : "não") +
                    " | Melanismo: " + (animal.isMelanismo() == true ? "sim" : "não") +
                    " | Siames: " + (animal.isSiames() == true ? "sim" : "não") +
                    " | Vitiligo: " + (animal.isVitiligo() == true ? "sim" : "não"));
            i++;
        }

        System.out.println("\nQual animal deseja comprar (1, 2,ou 3): ");
        int numAnimal = scan.nextInt();
        switch (numAnimal) {
            case 1:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[0].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[1 - 1]);
                break;
            case 2:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[1].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[2 - 1]);
                break;
            case 3:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[2].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[3 - 1]);
                break;
            default:
                System.out.println("Valor inválido");
        }

    }

    public static void recintosAleatorio(Zoo zoo) {
        Scanner scan = new Scanner(System.in);

        // cria 3 recintos
        Recinto rec1 = new Recinto();
        Recinto rec2 = new Recinto();
        Recinto rec3 = new Recinto();

        System.out.println("\nRECINTOS DISPONÍVEIS:");
        System.out.println("Candidato 1: capacidade: " + rec1.getCapacidade() + " | Custo: " + rec1.getCusto() + "€");
        System.out.println("Candidato 2: capacidade: " + rec2.getCapacidade() + " | Custo: " + rec2.getCusto() + "€");
        System.out.println("Candidato 3: capacidade: " + rec3.getCapacidade() + " | Custo: " + rec3.getCusto() + "€\n");

        System.out.println("Qual dos seguintes recintos pretende escolher?(se não pretender nenhum insira 0)");
        int escolhaRecinto = scan.nextInt();
        if (escolhaRecinto > 0 && escolhaRecinto <= 3)
            Recinto.setIdRecintoAtualizado();
        switch (escolhaRecinto) {
            case 0:
                break;
            case 1:
                rec1.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setRecintos(rec1);
                zoo.setSaldo(zoo.getSaldo() - rec1.getCusto());
                break;
            case 2:
                rec2.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setRecintos(rec2);
                zoo.setSaldo(zoo.getSaldo() - rec2.getCusto());
                break;
            case 3:
                rec3.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setRecintos(rec3);
                zoo.setSaldo(zoo.getSaldo() - rec3.getCusto());
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }

    public static void listarRecintos(Zoo zoo) {
        System.out.println("\nRECINTOS");
        for (Recinto i : zoo.getInstalcoes().keySet()) {
            System.out.println("ID: " + i.getIdRecinto() + " | capacidade: " + i.getCapacidade() + " | custo: "
                    + i.getCusto() + "€");
        }
    }

    public static void calendarioChines() {

        String[] calendario = { "Tigre", "Coelho", "Dragão", "Serpente", "Cavalo", "Carneiro", "Macaco", "Galo", "Cão",
                "Porco", "Rato", "Boi" };

        Random rand = new Random();
        String chinesAnimal = calendario[rand.nextInt(calendario.length)];
        System.out.println(chinesAnimal);
        switch (chinesAnimal) {
            case "Tigre":
                Tigre.setAtratividadeBase(Tigre.getAtratividadeBase() * 1.50);
                break;
            case "Coelho":
                Coelho.setAtratividadeBase(Coelho.getAtratividadeBase() * 1.50);
                break;
            case "Dragão":
                Dragao.setAtratividadeBase(Dragao.getAtratividadeBase() * 1.50);
                break;
            case "Serpente":
                Serpente.setAtratividadeBase(Serpente.getAtratividadeBase() * 1.50);
                break;
            case "Cavalo":
                Cavalo.setAtratividadeBase(Cavalo.getAtratividadeBase() * 1.50);
                break;
            case "Carneiro":
                Carneiro.setAtratividadeBase(Carneiro.getAtratividadeBase() * 1.50);
                break;
            case "Macaco":
                Macaco.setAtratividadeBase(Macaco.getAtratividadeBase() * 1.50);
                break;
            case "Galo":
                Galo.setAtratividadeBase(Galo.getAtratividadeBase() * 1.50);
                break;
            case "Cão":
                Cao.setAtratividadeBase(Cao.getAtratividadeBase() * 1.50);
                break;
            case "Porco":
                Porco.setAtratividadeBase(Porco.getAtratividadeBase() * 1.50);
                break;
            case "Rato":
                Rato.setAtratividadeBase(Porco.getAtratividadeBase() * 1.50);
                break;
            case "Boi":
                Boi.setAtratividadeBase(Boi.getAtratividadeBase() * 1.50);
                break;
        }

    }

    public static void periodoContabilistico(Zoo zoo) {
        //calcular primeiro os custos totais do zoo
        zoo.calculaDespesas();

        //calcula os proveitos totais do zoo
        
        //retira do saldo do zoo os custos
        zoo.getSaldo() - zoo.calculaDespesas();
        //registar os nascimentos e obitos

        //em caso de prejuizo pode-se perder animais
    }
}
