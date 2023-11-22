import javax.swing.*;

import dados.Equipamento.Colecao;

import java.awt.*;
import java.awt.event.*;

public class MenuEquipamento extends JFrame {
    private JButton verEquipamentos, cadastrarEquipamento;

    public MenuEquipamento(Colecao equipamentos) {
        // Set the title of the window
        super("Menu de Equipamentos");

        // Create buttons
        verEquipamentos = new JButton("Ver Equipamentos");
        verEquipamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListarEquipamentos(equipamentos);
            }
        });

        cadastrarEquipamento = new JButton("Cadastrar Equipamento");
        cadastrarEquipamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdicionarEquipamento(equipamentos);
            }
        });

        // Set layout manager to FlowLayout

        setLayout(new FlowLayout());
        setSize(300, 150);
        // Add buttons to the fram
        Container c = new Container();
        c.setLayout(new GridLayout(2, 1));
        c.add(cadastrarEquipamento);
        c.add(verEquipamentos);
        add(new JLabel("Menu de Equipamentos"));
        add(c);

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Set the layout and make the window visible
        setVisible(true);
    }
}
