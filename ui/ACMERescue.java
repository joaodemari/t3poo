import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import dados.Equipe;
import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEquipamento;
import dados.Colecao.ColecaoEquipe;
import dados.Equipamento.Equipamento;
import files.ReceberArquivo;

public class ACMERescue {

    private ColecaoEquipamento equipamentos;
    private ColecaoEquipe equipes;
    private ColecaoAtendimento atendimentos;

    public ACMERescue() {
        this.equipamentos = new ColecaoEquipamento();
        this.equipes = new ColecaoEquipe();
        this.atendimentos = new ColecaoAtendimento();
        new ReceberArquivo<Equipamento>("files/example/EXEMPLO-EQUIPAMENTOS.CSV", equipamentos).lerDados();
        new ReceberArquivo<Equipe>("files/example/EXEMPLO-EQUIPES.CSV", equipes).lerDados();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SystemUI(equipamentos, atendimentos, equipes);
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