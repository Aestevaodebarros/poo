package biblioteca;

/**
 * Classe base para qualquer item que possa fazer parte do acervo da
 * biblioteca (livros, periódicos, etc). Implementa o contrato Emprestavel,
 * fornecendo a lógica concreta de empréstimo e devolução.
 */
public class ItemBiblioteca implements Emprestavel {

    private String titulo;
    private String codigo;
    private boolean disponivel;
    private Pessoa pessoaComItem;

    public ItemBiblioteca(String titulo, String codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.disponivel = true;
        this.pessoaComItem = null;
    }

    @Override
    public boolean emprestar(Pessoa p) {
        // Só permite o empréstimo se o item estiver disponível
        if (disponivel) {
            disponivel = false;
            pessoaComItem = p;
            return true;
        }
        return false;
    }

    @Override
    public void devolver() {
        disponivel = true;
        pessoaComItem = null;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Método que as subclasses (Livro, Periodico) sobrescrevem para exibir
     * informações específicas de cada tipo de item.
     */
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo + " | Código: " + codigo
                + " | Disponível: " + disponivel);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Pessoa getPessoaComItem() {
        return pessoaComItem;
    }

    public void setPessoaComItem(Pessoa pessoaComItem) {
        this.pessoaComItem = pessoaComItem;
    }
}
