package Equipe;

import javax.swing.*;

import dados.Equipe;
import dados.Colecao.ColecaoEquipamento;
import dados.Colecao.ColecaoEquipe;
import dados.Equipamento.Equipamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VincularEquipamento extends JPanel implements ActionListener {
    private JComboBox<String> equipamentoComboBox;
    private JComboBox<String> equipeComboBox;
    private JButton vincularButton;
    private ColecaoEquipamento equipamentos;
    private ColecaoEquipe equipes;

    public VincularEquipamento(ColecaoEquipamento equipamentos, ColecaoEquipe equipes) {
        // Inicializa os JComboBox com as coleções de equipamentos e equipes
        equipamentoComboBox = new JComboBox<>(equipamentos.toNomeArray());
        equipeComboBox = new JComboBox<>(equipes.toCodinomeArray());

        this.equipamentos = equipamentos;
        this.equipes = equipes;

        // Inicializa o botão de vincular
        vincularButton = new JButton("Vincular");
        vincularButton.addActionListener(this);

        // Adiciona os componentes ao painel
        add(new JLabel("Selecionar Equipamento:"));
        add(equipamentoComboBox);
        add(new JLabel("Selecionar Equipe:"));
        add(equipeComboBox);
        add(vincularButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ação a ser realizada ao clicar no botão de vincular
        Equipamento equipamentoSelecionado = equipamentos
                .getEquipamentoByNome(equipamentoComboBox.getSelectedItem().toString());
        Equipe equipeSelecionada = equipes.getEquipeByCodinome(equipeComboBox.getSelectedItem().toString());

        // Verifica se ambos estão selecionados antes de vincular
        if (equipamentoSelecionado != null && equipeSelecionada != null) {
            equipeSelecionada.vincularEquipamento(equipamentoSelecionado);
            JOptionPane.showMessageDialog(this, "Equipamento vinculado à equipe com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um equipamento e uma equipe antes de vincular.");
        }
    }
}
