package biblioteca;

/**
 * Classe abstrata que representa uma pessoa genérica no sistema da biblioteca.
 * Serve de base para Aluno e Funcionario, que se diferenciam pelo tipo
 * retornado em getTipo().
 */
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    /**
     * Retorna o tipo da pessoa (ex.: "Aluno", "Funcionario").
     * Cada subclasse concreta deve implementar sua própria versão.
     */
    public abstract String getTipo();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getTipo() + " - " + nome + " (CPF: " + cpf + ")";
    }
}
