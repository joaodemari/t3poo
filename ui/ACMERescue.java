import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import dados.Equipe;
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

    public ACMERescue() {
        this.equipamentos = new ColecaoEquipamento();
        this.equipes = new ColecaoEquipe();
        this.atendimentos = new ColecaoAtendimento();
        new ReceberArquivo<Equipamento>("files/example/EXEMPLO-EQUIPAMENTOS.CSV", equipamentos).lerDados();
        new ReceberArquivo<Equipe>("files/example/EXEMPLO-EQUIPES.CSV", equipes).lerDados();
        new ReceberArquivo<Event>("files/example/EXEMPLO-EVENTOS.CSV", events).lerDados();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SystemUI(equipamentos, atendimentos, equipes, events);
                frame.setVisible(true);
            }
        });

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