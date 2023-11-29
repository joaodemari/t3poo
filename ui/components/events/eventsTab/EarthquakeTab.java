package components.events.eventsTab;

import javax.swing.*;
import java.awt.*;

public class EarthquakeTab extends JPanel{
    
    private JLabel magnitudeLabel;
    private JTextField magnitudeField;

    public EarthquakeTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Detalhes do terremoto"));

        magnitudeLabel = new JLabel("Velocidade");
        magnitudeField = new JTextField(10);

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        magnitudeLabel.setFont(fonte);
        magnitudeField.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(magnitudeLabel);
        this.add(magnitudeField);
    }

    // Métodos de acesso aos componentes

    public String getMagnitude() {
        return magnitudeField.getText();
    }

    public void limpar() {
        magnitudeField.setText("");
    }
}
