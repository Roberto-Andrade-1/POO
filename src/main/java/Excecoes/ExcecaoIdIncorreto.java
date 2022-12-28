package Excecoes;

public class ExcecaoIdIncorreto extends Exception {
    public ExcecaoIdIncorreto(int id, String texto) {
        super("Não foi possível encontrar o " + texto + " com id: " + id + " tente outro");
    }
}
