package biblioteca;

/**
 * Representa um periódico (revista, jornal científico, etc) do acervo,
 * adicionando os atributos específicos edicao e issn a um ItemBiblioteca.
 */
public class Periodico extends ItemBiblioteca {

    private int edicao;
    private String issn;

    public Periodico(String titulo, String codigo, int edicao, String issn) {
        super(titulo, codigo);
        this.edicao = edicao;
        this.issn = issn;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Periodico] Título: " + getTitulo()
                + " | Código: " + getCodigo()
                + " | Edição: " + edicao
                + " | ISSN: " + issn
                + " | Disponível: " + isDisponivel());
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }
}
