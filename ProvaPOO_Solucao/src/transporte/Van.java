package transporte;

/**
 * Representa uma van da frota. Herda de Veiculo e implementa Rastreavel
 * para permitir o rastreamento de sua localização.
 */
public class Van extends Veiculo implements Rastreavel {

    private String empresaResponsavel;
    private String localizacaoAtual;

    public Van(String placa, int capacidadePassageiros, int anoFabricacao, String empresaResponsavel) {
        super(placa, capacidadePassageiros, anoFabricacao);
        this.empresaResponsavel = empresaResponsavel;
        this.localizacaoAtual = "Garagem";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Van] Placa: " + getPlaca()
                + " | Capacidade: " + getCapacidadePassageiros()
                + " | Ano: " + getAnoFabricacao()
                + " | Empresa: " + empresaResponsavel
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

    public String getEmpresaResponsavel() {
        return empresaResponsavel;
    }

    public void setEmpresaResponsavel(String empresaResponsavel) {
        this.empresaResponsavel = empresaResponsavel;
    }
}
