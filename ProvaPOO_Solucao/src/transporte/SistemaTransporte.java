package transporte;

/**
 * Classe principal que demonstra o funcionamento do sistema de
 * gerenciamento de rotas de transporte, incluindo cadastro,
 * atualização de localização e polimorfismo.
 */
public class SistemaTransporte {

    public static void main(String[] args) {
        GerenciadorFrota gerenciador = new GerenciadorFrota();

        // Criação de 2 ônibus e 2 vans
        Onibus onibus1 = new Onibus("ABC-1234", 45, 2018, "Linha 101");
        Onibus onibus2 = new Onibus("ABC-5678", 40, 2020, "Linha 202");
        Van van1 = new Van("VAN-1111", 15, 2019, "Transporte Rápido Ltda");
        Van van2 = new Van("VAN-2222", 12, 2021, "Viação Modelo Ltda");

        // Cadastro no GerenciadorFrota
        gerenciador.cadastrarVeiculo(onibus1);
        gerenciador.cadastrarVeiculo(onibus2);
        gerenciador.cadastrarVeiculo(van1);
        gerenciador.cadastrarVeiculo(van2);

        // Atualização de localização de pelo menos 2 veículos
        onibus1.atualizarLocalizacao("Terminal Central");
        van1.atualizarLocalizacao("Rodovia BR-324, km 12");

        // Listagem demonstrando polimorfismo: cada Veiculo chama sua
        // própria versão de exibirDetalhes(), mesmo sendo tratado
        // genericamente como Veiculo dentro do GerenciadorFrota.
        System.out.println("=== Frota cadastrada ===");
        gerenciador.listarTodos();

        // Exemplo de busca por placa
        System.out.println("\n=== Busca por placa ABC-1234 ===");
        Veiculo encontrado = gerenciador.buscarPorPlaca("ABC-1234");
        if (encontrado != null) {
            encontrado.exibirDetalhes();
        }
    }
}
