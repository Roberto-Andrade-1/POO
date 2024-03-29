package com.mycompany.jumanji_poo;

import Ocorrencias.Adiciona;
import Ocorrencias.Morte;
import Ocorrencias.OcorrenciaPeriodo;
import Ocorrencias.Nascimento;
import Ocorrencias.InseriuAnimalNoRecinto;
import Ocorrencias.InseriuRecinto;
import Ocorrencias.Fugiu;
import Ocorrencias.Ocorrencia;
import Ocorrencias.CompraRecinto;
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
import Excecoes.ExcecaoGenoma;
import Excecoes.ExcecaoIdIncorreto;
import Excecoes.ExcecaoMutacao;
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
            ExcecaoComprarAnimal, ExcecaoCalendarioChines, ExcecaoGenoma, ExcecaoMutacao {

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

                    Adiciona adic = new Adiciona(a);// classe dinamica para o histórico(ocorrencias) do zoo
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
                throw new ExcecaoComprarAnimal();
        }
        if (inserir) { // se a escolha for uma das 6 possiveis
            if (zoo.getSaldo() - a.retornaCusto() >= 0) { // verificca se o zoo tem saldo para comprar o animal
                System.out.println(a);// imprime uma mensagem atraves do overide do toString na superclasse Animal
                Animal.incrementaIdAnimalAtualizado();// atualiza o id global dos animais
                a.setIdAnimal(Animal.getIdAnimalAtualizado());// define o id deste animal para o amis atualizado
                zoo.setAnimaisErrantes(a);// como este animal não tem recinto é considerado um animal errante
                zoo.setSaldo(zoo.getSaldo() - a.retornaCusto());// atualiza o saldo do zoo retirando o custo do animal
                                                                // comprado

                Adiciona adic = new Adiciona(a, escolha);// classe dinamica para o histórico(ocorrencias) do zoo
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

                    CompraRecinto comRec = new CompraRecinto(escolhido, escolhaRecinto);// classe dinamica para o
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
                                            InseriuAnimalNoRecinto insRec = new InseriuAnimalNoRecinto(animais[j],
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

                                    InseriuAnimalNoRecinto insRec = new InseriuAnimalNoRecinto(animais[num], idRecinto,
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
    public static void listarAnimaisCarGenetica(Zoo zoo) throws ExcecaoGenoma {
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

        // isAssignableFrom verifica se a classe implementa a interface
        switch (escolha) {
            case "1":
            case "canis":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Canis.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a
                                                                          // interface,ou seja, se este animal tem o
                                                                          // respetivo genoma
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Canis.class.isAssignableFrom(animal.getClass())) {// verifica se o animal
                                                                                                // é diferente de null e
                                                                                                // depoois verifca se
                                                                                                // implementa a
                                                                                                // interface, ou seja,
                                                                                                // se tem o respetivo
                                                                                                // genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case "2":
            case "equus":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Equus.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a
                                                                          // interface,ou seja, se este animal tem o
                                                                          // respetivo genoma
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Equus.class.isAssignableFrom(animal.getClass())) {// verifica se o animal
                                                                                                // é diferente de null e
                                                                                                // depoois verifca se
                                                                                                // implementa a
                                                                                                // interface, ou seja,
                                                                                                // se tem o respetivo
                                                                                                // genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case "3":
            case "naja":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Naja.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a interface,
                                                                         // ou seja, se este animal tem o respetivo
                                                                         // genoma
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Naja.class.isAssignableFrom(animal.getClass())) {// verifica se o animal é
                                                                                               // diferente de null e
                                                                                               // depoois verifca se
                                                                                               // implementa a
                                                                                               // interface, ou seja, se
                                                                                               // tem o respetivo genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case "4":
            case "ovis":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Ovis.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a interface,
                                                                         // ou seja, se este animal tem o respetivo
                                                                         // genoma
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Ovis.class.isAssignableFrom(animal.getClass())) {// verifica se o animal é
                                                                                               // diferente de null e
                                                                                               // depoois verifca se
                                                                                               // implementa a
                                                                                               // interface, ou seja, se
                                                                                               // tem o respetivo genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case "5":
            case "panthera":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Panthera.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a
                                                                             // interface,ou seja, se este animal tem o
                                                                             // respetivo genoma
                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Panthera.class.isAssignableFrom(animal.getClass())) {// verifica se o
                                                                                                   // animal é diferente
                                                                                                   // de null e depoois
                                                                                                   // verifca se
                                                                                                   // implementa a
                                                                                                   // interface, ou
                                                                                                   // seja, se tem o
                                                                                                   // respetivo genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            case "6":
            case "ursus":
                for (Animal animal : zoo.getAnimaisErrantes()) {// corre a lista de animais errantes
                    if (Ursus.class.isAssignableFrom(animal.getClass())) {// verifica se o animal implementa a
                                                                          // interface,ou seja, se este animal tem o
                                                                          // respetivo genoma este animal tem o

                        System.out.println(animal);
                    }
                }
                for (Animal[] ani : zoo.getRecintos().values()) {// percorre cada array de animais da hashmap
                    for (Animal animal : ani) {// percorre cada animal do respetivo array
                        if (animal != null && Ursus.class.isAssignableFrom(animal.getClass())) {// verifica se o animal
                                                                                                // é diferente de null e
                                                                                                // depoois verifca se
                                                                                                // implementa a
                                                                                                // interface, ou seja,
                                                                                                // se tem o respetivo
                                                                                                // genoma
                            System.out.println(animal);
                        }
                    }
                }
                break;
            default:
                throw new ExcecaoGenoma();
        }
    }

    // 7.Overload feito para o retrato familiar
    public static void listarAnimaisCarGenetica(Zoo zoo, String escolha) throws ExcecaoGenoma {
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
            default:
                throw new ExcecaoGenoma();
        }
    }

    // 8.Listar animal com uma dada mutação
    public static void listarDadaMutacao(Zoo zoo) throws ExcecaoMutacao {
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
                for (Animal animal : zoo.getAnimaisErrantes()) {// percorre a lista de animais errantes
                    if (animal.isAlbinismo())// verifica se o animal tem a respetiva mutação
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {// percorre os values da hashmap
                    for (Animal ani : animal) {// percorre o array de animais
                        if (ani != null && ani.isAlbinismo())// verifica se o animal é diferente de null e se tem a
                                                             // respetiva mutação pretendida
                            System.out.println(ani);
                    }
                }
                break;
            case "2":
            case "heterocromia":
                for (Animal animal : zoo.getAnimaisErrantes()) {// percorre a lista de animais errantes
                    if (animal.isHeterocromia())// verifica se o animal tem a respetiva mutação
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {// percorre os values da hashmap
                    for (Animal ani : animal) {// percorre o array de animais
                        if (ani != null && ani.isHeterocromia())// verifica se o animal é diferente de null e se tem a
                                                                // respetiva mutação pretendida
                            System.out.println(ani);
                    }
                }
                break;
            case "3":
            case "melanismo":
                for (Animal animal : zoo.getAnimaisErrantes()) {// percorre a lista de animais errantes
                    if (animal.isMelanismo())// verifica se o animal tem a respetiva mutação
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {// percorre os values da hashmap
                    for (Animal ani : animal) {// percorre o array de animais
                        if (ani != null && ani.isMelanismo())// verifica se o animal é diferente de null e se tem a
                                                             // respetiva mutação pretendida
                            System.out.println(ani);
                    }
                }
                break;
            case "4":
            case "siames":
                for (Animal animal : zoo.getAnimaisErrantes()) {// percorre a lista de animais errantes
                    if (animal.isSiames())// verifica se o animal tem a respetiva mutação
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {// percorre os values da hashmap
                    for (Animal ani : animal) {// percorre o array de animais
                        if (ani != null && ani.isSiames())// verifica se o animal é diferente de null e se tem a
                                                          // respetiva mutação pretendida
                            System.out.println(ani);
                    }
                }
                break;
            case "5":
            case "vitiligo":
                for (Animal animal : zoo.getAnimaisErrantes()) {// percorre a lista de animais errantes
                    if (animal.isVitiligo())// verifica se o animal tem a respetiva mutação
                        System.out.println(animal);
                }
                for (Animal[] animal : zoo.getRecintos().values()) {// percorre os values da hashmap
                    for (Animal ani : animal) {// percorre o array de animais
                        if (ani != null && ani.isVitiligo())// verifica se o animal é diferente de null e se tem a
                                                            // respetiva mutação pretendida
                            System.out.println(ani);
                    }
                }
                break;
            default:
                throw new ExcecaoMutacao();
        }
    }

    // 8.Overload feito para o retrato familiar
    public static void listarDadaMutacao(Zoo zoo, String escolha) throws ExcecaoMutacao {
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
                throw new ExcecaoMutacao();
        }
    }

    // 10. Retrato Familiar
    public static void retratoFamiliar(Zoo zoo, Ocorrencia ocor) throws ExcecaoGenoma, ExcecaoMutacao {

        System.out.println("\n-------Histórico-------\n");
        System.out.println(ocor);

        System.out.println("\n-------Caracteristicas Genéticas-------");

        String[] caractGen = { "Canis", "Equus", "Naja", "Ovis", "Panthera", "Ursus" };
        for (int index = 0; index < caractGen.length; index++) {
            System.out.println("\n------" + caractGen[index] + "------");
            listarAnimaisCarGenetica(zoo, caractGen[index]);
            // para cada característica genética serão listados os animais que as têm
        }

        System.out.println("\n-------Mutações-------");
        String[] mutacoes = { "Albino", "Heterocromia", "Melanismo", "Siames", "Vitiligo" };
        for (int i = 0; i < mutacoes.length; i++) {
            System.out.println("\n------" + mutacoes[i] + "------");
            listarDadaMutacao(zoo, mutacoes[i]);
            // para cada mutação serão listados os animais que as têm
        }

        System.out.println("\n-------Animais Perdidos-------");
        for (Animal animal : zoo.getAnimaisPerdidos()) {
            System.out.println(animal);
            // será mostrado os animais perdidos
        }

        System.out.println("\n-------Animais Mortos-------"); // será mostrado os animais que já morreram
        zoo.listarAnimaisMortos();

        System.out.println("\n-------Animais Errantes-------");// será mostrado os animais errantes
        zoo.listarAnimaisErrantes();

        System.out.println("\n-------Recintos-------");// será mostrado todos os recintos do zoo
        zoo.listarRecintos();

        System.out.println("\n-------Animais em Recintos-------");
        for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {// percorre a hashmap
            Recinto rec = recintos.getKey();
            Animal[] animais = recintos.getValue();
            System.out.println("\nRecinto: " + rec);// imprime o recinto
            if (rec.getOcupacao() == 0) {// caso não haja animais no recinto
                System.out.println("    ->Não existe animais colocados neste recinto");
            } else {// caso haja
                for (Animal animal : animais) {// percorre o array de animais
                    if (animal != null) {// se o animal for diferente de null este imprime o animal
                        System.out.println("    " + animal);
                    }
                }
            }
        }
    }

    // 13.Periodo contabilistico
    public static void periodoContabilistico(Zoo zoo, Ocorrencia ocor) {
        // calcular primeiro os custos totais do zoo
        Random rand = new Random();

        // despesas
        System.out.println("Despesas: " + zoo.calculaDespesas());
        zoo.setSaldo(zoo.getSaldo() - zoo.calculaDespesas());

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

        OcorrenciaPeriodo ocoPer = new OcorrenciaPeriodo(zoo.calculaDespesas(), proveitos);
        ocor.setHistorico(ocoPer.toString());

        if (proveitos < zoo.calculaDespesas()) {// caso haja prejuízo

            List<Animal> animaisPerdidosAgora = new ArrayList<Animal>();// variavel local para guardar os animais
                                                                        // perdidos neste período contabilístico

            for (Animal[] animais : zoo.getRecintos().values()) {// percorre os valores da hashmap

                for (int i = 0; i < animais.length; i++) {
                    if (animais[i] != null) {// verifica se ele é diferente de null

                        int num = rand.nextInt(101);// gera um número aleatório entre 0 e 100

                        if (num <= 30) {// probabilidade de 30% do animal escapar

                            animaisPerdidosAgora.add(animais[i]);// é adicionado à lista de animais perdidos neste
                                                                 // perdido contabilístico

                            zoo.setAnimaisPerdidos(animais[i]);// é adicionado à lista de animais perdidos do zoo
                            animais[i] = null;// retira o animal do recinto
                        }
                    }
                }
            }
            for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {// percorre a lista de animais errantes do zoo

                if (zoo.getAnimaisErrantes().get(i) != null) {// verifica se o animal não é null

                    int num = rand.nextInt(101);// cria um número aleatorio entre 0 a 100

                    if (num <= 30) {// probabilidade de 30% do animal se perder

                        animaisPerdidosAgora.add(zoo.getAnimaisErrantes().get(i));// adiciona o animal à lista de
                                                                                  // animais
                                                                                  // perdidos neste período
                                                                                  // contabilístico

                        zoo.setAnimaisPerdidos(zoo.getAnimaisErrantes().get(i));// adiciona o animal à lista de animais
                                                                                // perdidos do zoo

                        zoo.getAnimaisErrantes().remove(i);// retira o animal da lista de animais errantes
                    }
                }
            }

            System.out.println("\nPerdas:");
            if (animaisPerdidosAgora.isEmpty()) {
                System.out.println("Nenhum animal foi perdido neste período contabilístico");
            } else {
                System.out.println("Os seguintes animais fugiram do zoo:");
                for (Animal animal : animaisPerdidosAgora) {
                    System.out.println(animal);
                }
            }

            Fugiu aniFug = new Fugiu(animaisPerdidosAgora);// cria um nova classe
            ocor.setHistorico(aniFug.toString());// adiciona um texto na lista do historico evocando o metodo toString
                                                 // da classe gerada anteriormente
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

        // variavel local para guardar animais mortos neste período contabilísstico
        List<Animal> animaisMortosNumPeriodo = new ArrayList<Animal>();

        // animais errantes
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {

            int num = rand.nextInt(101);// numero aleatório entre 0 e 100
            if (zoo.getAnimaisErrantes().get(i) != null) {// se o animal for diferente de null
                if (zoo.getAnimaisErrantes().get(i).getIdade() >= zoo.getAnimaisErrantes().get(i)
                        .retornaEsperancaVida()) { // 90% do animal morrer face à sua esperança de vida
                    if (num < 90) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.8
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 75% do animal face à sua esperança
                                                                                   // de vida
                    if (num < 75) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.6
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 40% do animal morrer face à sua
                                                                                   // esperança de vida
                    if (num < 40) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else if (zoo.getAnimaisErrantes().get(i).getIdade() >= 0.4
                        * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida()) {// 10% do animal morrer face à sua
                                                                                   // esperança de vida
                    if (num < 10) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                } else { // 3% do animal morrer face à sua esperança de vida
                    if (num < 3) {
                        animaisMortosNumPeriodo.add(zoo.getAnimaisErrantes().get(i));
                        zoo.setAnimaisMortos(zoo.getAnimaisErrantes().get(i));
                        zoo.getAnimaisErrantes().remove(zoo.getAnimaisErrantes().get(i));
                    }
                }
            }
        }

        // animais em recintos
        for (Animal[] animais : zoo.getRecintos().values()) {
            int num = rand.nextInt(101);
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {
                    if (animais[i].getIdade() >= animais[i].retornaEsperancaVida()) { // 90% de o animal morrer face à
                                                                                      // sua esperança de vida
                        if (num < 90) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.8 * animais[i].retornaEsperancaVida()) {// 75$ do animal
                                                                                                  // morrer face à sua
                                                                                                  // esperança de vida
                        if (num < 75) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.6 * animais[i].retornaEsperancaVida()) {// 40% do animal
                                                                                                  // morrer face à sua
                                                                                                  // esperança de vida
                        if (num < 40) {
                            animaisMortosNumPeriodo.add(animais[i]);
                            zoo.setAnimaisMortos(animais[i]);
                            animais[i] = null;
                        }
                    } else if (animais[i].getIdade() >= 0.4 * animais[i].retornaEsperancaVida()) {// 10% do animal
                                                                                                  // morrer face à sua
                                                                                                  // esperança de vida
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
            for (Animal animal : animaisMortosNumPeriodo) {
                System.out.println(animal);
            }
        }
        Morte morteAni = new Morte(animaisMortosNumPeriodo);
        ocor.setHistorico(morteAni.toString());

        // retira do saldo do zoo os custos (ja ta feito no metodo calculaDespesas no
        // zoo)

        // Nascimentos
        System.out.println("\nNasimentos: ");

        // variavel local que guarda os animais que nasceram neste período
        // contabilístico
        List<Animal> nascimentosNestePeriodo = new ArrayList<Animal>();

        // para animais errantes
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            int num = rand.nextInt(101);// gera um número de 0 a 100
            Animal a = null;
            if (zoo.getAnimaisErrantes().get(i).retornaApetiteReprodutivo() >= num // caso o número gerado for menor ou
                                                                                   // igual que
                                                                                   // o apetite
                                                                                   // reprodutivo(probabilidade)
                    && zoo.getAnimaisErrantes().get(i).getIdade() >= Math
                            .round((0.25) * zoo.getAnimaisErrantes().get(i).retornaEsperancaVida())) {// E se o animal
                                                                                                      // tiver 1/4 da
                                                                                                      // sua esperança
                                                                                                      // de vida este
                                                                                                      // pode procriar

                switch (zoo.getAnimaisErrantes().get(i).getClass().getSimpleName()) {// verifica a classe do pai/mãe do
                                                                                     // animal
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
                }
                Animal.incrementaIdAnimalAtualizado();// atualiza o id global dos animais
                a.setIdAnimal(Animal.getIdAnimalAtualizado());// define o id deste respetivo animal como o mais atual
                nascimentosNestePeriodo.add(a);// adiciona o animal à lista de animais deste período contabilistico
                zoo.setAnimaisErrantes(a);// adiciona o animal à lista de animais errantes do zoo
            }
        }

        // para animais em recintos
        for (Animal[] animais : zoo.getRecintos().values()) {
            for (Animal animal : animais) {
                int num = rand.nextInt(101);// gera um número aleatório de 0 a 100;
                Animal a = null;
                if (animal != null // animal diferente de null
                        && animal.retornaApetiteReprodutivo() >= num //
                        && animal.getIdade() >= Math.round((0.25) * animal.retornaEsperancaVida())) {// caso o número
                                                                                                     // gerado for menor
                                                                                                     // ou
                                                                                                     // igual que
                                                                                                     // o apetite
                                                                                                     // reprodutivo(probabilidade)
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
                    Animal.incrementaIdAnimalAtualizado();// atualiza o id global dos animais
                    a.setIdAnimal(Animal.getIdAnimalAtualizado());// define o id deste animal para o mais atualizado
                    nascimentosNestePeriodo.add(a);// adiciona o animal à lista de animais nascidos neste período
                                                   // contabilístico
                    zoo.setAnimaisErrantes(a);// mete o animal na lista de animais errantes
                }
            }
        }

        if (nascimentosNestePeriodo.isEmpty()) {
            System.out.println("Nenhum animal nasceu neste período contabilístico");
        } else {
            System.out.println("Os seguintes animais nasceram");
            for (Animal animal : nascimentosNestePeriodo) {
                System.out.println(animal);
            }
        }

        Nascimento aniNasc = new Nascimento(nascimentosNestePeriodo); // como ocorreu um nascimento criamos uma nova
                                                                      // classe da package Ocorrrencias
        ocor.setHistorico(aniNasc.toString());// é adicionado ao histórico
    }

    // 14. Jumanji
    public static void jumanji(Zoo zoo, Ocorrencia ocor) {
        Random rand = new Random();

        ocor.setHistorico("\n------Jumanji------\n");

        // variável local para guardar
        List<Animal> animaisPerdidos = new ArrayList<Animal>();

        // para os animais em recintos
        for (Animal[] animais : zoo.getRecintos().values()) {
            for (int i = 0; i < animais.length; i++) {
                if (animais[i] != null) {// verifica se o animal não é null
                    int num = rand.nextInt(101);// gera um número aleatório de 0 a 100
                    if (num <= 30) {// Probabilidade de 30% do animal se perder
                        animaisPerdidos.add(animais[i]);// adiciona o animal aos animais perdidos ao chamar o metodo
                                                        // jumanji
                        zoo.setAnimaisPerdidos(animais[i]);// adiciona o animal à lista de animais perdidos do zoo
                        animais[i] = null;// retira o animal da hashmap do zoo
                    }
                }
            }
        }

        // para os animais errantes
        for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {
            if (zoo.getAnimaisErrantes().get(i) != null) {
                int num = rand.nextInt(101);// gera um número aleatório de 0 a 100
                if (num <= 30) {// Probabilidade de 30% do animal se perder
                    animaisPerdidos.add(zoo.getAnimaisErrantes().get(i));// adiciona o animal aos animais perdidos ao
                                                                         // chamar o metodo jumanji
                    zoo.setAnimaisPerdidos(zoo.getAnimaisErrantes().get(i));// adiciona o animal à lista de animais
                                                                            // perdidos do zoo
                    zoo.getAnimaisErrantes().remove(i);// remove o animal da lista de animais errantes
                }
            }
        }

        System.out.println("\nPerdas:");
        if (animaisPerdidos.isEmpty()) {
            System.out.println("Nenhum animal foi perdido neste período contabilístico");
        } else {
            System.out.println("Os seguintes animais fugiram do zoo:");
            for (Animal animal : animaisPerdidos) {
                System.out.println(animal);
            }
        }

        Fugiu aniFug = new Fugiu(animaisPerdidos);// cria a classe fuga para depois adicionar no histórico
        ocor.setHistorico(aniFug.toString());// adiciona um texto na lista do historico evocando o metodo toString//
                                             // da classe gerada anteriormente

        if (zoo.getRecintos().size() > 0) {//
            for (int i = 0; i < zoo.getAnimaisErrantes().size(); i++) {// percorre a lista de animais errantes
                int idDoRecintoAle = rand.nextInt(zoo.getRecintos().size()) + 1;// gera um número aleatorio entre 1 até
                                                                                // o numero de recintos que temos no zoo

                for (Map.Entry<Recinto, Animal[]> recintos : zoo.getRecintos().entrySet()) {// percorre todos os
                                                                                            // recintos

                    Recinto rec = recintos.getKey();
                    Animal[] animais = recintos.getValue();
                    if (rec.getIdRecinto() == idDoRecintoAle) {// se o id corresponder ao id gerado aleatoriamnete

                        int num = rand.nextInt(rec.getCapacidade());// criado um número aleatorio para ver a posição do
                                                                    // array

                        Animal a = animais[num];// guarda o possível animal numa variável local
                        animais[num] = zoo.getAnimaisErrantes().get(i);// define o animal na posiçaõ aleatória no array
                                                                       // do recinto
                        zoo.getAnimaisErrantes().remove(i);// remove o animla da lista de animais errantes
                        if (a != null) {// caso o animal nao for null
                            zoo.setAnimaisErrantes(a);// o animal que antes estava no array do recinto passa a ser um
                                                      // animal errante
                            InseriuAnimalNoRecinto insRec = new InseriuAnimalNoRecinto(animais[num], idDoRecintoAle, a);// ocorrencia
                                                                                                                        // onde
                                                                                                                        // o
                                                                                                                        // animal
                                                                                                                        // foi
                                                                                                                        // inserido
                                                                                                                        // no
                                                                                                                        // recinto
                                                                                                                        // mas
                                                                                                                        // teve
                                                                                                                        // que
                                                                                                                        // retirar
                                                                                                                        // outro
                            System.out.println(insRec);
                            ocor.setHistorico(insRec.toString());// adiciona ao histórico a ocorrencia
                        } else {
                            InseriuAnimalNoRecinto insRec = new InseriuAnimalNoRecinto(animais[num], idDoRecintoAle);// ocorrencia
                                                                                                                     // onde
                                                                                                                     // o
                                                                                                                     // animal
                                                                                                                     // é
                                                                                                                     // adicionado
                                                                                                                     // ao
                                                                                                                     // recinto
                            System.out.println(insRec);
                            ocor.setHistorico(insRec.toString());// adiciona ao historico a ocorrencia
                        }
                    }
                }
            }
        }
    }

    // -------leitura de ficheiros---------//

    /*
     * Este método insere dados no zoo referente aos recintos onde lê o ficheiro
     * Recintos.txt e insere os novos recintos na hashmap do zoo. Criamos uma
     * variavel numDaLinha, se o numDalinha for igual a 1 esta refere-se ao id do
     * recinto, a segunda linha refere-se à capacidade do recinto e a terceira serve
     * para dividir os recintos no ficheiro e no método serve para inserir o recinto
     * na hashmap
     */
    public static void uploadRecintos(Zoo zoo, Ocorrencia ocor) throws IOException {

        // variaveis locais
        String linha;
        int idRecinto = 0, capacidade = 0;
        Recinto rec = null;
        FileReader inStrem = new FileReader("Recintos.txt");
        BufferedReader lerDados = new BufferedReader(inStrem);

        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {// lê até a acabar as linhas do ficheiro
                switch (numDaLinha) {
                    case 1:// id do recinto
                        idRecinto = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:// capacidade do recinto
                        capacidade = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:// inserção do recinto na hashmap
                        rec = new Recinto(idRecinto, capacidade);
                        Recinto.setIdRecintoAtualizado();
                        zoo.setRecintos(rec);
                        linha = lerDados.readLine();
                        numDaLinha = 1;

                        InseriuRecinto insRec = new InseriuRecinto(rec);
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

    /*
     * Este método insere dados no zoo referente aos animais que estão em recintos
     * onde lê o ficheiro AnimaisEmRecintos.txt, insere os novos animais no array
     * de animais da hashmap do zoo. Criamos uma variavel numDaLinha, a primeira
     * linha refere-se ao id do recinto onde o animal está, da segunda até a decima
     * primeira linhas referem-se à informação do animal e na decima primeira onde
     * está a sua especie este evoca o construtor dependendo da mesma, a decima
     * segunda linha serve no ficheiro de texto para dividir cada animal e neste
     * método para inserir o animal no array de animais do respetivo recinto na
     * hashmap
     */
    public static void uploadAnimaisEmRecintos(Zoo zoo, Ocorrencia ocor) throws IOException {

        // variaveis locais
        String linha;
        // variaveis que serão precisas para inserir e criar o animal
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
                                        animais[i] = a;

                                        InseriuAnimalNoRecinto insRec = new InseriuAnimalNoRecinto(a, recintoId);// ocorrencia
                                                                                                                 // do
                                                                                                                 // animal
                                                                                                                 // ao
                                                                                                                 // entrar
                                                                                                                 // no
                                                                                                                 // zoo
                                        ocor.setHistorico(insRec.toString());// insere no histórico a informação

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

    /*
     * Este método insere dados no zoo referente aos animais errantes , este método
     * baseia-se em ler o ficheiro AnimaisErrantes.txt.
     * Implementamos, outra vez, a variavel local numDalinha que se refere ao número
     * da linha do ficheiro. Para termos o animal precisamos de 11 linhas, sendo as
     * 9 primeiras parametros para o construtor, a decima a sua class(espécie) e a
     * decima primeira serve no ficheiro para dividir os animais e neste metodo para
     * inserir o animal na lista de animais errantes
     */
    public static void uploadAnimaisErrantes(Zoo zoo, Ocorrencia ocor) throws IOException {
        String linha;

        // variaveis que servirão para os parametros do construtor do animal
        String nomeAnimal = new String(), sexoAnimal = new String();
        boolean vitiligoAnimal = false, heterocromiaAnimal = false, albinismoAnimal = false, melanismoAnimal = false,
                siamesAnimal = false;
        int idAnimal = 0, idadeAnimal = 0;

        Animal a = null;
        FileReader inStream = new FileReader("AnimaisErrantes.txt");
        BufferedReader lerDados = new BufferedReader(inStream);
        try {
            int numDaLinha = 1;
            linha = lerDados.readLine();
            while (linha != null) {// ler o ficheiro até o final
                switch (numDaLinha) {
                    case 1:// id do animal
                        idAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 2:// idade do animal
                        idadeAnimal = Integer.parseInt(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 3:// nome do animal
                        nomeAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 4:// sexo do animal
                        sexoAnimal = linha;
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 5:// albino
                        albinismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 6:// heterocromia
                        heterocromiaAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 7:// melanismo
                        melanismoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 8:// vitiligo
                        vitiligoAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 9:// siames
                        siamesAnimal = Boolean.parseBoolean(linha);
                        linha = lerDados.readLine();
                        numDaLinha++;
                        break;
                    case 10:// constutor, define o animal
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
                    case 11:// inserção na lista de animais errantes
                        zoo.setAnimaisErrantes(a);
                        Animal.setIdAnimalAtualizado(idAnimal);
                        linha = lerDados.readLine();
                        numDaLinha = 1;// linha volta a 1 pois a proxima linha pode ser ou não um novo animal

                        Adiciona adAni = new Adiciona(a);
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

    /*
     * Este método insere dados no zoo referente aos animais mortos, este método
     * baseia-se em ler o ficheiro AnimaisMortos.txt . Este método tem o mesmo
     * obejtivo que o de cima, só que a lista e o tipo de ocorrencia para o
     * histórico é diferente.
     */
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

    /*
     * Este método insere dados no zoo referente aos animais perdidos, este método
     * baseia-se em ler o ficheiro AnimaisPerdidos.txt . Este método tem o mesmo
     * obejtivo que o de cima, só que a lista e o tipo de ocorrencia para o
     * histórico é diferente.
     */
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
                        Fugiu aniFugiu = new Fugiu(a);
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
