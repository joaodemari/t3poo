package dados.Equipamento;

import java.util.ArrayList;

public class Colecao {

    private ArrayList<Equipamento> equipamentos;

    public Colecao() {
        equipamentos = new ArrayList<Equipamento>();
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void adicionar(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void remover(Equipamento equipamento) {
        equipamentos.remove(equipamento);
    }

    public String[][] getEquipamentosAsArray() {
        String[][] equipamentosArray = new String[equipamentos.size()][3];
        for (int i = 0; i < equipamentos.size(); i++) {
            equipamentosArray[i][0] = String.valueOf(equipamentos.get(i).getId());
            equipamentosArray[i][1] = equipamentos.get(i).getNome();
            equipamentosArray[i][2] = String.valueOf(equipamentos.get(i).getCustoDia());
        }
        return equipamentosArray;
    }
}
