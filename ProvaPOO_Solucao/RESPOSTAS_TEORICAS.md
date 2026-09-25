# Respostas Teóricas — Avaliação Prática de POO

## Questão 2 — Questões Teóricas (Referente à Questão 1)

**1. Por que a classe Pessoa deve ser declarada como abstrata neste sistema? O que aconteceria se ela fosse concreta?**

`Pessoa` representa um conceito genérico que, sozinho, não corresponde a nenhuma entidade real do sistema: na prática, toda pessoa cadastrada é sempre um `Aluno` ou um `Funcionario`, nunca uma "Pessoa" pura. Por isso ela é declarada `abstract`, e o método `getTipo()` também é abstrato, obrigando cada subclasse a definir seu próprio comportamento.

Se `Pessoa` fosse concreta, seria possível instanciá-la diretamente (`new Pessoa(...)`), o que permitiria criar objetos sem significado de negócio (uma "pessoa" que não é nem aluno nem funcionário) e faria com que `getTipo()` precisasse de uma implementação genérica sem sentido real (ex.: retornar `"Pessoa"` ou uma string vazia), enfraquecendo o modelo e abrindo espaço para inconsistências no sistema.

**2. Qual é a diferença prática entre usar extends e implements em Java? Dê um exemplo retirado do diagrama da Questão 1 para cada um.**

`extends` é usado para **herança**: uma classe estende outra classe (ou uma classe abstrata), herdando atributos e métodos já implementados, podendo reaproveitar e sobrescrever comportamento. Uma classe só pode ter **um** superclasse (herança simples). Exemplo do diagrama: `Aluno extends Pessoa` — `Aluno` herda `nome`, `cpf`, `email` de `Pessoa` e sobrescreve `getTipo()`.

`implements` é usado para **implementar um contrato (interface)**: a classe se compromete a fornecer implementação para todos os métodos declarados na interface, mas não herda nenhuma implementação pronta — apenas a assinatura dos métodos. Uma classe pode implementar **várias** interfaces ao mesmo tempo. Exemplo do diagrama: `ItemBiblioteca implements Emprestavel` — `ItemBiblioteca` precisa fornecer o corpo dos métodos `emprestar()`, `devolver()` e `isDisponivel()`.

**3. Por que a interface Emprestavel define o contrato de comportamento, enquanto a classe ItemBiblioteca fornece a implementação concreta? Qual vantagem isso traz para o sistema?**

`Emprestavel` define **o que** deve ser feito (a assinatura dos métodos `emprestar()`, `devolver()` e `isDisponivel()`), sem se preocupar em **como** isso será feito. `ItemBiblioteca` é quem decide a lógica real: por exemplo, só permitir o empréstimo se o item estiver disponível, e controlar o atributo `disponivel` internamente.

Essa separação entre contrato e implementação traz como principais vantagens:
- **Baixo acoplamento**: outras partes do sistema podem depender apenas da interface `Emprestavel`, sem precisar conhecer os detalhes internos de `ItemBiblioteca`.
- **Polimorfismo**: é possível tratar qualquer objeto emprestável de forma uniforme (`Emprestavel e = new Livro(...)`), independentemente de sua classe concreta.
- **Flexibilidade e extensibilidade**: se no futuro surgir um novo tipo de item emprestável com uma lógica diferente, basta implementar a interface, sem alterar o restante do sistema que já depende do contrato.

---

## Questão 4 — Análise e Correção de Código

### a) Identificação e explicação dos quatro erros

**Erro 1 — Quebra de encapsulamento (atributos públicos)**
Na classe `Produto`, os atributos `nome` e `preco` foram declarados como `public`:
```java
public String nome;
public double preco;
```
Isso viola um dos pilares da POO (encapsulamento), pois permite que qualquer classe externa altere o estado do objeto diretamente, sem qualquer controle ou validação (ex.: `produto.preco = -500;`).
**Correção:** declarar os atributos como `private` e fornecer métodos `getNome()`, `setNome()`, `getPreco()` e `setPreco()`.

**Erro 2 — Sombreamento de variável no construtor (self-assignment)**
```java
public Produto(String nome, double preco) {
    nome = nome;
    preco = preco;
}
```
Como os parâmetros do construtor têm o mesmo nome dos atributos da classe, `nome = nome` apenas atribui o parâmetro a ele mesmo — os atributos da instância **nunca são inicializados** (permanecem `null` e `0.0`).
**Correção:** usar a palavra-chave `this` para referenciar o atributo da instância: `this.nome = nome; this.preco = preco;`.

**Erro 3 — Ausência da anotação @Override**
O método `aplicarDesconto()` em `ProdutoPromo` implementa o método declarado na interface `Descontavel`, mas não está anotado com `@Override`. Embora o código compile sem essa anotação, é uma boa prática de POO utilizá-la sempre que se sobrescreve/implementa um método, pois o compilador passa a verificar se a assinatura realmente corresponde a um método da superclasse/interface, evitando erros silenciosos (ex.: um erro de digitação criaria um método novo em vez de sobrescrever o existente).
**Correção:** adicionar `@Override` imediatamente acima de `public void aplicarDesconto()`.

**Erro 4 — Uso indevido da interface como tipo de referência para acessar membro não pertencente ao contrato**
```java
Descontavel d = new ProdutoPromo("Notebook", 3000.0);
d.aplicarDesconto();
System.out.println(d.preco);
```
A variável `d` é declarada do tipo `Descontavel` (a interface), então só é possível acessar, através dela, os membros definidos no contrato da interface (`aplicarDesconto()`, `TAXA_PADRAO`). O atributo `preco` pertence apenas à classe `Produto`/`ProdutoPromo`, não à interface — esse código **não compila**. Isso mostra uma confusão conceitual entre o contrato de comportamento (interface) e os dados concretos do objeto (classe).
**Correção:** usar uma referência do tipo concreto (`ProdutoPromo produto = new ProdutoPromo(...)`) e acessar o valor por meio de um getter (`produto.getPreco()`), já que `preco` também deveria ser privado (ver Erro 1).

### Código corrigido (resumo)

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}

interface Descontavel {
    double TAXA_PADRAO = 0.10;
    void aplicarDesconto();
}

class ProdutoPromo extends Produto implements Descontavel {
    public ProdutoPromo(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void aplicarDesconto() {
        setPreco(getPreco() - (getPreco() * TAXA_PADRAO));
    }
}

class Main {
    public static void main(String[] args) {
        ProdutoPromo produto = new ProdutoPromo("Notebook", 3000.0);
        produto.aplicarDesconto();
        System.out.println(produto.getPreco());
    }
}
```

*(Versão completa e comentada disponível em `src/questao4/CodigoCorrigido.java`.)*
