
import javax.swing.*;

import Atendimento.AdicionarAtendimento.AdicionarAtendimento;
import Equipamento.AdicionarEquipamento.AdicionarEquipamento;
import Equipe.VincularEquipamento;
import ImportExport.ImportExportPanel;
import MostrarRelatorio.MostrarRelatorioPanel;
import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEquipamento;
import dados.Colecao.ColecaoEquipe;
import dados.Colecao.ColecaoEvents;
import events.EventsUi;

import java.awt.*;
import java.awt.event.*;

public class SystemUI extends JPanel {
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JButton selectedButton;
    private ColecaoEquipamento equipamentos;
    private ColecaoAtendimento atendimentos;
    private ColecaoEquipe equipes;
    private ColecaoEvents events;

    public SystemUI(ColecaoEquipamento equipamentos, ColecaoAtendimento atendimentos, ColecaoEquipe equipes,
            ColecaoEvents events) {
        setPreferredSize(new Dimension(1000, 600));
        this.equipamentos = equipamentos;
        this.atendimentos = atendimentos;
        this.equipes = equipes;
        this.events = events;
        createSidebar();
        createContentPanel();

        setLayout(new BorderLayout());
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void createSidebar() {
        sidebarPanel = new JPanel();
        sidebarPanel.setBackground(Color.LIGHT_GRAY);
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));

        createSidebarButton("Home", new JPanel());
        createSidebarButton("Relatório Geral", new MostrarRelatorioPanel(atendimentos, equipes, equipamentos, events));
        createSidebarButton("Cadastrar Atendimento", new AdicionarAtendimento(atendimentos));
        createSidebarButton("Cadastrar Equipamento", new AdicionarEquipamento(equipamentos));
        createSidebarButton("Equipes", new VincularEquipamento(equipamentos, equipes));
        createSidebarButton("Eventos", new EventsUi(events));
        createSidebarButton("Importar/Exportar dados", new ImportExportPanel());
    }

    private JButton createSidebarButton(String text, JPanel content) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click events here
                handleSidebarButtonClick(button, text, content);
            }
        });
        button.setMaximumSize(new Dimension(200, 40));
        button.setBackground(Color.WHITE);
        sidebarPanel.add(button);
        return button;
    }

    private void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        // Add your content components to this panel
        JLabel contentLabel = new JLabel("Content Panel");
        contentLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(contentLabel);
    }

    private void handleSidebarButtonClick(JButton button, String buttonText, JPanel buttonPanel) {
        if (selectedButton != null) {
            // Reset the background color of the previously selected button
            selectedButton.setBackground(Color.WHITE);
        }

        // Set the background color of the selected button
        button.setBackground(Color.lightGray);
        selectedButton = button;

        // Update the content panel
        contentPanel.removeAll();
        contentPanel.add(buttonPanel);
        contentPanel.revalidate();
        contentPanel.repaint();

    }

}
