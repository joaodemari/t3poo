package events.eventsTab;

import javax.swing.*;
import java.awt.*;

public class EarthquakeTab extends JPanel {

    private JLabel magnitudeLabel;
    private JTextField magnitudeField;

    public EarthquakeTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setBorder(BorderFactory.createTitledBorder("Detalhes do terremoto"));

        magnitudeLabel = new JLabel("Velocidade");
        magnitudeField = new JTextField(10);

        Font fonte = new Font("Arial", Font.PLAIN, 14);
        magnitudeLabel.setFont(fonte);
        magnitudeField.setFont(fonte);

        this.add(magnitudeLabel);
        this.add(magnitudeField);
    }

    public String getMagnitude() {
        return magnitudeField.getText();
    }

    public void limpar() {
        magnitudeField.setText("");
    }
}
