package transporte;

/**
 * Classe abstrata que representa um veículo genérico da frota de
 * transporte. Onibus e Van herdam desta classe.
 */
public abstract class Veiculo {

    private String placa;
    private int capacidadePassageiros;
    private int anoFabricacao;

    public Veiculo(String placa, int capacidadePassageiros, int anoFabricacao) {
        this.placa = placa;
        this.capacidadePassageiros = capacidadePassageiros;
        this.anoFabricacao = anoFabricacao;
    }

    /**
     * Cada subclasse concreta deve exibir seus próprios detalhes,
     * incluindo os atributos herdados de Veiculo.
     */
    public abstract void exibirDetalhes();

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
