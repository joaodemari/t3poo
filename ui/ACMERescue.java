import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dados.Equipe;
import dados.Atendimento.Atendimento;
import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEquipamento;
import dados.Colecao.ColecaoEquipe;
import dados.Colecao.ColecaoEvents;
import dados.Equipamento.Equipamento;
import dados.events.Event;
import files.ReceberArquivo;

public class ACMERescue {

    private ColecaoEquipamento equipamentos;
    private ColecaoEquipe equipes;
    private ColecaoAtendimento atendimentos;
    private ColecaoEvents events;
    private JFrame frame;
    private JPanel sistema;

    public ACMERescue() {
        this.equipamentos = ColecaoEquipamento.getInstance();
        this.equipes = ColecaoEquipe.getInstance();
        this.atendimentos = ColecaoAtendimento.getInstance();
        this.events = ColecaoEvents.getInstance();
        new ReceberArquivo("files/example/EXEMPLO-EQUIPAMENTOS.CSV").lerDados();
        new ReceberArquivo("files/example/EXEMPLO-EQUIPES.CSV").lerDados();
        new ReceberArquivo("files/example/EXEMPLO-EVENTOS.CSV").lerDados();
        new ReceberArquivo("files/example/EXEMPLO-ATENDIMENTOS.CSV").lerDados();
        this.frame = new JFrame("ACME Rescue");
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);
        frame.setLayout(boxLayout);
        frame.setLayout(new FlowLayout());
        frame.setSize(1300, 600);
        frame.setResizable(false);
        JButton button = new JButton("refresh");
        sistema = new SystemUI(equipamentos, atendimentos, equipes, events);
        button.addActionListener(e -> {
            frame.remove(sistema);
            sistema = new SystemUI(equipamentos, atendimentos, equipes, events);
            frame.add(sistema);
            frame.repaint();
            frame.revalidate();
        });
        frame.add(button);
        frame.add(sistema);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}