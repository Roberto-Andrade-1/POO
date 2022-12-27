package com.mycompany.jumanji_poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    private static Scanner scan;

    public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        boolean primeiraVez = true;
        boolean sair = false;
        Zoo zoo = new Zoo(300000);
        List<String> historico = new ArrayList<String>();

        historico.add("------INÍCIO------");

        while (primeiraVez) {
            System.out.println("Deseja inserir alguns animais e recintos guardados em ficheiros?(sim/não)");
            String escolhaPrimeira = scan.next();
            escolhaPrimeira = escolhaPrimeira.toLowerCase();
            switch (escolhaPrimeira) {
                case "sim":
                    historico.add("\nFoi adicionado dados a partir de ficheiros por escolha do utilizador");
                    uploadRecintos(zoo);
                    uploadAnimaisEmRecintos(zoo);
                    uploadAnimaisErrantes(zoo);
                    uploadAnimaisMortos(zoo);
                    uploadAnimaisPerdidos(zoo);
                    primeiraVez = false;
                    break;
                case "não":
                case "nao":
                    primeiraVez = false;
                    break;
                default:
                    System.out.println("escolha sim ou não!\n");
                    break;

            }
        }
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
                    adquirirAnimaisAleatorios(zoo, historico);
                    break;
                case 2:
                    animalCaracAlea(zoo, historico);
                    break;
                case 3:
                    recintosAleatorio(zoo, historico);
                    break;
                case 4:
                    adicionarInstalacao(zoo, historico);
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
                    System.out.println("\nRECINTOS");
                    zoo.listarRecintos();
                    break;
                case 10:
                    retratoFamiliar(zoo, historico);
                    break;
                case 11:
                    System.out.println("Animais mortos:");
                    zoo.listarAnimaisMortos();
                    break;
                case 12:
                    for (int i = 0; i < historico.size(); i++) {
                        System.out.println(historico.get(i));
                    }
                    break;
                case 13:
                    periodoContabilistico(zoo, historico);
                    System.out.println("Saldo atualmente disponivel: " + zoo.getSaldo());
                    break;
                case 14:
                    jumanji(zoo, historico);
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
    public static void adquirirAnimaisAleatorios(Zoo zoo, List<String> hist) {
        // scan = new Scanner(System.in);
        Animal a = null;

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
                a = treAnimaisAleat[0];
                break;
            case 2:
                a = treAnimaisAleat[1];
                break;
            case 3:
                a = treAnimaisAleat[2];
                break;
            default:
                System.out.println("Valor inválido");
        }
        if (a != null) {
            Animal.setIdAnimalAtualizado();
            a.setIdAnimal(Animal.getIdAnimalAtualizado());
            zoo.setAnimaisErrantes(a);
            zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());

            String texto = new String();
            texto = "\nO seguinte animal gerado aleatoriamente foi adicioando ao zoo como animal errante:\n     " + a;
            hist.add(texto);
        }
    }

    // 2.Adquirir animal com característica genética
    public static void animalCaracAlea(Zoo zoo, List<String> hist) {
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

        String escolha = scan.next();
        Animal a = animaisAleatorios();
        boolean inserir = false;
        // isAssignableFrom verifica se a classe implementa a interface
        switch (escolha) {
            case "Canis":
                if (Canis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Canis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "Equus":
                if (Equus.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Equus.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "Naja":
                if (Naja.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Naja.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "Ovis":
                if (Ovis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Ovis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "Panthera":
                if (Panthera.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Panthera.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "Ursus":
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
                System.out.println("Opção inválida");
                break;
        }
        if (inserir) {
            System.out.println(a);
            Animal.setIdAnimalAtualizado();
            a.setIdAnimal(Animal.getIdAnimalAtualizado());
            zoo.setAnimaisErrantes(a);
            String texto = new String();
            texto = "\nO seguinte animal foi comprado através de uma pesquisa pela caracteristica genética " + escolha
                    + " e inserido no zoo como animal errante "
                    + ":\n      " + a;
            hist.add(texto);
            zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());
        }
    }

    // 3.Recintos Aleatorios
    public static void recintosAleatorio(Zoo zoo, List<String> hist) {
        // Scanner scan = new Scanner(System.in);

        Recinto escolhido = null;

        // cria 3 recintos
        Recinto[] recintosAle = new Recinto[3];
        for (int i = 0; i < recintosAle.length; i++) {
            recintosAle[i] = new Recinto();
        }

        System.out.println("\nRECINTOS DISPONÍVEIS:");
        for (int i = 0; i < recintosAle.length; i++) {
            System.out.println("Candidato " + (i + 1) + ": " + recintosAle[i]);
        }

        System.out.println("Qual dos seguintes recintos pretende escolher?(se não pretender nenhum insira 0)");
        int escolhaRecinto = scan.nextInt();
        if (escolhaRecinto > 0 && escolhaRecinto <= 3)
            Recinto.setIdRecintoAtualizado();
        switch (escolhaRecinto) {
            case 0:
                System.out.println("Não foi escolhido nenhum recinto");
                break;
            case 1:
            case 2:
            case 3:
                escolhido = recintosAle[escolhaRecinto - 1];
                String texto = new String();
                texto = "O utilizador escolheu o seguinte recinto do candidato " + escolhaRecinto + ":\n      "
                        + escolhido;
                hist.add(texto);

                escolhido.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.setRecintos(escolhido);
                zoo.setSaldo(zoo.getSaldo() - escolhido.getCusto());
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }

    // 4.Adicionar animal nas instalações
    public static void adicionarInstalacao(Zoo zoo, List<String> hist) {
        // Scanner scan = new Scanner(System.in);

        String texto = new String();

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

                        texto = "\nInseriu o seguinte animal no recinto com id " + idRecinto;

                        if (rec.getCapacidade() != rec.getOcupacao()) {// se ainda houver lugares disponiveis no recinto
                            for (int i = 0; i < animais.length; i++) {// adiciona na Hashmap numa posição nula
                                if (animais[i] == null) {
                                    animais[i] = ani;
                                    texto += "\n    " + ani;
                                    break; // nao repetir o animal até ocupar a capacidade do recinto
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

                            texto += "\n    " + ani;
                            texto += "\n    ->Como o recinto estava cheio o seguinte animal tornou-se errante\n    "
                                    + a;

                        }
                        System.out.println("\nAnimal inserido com sucesso");
                        hist.add(texto);
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
        String escolha = scan.next();
        switch (escolha) {
            case "Canis":
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
            case "Equus":
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
            case "Naja":
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
            case "Ovis":
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
            case "Panthera":
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
            case "Ursus":
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

    // Overload
    public static void listarAnimaisCarGenetica(Zoo zoo, String escolha) {
        switch (escolha) {
            case "Canis":
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
            case "Equus":
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
            case "Naja":
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
            case "Ovis":
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
            case "Panthera":
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
            case "Ursus":
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
        String escolha = scan.next();
        switch (escolha) {
            case "Albino":
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
            case "Heterocromia":
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
            case "Melanismo":
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
            case "Siames":
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
            case "Vitiligo":
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

    // Overload
    public static void listarDadaMutacao(Zoo zoo, String escolha) {
        switch (escolha) {
            case "Albino":
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
            case "Heterocromia":
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
            case "Melanismo":
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
            case "Siames":
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
            case "Vitiligo":
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
    public static void periodoContabilistico(Zoo zoo, List<String> hist) {
        // calcular primeiro os custos totais do zoo
        // zoo.calculaDespesas();
        Random rand = new Random();
        String texto = new String();

        texto += "\n------Período Contabilistico------\n";

        System.out.println("Despesas: " + zoo.calculaDespesas());
        texto += "\n->As suas despesas foram as seguintes: " + zoo.calculaDespesas() + "€\n";

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
        texto += "\n->Os seus proveitos foram os seguintes: " + proveitos + "€\n";

        if (proveitos < zoo.calculaDespesas()) {
            List<Animal> animaisPerdidosAgora = new ArrayList<Animal>();
            texto += "\nHouve prejuizo no seu zoo neste periodo contabilistico:";

            for (Animal[] animais : zoo.getRecintos().values()) {
                for (int i = 0; i < animais.length; i++) {
                    if (animais[i] != null) {
                        int num = rand.nextInt(101);
                        if (num <= 30) {
                            animaisPerdidosAgora.add(animais[i]);
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
                        animaisPerdidosAgora.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisPerdidos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(i);
                    }
                }
            }
            if (animaisPerdidosAgora.isEmpty()) {
                texto += "\n->Não foram perdidos animais por prejuízo\n";
            } else {
                texto += "\n->Os seguintes animais foram perdidos neste período contabilístico";
                for (Animal animal : animaisPerdidosAgora) {
                    texto += "\n " + animal;
                }
            }
        }

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
        System.out.println("\nMortes:");
        List<Animal> animaisMortosNumPeriodo = new ArrayList<Animal>();
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
            System.out.println("Nenhum animal morreu neste período contabilístico");
            texto += "\n\nNão morreram animais neste período contabilístico";
        } else {
            System.out.println("Os seguintes animais morreram neste período contabilístico:");
            texto += "\n\nOs seguintes animais morreram neste período contabilístico";
            for (Animal animal : animaisMortosNumPeriodo) {
                System.out.println(animal);
                texto += "\n" + animal;
            }
        }

        // retira do saldo do zoo os custos (ja ta feito no metodo calculaDespesas no
        // zoo)

        // Nascimentos
        System.out.println("\nNasimentos: ");
        List<Animal> nascimentosNestePeriodo = new ArrayList<Animal>();
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            int num = rand.nextInt(101);
            Animal a = null;
            if (zoo.getAnimaisErrantes().get(i).retornaApetiteReprodutivo() >= num
                    && zoo.getAnimaisErrantes().get(i).getIdade() >= Math
                            .round((0.25) * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida())) {
                switch (zoo.getAnimaisErrantes().get(i).getClass().getSimpleName()) {
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
                nascimentosNestePeriodo.add(a);
                zoo.setAnimaisErrantes(a);
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
                    nascimentosNestePeriodo.add(a);
                }
            }
        }

        if (nascimentosNestePeriodo.isEmpty()) {
            System.out.println("Nenhum animal nasceu neste período contabilístico");
            texto += "\n\nNenhum animal nasceu neste período contabilístico";
        } else {
            System.out.println("Os seguintes animais nasceram");
            texto += "\n\n0s seguintes animais nasceram neste período contabilístico: ";
            for (Animal animal : nascimentosNestePeriodo) {
                System.out.println(animal);
                texto += "\n" + animal;
            }
        }

        hist.add(texto);
    }

    // 14. Jumanji
    public static void jumanji(Zoo zoo, List<String> hist) {
        Random rand = new Random();
        String texto = new String();

        texto += "\n------Jumanji------\n";
        List<Animal> animaisPerdidos = new ArrayList<Animal>();

        for (Animal[] animais : zoo.getRecintos().values()) {
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {
                    int num = rand.nextInt(101);
                    if (num <= 30) {
                        animaisPerdidos.add(animais[i]);
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
                    animaisPerdidos.add(zoo.getAnimaisErrantes().get(i));
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
                        texto += "\nO seguinte animal errante foi para o recinto com o id " + idDoRecintoAle;
                        texto += "\n    " + animais[num];
                        if (a != null) {
                            zoo.setAnimaisErrantes(a);
                            texto += "\nO seguinte animal tornou-se errante:\n  " + a;
                        }
                    }
                }
            }
        }

        if (animaisPerdidos.isEmpty()) {
            texto += "\nNão foram perdidos animais pelo jumanji";
        } else {
            texto += "\nOs seguintes animais foram perdidos pela função jumanji:";
            for (Animal animal : animaisPerdidos) {
                texto += "\n" + animal;
            }
        }

        hist.add(texto);
    }

    public static void retratoFamiliar(Zoo zoo, List<String> his) {

        System.out.println("\n-------Histórico-------\n");
        for (int i = 0; i < his.size(); i++) {
            System.out.println(his.get(i));
        }

        System.out.println("\n-------Caracteristicas Geneticas-------");

        String[] caractGen = { "Canis", "Equus", "Naja", "Ovis", "Panthera", "Ursus" };
        for (int index = 0; index < caractGen.length; index++) {
            System.out.println("------" + caractGen[index] + "------");
            listarAnimaisCarGenetica(zoo, caractGen[index]);
        }

        System.out.println("\n-------Mutações-------");
        String[] mutacoes = { "Albino", "Heterocromia", "Melanismo", "Siames", "Vitiligo" };
        for (int i = 0; i < mutacoes.length; i++) {
            System.out.println("------" + mutacoes[i] + "------");
            listarDadaMutacao(zoo, mutacoes[i]);
        }

        System.out.println("\n-------Animais Perdidos-------");
        for (Animal animal : zoo.getAnimaisPerdidos()) {
            System.out.println(animal);
        }

        System.out.println("\n-------Animais Mortos-------");
        zoo.listarAnimaisMortos();

        System.out.println("\n-------Animais Errantes-------");
        zoo.listarAnimaisErrantes();

        System.out.println("\n-------Recintos-------");
        zoo.listarRecintos();

        System.out.println("\n-------Animais em Recintos-------");
        for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {
            Recinto rec = recintos.getKey();
            Animal[] animais = recintos.getValue();
            System.out.println(rec);
            for (Animal animal : animais) {
                if (animal != null) {
                    System.out.println("    " + animal);
                }
            }
        }
    }

    // -------leitura de ficheiros---------//

    public static void uploadRecintos(Zoo zoo) throws IOException {
        String linha;
        int idRecinto = 0, capacidade = 0;
        Recinto rec = null;
        FileReader inStrem = new FileReader("Recintos.txt");
        BufferedReader lerDados = new BufferedReader(inStrem);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {
                switch (numDaLinha) {
                    case 1:
                        idRecinto = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:
                        capacidade = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:
                        rec = new Recinto(idRecinto, capacidade);
                        Recinto.setIdRecintoAtualizado();
                        zoo.setRecintos(rec);
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisEmRecintos(Zoo zoo) throws IOException {
        String linha;
        String nomeAnimal = new String(), sexoAnimal = new String();
        boolean vitiligoAnimal = false, heterocromiaAnimal = false, albinismoAnimal = false, melanismoAnimal = false,
                siamesAnimal = false;
        Animal a = null;
        int recintoId = 0, idAnimal = 0, idadeAnimal = 0;
        FileReader inStream = new FileReader("AnimaisEmRecintos.txt");
        BufferedReader lerDados = new BufferedReader(inStream);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {
                switch (numDaLinha) {
                    case 1:
                        recintoId = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:
                        idAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:
                        idadeAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 4:
                        nomeAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 5:
                        sexoAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 6:
                        albinismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 7:
                        heterocromiaAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 8:
                        melanismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 9:
                        vitiligoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 10:
                        siamesAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 11:
                        switch (linha) {
                            case "Boi":
                                a = new Boi(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cao":
                                a = new Cao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Carneiro":
                                a = new Carneiro(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cavalo":
                                a = new Cavalo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Chita":
                                a = new Chita(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Coelho":
                                a = new Coelho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Dragao":
                                a = new Dragao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Galo":
                                a = new Galo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Leao":
                                a = new Leao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "LinceIberico":
                                a = new LinceIberico(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Lobo":
                                a = new Lobo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Macaco":
                                a = new Macaco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Panda":
                                a = new Panda(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Porco":
                                a = new Porco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Raposa":
                                a = new Raposa(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Rato":
                                a = new Rato(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Serpente":
                                a = new Serpente(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Tigre":
                                a = new Tigre(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoCastanho":
                                a = new UrsoCastanho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPolar":
                                a = new UrsoPolar(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPreto":
                                a = new UrsoPreto(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                        }
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 12:
                        for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {
                            Recinto rec = recintos.getKey();
                            Animal[] animais = recintos.getValue();
                            if (rec.getIdRecinto() == recintoId) {
                                for (int i = 0; i < animais.length; i++) {
                                    if (animais[i] == null) {
                                        Animal.setIdAnimalAtualizado();
                                        animais[i] = a;
                                        break;
                                    }
                                }
                            }
                        }
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisErrantes(Zoo zoo) throws IOException {
        String linha;
        String nomeAnimal = new String(), sexoAnimal = new String();
        boolean vitiligoAnimal = false, heterocromiaAnimal = false, albinismoAnimal = false, melanismoAnimal = false,
                siamesAnimal = false;
        Animal a = null;
        int idAnimal = 0, idadeAnimal = 0;
        FileReader inStream = new FileReader("AnimaisErrantes.txt");
        BufferedReader lerDados = new BufferedReader(inStream);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {
                switch (numDaLinha) {
                    case 1:
                        idAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:
                        idadeAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:
                        nomeAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 4:
                        sexoAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 5:
                        albinismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 6:
                        heterocromiaAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 7:
                        melanismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 8:
                        vitiligoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 9:
                        siamesAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 10:
                        switch (linha) {
                            case "Boi":
                                a = new Boi(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cao":
                                a = new Cao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Carneiro":
                                a = new Carneiro(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cavalo":
                                a = new Cavalo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Chita":
                                a = new Chita(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Coelho":
                                a = new Coelho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Dragao":
                                a = new Dragao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Galo":
                                a = new Galo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Leao":
                                a = new Leao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "LinceIberico":
                                a = new LinceIberico(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Lobo":
                                a = new Lobo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Macaco":
                                a = new Macaco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Panda":
                                a = new Panda(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Porco":
                                a = new Porco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Raposa":
                                a = new Raposa(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Rato":
                                a = new Rato(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Serpente":
                                a = new Serpente(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Tigre":
                                a = new Tigre(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoCastanho":
                                a = new UrsoCastanho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPolar":
                                a = new UrsoPolar(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPreto":
                                a = new UrsoPreto(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                        }
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 11:
                        zoo.setAnimaisErrantes(a);
                        Animal.setIdAnimalAtualizado();
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisMortos(Zoo zoo) throws IOException {
        String linha;
        String nomeAnimal = new String(), sexoAnimal = new String();
        boolean vitiligoAnimal = false, heterocromiaAnimal = false, albinismoAnimal = false, melanismoAnimal = false,
                siamesAnimal = false;
        Animal a = null;
        int idAnimal = 0, idadeAnimal = 0;
        FileReader inStream = new FileReader("AnimaisMortos.txt");
        BufferedReader lerDados = new BufferedReader(inStream);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {
                switch (numDaLinha) {
                    case 1:
                        idAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:
                        idadeAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:
                        nomeAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 4:
                        sexoAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 5:
                        albinismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 6:
                        heterocromiaAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 7:
                        melanismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 8:
                        vitiligoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 9:
                        siamesAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 10:
                        switch (linha) {
                            case "Boi":
                                a = new Boi(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cao":
                                a = new Cao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Carneiro":
                                a = new Carneiro(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cavalo":
                                a = new Cavalo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Chita":
                                a = new Chita(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Coelho":
                                a = new Coelho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Dragao":
                                a = new Dragao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Galo":
                                a = new Galo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Leao":
                                a = new Leao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "LinceIberico":
                                a = new LinceIberico(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Lobo":
                                a = new Lobo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Macaco":
                                a = new Macaco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Panda":
                                a = new Panda(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Porco":
                                a = new Porco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Raposa":
                                a = new Raposa(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Rato":
                                a = new Rato(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Serpente":
                                a = new Serpente(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Tigre":
                                a = new Tigre(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoCastanho":
                                a = new UrsoCastanho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPolar":
                                a = new UrsoPolar(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPreto":
                                a = new UrsoPreto(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                        }
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 11:
                        zoo.setAnimaisMortos(a);
                        Animal.setIdAnimalAtualizado();
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisPerdidos(Zoo zoo) throws IOException {
        String linha;
        String nomeAnimal = new String(), sexoAnimal = new String();
        boolean vitiligoAnimal = false, heterocromiaAnimal = false, albinismoAnimal = false, melanismoAnimal = false,
                siamesAnimal = false;
        Animal a = null;
        int idAnimal = 0, idadeAnimal = 0;
        FileReader inStream = new FileReader("AnimaisPerdidos.txt");
        BufferedReader lerDados = new BufferedReader(inStream);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {
                switch (numDaLinha) {
                    case 1:
                        idAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:
                        idadeAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:
                        nomeAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 4:
                        sexoAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 5:
                        albinismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 6:
                        heterocromiaAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 7:
                        melanismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 8:
                        vitiligoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 9:
                        siamesAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 10:
                        switch (linha) {
                            case "Boi":
                                a = new Boi(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cao":
                                a = new Cao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Carneiro":
                                a = new Carneiro(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Cavalo":
                                a = new Cavalo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Chita":
                                a = new Chita(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Coelho":
                                a = new Coelho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Dragao":
                                a = new Dragao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Galo":
                                a = new Galo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Leao":
                                a = new Leao(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "LinceIberico":
                                a = new LinceIberico(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Lobo":
                                a = new Lobo(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Macaco":
                                a = new Macaco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Panda":
                                a = new Panda(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Porco":
                                a = new Porco(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Raposa":
                                a = new Raposa(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Rato":
                                a = new Rato(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Serpente":
                                a = new Serpente(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "Tigre":
                                a = new Tigre(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoCastanho":
                                a = new UrsoCastanho(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPolar":
                                a = new UrsoPolar(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                            case "UrsoPreto":
                                a = new UrsoPreto(idAnimal, idadeAnimal, nomeAnimal, sexoAnimal, albinismoAnimal,
                                        vitiligoAnimal, melanismoAnimal, heterocromiaAnimal, siamesAnimal);
                                break;
                        }
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 11:
                        zoo.setAnimaisPerdidos(a);
                        Animal.setIdAnimalAtualizado();
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }
}
