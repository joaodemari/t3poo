package Equipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import dados.Equipe;

public class CadastroEquipe extends JPanel {
    private JTextField codinomeField, membrosField, latitudeField, longitudeField;
    private JTextArea mensagemArea;
    private ArrayList<Equipe> equipes;

    public CadastroEquipe() {
        equipes = new ArrayList<>();

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        codinomeField = new JTextField(20);
        membrosField = new JTextField(20);
        latitudeField = new JTextField(20);
        longitudeField = new JTextField(20);
        mensagemArea = new JTextArea(15, 30);
        mensagemArea.setEditable(false);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar Campos");
        JButton mostrarButton = new JButton("Mostrar Dados");

        mainPanel.add(new JLabel("Codinome da Equipe:"));
        mainPanel.add(codinomeField);
        mainPanel.add(new JLabel("Quantidade de Membros:"));
        mainPanel.add(membrosField);
        mainPanel.add(new JLabel("Latitude:"));
        mainPanel.add(latitudeField);
        mainPanel.add(new JLabel("Longitude:"));
        mainPanel.add(longitudeField);
        mainPanel.add(new JLabel("Mensagens:"));
        mainPanel.add(new JScrollPane(mensagemArea));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(mostrarButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEquipe();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDados();
            }
        });
    }

    private void cadastrarEquipe() {
        String codinome = codinomeField.getText();
        int quantidadeMembros = Integer.parseInt(membrosField.getText());
        double latitude = Double.parseDouble(latitudeField.getText());
        double longitude = Double.parseDouble(longitudeField.getText());

        if (codinome.isEmpty()) {
            exibirMensagemErro("Preencha o codinome da equipe.");
            return;
        }

        for (Equipe equipe : equipes) {
            if (equipe.getCodinome().equals(codinome)) {
                exibirMensagemErro("Equipe com o mesmo codinome já existe.");
                return;
            }
        }

        Equipe novaEquipe = new Equipe(codinome, quantidadeMembros, latitude, longitude);
        equipes.add(novaEquipe);

        Collections.sort(equipes);

        exibirMensagemSucesso("Equipe cadastrada com sucesso.");
    }

    private void limparCampos() {
        codinomeField.setText("");
        membrosField.setText("");
        latitudeField.setText("");
        longitudeField.setText("");
        mensagemArea.setText("");
    }

    private void mostrarDados() {
        mensagemArea.setText("=== Equipes Cadastradas ===\n");
        for (Equipe equipe : equipes) {
            mensagemArea.append(equipe.toString() + "\n");
        }
    }

    private void exibirMensagemErro(String mensagem) {
        mensagemArea.setText("Erro: " + mensagem);
    }

    private void exibirMensagemSucesso(String mensagem) {
        mensagemArea.setText("Sucesso: " + mensagem);
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }
}