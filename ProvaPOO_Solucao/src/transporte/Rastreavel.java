package transporte;

/**
 * Contrato para qualquer entidade que possa ter sua localização
 * consultada e atualizada.
 */
public interface Rastreavel {

    String getLocalizacaoAtual();

    void atualizarLocalizacao(String local);
}
