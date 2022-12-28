package Excecoes;

public class ExcecaoNumMenuInvalido extends Exception {
   public ExcecaoNumMenuInvalido() {
      super("Tem que inserir um número entre 1 a 15");
   }
}
