package com.mycompany.jumanji_poo;

import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    public static void main(String[] args) {

        boolean sair = false;
        Scanner scan = new Scanner(System.in);
        Zoo zoo = new Zoo(100000);

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
                    animaisAleatorios();
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
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    listarInstalacoes(zoo);
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

    public static void animaisAleatorios() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int totalAnimais = 21;

        Animal[] treAnimaisAleat = new Animal[3];
        // cria 3 animais
        for (int i = 0; i < treAnimaisAleat.length; i++) {
            int numAleatorio = rand.nextInt(4);
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
            }
        }
        System.out.println("Animais:");
        for (Animal animal : treAnimaisAleat) {
            System.out.println("Espécie:" + animal.getClass().getSimpleName() +
                    "| Nome: " + animal.getNome() +
                    "| Idade: " + animal.getIdade());
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
                zoo.setInstalacoes(rec1);
                zoo.setSaldo(zoo.getSaldo() - rec1.getCusto());
                break;
            case 2:
                rec2.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setInstalacoes(rec2);
                zoo.setSaldo(zoo.getSaldo() - rec2.getCusto());
                break;
            case 3:
                rec3.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setInstalacoes(rec3);
                zoo.setSaldo(zoo.getSaldo() - rec3.getCusto());
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }

    public static void listarInstalacoes(Zoo zoo) {
        System.out.println("\nRECINTOS");
        for (Recinto i : zoo.getInstalcoes().keySet()) {
            System.out.println("ID: " + i.getIdRecinto() + " | capacidade: " + i.getCapacidade() + " | custo: "
                    + i.getCusto() + "€");
        }
    }

    public static void calendarioChines() {
        String[] calendario = { "Tigre", "Coelho", "Dragão", "Cobra", "Cavalo", "Cabra", "Macaco", "Galo", "Cao",
                "Porco", "Rato", "Boi" };
        // for tem de depeder do periodo contabilistico
        Random rand = new Random();
        String chinesAnimal = calendario[rand.nextInt(calendario.length)];
        System.out.println(chinesAnimal);
        // for(int i=0;i<12;i){
        // return calendario[i];
        // if(i == 12){
        // i = 0;
        // }
        // }
    }
}
