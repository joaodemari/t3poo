package Atendimento.AdicionarAtendimento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.InputMismatchException;

import dados.Atendimento.Atendimento;
import dados.Atendimento.Status;
import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEquipe;
import dados.Equipe;

public class AdicionarAtendimento extends JPanel implements ActionListener {
    private ColecaoAtendimento atendimentos;

    private JButton botao, limpar;
    private JLabel codLabel, dataInicioLabel, duracaoLabel, equipeLabel;
    private JTextField codField, dataInicioField, duracaoField;
    private JComboBox<String> equipeComboBox;

    public AdicionarAtendimento(ColecaoAtendimento atendimentos, ColecaoEquipe equipes) {
        this.atendimentos = atendimentos;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        limpar = new JButton("Limpar");
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codField.setText("");
                dataInicioField.setText("");
                duracaoField.setText("");
                // Limpar outros campos, se necessário
            }
        });
        add(limpar);

        codLabel = new JLabel("Código do Atendimento");
        codField = new JTextField(20);

        add(codLabel);
        add(codField);

        dataInicioLabel = new JLabel("Data de Início (YYYY-MM-DD)");
        dataInicioField = new JTextField(20);

        add(dataInicioLabel);
        add(dataInicioField);

        duracaoLabel = new JLabel("Duração (em horas)");
        duracaoField = new JTextField(20);

        add(duracaoLabel);
        add(duracaoField);

        equipeLabel = new JLabel("Equipe");
        equipeComboBox = new JComboBox<String>(equipes.toCodinomeArray());

        add(equipeLabel);
        add(equipeComboBox);

        botao = new JButton("ADICIONAR");
        add(botao);
        botao.addActionListener(this);

        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (codField.getText().equals("") || dataInicioField.getText().equals("")
                    || duracaoField.getText().equals("")) {
                throw new InputMismatchException("Preencha todos os campos.");
            }

            int cod = Integer.parseInt(codField.getText());
            Date dataInicio = Date.valueOf(dataInicioField.getText());
            int duracao = Integer.parseInt(duracaoField.getText());
            Equipe equipe = (Equipe) equipeComboBox.getSelectedItem();

            Atendimento atendimento = new Atendimento(cod, dataInicio, duracao, equipe);
            atendimentos.adicionar(atendimento);

            showMessage("Atendimento adicionado com sucesso!");
        } catch (InputMismatchException error) {
            showMessage(error.getMessage());
        } catch (NumberFormatException error) {
            showMessage("Duração deve ser um número inteiro.");
        } catch (Exception error) {
            showMessage("Erro ao adicionar atendimento.");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
