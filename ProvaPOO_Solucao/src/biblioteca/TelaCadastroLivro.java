package biblioteca;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Tela Swing responsável por cadastrar livros em um Acervo e permitir a
 * busca de itens por título.
 */
public class TelaCadastroLivro extends JFrame {

    private JTextField campoTitulo;
    private JTextField campoCodigo;
    private JTextField campoAutor;
    private JTextField campoIsbn;
    private JTextArea areaResultado;

    private Acervo acervo;

    public TelaCadastroLivro(Acervo acervo) {
        this.acervo = acervo;
        montarInterface();
    }

    private void montarInterface() {
        setTitle("Cadastro de Livro - Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel de formulário
        JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        campoTitulo = new JTextField();
        campoCodigo = new JTextField();
        campoAutor = new JTextField();
        campoIsbn = new JTextField();

        painelFormulario.add(new JLabel("Título:"));
        painelFormulario.add(campoTitulo);
        painelFormulario.add(new JLabel("Código:"));
        painelFormulario.add(campoCodigo);
        painelFormulario.add(new JLabel("Autor:"));
        painelFormulario.add(campoAutor);
        painelFormulario.add(new JLabel("ISBN:"));
        painelFormulario.add(campoIsbn);

        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoBuscar = new JButton("Buscar por Título");
        painelFormulario.add(botaoAdicionar);
        painelFormulario.add(botaoBuscar);

        // Área de resultado
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        add(painelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        botaoAdicionar.addActionListener(e -> adicionarLivro());
        botaoBuscar.addActionListener(e -> buscarPorTitulo());
    }

    private void adicionarLivro() {
        String titulo = campoTitulo.getText().trim();
        String codigo = campoCodigo.getText().trim();
        String autor = campoAutor.getText().trim();
        String isbn = campoIsbn.getText().trim();

        if (titulo.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Título e código são obrigatórios.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Livro livro = new Livro(titulo, codigo, autor, isbn);
        acervo.adicionarItem(livro);

        JOptionPane.showMessageDialog(this,
                "Livro \"" + titulo + "\" adicionado ao acervo com sucesso!",
                "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        limparCampos();
    }

    private void buscarPorTitulo() {
        String titulo = campoTitulo.getText().trim();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite um título para buscar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<ItemBiblioteca> resultados = acervo.buscarPorTitulo(titulo);
        StringBuilder sb = new StringBuilder();
        if (resultados.isEmpty()) {
            sb.append("Nenhum item encontrado para: ").append(titulo).append("\n");
        } else {
            sb.append("Resultados encontrados:\n\n");
            for (ItemBiblioteca item : resultados) {
                sb.append("- ").append(item.getTitulo())
                  .append(" (Código: ").append(item.getCodigo())
                  .append(", Disponível: ").append(item.isDisponivel())
                  .append(")\n");
            }
        }
        areaResultado.setText(sb.toString());
    }

    private void limparCampos() {
        campoTitulo.setText("");
        campoCodigo.setText("");
        campoAutor.setText("");
        campoIsbn.setText("");
    }

    public static void main(String[] args) {
        Acervo acervo = new Acervo();
        javax.swing.SwingUtilities.invokeLater(() -> {
            TelaCadastroLivro tela = new TelaCadastroLivro(acervo);
            tela.setVisible(true);
        });
    }
}
