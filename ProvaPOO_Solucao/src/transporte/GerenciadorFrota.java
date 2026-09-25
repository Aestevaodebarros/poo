package transporte;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia a frota de veículos utilizando um Map, onde a chave é a placa
 * do veículo, permitindo busca rápida por placa.
 */
public class GerenciadorFrota {

    private Map<String, Veiculo> veiculos;

    public GerenciadorFrota() {
        this.veiculos = new HashMap<String, Veiculo>();
    }

    public void cadastrarVeiculo(Veiculo v) {
        veiculos.put(v.getPlaca(), v);
    }

    public Veiculo buscarPorPlaca(String placa) {
        return veiculos.get(placa);
    }

    public void removerVeiculo(String placa) {
        veiculos.remove(placa);
    }

    /**
     * Lista todos os veículos cadastrados, chamando exibirDetalhes() de
     * cada um por meio de uma referência polimórfica do tipo Veiculo.
     */
    public void listarTodos() {
        for (Veiculo v : veiculos.values()) {
            v.exibirDetalhes();
        }
    }
}
