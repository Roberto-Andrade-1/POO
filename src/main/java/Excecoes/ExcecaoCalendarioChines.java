package Excecoes;

public class ExcecaoCalendarioChines extends Exception {
   /*
    * Exceção criada caso o utilizador insira um valor não permitido
    */
   public ExcecaoCalendarioChines() {
      super("Tem que inserir um ano válido, ano 0 para cima");
   }
}