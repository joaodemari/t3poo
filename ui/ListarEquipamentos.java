import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import dados.Equipamento.Colecao;
import dados.Equipamento.Equipamento;
import dados.Equipamento.Colecao;

public class ListarEquipamentos extends JFrame {
    private Colecao equipamentos;
    private JButton voltar;

    public ListarEquipamentos(Colecao equipamentos) {
        super("Lista de Equipamentos");

        this.equipamentos = equipamentos;
        voltar = new JButton("Voltar");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuEquipamento(equipamentos);
            }
        });
        add(voltar);
        setLayout(new FlowLayout());
        String[] column = { "ID", "Nome", "Custo por Dia" };
        JTable jt = new JTable(equipamentos.getEquipamentosAsArray(), column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
