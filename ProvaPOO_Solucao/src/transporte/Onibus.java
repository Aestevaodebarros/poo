package transporte;

/**
 * Representa um ônibus da frota. Herda de Veiculo e implementa Rastreavel
 * para permitir o rastreamento de sua localização.
 */
public class Onibus extends Veiculo implements Rastreavel {

    private String numeroLinha;
    private String localizacaoAtual;

    public Onibus(String placa, int capacidadePassageiros, int anoFabricacao, String numeroLinha) {
        super(placa, capacidadePassageiros, anoFabricacao);
        this.numeroLinha = numeroLinha;
        this.localizacaoAtual = "Garagem";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Onibus] Placa: " + getPlaca()
                + " | Capacidade: " + getCapacidadePassageiros()
                + " | Ano: " + getAnoFabricacao()
                + " | Linha: " + numeroLinha
                + " | Localização: " + localizacaoAtual);
    }

    @Override
    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    @Override
    public void atualizarLocalizacao(String local) {
        this.localizacaoAtual = local;
    }

    public String getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(String numeroLinha) {
        this.numeroLinha = numeroLinha;
    }
}
