package components.events;

import javax.swing.*;

import java.awt.*;

public class EventsUi extends JPanel {
    private JButton refresh;

    public EventsUi() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout com espaçamento

        // Adiciona uma borda ao painel
        this.setBorder(BorderFactory.createTitledBorder("Eventos"));

        refresh = new JButton("Atualizar");

        // Define a fonte para os componentes
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        refresh.setFont(fonte);

        // Adiciona os componentes ao painel
        this.add(refresh);
    }
}
