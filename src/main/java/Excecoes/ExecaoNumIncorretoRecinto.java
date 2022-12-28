package Excecoes;

public class ExecaoNumIncorretoRecinto extends Exception {
   public ExecaoNumIncorretoRecinto() {
      super("Tem de inserir 0 ou um número dos candidatos");
   }
}
