package Excecoes;

public class ExcecaoCalendarioChines extends Exception {
   public ExcecaoCalendarioChines() {
      super("Tem que inserir um ano válido, ano 0 para cima");
   }
}