package Excecoes;

public class ExcecaoComprarAnimal extends Exception {
   public ExcecaoComprarAnimal() {
      super("Tem de escolher uma das 3 opções apresentadas(1, 2 ou 3)");
   }

   public ExcecaoComprarAnimal(String escolha) {
      super("Não pode escolher " + escolha
            + " insira o número ou nome de uma caracteristica genetica disponível");
   }
}
