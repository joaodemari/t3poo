import javax.swing.*;
import java.awt.*;

public class BarcoTab extends JPanel {

    private JLabel barcoLabel;
    private JTextField barcoField;

    public BarcoTab() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Configurações do Barco"));

        barcoLabel = new JLabel("Capacidade");
        barcoField = new JTextField(10);

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        barcoLabel.setFont(fonte);
        barcoField.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(barcoLabel);
        this.add(barcoField);

        // Define cores de fundo para os componentes (opcional)
        this.setBackground(Color.cyan);
        barcoField.setBackground(Color.white);

        // Adiciona um ouvinte de eventos ou personaliza ainda mais conforme necessário
    }

    // Métodos de acesso aos componentes
    public String getCapacidade() {
        return barcoField.getText();
    }

    public void limpar() {
        barcoField.setText("");
    }
}
