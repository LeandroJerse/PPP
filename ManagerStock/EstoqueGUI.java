import crud.ProdutoDAO;
import entities.Produto;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EstoqueGUI extends JFrame {
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final JTable tabela;
    private final DefaultTableModel modeloTabela;

    public EstoqueGUI() {
        setTitle("Controle de Estoque");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel(new BorderLayout());

        // Tabela de produtos
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Estoque");

        tabela = new JTable(modeloTabela);
        atualizarTabela();

        // Painel de adicionar produto
        JPanel painelAdicionar = new JPanel(new GridLayout(0, 2, 5, 5));
        painelAdicionar.setBorder(new TitledBorder("Adicionar Produto"));

        // Campos de entrada para adicionar produto
        JTextField txtNome = new JTextField();
        JTextField txtDescricao = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtEstoque = new JTextField();

        // Botão para adicionar produto
        JButton btnAdicionar = new JButton("Adicionar Produto");

        // Ação do botão Adicionar
        btnAdicionar.addActionListener((ActionEvent e) -> {
            try {
                produtoDAO.adicionarProduto(
                        txtNome.getText(),
                        txtDescricao.getText(),
                        Double.parseDouble(txtPreco.getText()),
                        Integer.parseInt(txtEstoque.getText())
                );
                atualizarTabela();
                limparCampos();
                JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos! Verifique os campos.");
            }
        });

        // Adicionando componentes ao painel de adicionar produto
        painelAdicionar.add(new JLabel("Nome:"));
        painelAdicionar.add(txtNome);
        painelAdicionar.add(new JLabel("Descrição:"));
        painelAdicionar.add(txtDescricao);
        painelAdicionar.add(new JLabel("Preço:"));
        painelAdicionar.add(txtPreco);
        painelAdicionar.add(new JLabel("Estoque Inicial:"));
        painelAdicionar.add(txtEstoque);
        painelAdicionar.add(btnAdicionar);

        // Painel de gerenciar estoque
        JPanel painelGerenciar = new JPanel(new GridLayout(0, 2, 5, 5));
        painelGerenciar.setBorder(new TitledBorder("Gerenciar Estoque"));

        // Campos de entrada para gerenciar estoque
        JTextField txtId = new JTextField();
        JTextField txtQuantidade = new JTextField();

        // Botões para gerenciar estoque
        JButton btnComprar = new JButton("Registrar Compra");
        JButton btnVender = new JButton("Registrar Venda");
        JButton btnRemover = new JButton("Remover Produto");

        // Ações dos botões de gerenciar estoque
        btnComprar.addActionListener((ActionEvent e) -> {
            try {
                produtoDAO.atualizarEstoque(
                        Integer.parseInt(txtId.getText()),
                        Integer.parseInt(txtQuantidade.getText()),
                        true
                );
                atualizarTabela();
                JOptionPane.showMessageDialog(this, "Compra registrada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID ou quantidade inválidos!");
            }
        });

        btnVender.addActionListener((ActionEvent e) -> {
            try {
                produtoDAO.atualizarEstoque(
                        Integer.parseInt(txtId.getText()),
                        Integer.parseInt(txtQuantidade.getText()),
                        false
                );
                atualizarTabela();
                JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID ou quantidade inválidos!");
            }
        });

        btnRemover.addActionListener((ActionEvent e) -> {
            try {
                produtoDAO.removerProduto(Integer.parseInt(txtId.getText()));
                atualizarTabela();
                JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido!");
            }
        });

        // Adicionando componentes ao painel de gerenciar estoque
        painelGerenciar.add(new JLabel("ID do Produto:"));
        painelGerenciar.add(txtId);
        painelGerenciar.add(new JLabel("Quantidade:"));
        painelGerenciar.add(txtQuantidade);
        painelGerenciar.add(btnComprar);
        painelGerenciar.add(btnVender);
        painelGerenciar.add(btnRemover);

        // Painel de controles (combina adicionar e gerenciar)
        JPanel painelControles = new JPanel(new GridLayout(2, 1, 5, 5));
        painelControles.add(painelAdicionar);
        painelControles.add(painelGerenciar);

        // Adicionando componentes ao painel principal
        painel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        painel.add(painelControles, BorderLayout.SOUTH);

        add(painel);
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        List<Produto> produtos = produtoDAO.listarProdutos();
        for (Produto p : produtos) {
            modeloTabela.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getDescricao(),
                    p.getPreco(),
                    p.getEstoque()
            });
        }
    }

    private void limparCampos() {
        for (Component c : ((JPanel) getContentPane().getComponent(0)).getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EstoqueGUI().setVisible(true);
        });
    }
}