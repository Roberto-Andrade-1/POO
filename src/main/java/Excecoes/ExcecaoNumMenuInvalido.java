package Excecoes;

public class ExcecaoInputInvalido extends Exception {
   public ExcecaoInputInvalido() {
      super("Tem que inserir um número entre 1 a 15");
   }
}
