import javax.swing.*;

import dados.Equipamento.Barco;
import dados.Equipamento.Equipamento;

import java.awt.event.*;

public class JanelaEquipamento extends JFrame implements ActionListener {
    private JButton botao;
    private JLabel nomeLabel, custoAreaLabel, tipoLabel, tituloLabel;
    private JTextField nomeField, custoDiaField;
    private JPanel nomeContainer, custoDiaContainer, tipoContainer, containerMaior;
    private JTabbedPane tipoTab;
    private BarcoTab barcoTab;

    public JanelaEquipamento() {
        super("Janela de Equipamento");

        // Botão de Adicionar
        botao = new JButton("ADICIONAR");

        // Labels e Fields
        nomeLabel = new JLabel("Nome do Equipamento");
        nomeField = new JTextField(15);
        custoAreaLabel = new JLabel("Custo por Dia");
        custoDiaField = new JTextField(5);

        // Containers
        nomeContainer = new JPanel();
        custoDiaContainer = new JPanel();
        tipoContainer = new JPanel();
        containerMaior = new JPanel();

        // Configurando layout dos containers
        BoxLayout layout = new BoxLayout(containerMaior, BoxLayout.Y_AXIS);
        containerMaior.setLayout(layout);

        // Adicionando componentes aos containers
        nomeContainer.add(nomeLabel);
        nomeContainer.add(nomeField);
        custoDiaContainer.add(custoAreaLabel);
        custoDiaContainer.add(custoDiaField);

        // Tipo de Equipamento (TabbedPane)
        tipoLabel = new JLabel("Tipo de Equipamento");
        tipoTab = new JTabbedPane();
        barcoTab = new BarcoTab();
        tipoTab.addTab("Barco", barcoTab);
        tipoTab.addTab("Caminhão Tanque", new JPanel());
        tipoTab.addTab("Escavadeira", new JPanel());
        tipoContainer.add(tipoLabel);
        tipoContainer.add(tipoTab);

        // Adicionando containers maiores
        containerMaior.add(nomeContainer);
        containerMaior.add(custoDiaContainer);
        containerMaior.add(tipoContainer);

        // Adicionando botão e ouvinte de eventos
        containerMaior.add(botao);
        botao.addActionListener(this);

        // Configurações da janela principal
        this.add(containerMaior);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(600, 400); // Tamanho ajustado para melhor visualização
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao) {
            // Verifica qual tab está selecionada
            int tabIndex = tipoTab.getSelectedIndex();

            // Cria o objeto do tipo correspondente à tab selecionada
            Equipamento equipamento = null;
            switch (tabIndex) {
                case 0: // Barco
                    equipamento = new Barco(1, nomeField.getText(), Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(barcoTab.getCapacidade()));
                    break;
                // Adicione casos para outros tipos (CaminhaoTanque, Escavadeira) conforme
                // necessário
            }

            if (equipamento != null) {
                // Faça algo com o objeto equipamento, por exemplo, imprima suas informações
                System.out.println("Tipo: " + equipamento.getClass().getSimpleName());
                System.out.println("Nome: " + equipamento.getNome());
                System.out.println("Custo por Dia: " + equipamento.getCustoDia());

                // Adicione código adicional conforme necessário
            }
        }
    }
}