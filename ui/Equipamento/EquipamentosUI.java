package Equipamento;

import javax.swing.*;

import java.awt.*;

import dados.Equipamento.ColecaoEquipamento;
import dados.Equipamento.Equipamento;
import Equipamento.AdicionarEquipamento.AdicionarEquipamento;

public class EquipamentosUI extends JPanel {
    private ColecaoEquipamento equipamentos;
    private JButton refresh;

    public EquipamentosUI(ColecaoEquipamento equipamentos) {
        this.equipamentos = equipamentos;
        add(new AdicionarEquipamento(equipamentos));

        setLayout(new FlowLayout());
        String[] column = { "ID", "Nome", "Custo por Dia", "Tipo" };
        String[][] data = equipamentos.getEquipamentosAsArray();
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);

        setVisible(true);
    }

    public JScrollPane makeGrid(String[][] data) {
        String[] column = { "ID", "Nome", "Custo por Dia", "Tipo" };
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        return sp;
    }
}
