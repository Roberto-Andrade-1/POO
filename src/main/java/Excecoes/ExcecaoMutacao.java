package Excecoes;

public class ExcecaoMutacao extends Exception {
   public ExcecaoMutacao() {
      super("Tem de inserir o respetivo número ou o nome de uma característica genética das disponiveis apresentads em cima");
   }
}
