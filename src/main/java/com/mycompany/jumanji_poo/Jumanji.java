package com.mycompany.jumanji_poo;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        boolean sair = false;
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
                    adquirirAnimaisAleatorios(zoo);
                    break;
                case 2:
                    animalCaracAlea(zoo);
                    break;
                case 3:
                    recintosAleatorio(zoo);
                    break;
                case 4:
                    adicionarInstalacao(zoo);
                    break;
                case 5:
                    calendarioChines();
                    break;
                case 6:
                    zoo.listarAnimais();
                    break;
                case 7:
                    listarAnimaisCarGenetica(zoo);
                    break;
                case 8:
                    listarDadaMutacao(zoo);
                    break;
                case 9:
                    zoo.listarRecintos();
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    System.out.println(zoo.getSaldo());
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

    public static Animal animaisAleatorios() {
        Random rand = new Random();
        int totalAnimais = 21;
        int numAleatorio = rand.nextInt(totalAnimais);

        Animal a = null;

        switch (numAleatorio) {
            case 0:
                a = new Boi();
                break;
            case 1:
                a = new Cao();
                break;
            case 2:
                a = new Carneiro();
                break;
            case 3:
                a = new Cavalo();
                break;
            case 4:
                a = new Chita();
                break;
            case 5:
                a = new Coelho();
                break;
            case 6:
                a = new Dragao();
                break;
            case 7:
                a = new Galo();
                break;
            case 8:
                a = new Leao();
                break;
            case 9:
                a = new LinceIberico();
                break;
            case 10:
                a = new Lobo();
                break;
            case 11:
                a = new Macaco();
                break;
            case 12:
                a = new Panda();
                break;
            case 13:
                a = new Porco();
                break;
            case 14:
                a = new Raposa();
                break;
            case 15:
                a = new Rato();
                break;
            case 16:
                a = new Serpente();
                break;
            case 17:
                a = new Tigre();
                break;
            case 18:
                a = new UrsoCastanho();
                break;
            case 19:
                a = new UrsoPolar();
                break;
            case 20:
                a = new UrsoPreto();
                break;
        }
        return a;
    }

    // 1.adquirir um animal aleatório
    public static void adquirirAnimaisAleatorios(Zoo zoo) /* throws IOException */ {
        // scan = new Scanner(System.in);

        Animal[] treAnimaisAleat = new Animal[3];
        // cria 3 animais
        for (int i = 0; i < treAnimaisAleat.length; i++) {
            treAnimaisAleat[i] = animaisAleatorios();
        }

        System.out.println("\nAnimais para comprar:");
        int i = 1;

        for (Animal animal : treAnimaisAleat) {
            System.out.print("\n" + i + "." + animal);
            i++;
        }

        System.out.println("\n\nQual animal deseja comprar (1, 2 ou 3): ");
        int numAnimal = scan.nextInt();
        switch (numAnimal) {
            case 1:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[0].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[0]);
                zoo.setSaldo(zoo.getSaldo() - treAnimaisAleat[0].retornaCusto());
                break;
            case 2:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[1].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[1]);
                zoo.setSaldo(zoo.getSaldo() - treAnimaisAleat[1].retornaCusto());
                break;
            case 3:
                Animal.setIdAnimalAtualizado();
                treAnimaisAleat[2].setIdAnimal(Animal.getIdAnimalAtualizado());
                zoo.setAnimaisErrantes(treAnimaisAleat[2]);
                zoo.setSaldo(zoo.getSaldo() - treAnimaisAleat[2].retornaCusto());
                break;
            default:
                System.out.println("Valor inválido");
        }

    }

    // 2.Adquirir animal com característica genética
    public static void animalCaracAlea(Zoo zoo) {
        // Scanner scan = new Scanner(System.in);

        System.out.println("""

                Escolha uma das seguintes caracteristicas genéticas:
                1.Canis
                2.Equus
                3.Naja
                4.Ovis
                5.Phantera
                6.Ursus
                """);

        int escolha = scan.nextInt();
        Animal a = animaisAleatorios();
        boolean inserir = false;
        // isAssignableFrom verifica se a classe implementa a interface
        switch (escolha) {
            case 1:
                if (Canis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Canis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case 2:
                if (Equus.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Equus.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case 3:
                if (Naja.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Naja.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case 4:
                if (Ovis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Ovis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case 5:
                if (Panthera.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Panthera.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case 6:
                if (Ursus.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Ursus.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            default:
                System.out.println("Numero invalido");
                break;
        }
        if (inserir) {
            System.out.println(a);
            Animal.setIdAnimalAtualizado();
            a.setIdAnimal(Animal.getIdAnimalAtualizado());
            zoo.setAnimaisErrantes(a);
            zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());
        }
    }

    // 3.Recintos Aleatorios
    public static void recintosAleatorio(Zoo zoo) {
        // Scanner scan = new Scanner(System.in);

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

    // 4.Adicionar animal nas instalações
    public static void adicionarInstalacao(Zoo zoo) {
        // Scanner scan = new Scanner(System.in);

        System.out.println("\nQual animal deseja adicionar? (ID)");
        zoo.listarAnimaisErrantes();
        int idAnimal = scan.nextInt();

        System.out.println("\nQual o recinto que pretende inserir o Animal? (ID)");
        zoo.listarRecintos();
        int idRecinto = scan.nextInt();

        for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {
            Recinto rec = recintos.getKey();
            Animal[] animais = recintos.getValue();
            if (rec.getIdRecinto() == idRecinto) {// verifica o id do recinto
                for (int j = 0; j < zoo.getAnimaisErrantes().size(); j++) {// percorrer lista animais errantes
                    Animal ani = zoo.getAnimaisErrantes().get(j);
                    if (ani.getIdAnimal() == idAnimal) {// se o id for igual ao qur o utilizador escolheu
                        if (rec.getCapacidade() != rec.getOcupacao()) {// se ainda houver lugares disponiveis no recinto
                            animais[rec.getOcupacao()] = ani;// adiciona na Hashmap
                            zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(j));// retira da lista de
                                                                                             // aniamis errantes
                        } else {// caso esteja cheio o recinto
                            Random rand = new Random();
                            int num = rand.nextInt(rec.getCapacidade());// é gerado um número aleatorio para escolher
                                                                        // qual animal (posição) irá sair
                            Animal a = animais[num];// variavel para guardar aniaml do recinto
                            animais[num] = ani;// adiciona hashmap o animal errante
                            zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(j));// retira hashmap
                            zoo.setAnimaisErrantes(a);// insere o animal antigo da hashmap na lista de animais
                        }
                        System.out.println("\nAnimal inserido com sucesso");
                    }
                }
            }
        }
    }

    // 5.Calendario Chines
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

    // 7.Listar Animais com caracteristica Generica especificada
    public static void listarAnimaisCarGenetica(Zoo zoo) {
        System.out.println("""

                Qual a característica genetica que pretende?
                1.Canis
                2.Equus
                3.Naja
                4.Ovis
                5.Phantera
                6.Ursus

                """);
        int escolha = scan.nextInt();
        switch (escolha) {
            case 1:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Canis.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Canis.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 2:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Equus.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Equus.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 3:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Naja.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Naja.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 4:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Ovis.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Ovis.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 5:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Panthera.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Panthera.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case 6:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (Ursus.class.isAssignableFrom(animal.getClass())) {
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {
                    for (Animal animal : ani) {
                        if (animal != null && Ursus.class.isAssignableFrom(animal.getClass())) {
                            System.out.println(animal);
                        }
                    }
                }
                break;
        }
    }

    // 8.Listar animal com uma dada mutação
    public static void listarDadaMutacao(Zoo zoo) {
        scan = new Scanner(System.in);
        System.out.println("""

                Qual a mutação pretende?
                1.Albino
                2.Heterocromia
                3.Melanismo
                4.Siames
                5.Vitiligo

                """);
        int escolha = scan.nextInt();
        switch (escolha) {
            case 1:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (animal.isAlbinismo())
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {
                    for (Animal ani : animal) {
                        if (ani.isAlbinismo())
                            System.out.println(animal);
                    }
                }
                break;
            case 2:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (animal.isHeterocromia())
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {
                    for (Animal ani : animal) {
                        if (ani.isHeterocromia())
                            System.out.println(animal);
                    }
                }
                break;
            case 3:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (animal.isMelanismo())
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {
                    for (Animal ani : animal) {
                        if (ani.isMelanismo())
                            System.out.println(animal);
                    }
                }
                break;
            case 4:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (animal.isSiames())
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {
                    for (Animal ani : animal) {
                        if (ani.isSiames())
                            System.out.println(animal);
                    }
                }
                break;
            case 5:
                for (Animal animal : zoo.getAnimaisErrantes()) {
                    if (animal.isVitiligo())
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {
                    for (Animal ani : animal) {
                        if (ani.isVitiligo())
                            System.out.println(animal);
                    }
                }
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    public static void periodoContabilistico(Zoo zoo) {
        // calcular primeiro os custos totais do zoo
        zoo.calculaDespesas();

        // calcula os proveitos totais do zoo

        // retira do saldo do zoo os custos
        // zoo.getSaldo() - zoo.calculaDespesas();
        // registar os nascimentos e obitos

        // em caso de prejuizo pode-se perder animais
    }
}
