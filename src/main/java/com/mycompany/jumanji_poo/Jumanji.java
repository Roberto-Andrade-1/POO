package com.mycompany.jumanji_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        boolean sair = false;
        Zoo zoo = new Zoo(300000);

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
                    zoo.listarAnimaisMortos();
                    break;
                case 12:
                    break;
                case 13:
                    periodoContabilistico(zoo);
                    System.out.println("Saldo atualmente disponivel: " + zoo.getSaldo());
                    break;
                case 14:
                    jumanji(zoo);
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
                            for (int i = 0; i < animais.length; i++) {// adiciona na Hashmap numa posição nula
                                if (animais[i] == null) {
                                    animais[i] = ani;
                                    break;
                                }
                            }
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

        System.out.println("Escolha um ano: ");
        int year = scan.nextInt();
        if (year < 2000)
            System.out.println("Tem de inserir um ano a partir de 2000");
        else if ((year - 2000) % 12 == 0) {
            Dragao.setAtratividadeBase(Dragao.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Dragão, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
        } else if ((year - 2000) % 12 == 1) {
            Serpente.setAtratividadeBase(Serpente.getAtratividadeBase() * 1.50);
            System.out.println("Ano da Serpente, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
        } else if ((year - 2000) % 12 == 2) {
            Cavalo.setAtratividadeBase(Cavalo.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Cavalo, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
        } else if ((year - 2000) % 12 == 3) {
            Carneiro.setAtratividadeBase(Carneiro.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Carneiro, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
        } else if ((year - 2000) % 12 == 4) {
            Macaco.setAtratividadeBase(Macaco.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Macaco, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
        } else if ((year - 2000) % 12 == 5) {
            Galo.setAtratividadeBase(Galo.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Galo, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else if ((year - 2000) % 12 == 6) {
            Cao.setAtratividadeBase(Cao.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Cão, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else if ((year - 2000) % 12 == 7) {
            Porco.setAtratividadeBase(Porco.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Porco, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else if ((year - 2000) % 12 == 8) {
            Rato.setAtratividadeBase(Rato.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Rato, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else if ((year - 2000) % 12 == 9) {
            Boi.setAtratividadeBase(Boi.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Boi, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else if ((year - 2000) % 12 == 10) {
            Tigre.setAtratividadeBase(Tigre.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Tigre, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
        } else {
            Coelho.setAtratividadeBase(Coelho.getAtratividadeBase() * 1.50);
            System.out.println("Ano do Coelho, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
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
                        if (ani != null && ani.isAlbinismo())
                            System.out.println(ani);
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
                        if (ani != null && ani.isHeterocromia())
                            System.out.println(ani);
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
                        if (ani != null && ani.isMelanismo())
                            System.out.println(ani);
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
                        if (ani != null && ani.isSiames())
                            System.out.println(ani);
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
                        if (ani != null && ani.isVitiligo())
                            System.out.println(ani);
                    }
                }
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    // 13.Periodo contabilistico
    public static void periodoContabilistico(Zoo zoo) {
        // calcular primeiro os custos totais do zoo
        // zoo.calculaDespesas();
        System.out.println("Despesas: " + zoo.calculaDespesas());

        // calcula os proveitos totais do zoo
        int proveitos = 0;
        for (Animal[] animais : zoo.getRecintos().values()) {
            for (Animal animal : animais) {
                if (animal != null) {
                    zoo.setSaldo(zoo.getSaldo() + animal.retornaAtratividade());
                    proveitos += animal.retornaAtratividade();
                }
            }
        }
        System.out.println("Proveitos: " + proveitos);
        System.out.println("Despesa: " + zoo.calculaDespesas());// só para ver

        // aumenta idade dos animais
        for (Animal animal : zoo.getAnimaisErrantes()) {
            animal.setIdade(animal.getIdade() + 1);
        }
        for (Animal[] animais : zoo.getRecintos().values()) {
            for (Animal animal : animais) {
                if (animal != null)
                    animal.setIdade(animal.getIdade() + 1);
            }
        }

        // Probabilidade de morrer
        ArrayList<Animal> animaisMortosNumPeriodo = new ArrayList<Animal>();
        Random rand = new Random();
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            int num = rand.nextInt(101);
            if (zoo.getAnimaisErrantes().get(i) != null) {
                if (zoo.getAnimaisErrantes().get(i).getIdade() >= zoo.getAnimaisErrantes().get(i)
                        .retornaEsperancaVida()) { // 90% do animal morrer
                    if (num < 90) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.8
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 75% do animal morrer
                    if (num < 75) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.6
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 40% do animal morrer
                    if (num < 40) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.4
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 10% do animal morrer
                    if (num < 10) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else { // 3% do animal morrer
                    if (num < 3) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                }
            }
        }

        for (Animal[] animais : zoo.getRecintos().values()) {
            int num = rand.nextInt(101);
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {
                    if (animais[i].getIdade() >= animais[i].retornaEsperancaVida()) { // 90% de o animal morrer
                        if (num < 90) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.8 * animais[i].retornaEsperancaVida()) {// 75$ do animal
                                                                                                  // morrer
                        if (num < 75) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.6 * animais[i].retornaEsperancaVida()) {// 40% do animal
                                                                                                  // morrer
                        if (num < 40) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.4 * animais[i].retornaEsperancaVida()) {// 10% do animal
                                                                                                  // morrer
                        if (num < 10) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else { // 3% de morrer
                        if (num < 3) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    }
                }
            }
        }

        if (animaisMortosNumPeriodo.isEmpty()) {
            System.out.println("\nNenhum animal morreu neste período contabilístico");
        } else {
            System.out.println("\nOs seguintes animais morreram neste período contabilístico:");
            for (Animal animal : animaisMortosNumPeriodo) {
                System.out.println(animal);
            }
        }

        // retira do saldo do zoo os custos (ja ta feito no metodo calculaDespesas no
        // zoo)

        // nascimentos
        System.out.println("\nNasimentos: ");
        List<Animal> ani = new ArrayList<Animal>();
        for (Animal animal : zoo.getAnimaisErrantes()) {
            int num = rand.nextInt(101);
            Animal a = null;
            if (animal.retornaApetiteReprodutivo() >= num
                    && animal.getIdade() >= Math.round((0.25) * animal.retornaEsperancaVida())) {
                switch (animal.getClass().getSimpleName()) {
                    case "Boi":
                        a = new Boi(0);
                        break;
                    case "Cao":
                        a = new Cao(0);
                        break;
                    case "Carneiro":
                        a = new Carneiro(0);
                        break;
                    case "Cavalo":
                        a = new Cavalo(0);
                        break;
                    case "Chita":
                        a = new Chita(0);
                        break;
                    case "Coelho":
                        a = new Coelho(0);
                        break;
                    case "Dragao":
                        a = new Dragao(0);
                        break;
                    case "Galo":
                        a = new Galo(0);
                        break;
                    case "Leao":
                        a = new Leao(0);
                        break;
                    case "LinceIberico":
                        a = new LinceIberico(0);
                        break;
                    case "Lobo":
                        a = new Lobo(0);
                        break;
                    case "Macaco":
                        a = new Macaco(0);
                        break;
                    case "Panda":
                        a = new Panda(0);
                        break;
                    case "Porco":
                        a = new Porco(0);
                        break;
                    case "Raposa":
                        a = new Raposa(0);
                        break;
                    case "Rato":
                        a = new Rato(0);
                        break;
                    case "Serpente":
                        a = new Serpente(0);
                        break;
                    case "Tigre":
                        a = new Tigre(0);
                        break;
                    case "UrsoCastanho":
                        a = new UrsoCastanho(0);
                        break;
                    case "UrsoPolar":
                        a = new UrsoPolar(0);
                        break;
                    case "UrsoPreto":
                        a = new UrsoPreto(0);
                        break;
                    default:
                        System.out.println("Erro especie animal");
                }
                Animal.setIdAnimalAtualizado();
                a.setIdAnimal(Animal.getIdAnimalAtualizado());
                ani.add(a);
                System.out.println(a);
            }
        }

        for (Animal[] animais : zoo.getRecintos().values()) {
            for (Animal animal : animais) {
                int num = rand.nextInt(101);
                Animal a = null;
                if (animal != null && animal.retornaApetiteReprodutivo() >= num
                        && animal.getIdade() >= Math.round((0.25) * animal.retornaEsperancaVida())) {
                    switch (animal.getClass().getSimpleName()) {
                        case "Boi":
                            a = new Boi(0);
                            break;
                        case "Cao":
                            a = new Cao(0);
                            break;
                        case "Carneiro":
                            a = new Carneiro(0);
                            break;
                        case "Cavalo":
                            a = new Cavalo(0);
                            break;
                        case "Chita":
                            a = new Chita(0);
                            break;
                        case "Coelho":
                            a = new Coelho(0);
                            break;
                        case "Dragao":
                            a = new Dragao(0);
                            break;
                        case "Galo":
                            a = new Galo(0);
                            break;
                        case "Leao":
                            a = new Leao(0);
                            break;
                        case "LinceIberico":
                            a = new LinceIberico(0);
                            break;
                        case "Lobo":
                            a = new Lobo(0);
                            break;
                        case "Macaco":
                            a = new Macaco(0);
                            break;
                        case "Panda":
                            a = new Panda(0);
                            break;
                        case "Porco":
                            a = new Porco(0);
                            break;
                        case "Raposa":
                            a = new Raposa(0);
                            break;
                        case "Rato":
                            a = new Rato(0);
                            break;
                        case "Serpente":
                            a = new Serpente(0);
                            break;
                        case "Tigre":
                            a = new Tigre(0);
                            break;
                        case "UrsoCastanho":
                            a = new UrsoCastanho(0);
                            break;
                        case "UrsoPolar":
                            a = new UrsoPolar(0);
                            break;
                        case "UrsoPreto":
                            a = new UrsoPreto(0);
                            break;
                        default:
                            System.out.println("Erro especie animal");
                    }
                    Animal.setIdAnimalAtualizado();
                    a.setIdAnimal(Animal.getIdAnimalAtualizado());
                    ani.add(a);
                    System.out.println(a);
                }
            }
        }

        for (Animal animal : ani) {
            zoo.setAnimaisErrantes(animal);
        }

        // em caso de prejuizo pode-se perder animais
        if (proveitos < zoo.calculaDespesas()) {
            for (Animal[] animais : zoo.getRecintos().values()) {
                for (int i = 0; i < animais.length; i++) {
                    if (animais[i] != null) {
                        int num = rand.nextInt(101);
                        if (num <= 30) {
                            zoo.setAnimaisPerdidos(animais[i]);
                            animais[i] = null;
                        }
                    }
                }
            }
            for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
                if (zoo.getAnimaisErrantes().get(i) != null) {
                    int num = rand.nextInt(101);
                    if (num <= 30) {
                        zoo.setAnimaisPerdidos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(i);
                    }
                }
            }
        }
    }

    //14. Jumanji
    public static void jumanji(Zoo zoo) {
        Random rand = new Random();
        for (Animal[] animais : zoo.getRecintos().values()) {
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {
                    int num = rand.nextInt(101);
                    if (num <= 40) {
                        zoo.setAnimaisPerdidos(animais[i]);
                        animais[i] = null;
                    }
                }
            }
        }
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            if (zoo.getAnimaisErrantes().get(i) != null) {
                int num = rand.nextInt(101);
                if (num <= 30) {
                    zoo.setAnimaisPerdidos(zoo.getAnimaisErrantes().get(i));
                    zoo.getAnimaisErrantes().remove(i);
                }
            }
        }
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            if (zoo.getRecintos().size() > 0) {
                int idDoRecintoAle = rand.nextInt(zoo.getRecintos().size()) + 1;
                for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {
                    Recinto rec = recintos.getKey();
                    Animal[] animais = recintos.getValue();
                    if (rec.getIdRecinto() == idDoRecintoAle) {
                        int num = rand.nextInt(rec.getCapacidade());
                        Animal a = animais[num];
                        animais[num] = zoo.getAnimaisErrantes().get(i);
                        zoo.getAnimaisErrantes().remove(i);
                        if (a != null) {
                            zoo.setAnimaisErrantes(a);
                        }
                    }
                }
            }
        }
    }
}
