package Equipamento.AdicionarEquipamento;

import javax.swing.*;

import dados.Colecao.ColecaoEquipamento;
import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;
import dados.Equipamento.Equipamento;
import dados.Equipamento.Escavadeira;

import java.awt.event.*;
import java.util.InputMismatchException;

public class AdicionarEquipamento extends JPanel implements ActionListener {
    private ColecaoEquipamento equipamentos;

    private JButton botao, voltar, listarEquipamentos, limpar;
    private JLabel nomeLabel, custoDiaLabel, idLabel;
    private JTextField nomeField, custoDiaField, idField;
    private JPanel nomeContainer, custoDiaContainer, tipoContainer, actionsContainer, addContainer, idContainer;
    private JTabbedPane tipoTab;
    private BarcoTab barcoTab;
    private EscavadeiraTab escavadeiraTab;
    private CaminhaoTab caminhaoTab;

    public AdicionarEquipamento(ColecaoEquipamento equipamentos) {

        this.equipamentos = equipamentos;

        actionsContainer = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        limpar = new JButton("Limpar");
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                custoDiaField.setText("");
                idField.setText("");
                barcoTab.limpar();
                escavadeiraTab.limpar();
                caminhaoTab.limpar();
            }
        });
        actionsContainer.add(limpar);

        add(actionsContainer);

        idLabel = new JLabel("ID do Equipamento");
        idField = new JTextField(20);
        idContainer = new JPanel();
        idContainer.add(idLabel);
        idContainer.add(idField);
        add(idContainer);

        nomeLabel = new JLabel("Nome do Equipamento");
        nomeField = new JTextField(20);

        nomeContainer = new JPanel();
        nomeContainer.add(nomeLabel);
        nomeContainer.add(nomeField);
        add(nomeContainer);

        custoDiaLabel = new JLabel("Custo por Dia");
        custoDiaField = new JTextField(20);
        custoDiaContainer = new JPanel();
        custoDiaContainer.add(custoDiaLabel);
        custoDiaContainer.add(custoDiaField);
        add(custoDiaContainer);

        tipoTab = new JTabbedPane();
        barcoTab = new BarcoTab();
        escavadeiraTab = new EscavadeiraTab();
        caminhaoTab = new CaminhaoTab();

        tipoTab.addTab("Barco", barcoTab);
        tipoTab.addTab("Caminhão Tanque", caminhaoTab);
        tipoTab.addTab("Escavadeira", escavadeiraTab);

        tipoContainer = new JPanel();
        tipoContainer.add(tipoTab);
        add(tipoContainer);

        addContainer = new JPanel();
        BoxLayout boxLayout = new BoxLayout(addContainer, BoxLayout.Y_AXIS);
        addContainer.setLayout(boxLayout);

        botao = new JButton("ADICIONAR");
        addContainer.add(botao);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarEquipamento.this.actionPerformed(e);
            }
        });

        add(addContainer);

        setSize(500, 400);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            int tabIndex = tipoTab.getSelectedIndex();

            if (nomeField.getText().equals(""))
                throw new InputMismatchException();
            if (equipamentos.idExists(idField.getText()))
                throw new InputMismatchException();
            Equipamento equipamento = null;

            switch (tabIndex) {
                case 0:
                    equipamento = new Barco(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(barcoTab.getCapacidade()));
                    break;
                case 1:
                    equipamento = new CaminhaoTanque(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(caminhaoTab.getCapacidade()));
                    break;
                case 2:
                    equipamento = new Escavadeira(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()), escavadeiraTab.getCombustivel(),
                            Integer.parseInt(escavadeiraTab.getCapacidade()));
                    break;
            }

            equipamentos.adicionar(equipamento);
            showMessage("Equipamento adicionado com sucesso!");

        } catch (InputMismatchException error) {
            if (equipamentos.idExists(idField.getText())) {
                showMessage("Id não pode ser repetido ou vazio!");
            } else {
                showMessage("Nome do equipamento não pode ser vazio!");
            }
        } catch (NumberFormatException error) {

            showMessage("Dados inseridos são inválidos!");
        } catch (Exception error) {
            showMessage("Erro identificado!");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}