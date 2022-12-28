package Excecoes;

public class ExecaoNumIncorretoRecinto extends Exception {
   public ExecaoNumIncorretoRecinto() {
      super("Tem de inserir 0 caso não queira o recinto ou, se quiser, um número dos candidatos");
   }
}
