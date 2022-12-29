package com.mycompany.jumanji_poo;

import Ocorrencias.Adicionar;
import Ocorrencias.Morte;
import Ocorrencias.OcorrenciaPeriodo;
import Ocorrencias.Nascimento;
import Ocorrencias.InserirAnimalNoRecinto;
import Ocorrencias.InserirRecinto;
import Ocorrencias.Fugir;
import Ocorrencias.Ocorrencia;
import Ocorrencias.ComprarRecinto;
import Animais.Dragao;
import Animais.Carneiro;
import Animais.Macaco;
import Animais.Raposa;
import Animais.Lobo;
import Animais.Cavalo;
import Animais.LinceIberico;
import Animais.Galo;
import Animais.Rato;
import Animais.Tigre;
import Animais.Leao;
import Animais.UrsoCastanho;
import Animais.Serpente;
import Animais.Porco;
import Animais.Coelho;
import Animais.Panda;
import Animais.UrsoPreto;
import Excecoes.ExcecaoCalendarioChines;
import Excecoes.ExcecaoComprarAnimal;
import Excecoes.ExcecaoIdIncorreto;
import Excecoes.ExcecaoNumMenuInvalido;
import Excecoes.ExecaoNumIncorretoRecinto;
import Genoma.Canis;
import Genoma.Equus;
import Genoma.Naja;
import Genoma.Ovis;
import Genoma.Panthera;
import Genoma.Ursus;
import Animais.Cao;
import Animais.UrsoPolar;
import Animais.Chita;
import Animais.Boi;
import Animais.Animal;
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

    public static void main(String[] args)
            throws IOException, ExcecaoIdIncorreto, ExcecaoNumMenuInvalido, ExecaoNumIncorretoRecinto,
            ExcecaoComprarAnimal, ExcecaoCalendarioChines {

        // Variaveis locais
        scan = new Scanner(System.in);
        boolean primeiraVez = true;
        boolean sair = false;
        Zoo zoo = new Zoo(300000);
        Ocorrencia ocorrencias = new Ocorrencia();// historico

        while (primeiraVez) {// Caso o utilizador queira pode no inicio inserir dados do zoo guardados em
                             // ficheiros

            System.out.println("Deseja inserir alguns animais e recintos guardados em ficheiros?(sim/nao)");
            String escolhaPrimeira = scan.next();
            escolhaPrimeira = escolhaPrimeira.trim(); // retira os espaços no final e no começo do input
            escolhaPrimeira = escolhaPrimeira.toLowerCase(); // todos os caracteres passam para minúsculas
            switch (escolhaPrimeira) {
                case "sim":
                    uploadRecintos(zoo, ocorrencias); // le o ficheiro Recintos.txt e insere os dados do mesmo

                    uploadAnimaisEmRecintos(zoo, ocorrencias);// le o ficheiro AnimaisEmRecintos.txt e insere os dados
                                                              // do mesmo

                    uploadAnimaisErrantes(zoo, ocorrencias);// le o ficheiro AnimaisErrantes.txt e insere os dados do
                                                            // mesmo

                    uploadAnimaisMortos(zoo, ocorrencias);// le o ficheiro AnimaisMortos.txt e insere os dados do mesmo

                    uploadAnimaisPerdidos(zoo, ocorrencias);// le o ficheiro AnimaisPerdidos.txt e insere os dados do
                                                            // mesmo

                    primeiraVez = false;// passa para o menu
                    break;
                case "nao":
                    primeiraVez = false;// passa para o menu
                    break;
                default:
                    System.out.println("Escolha sim ou nao!\n");// volta a perguntar ao utilizador pois a resposta não
                                                                // foi adequada
                    break;
            }
        }
        while (!sair) { // enquanto o utilizador não escolher a opção 15(sair) irá funcionar o menu
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
            if (scan.hasNextInt()) {// vericia se o input é o pretendido(int) se não for levanta uma exceção
                int escolha = scan.nextInt();
                switch (escolha) {
                    case 1:
                        adquirirAnimaisAleatorios(zoo, ocorrencias);
                        break;
                    case 2:
                        animalCaracAlea(zoo, ocorrencias);
                        break;
                    case 3:
                        recintosAleatorio(zoo, ocorrencias);
                        break;
                    case 4:
                        adicionarInstalaca(zoo, ocorrencias);
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
                        retratoFamiliar(zoo, ocorrencias);
                        break;
                    case 11:
                        System.out.println("Animais mortos:");
                        zoo.listarAnimaisMortos();
                        break;
                    case 12:
                        System.out.println(ocorrencias);
                        break;
                    case 13:
                        periodoContabilistico(zoo, ocorrencias);
                        System.out.println("Saldo atualmente disponivel: " + zoo.getSaldo());
                        break;
                    case 14:
                        jumanji(zoo, ocorrencias);
                        break;
                    case 15:
                        sair = true;
                        break;
                    default:
                        System.out.println("Número inválido");
                        break;
                }
            } else {
                throw new ExcecaoNumMenuInvalido();
            }
        }
    }

    public static Animal animaisAleatorios() {
        Random rand = new Random();
        int totalAnimais = 21;// total de animais disponíveis
        int numAleatorio = rand.nextInt(totalAnimais);// gera um número aleatório

        Animal a = null;// variável local, inicializa a classe Animal a null

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
        return a; // retorna um animal de uma específica espécie dependendo do número aleatório
    }

    // 1.adquirir um animal aleatório
    public static void adquirirAnimaisAleatorios(Zoo zoo, Ocorrencia ocor) throws ExcecaoComprarAnimal {

        // variáveis locais
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
        if (scan.hasNextInt()) {
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
                if ((zoo.getSaldo() - a.retornaCusto()) >= 0) {// se o zoo não tiver dinheiro este não pode comprar o
                                                               // animal

                    Animal.incrementaIdAnimalAtualizado();// atualiza o id global dos animais
                    a.setIdAnimal(Animal.getIdAnimalAtualizado());// define o id do animal para o id mais atualizado
                    zoo.setAnimaisErrantes(a);// o animal não tem um recinto por isso é um animal errante
                    zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());// atualiza o saldo do zoo ao comprar o animal

                    Adicionar adic = new Adicionar(a);// classe dinamica para o histórico(ocorrencias) do zoo
                    ocor.setHistorico(adic.toString());// faz o toString da classe para guardar a informação(String) no
                                                       // histórico
                } else
                    System.out.println("Não tem dinheiro para comprar o animal");// se o zoo nao tiver o saldo
                                                                                 // necessário aparece esta mensagem
            } else
                throw new ExcecaoComprarAnimal();// exceção se o utilizador não escolher uma das 3 opções
        } else
            throw new ExcecaoComprarAnimal();// exceção se o utilizador não escolher uma das 3 opções
    }

    // 2.Adquirir animal com característica genética
    public static void animalCaracAlea(Zoo zoo, Ocorrencia ocor) throws ExcecaoComprarAnimal {

        System.out.println("""

                Escolha uma das seguintes caracteristicas genéticas
                (Insira o número ou o seu nome):
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
        escolha = escolha.toLowerCase(); // todos os caracteres passam para minúsculas
        escolha = escolha.trim(); // retira os espaços no final e no começo do input

        // isAssignableFrom verifica se a classe implementa a interface
        switch (escolha) {
            case "1":
            case "canis":
                if (Canis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Canis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "2":
            case "equus":
                if (Equus.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Equus.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "3":
            case "naja":
                if (Naja.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Naja.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "4":
            case "ovis":
                if (Ovis.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Ovis.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "5":
            case "panthera":
                if (Panthera.class.isAssignableFrom(a.getClass())) {
                    inserir = true;
                } else {
                    while (!Panthera.class.isAssignableFrom(a.getClass())) {
                        a = animaisAleatorios();
                    }
                    inserir = true;
                }
                break;
            case "6":
            case "ursus":
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
        if (inserir) { // se a escolha for uma das 6 possiveis
            if (zoo.getSaldo() - a.retornaCusto() >= 0) { // verificca se o zoo tem saldo para comprar o animal
                System.out.println(a);// imprime uma mensagem atraves do overide do toString na superclasse Animal
                Animal.incrementaIdAnimalAtualizado();// atualiza o id global dos animais
                a.setIdAnimal(Animal.getIdAnimalAtualizado());// define o id deste animal para o amis atualizado
                zoo.setAnimaisErrantes(a);// como este animal não tem recinto é considerado um animal errante
                zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());// atualiza o saldo do zoo retirando o custo do animal
                                                                // comprado

                Adicionar adic = new Adicionar(a, escolha);// classe dinamica para o histórico(ocorrencias) do zoo
                ocor.setHistorico(adic.toString());// faz o toString da classe para guardar a informação(String) no
                // histórico

            } else {// se o zoo não tiver saldo disponivel para comprar o animal
                System.out.println("Não tem dinheiro para comprar o seguinte animal");
                System.out.println(a);
            }
        } else // se a escolha não seja uma das 6 possiveis lança uma exceção
            throw new ExcecaoComprarAnimal();
    }

    // 3.Recintos Aleatorios
    public static void recintosAleatorio(Zoo zoo, Ocorrencia ocor) throws ExecaoNumIncorretoRecinto {

        // variaveis locais
        boolean verificação = false;
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

        System.out.println("\nQual dos seguintes recintos pretende escolher?\n" +
                "(se não pretender nenhum insira 0, se quiser insira o número do candidato)\n");

        if (scan.hasNextInt()) {// verifica se a esolha é um número inteiro
            int escolhaRecinto = scan.nextInt();
            switch (escolhaRecinto) {
                case 0:// caso o utilizador não queira o zoo
                    verificação = true;
                    System.out.println("Não foi escolhido nenhum recinto\n");
                    break;
                case 1:
                case 2:
                case 3:
                    verificação = true;
                    escolhido = recintosAle[escolhaRecinto - 1];
                    break;
            }
            if (verificação) {
                if (escolhido != null && (zoo.getSaldo() - escolhido.getCusto()) > 0) {// se o recinto escolhido tiver
                                                                                       // saldo sufeciente para comprar
                                                                                       // o recinto
                    Recinto.setIdRecintoAtualizado();// atualiza o id global(atualizado) dos recintos
                    escolhido.setIdRecinto(Recinto.getIdRecintoAtualizado());// define o id deste recinto como o mais
                                                                             // recente
                    zoo.setRecintos(escolhido);// insere o recinto no zoo(hashmap)
                    zoo.setSaldo(zoo.getSaldo() - escolhido.getCusto());// atualiza o saldo do zoo retirando o custo do
                                                                        // recinto

                    ComprarRecinto comRec = new ComprarRecinto(escolhido, escolhaRecinto);// classe dinamica para o
                                                                                          // histórico(ocorrencias) do
                                                                                          // zoo ao comprar o recinto
                    ocor.setHistorico(comRec.toString());// adiciona a ocorrencia oa histórico
                } else {
                    System.out.println("Não tem dinheiro para comprar o recinto");
                }
            } else // se não inserir um valor correto para escolher o recinto
                throw new ExecaoNumIncorretoRecinto();
        } else // se não inserir um valor correto para escolher o recinto
            throw new ExecaoNumIncorretoRecinto();
    }

    // 4.Adicionar animal nas instalações
    public static void adicionarInstalaca(Zoo zoo, Ocorrencia ocor) throws ExcecaoIdIncorreto {
        System.out.println("\nQual animal deseja adicionar? (ID)");
        zoo.listarAnimaisErrantes();
        int idAnimal = scan.nextInt();
        if (zoo.verificaIdAnimal(idAnimal)) {// verifica se existe algum animal na lista de animais errantes com o id
                                             // inserido
            for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {// percorre lista de animais errantes
                if (idAnimal == zoo.getAnimaisErrantes().get(i).getIdAnimal()) {// encontra o animal com o id inserido
                    System.out.println("\nQual o recinto que pretende inserir o Animal? (ID)");
                    zoo.listarRecintos();
                    int idRecinto = scan.nextInt();
                    if (zoo.verificaIdRecinto(idRecinto)) {// verifica se o id inserido corresponde com algum existente
                                                           // no zoo
                        for (Recinto rec : zoo.getRecintos().keySet()) {// percorre os recintos
                            if (idRecinto == rec.getIdRecinto()) {// encontra o recinto com o id pedido
                                Animal[] animais = zoo.getRecintos().get(rec);// chama o array de animais do respetivo
                                                                              // recinto
                                zoo.verificaOcupacaoRec();
                                if (rec.getCapacidade() != rec.getOcupacao()) {// verifica se tem lugares vagos no
                                                                               // recinto
                                    for (int j = 0; j < animais.length; j++) {
                                        if (animais[j] == null) {
                                            animais[j] = zoo.getAnimaisErrantes().get(i);// insere o animal no recinto
                                            zoo.getAnimaisErrantes().remove(i);// retira-o dos animais errantes
                                            InserirAnimalNoRecinto insRec = new InserirAnimalNoRecinto(animais[j],
                                                    idRecinto);
                                            ocor.setHistorico(insRec.toString());// insere dados no histórico
                                            break;
                                        }
                                    }
                                } else {// se o recinto que pretende estiver lotado
                                    Random rand = new Random();
                                    int num = rand.nextInt(rec.getCapacidade());// é gerado um número aleatorio
                                    Animal a = animais[num];// variavel para guardar animal do recinto
                                    animais[num] = zoo.getAnimaisErrantes().get(i);// adiciona hashmap o animal errante
                                    zoo.getAnimaisErrantes().remove(i);// retira porque agora está num recinto
                                    zoo.setAnimaisErrantes(a);// animal que estava no recinto torna-se errante

                                    InserirAnimalNoRecinto insRec = new InserirAnimalNoRecinto(animais[num], idRecinto,
                                            a);
                                    ocor.setHistorico(insRec.toString());// insere dado no histórico
                                }
                                System.out.println("\nAnimal inserido com sucesso");
                            }
                        }
                    } else // levante exceção caso não haja o id do recinto na hashmap do zoo
                        throw new ExcecaoIdIncorreto(idRecinto, "recinto");
                }
            }
        } else// levante exceção caso não haja o id do animal na lista de animais errantes
            throw new ExcecaoIdIncorreto(idAnimal, "animal");
    }

    // 5.Calendario Chines
    public static void calendarioChines() throws ExcecaoCalendarioChines {

        System.out.println("\nEscolha um ano: ");
        if (scan.hasNextInt()) {// verifica se o ano é do tipo inteiro
            int ano = scan.nextInt();
            System.out.println("\n");
            if (ano % 12 == 8) {
                Dragao.setAtratividadeBase(Dragao.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Dragão, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
            } else if (ano % 12 == 9) {
                Serpente.setAtratividadeBase(Serpente.getAtratividadeBase() * 1.50);
                System.out.println("Ano da Serpente, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
            } else if (ano % 12 == 10) {
                Cavalo.setAtratividadeBase(Cavalo.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Cavalo, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
            } else if (ano % 12 == 11) {
                Carneiro.setAtratividadeBase(Carneiro.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Carneiro, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
            } else if (ano % 12 == 0) {
                Macaco.setAtratividadeBase(Macaco.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Macaco, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n");
            } else if (ano % 12 == 1) {
                Galo.setAtratividadeBase(Galo.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Galo, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 2) {
                Cao.setAtratividadeBase(Cao.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Cão, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 3) {
                Porco.setAtratividadeBase(Porco.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Porco, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 4) {
                Rato.setAtratividadeBase(Rato.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Rato, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 5) {
                Boi.setAtratividadeBase(Boi.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Boi, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 6) {
                Tigre.setAtratividadeBase(Tigre.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Tigre, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else if (ano % 12 == 7) {
                Coelho.setAtratividadeBase(Coelho.getAtratividadeBase() * 1.50);
                System.out.println("Ano do Coelho, o animal tem a sua atratividade base multiplicada em 1,5 vezes\n ");
            } else
                throw new ExcecaoCalendarioChines();
        } else
            throw new ExcecaoCalendarioChines();
    }

    // 7.Listar Animais com caracteristica Generica especificada
    public static void listarAnimaisCarGenetica(Zoo zoo) {
        System.out.println("""

                Qual a característica genetica que pretende?(Insira o número ou o seu nome)
                1.Canis
                2.Equus
                3.Naja
                4.Ovis
                5.Panthera
                6.Ursus

                """);
        String escolha = scan.next();
        escolha = escolha.trim(); // retira os espaços no final e no começo do input
        escolha = escolha.toLowerCase(); // todos os caracteres passam para minúsculas
        switch (escolha) {
            case "1":
            case "canis":
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
            case "2":
            case "equus":
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
            case "3":
            case "naja":
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
            case "4":
            case "ovis":
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
            case "5":
            case "panthera":
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
            case "6":
            case "ursus":
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
            default:
                System.out.println("Insira um número do respetivo genoma ou o seu nome!");
                break;
        }
    }

    // 7.Overload
    public static void listarAnimaisCarGenetica(Zoo zoo, String escolha) {
        escolha = escolha.trim(); // retira os espaços no final e no começo do input
        escolha = escolha.toLowerCase(); // todos os caracteres passam para minúsculas
        switch (escolha) {
            case "canis":
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
            case "equus":
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
            case "naja":
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
            case "ovis":
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
            case "panthera":
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
            case "ursus":
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

                Qual a mutação pretende?(Insira o número ou o seu nome)
                1.Albino
                2.Heterocromia
                3.Melanismo
                4.Siames
                5.Vitiligo

                """);
        String escolha = scan.next();
        escolha = escolha.toLowerCase(); // todos os caracteres passam para minúsculas
        escolha = escolha.trim(); // retira os espaços no final e no começo do input
        switch (escolha) {
            case "1":
            case "albino":
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
            case "2":
            case "heterocromia":
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
            case "3":
            case "melanismo":
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
            case "4":
            case "siames":
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
            case "5":
            case "vitiligo":
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
                System.out.println("Insera o respetivo número da característica genética ou o seu nome!");
                break;
        }
    }

    // 8.Overload
    public static void listarDadaMutacao(Zoo zoo, String escolha) {
        escolha = escolha.toLowerCase(); // todos os caracteres passam para minúsculas
        escolha = escolha.trim(); // retira os espaços no final e no começo do input
        switch (escolha) {
            case "albino":
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
            case "heterocromia":
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
            case "melanismo":
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
            case "siames":
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
            case "vitiligo":
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

    // 10. Retrato Familiar
    public static void retratoFamiliar(Zoo zoo, Ocorrencia ocor) {

        System.out.println("\n-------Histórico-------\n");
        System.out.println(ocor);

        System.out.println("\n-------Caracteristicas Geneticas-------");

        String[] caractGen = { "Canis", "Equus", "Naja", "Ovis", "Panthera", "Ursus" };
        for (int index = 0; index < caractGen.length; index++) {
            System.out.println("\n------" + caractGen[index] + "------");
            listarAnimaisCarGenetica(zoo, caractGen[index]);
        }

        System.out.println("\n-------Mutações-------");
        String[] mutacoes = { "Albino", "Heterocromia", "Melanismo", "Siames", "Vitiligo" };
        for (int i = 0; i < mutacoes.length; i++) {
            System.out.println("\n------" + mutacoes[i] + "------");
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

    // 13.Periodo contabilistico
    public static void periodoContabilistico(Zoo zoo, Ocorrencia ocor) {
        // calcular primeiro os custos totais do zoo
        // zoo.calculaDespesas();
        Random rand = new Random();
        // String texto = new String();

        // texto += "\n------Período Contabilistico------\n";

        System.out.println("Despesas: " + zoo.calculaDespesas());
        // texto += "\n->As suas despesas foram as seguintes: " + zoo.calculaDespesas()
        // + "€\n";

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
        // texto += "\n->Os seus proveitos foram os seguintes: " + proveitos + "€\n";

        OcorrenciaPeriodo ocoPer = new OcorrenciaPeriodo(zoo.calculaDespesas(), proveitos);
        ocor.setHistorico(ocoPer.toString());

        if (proveitos < zoo.calculaDespesas()) {
            List<Animal> animaisPerdidosAgora = new ArrayList<Animal>();
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
            Fugir aniFug = new Fugir(animaisPerdidosAgora);
            ocor.setHistorico(aniFug.toString());
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
        } else {
            System.out.println("Os seguintes animais morreram neste período contabilístico:");
        }
        Morte morteAni = new Morte(animaisMortosNumPeriodo);
        ocor.setHistorico(morteAni.toString());

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
                Animal.incrementaIdAnimalAtualizado();
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
                    Animal.incrementaIdAnimalAtualizado();
                    a.setIdAnimal(Animal.getIdAnimalAtualizado());
                    nascimentosNestePeriodo.add(a);
                }
            }
        }

        if (nascimentosNestePeriodo.isEmpty()) {
            System.out.println("Nenhum animal nasceu neste período contabilístico");
            // texto += "\n\nNenhum animal nasceu neste período contabilístico";
        } else {
            System.out.println("Os seguintes animais nasceram");
            // texto += "\n\n0s seguintes animais nasceram neste período contabilístico: ";
            // for (Animal animal : nascimentosNestePeriodo) {
            // System.out.println(animal);
            // texto += "\n" + animal;
            // }
        }

        Nascimento aniNasc = new Nascimento(nascimentosNestePeriodo);
        ocor.setHistorico(aniNasc.toString());

        // hist.add(texto);
    }

    // 14. Jumanji
    public static void jumanji(Zoo zoo, Ocorrencia ocor) {
        Random rand = new Random();
        // String texto = new String();

        ocor.setHistorico("\n------Jumanji------\n");
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

        Fugir aniFug = new Fugir(animaisPerdidos);
        ocor.setHistorico(aniFug.toString());

        if (zoo.getRecintos().size() > 0) {
            for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
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
                            InserirAnimalNoRecinto insRec = new InserirAnimalNoRecinto(animais[num], idDoRecintoAle, a);
                            ocor.setHistorico(insRec.toString());
                        } else {
                            InserirAnimalNoRecinto insRec = new InserirAnimalNoRecinto(animais[num], idDoRecintoAle);
                            ocor.setHistorico(insRec.toString());
                        }
                    }
                }
            }
        }
    }

    // -------leitura de ficheiros---------//

    public static void uploadRecintos(Zoo zoo, Ocorrencia ocor) throws IOException {
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

                        InserirRecinto insRec = new InserirRecinto(rec);
                        ocor.setHistorico(insRec.toString());

                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisEmRecintos(Zoo zoo, Ocorrencia ocor) throws IOException {
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
                                        Animal.setIdAnimalAtualizado(idAnimal);
                                        ;
                                        animais[i] = a;

                                        InserirAnimalNoRecinto insRec = new InserirAnimalNoRecinto(a, recintoId);
                                        ocor.setHistorico(insRec.toString());

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

    public static void uploadAnimaisErrantes(Zoo zoo, Ocorrencia ocor) throws IOException {
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
                        Animal.setIdAnimalAtualizado(idAnimal);
                        ;
                        linha = lerDados.readLine();
                        numDaLinha = 1;

                        Adicionar adAni = new Adicionar(a);
                        ocor.setHistorico(adAni.toString());

                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisMortos(Zoo zoo, Ocorrencia ocor) throws IOException {
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
                        Animal.setIdAnimalAtualizado(idAnimal);
                        linha = lerDados.readLine();
                        numDaLinha = 1;

                        Morte aniMorto = new Morte(a);
                        ocor.setHistorico(aniMorto.toString());
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado o ficheiro");
        } finally {
            lerDados.close();
        }
    }

    public static void uploadAnimaisPerdidos(Zoo zoo, Ocorrencia ocor) throws IOException {
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
                        Animal.setIdAnimalAtualizado(idAnimal);
                        linha = lerDados.readLine();
                        numDaLinha = 1;
                        Fugir aniFugiu = new Fugir(a);
                        ocor.setHistorico(aniFugiu.toString());
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
