package components.events.eventsTab;

import javax.swing.*;
import java.awt.*;

public class CycloneTab extends JPanel {

    private JLabel speedLabel, precipitationLabel;
    private JTextField speedField, precipitationField;

    public CycloneTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Detalhes do ciclone"));

        speedLabel = new JLabel("Velocidade");
        speedField = new JTextField(10);
        precipitationLabel = new JLabel("Precipitação");
        precipitationField = new JTextField(10);

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        speedLabel.setFont(fonte);
        speedField.setFont(fonte);
        precipitationLabel.setFont(fonte);
        precipitationField.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(speedLabel);
        this.add(speedField);
        this.add(precipitationLabel);
        this.add(precipitationField);
    }

    // Métodos de acesso aos componentes
    public String getSpeed() {
        return speedField.getText();
    }

    public String getPrecipitation() {
        return precipitationField.getText();
    }

    public void limpar() {
        speedField.setText("");
        precipitationField.setText("");
    }
}
