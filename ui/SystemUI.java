
import javax.swing.*;

import Equipamento.EquipamentosUI;
import dados.Colecao.ColecaoEquipamento;

import java.awt.*;
import java.awt.event.*;

public class SystemUI extends JFrame {
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JButton selectedButton;
    private ColecaoEquipamento c;

    public SystemUI(ColecaoEquipamento c) {
        setTitle("ACMERescue");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.c = c;
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

        createSidebarButton("Home", new EquipamentosUI(c));
        createSidebarButton("Atendimentos", new JPanel());
        createSidebarButton("Equipamentos", new JPanel());
        createSidebarButton("Equipes", new JPanel());
        createSidebarButton("Eventos", new JPanel());
        createSidebarButton("Importar/Exportar dados", new JPanel());
    }

    private JButton createSidebarButton(String text, JPanel content) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (content.countComponents() == 0) {
            content.setBackground(Color.WHITE);
            content.add(new JLabel(text));
        }

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
