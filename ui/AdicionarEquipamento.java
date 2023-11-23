import javax.swing.*;

import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;
import dados.Equipamento.Colecao;
import dados.Equipamento.Equipamento;
import dados.Equipamento.Escavadeira;

import java.awt.event.*;
import java.util.InputMismatchException;

public class AdicionarEquipamento extends JFrame {
    private Colecao equipamentos;

    private JButton botao, voltar, listarEquipamentos, limpar;
    private JLabel nomeLabel, custoDiaLabel, idLabel;
    private JTextField nomeField, custoDiaField, idField;
    private JPanel nomeContainer, custoDiaContainer, tipoContainer, actionsContainer, addContainer, idContainer;
    private JTabbedPane tipoTab;
    private BarcoTab barcoTab;
    private EscavadeiraTab escavadeiraTab;
    private CaminhaoTab caminhaoTab;

    public AdicionarEquipamento(Colecao equipamentos) {
        super("Adicionar Equipamento");

        this.equipamentos = equipamentos;

        actionsContainer = new JPanel();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
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
                new MenuEquipamento(equipamentos);
            }
        });
        actionsContainer.add(voltar);

        listarEquipamentos = new JButton("Listar Equipamentos");
        listarEquipamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListarEquipamentos(equipamentos);
            }
        });
        actionsContainer.add(listarEquipamentos);

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
                    if (addContainer.getComponentCount() > 1) {
                        addContainer.remove(1);
                    }
                    addContainer.add(new JLabel("Equipamento adicionado com sucesso!"));
                    addContainer.revalidate();
                    addContainer.repaint();

                } catch (InputMismatchException error) {
                    if (addContainer.getComponentCount() > 1) {
                        addContainer.remove(1);
                    }

                    if (equipamentos.idExists(idField.getText())) {
                        addContainer.add(new JLabel("Id não pode ser repetido ou vazio!"));
                    } else {
                        addContainer.add(new JLabel("Nome do equipamento não pode ser vazio!"));
                    }
                    addContainer.revalidate();
                    addContainer.repaint();
                } catch (NumberFormatException error) {
                    if (addContainer.getComponentCount() > 1) {
                        addContainer.remove(1);
                    }
                    addContainer.add(new JLabel("Dados inseridos são inválidos!"));
                    addContainer.revalidate();
                    addContainer.repaint();
                } catch (Exception error) {
                    if (addContainer.getComponentCount() > 1) {
                        addContainer.remove(1);
                    }
                    addContainer.add(new JLabel("Erro identificado!"));
                    addContainer.revalidate();
                    addContainer.repaint();
                }
            }

        });

        add(addContainer);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}