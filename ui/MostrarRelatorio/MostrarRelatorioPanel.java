package MostrarRelatorio;

import javax.swing.*;

import dados.Equipe;
import dados.Atendimento.Atendimento;
import dados.Colecao.*;
import dados.Equipamento.Equipamento;
import dados.events.Event;

import java.awt.*;
import java.util.ArrayList;

public class MostrarRelatorioPanel extends JPanel {

    public MostrarRelatorioPanel(ColecaoAtendimento atendimentos,
            ColecaoEquipe equipes,
            ColecaoEquipamento equipamentos,
            ColecaoEvents events) {

        setLayout(new GridLayout(2, 2));

        add(createSubPanel("Atendimentos", atendimentos));
        add(createSubPanel("Equipes", equipes));
        add(createSubPanel("Eventos", events));
        add(createSubPanel("Equipamentos", equipamentos));
    }

    private JPanel createSubPanel(String title, ArrayList<?> collection) {
        JPanel subPanel = new JPanel();
        subPanel.setBorder(BorderFactory.createTitledBorder(title));

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        for (Object item : collection) {
            textArea.append(item.toString() + "\n");
        }

        subPanel.add(new JScrollPane(textArea));

        return subPanel;
    }
}