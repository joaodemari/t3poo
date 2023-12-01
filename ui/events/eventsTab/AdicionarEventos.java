package events.eventsTab;

import javax.swing.*;

import dados.Colecao.ColecaoEvents;
import dados.events.Cyclone;
import dados.events.Drought;
import dados.events.Earthquake;
import dados.events.Event;

import java.awt.event.*;
import java.util.InputMismatchException;

public class AdicionarEventos extends JPanel implements ActionListener {
    private ColecaoEvents eventos;

    private JButton botao, voltar, listarEquipamentos, limpar;
    private JLabel nomeLabel, custoDiaLabel, idLabel;
    private JTextField nomeField, custoDiaField, idField;
    private JPanel nomeContainer, custoDiaContainer, tipoContainer, actionsContainer, addContainer, idContainer;
    private JTabbedPane tipoTab;
    private CycloneTab cycloneTab;
    private EarthquakeTab earthquakeTab;
    private DroughtTab droughtTab;

    public AdicionarEventos(ColecaoEvents eventos) {

        this.eventos = eventos;

        actionsContainer = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        limpar = new JButton("Limpar");
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                custoDiaField.setText("");
                idField.setText("");
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
        cycloneTab = new CycloneTab();
        earthquakeTab = new EarthquakeTab();
        droughtTab = new DroughtTab();

        tipoTab.addTab("Cyclone", cycloneTab);
        tipoTab.addTab("Earthquake", earthquakeTab);
        tipoTab.addTab("Drought", droughtTab);

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
                AdicionarEventos.this.actionPerformed(e);
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
            if (eventos.codigoExists(idField.getText()))
                throw new InputMismatchException();
            Event evento = null;

            showMessage("Evento adicionado com sucesso!");

        } catch (InputMismatchException error) {
            if (eventos.codigoExists(idField.getText())) {
                showMessage("Codigo não pode ser repetido ou vazio!");
            } else {
                showMessage("Nome do evento não pode ser vazio!");
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