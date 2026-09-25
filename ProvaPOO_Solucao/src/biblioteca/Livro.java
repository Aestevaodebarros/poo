package biblioteca;

/**
 * Representa um livro do acervo, adicionando os atributos específicos
 * autor e isbn a um ItemBiblioteca.
 */
public class Livro extends ItemBiblioteca {

    private String autor;
    private String isbn;

    public Livro(String titulo, String codigo, String autor, String isbn) {
        super(titulo, codigo);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Livro] Título: " + getTitulo()
                + " | Código: " + getCodigo()
                + " | Autor: " + autor
                + " | ISBN: " + isbn
                + " | Disponível: " + isDisponivel());
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
