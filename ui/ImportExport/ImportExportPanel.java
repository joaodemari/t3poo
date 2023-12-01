package ImportExport;

import javax.swing.*;

import dados.Equipe;
import dados.events.Event;
import dados.Atendimento.Atendimento;
import dados.Colecao.*;
import dados.Equipamento.Equipamento;
import files.ExportarArquivo;
import files.ReceberArquivo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportExportPanel extends JPanel {
    private JTextField exportFilePathField;
    private JButton exportButton;
    private JTextField importFilePathField;
    private JButton importButton;
    private JComboBox<String> collectionDropdown;
    private ColecaoEquipamento equipamentos;
    private ColecaoAtendimento atendimentos;
    private ColecaoEquipe equipes;
    private ColecaoEvents events;

    public ImportExportPanel(ColecaoAtendimento atendimentos, ColecaoEquipe equipes, ColecaoEquipamento equipamentos,
            ColecaoEvents events) {
        setLayout(new FlowLayout());
        this.equipamentos = equipamentos;
        this.atendimentos = atendimentos;
        this.equipes = equipes;
        this.events = events;

        Container exportContainer = new Container();
        exportContainer.setLayout(new BoxLayout(exportContainer, BoxLayout.Y_AXIS));
        JLabel exportFileLabel = new JLabel("Arquivo de destino para exportação:");
        exportFilePathField = new JTextField(20);
        exportContainer.add(exportFileLabel);
        exportContainer.add(exportFilePathField);
        exportButton = new JButton("Exportar");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = exportFilePathField.getText();
                new ExportarArquivo<>(filePath + "-EQUIPAMENTOS.CSV", equipamentos);
                new ExportarArquivo<>(filePath + "-ATENDIMENTOS.CSV", atendimentos);
                new ExportarArquivo<>(filePath + "-EQUIPES.CSV", equipes);
                new ExportarArquivo<>(filePath + "-EVENTOS.CSV", events);
            }
        });
        exportContainer.add(exportButton);
        Container importContainer = new Container();
        importContainer.setLayout(new BoxLayout(importContainer, BoxLayout.Y_AXIS));
        JLabel importFileLabel = new JLabel("Arquivo de origem para importação:");
        importFilePathField = new JTextField(20);
        importContainer.add(importFileLabel);
        importContainer.add(importFilePathField);
        String[] collectionOptions = { "Equipamentos", "Atendimentos", "Equipes", "Eventos" };
        collectionDropdown = new JComboBox<>(collectionOptions);
        importContainer.add(collectionDropdown);
        importButton = new JButton("Importar");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCollection = (String) collectionDropdown.getSelectedItem();
                String filePath = importFilePathField.getText();
                importCollection(selectedCollection, filePath);
            }
        });
        importContainer.add(importButton);
        add(exportContainer);
        add(importContainer);
    }

    private void importCollection(String selectedCollection, String filePath) {
        switch (selectedCollection) {
            case "Equipamentos":
                new ReceberArquivo<>(filePath, equipamentos).lerDados();
                break;
            case "Atendimentos":
                new ReceberArquivo<>(filePath, atendimentos).lerDados();
                break;
            case "Equipes":
                new ReceberArquivo<>(filePath, equipes).lerDados();
                break;
            case "Eventos":
                new ReceberArquivo<>(filePath, events).lerDados();
                break;
            default:
                break;
        }
    }
}
