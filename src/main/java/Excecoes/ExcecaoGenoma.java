package Excecoes;

public class ExcecaoGenoma extends Exception {
   /*
    * Exceção criada caso o utilizador insira um nome ou valor não permitido
    */
   public ExcecaoGenoma() {
      super("Tem que inserir o nome ou número do respetivo genoma dos disponibilizados em cima");
   }
}
