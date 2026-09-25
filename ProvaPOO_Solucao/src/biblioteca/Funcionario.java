package biblioteca;

/**
 * Representa um funcionário da instituição, que é um tipo específico de
 * Pessoa e pode tomar itens emprestados na biblioteca.
 */
public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(String nome, String cpf, String email, String cargo) {
        super(nome, cpf, email);
        this.cargo = cargo;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
