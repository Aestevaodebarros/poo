package biblioteca;

/**
 * Contrato de comportamento para qualquer item da biblioteca que possa ser
 * emprestado. Define o QUE deve ser feito, deixando o COMO a cargo de quem
 * implementa (no caso, ItemBiblioteca).
 */
public interface Emprestavel {

    /**
     * Tenta emprestar o item para a pessoa informada.
     * @param p pessoa que deseja pegar o item emprestado
     * @return true se o empréstimo foi realizado com sucesso, false caso
     *         o item não esteja disponível
     */
    boolean emprestar(Pessoa p);

    /**
     * Devolve o item, tornando-o disponível novamente.
     */
    void devolver();

    /**
     * Indica se o item está disponível para empréstimo.
     */
    boolean isDisponivel();
}
