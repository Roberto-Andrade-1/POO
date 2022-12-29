package Excecoes;

public class ExcecaoIdIncorreto extends Exception {
    /*
     * Exceção criada caso o utilizador insira um id não permitido
     */
    public ExcecaoIdIncorreto(int id, String texto) {
        super("Não foi possível encontrar o " + texto + " com id: " + id + " tente outro");
    }
}
