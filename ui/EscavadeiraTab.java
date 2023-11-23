import javax.swing.*;

import dados.Equipamento.Combustivel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscavadeiraTab extends JPanel {

    private JLabel escavadeiraLabel, combustivelLabel;
    private JTextField escavadeiraField;
    private JComboBox<String> dropdown;
    private String selected;

    public EscavadeiraTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        String[] combustiveis = { "ALCOOL", "DIESEL", "GASOLINA" };

        dropdown = new JComboBox<>(combustiveis);

        combustivelLabel = new JLabel("Combustível:");

        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the label with the selected item
                selected = dropdown.getSelectedItem().toString();
            }
        });
        add(combustivelLabel);
        add(dropdown);

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Configurações da Escavadeira"));

        escavadeiraLabel = new JLabel("Carga:");
        escavadeiraField = new JTextField(10);

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        escavadeiraLabel.setFont(fonte);
        escavadeiraField.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(escavadeiraLabel);
        this.add(escavadeiraField);

        // Define cores de fundo para os componentes (opcional)
        this.setBackground(Color.yellow);
        escavadeiraField.setBackground(Color.white);

        // Adiciona um ouvinte de eventos ou personaliza ainda mais conforme necessário
    }

    public void limpar() {
        escavadeiraField.setText("");

    }

    // Métodos de acesso aos componentes
    public String getCapacidade() {
        return escavadeiraField.getText();
    }

    public Combustivel getCombustivel() {
        switch (dropdown.getSelectedIndex()) {
            case 0:
                return Combustivel.ALCOOL;
            case 1:
                return Combustivel.DIESEL;
            case 2:
                return Combustivel.GASOLINA;
            default:
                return Combustivel.DIESEL;
        }
    }

    public String getSelected() {
        return selected;
    }

}
