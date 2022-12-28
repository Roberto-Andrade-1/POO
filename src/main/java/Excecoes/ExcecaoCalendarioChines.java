package Excecoes;

public class ExcecaoCalendarioChines extends Exception {
   public ExcecaoCalendarioChines() {
      super("Tem que inserir um ano a partir de 2000");
   }
}