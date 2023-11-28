package Equipamento.AdicionarEquipamento;

import javax.swing.*;

import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;
import dados.Equipamento.ColecaoEquipamento;
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
        voltar = new JButton("Voltar");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        actionsContainer.add(voltar);

        add(actionsContainer);

        idLabel = new JLabel("ID do Equipamento");
        idField = new JTextField(20);
        idContainer = new JPanel();
        idContainer.add(idLabel);
        idContainer.add(idField);
        add(idContainer);

        // Labels e Fields
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

        // Tabs
        tipoTab = new JTabbedPane();
        barcoTab = new BarcoTab();
        escavadeiraTab = new EscavadeiraTab();
        caminhaoTab = new CaminhaoTab();

        tipoTab.addTab("Barco", barcoTab);
        tipoTab.addTab("Caminhão Tanque", caminhaoTab);
        tipoTab.addTab("Escavadeira", escavadeiraTab);

        // Adicione outras tabs conforme necessário

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
        // Verifica qual tab está selecionada
        try {
            int tabIndex = tipoTab.getSelectedIndex();

            // Cria o objeto do tipo correspondente à tab selecionada

            if (nomeField.getText().equals(""))
                throw new InputMismatchException();
            if (equipamentos.idExists(idField.getText()))
                throw new InputMismatchException();
            Equipamento equipamento = null;

            switch (tabIndex) {
                case 0: // Barco
                    equipamento = new Barco(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(barcoTab.getCapacidade()));
                    break;
                case 1: // Caminhão Tanque
                    equipamento = new CaminhaoTanque(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(caminhaoTab.getCapacidade()));
                    break;
                case 2: // Escavadeira
                    equipamento = new Escavadeira(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()), escavadeiraTab.getCombustivel(),
                            Integer.parseInt(escavadeiraTab.getCapacidade()));
                    break;
            }

            // Adiciona o equipamento à coleção
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