package Equipamento.AdicionarEquipamento;

import javax.swing.*;
import java.awt.*;

public class CaminhaoTab extends JPanel {

    private JLabel caminhaoLabel;
    private JTextField caminhaoField;

    public CaminhaoTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setBorder(BorderFactory.createTitledBorder("Configurações do Caminhão"));

        caminhaoLabel = new JLabel("Capacidade");
        caminhaoField = new JTextField(10);

        Font fonte = new Font("Arial", Font.PLAIN, 14);
        caminhaoLabel.setFont(fonte);
        caminhaoField.setFont(fonte);

        this.add(caminhaoLabel);
        this.add(caminhaoField);

        this.setBackground(Color.green);
        caminhaoField.setBackground(Color.white);
    }

    public String getCapacidade() {
        return caminhaoField.getText();
    }

    public void limpar() {
        caminhaoField.setText("");
    }

}
