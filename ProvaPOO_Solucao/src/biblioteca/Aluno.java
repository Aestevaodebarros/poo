package biblioteca;

/**
 * Representa um aluno da instituição, que é um tipo específico de Pessoa
 * e pode tomar itens emprestados na biblioteca.
 */
public class Aluno extends Pessoa {

    private String matricula;
    private String curso;

    public Aluno(String nome, String cpf, String email, String matricula, String curso) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
