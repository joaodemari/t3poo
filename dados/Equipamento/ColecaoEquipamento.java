package dados.Equipamento;

import java.util.ArrayList;

public class ColecaoEquipamento {

    private ArrayList<Equipamento> equipamentos;

    public ColecaoEquipamento() {
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
        String[][] equipamentosArray = new String[equipamentos.size()][4];
        for (int i = 0; i < equipamentos.size(); i++) {
            equipamentosArray[i][0] = String.valueOf(equipamentos.get(i).getId());
            equipamentosArray[i][1] = equipamentos.get(i).getNome();
            equipamentosArray[i][2] = String.valueOf(equipamentos.get(i).getCustoDia());
            equipamentosArray[i][3] = equipamentos.get(i).getTipo();
        }
        return equipamentosArray;
    }

    public boolean idExists(String id) {
        try {
            int idInt = Integer.parseInt(id);
            for (Equipamento equipamento : equipamentos) {
                if (equipamento.getId() == idInt) {
                    return true;
                }
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
