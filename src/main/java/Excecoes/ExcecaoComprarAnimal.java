package Excecoes;

public class ExcecaoComprarAnimal extends Exception {

   /*
    * Exceção criada caso o utilizador pretenda comprar um dos tres animais
    * disponiveis
    */
   public ExcecaoComprarAnimal() {
      super("Tem de escolher uma das 3 opções apresentadas(1, 2 ou 3)");
   }

   /*
    * Exceção criada caso o utilizador escolha uma caracteristica não permitida
    */
   public ExcecaoComprarAnimal(String escolha) {
      super("Não pode escolher " + escolha
            + " insira o número ou nome de uma caracteristica genetica disponível");
   }
}
