package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o acervo da biblioteca, mantendo a coleção de itens
 * (livros, periódicos, etc.) utilizando uma List genérica.
 */
public class Acervo {

    private List<ItemBiblioteca> itens;

    public Acervo() {
        this.itens = new ArrayList<ItemBiblioteca>();
    }

    /**
     * Adiciona um item ao acervo.
     */
    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    /**
     * Remove um item do acervo a partir do seu código.
     */
    public void removerItem(String codigo) {
        itens.removeIf(item -> item.getCodigo().equals(codigo));
    }

    /**
     * Busca itens cujo título contenha (parcialmente, ignorando maiúsculas
     * e minúsculas) o texto informado.
     */
    public List<ItemBiblioteca> buscarPorTitulo(String titulo) {
        List<ItemBiblioteca> resultado = new ArrayList<ItemBiblioteca>();
        String buscaLower = titulo.toLowerCase();
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().toLowerCase().contains(buscaLower)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<ItemBiblioteca> getItens() {
        return itens;
    }
}
