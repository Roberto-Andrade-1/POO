package com.mycompany.jumanji_poo;
import java.util.Scanner;


public class Jumanji {
        
    public static void main(String[] args) {
        
        boolean sair=false;
        Scanner scan=new Scanner(System.in);
        Zoo zoo=new Zoo(1000000);
        
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
            int escolha=scan.nextInt();
            switch (escolha) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    recintosAleatorio(zoo);
                    break;
                case 4:
                    break;
                case 5:
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
                    sair=true;
                    break;
                default:
                    System.out.println("Número inválido");
                    break;
            }
        }
    }
    
    public static void recintosAleatorio(Zoo zoo){
        Scanner scan=new Scanner(System.in);
        
        //cria 3 recintos
        Recinto rec1=new Recinto();
        Recinto rec2=new Recinto();
        Recinto rec3=new Recinto();
        
        System.out.println("\nRECINTOS DISPONÍVEIS:");
        System.out.println("Candidato 1: capacidade: "+rec1.getCapacidade()+" | Custo: "+rec1.getCusto()+"€");
        System.out.println("Candidato 2: capacidade: "+rec2.getCapacidade()+" | Custo: "+rec2.getCusto()+"€");
        System.out.println("Candidato 3: capacidade: "+rec3.getCapacidade()+" | Custo: "+rec3.getCusto()+"€\n");
        
        System.out.println("Qual dos seguintes recintos pretende escolher?(se não pretender nenhum insira 0)");
        int escolhaRecinto=scan.nextInt();
        if (escolhaRecinto>0 && escolhaRecinto<=3)Recinto.setIdRecintoAtualizado();
        switch (escolhaRecinto) {
            case 0:
                break;
            case 1:
                rec1.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.getRecintos().add(rec1);
                zoo.setSaldo(zoo.getSaldo()-rec1.getCusto());
                break;
            case 2:
                rec2.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.getRecintos().add(rec2);
                zoo.setSaldo(zoo.getSaldo()-rec2.getCusto());
                break;
            case 3:
                rec3.setIdRecinto(Recinto.getIdRecintoAtualizado());
                zoo.getRecintos().add(rec3);
                zoo.setSaldo(zoo.getSaldo()-rec3.getCusto());
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }
    
    public static void listarInstalacoes(Zoo zoo){
        System.out.println("\nRECINTOS");
        for (int i = 0; i < zoo.getRecintos().size(); i++) {
            Recinto rec = zoo.getRecintos().get(i);
            System.out.println("ID: "+rec.getIdRecinto()+" | capacidade: "+rec.getCapacidade()+" | custo: "+ rec.getCusto()+"€");
        }
    }
}

