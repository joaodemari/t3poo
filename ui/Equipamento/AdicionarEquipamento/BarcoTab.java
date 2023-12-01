package Equipamento.AdicionarEquipamento;

import javax.swing.*;
import java.awt.*;

public class BarcoTab extends JPanel {

    private JLabel barcoLabel;
    private JTextField barcoField;

    public BarcoTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setBorder(BorderFactory.createTitledBorder("Configurações do Barco"));

        barcoLabel = new JLabel("Capacidade");
        barcoField = new JTextField(10);

        Font fonte = new Font("Arial", Font.PLAIN, 14);
        barcoLabel.setFont(fonte);
        barcoField.setFont(fonte);

        this.add(barcoLabel);
        this.add(barcoField);

        this.setBackground(Color.cyan);
        barcoField.setBackground(Color.white);
    }

    public String getCapacidade() {
        return barcoField.getText();
    }

    public void limpar() {
        barcoField.setText("");
    }
}
