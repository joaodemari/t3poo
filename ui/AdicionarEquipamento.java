import javax.swing.*;

import dados.Equipamento.Barco;
import dados.Equipamento.Colecao;
import dados.Equipamento.Equipamento;

import java.awt.*;
import java.awt.event.*;

public class AdicionarEquipamento extends JFrame implements ActionListener {
    private Colecao equipamentos;

    private JButton botao, voltar, listarEquipamentos;
    private JLabel nomeLabel, tipoLabel;
    private JTextField nomeField;
    private JPanel nomeContainer, tipoContainer;
    private JTabbedPane tipoTab;
    private BarcoTab barcoTab;

    public AdicionarEquipamento(Colecao equipamentos) {
        super("Adicionar Equipamento");
        setLayout(new FlowLayout());
        this.equipamentos = equipamentos;
        voltar = new JButton("Voltar");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuEquipamento(equipamentos);
            }
        });
        add(voltar);

        listarEquipamentos = new JButton("Listar Equipamentos");
        listarEquipamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListarEquipamentos(equipamentos);
            }
        });
        add(listarEquipamentos);

        // Botão de Adicionar
        botao = new JButton("ADICIONAR");

        // Labels e Fields
        nomeLabel = new JLabel("Nome do Equipamento");
        nomeField = new JTextField(20);

        nomeContainer = new JPanel();
        nomeContainer.add(nomeLabel);
        nomeContainer.add(nomeField);
        add(nomeContainer);

        // Adiciona o botão de adicionar

        // Tabs
        tipoTab = new JTabbedPane();
        barcoTab = new BarcoTab();
        tipoTab.addTab("Barco", barcoTab);
        // Adicione outras tabs conforme necessário

        tipoContainer = new JPanel();
        tipoContainer.add(tipoTab);
        add(tipoContainer);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        add(botao);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica qual tab está selecionada
                int tabIndex = tipoTab.getSelectedIndex();

                // Cria o objeto do tipo correspondente à tab selecionada
                Equipamento equipamento = null;
                switch (tabIndex) {
                    case 0: // Barco
                        equipamento = new Barco(1, nomeField.getText(), 0.0,
                                Integer.parseInt(barcoTab.getCapacidade()));
                        break;
                }

                if (equipamento != null) {
                    // Faça algo com o objeto equipamento, por exemplo, imprima suas informações
                    System.out.println("Tipo: " + equipamento.getClass().getSimpleName());
                    System.out.println("Nome: " + equipamento.getNome());
                    System.out.println("Custo por Dia: " + equipamento.getCustoDia());

                    // Adicione código adicional conforme necessário
                }
            }

        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao) {

        }
    }
}