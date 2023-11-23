import javax.swing.*;
import java.awt.*;

public class CaminhaoTab extends JPanel {

    private JLabel caminhaoLabel;
    private JTextField caminhaoField;

    public CaminhaoTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Configurações do Caminhão"));

        caminhaoLabel = new JLabel("Capacidade");
        caminhaoField = new JTextField(10);

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        caminhaoLabel.setFont(fonte);
        caminhaoField.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(caminhaoLabel);
        this.add(caminhaoField);

        // Define cores de fundo para os componentes (opcional)
        this.setBackground(Color.green);
        caminhaoField.setBackground(Color.white);

        // Adiciona um ouvinte de eventos ou personaliza ainda mais conforme necessário
    }

    // Métodos de acesso aos componentes
    public String getCapacidade() {
        return caminhaoField.getText();
    }

    public void limpar() {
        caminhaoField.setText("");
    }

}
