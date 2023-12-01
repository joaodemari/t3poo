package events.eventsTab;

import javax.swing.*;
import java.awt.*;

public class DroughtTab extends JPanel {

    private JLabel droughtLabel;
    private JTextField droughtField;

    public DroughtTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setBorder(BorderFactory.createTitledBorder("Detalhes da seca"));

        droughtLabel = new JLabel("Velocidade");
        droughtField = new JTextField(10);

        Font fonte = new Font("Arial", Font.PLAIN, 14);
        droughtLabel.setFont(fonte);
        droughtField.setFont(fonte);

        this.add(droughtLabel);
        this.add(droughtField);
    }

    public String getDrought() {
        return droughtField.getText();
    }

    public void limpar() {
        droughtField.setText("");
    }
}
