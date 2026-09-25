package questao4;

// ===================== VERSÃO CORRIGIDA =====================

// Classe para representar um produto em uma loja
// Erro 1 corrigido: atributos agora são private (encapsulamento),
// com getters e setters em vez de acesso público direto.
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        // Erro 2 corrigido: uso de "this." para diferenciar o atributo da
        // classe do parâmetro do construtor, que possuem o mesmo nome.
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

// Interface que define comportamento de desconto
interface Descontavel {
    double TAXA_PADRAO = 0.10; // implicitamente public static final, ok em interface
    void aplicarDesconto();
}

// Produto com desconto – herda de Produto e implementa a interface
class ProdutoPromo extends Produto implements Descontavel {

    public ProdutoPromo(String nome, double preco) {
        super(nome, preco);
    }

    // Erro 3 corrigido: uso da anotação @Override ao sobrescrever/implementar
    // o método da interface, conforme boas práticas de POO.
    @Override
    public void aplicarDesconto() {
        setPreco(getPreco() - (getPreco() * TAXA_PADRAO));
    }
}

class Main {
    public static void main(String[] args) {
        // Erro 4 corrigido: como "preco" não faz parte do contrato da
        // interface Descontavel, não é possível acessá-lo por meio de uma
        // referência do tipo Descontavel. A referência deve ser do tipo
        // concreto (ProdutoPromo) — ou então deve-se usar um getter.
        ProdutoPromo produto = new ProdutoPromo("Notebook", 3000.0);
        produto.aplicarDesconto();
        System.out.println(produto.getPreco());
    }
}
