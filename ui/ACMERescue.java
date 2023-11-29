import java.io.File;

import dados.Colecao.ColecaoEquipamento;
import dados.Equipamento.Equipamento;
import files.ReceberArquivo;

public class ACMERescue {

    private ColecaoEquipamento equipamentos;

    public ACMERescue() {
        this.equipamentos = new ColecaoEquipamento();
        new ReceberArquivo<Equipamento>("files/example/EXEMPLO-EQUIPAMENTOS.CSV", equipamentos).lerDados();
        new SystemUI(equipamentos);

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