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
        cycloneTab = new CycloneTab();
        earthquakeTab = new EarthquakeTab();
        droughtTab = new DroughtTab();

        tipoTab.addTab("Cyclone", cycloneTab);
        tipoTab.addTab("Earthquake", earthquakeTab);
        tipoTab.addTab("Drought", droughtTab);

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
                AdicionarEventos.this.actionPerformed(e);
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
            if (eventos.codigoExists(idField.getText()))
                throw new InputMismatchException();
            Event evento = null;

            switch (tabIndex) {
                case 0: // Ciclone
                    evento = new Cyclone(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()), cycloneTab.getSpeed());
                            Double.parseDouble(custoDiaField.getText()), cycloneTab.getPrecipitation());
                    break;
                case 1: // Caminhão Tanque
                    evento = new CaminhaoTanque(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()),
                            Integer.parseInt(caminhaoTab.getCapacidade()));
                    break;
                case 2: // Escavadeira
                    evento = new Escavadeira(Integer.parseInt(idField.getText()), nomeField.getText(),
                            Double.parseDouble(custoDiaField.getText()), escavadeiraTab.getCombustivel(),
                            Integer.parseInt(escavadeiraTab.getCapacidade()));
                    break;
            }

            // Adiciona o equipamento à coleção
            eventos.adicionar(evento);
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