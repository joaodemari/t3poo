package dados.Colecao;

import java.util.ArrayList;

import dados.Equipamento.Equipamento;

public class ColecaoEquipamento extends ArrayList<Equipamento> {

    private static ColecaoEquipamento instance;

    private ColecaoEquipamento() {
        super();
    }

    public static ColecaoEquipamento getInstance() {
        if (instance == null) {
            instance = new ColecaoEquipamento();
        }
        return instance;
    }

    public void adicionar(Equipamento equipamento) {
        this.add(equipamento);
    }

    public void remover(Equipamento equipamento) {
        this.remove(equipamento);
    }

    public String[] toNomeArray() {
        String[] nomes = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            nomes[i] = this.get(i).getNome();
        }
        return nomes;
    }

    @Override
    public String[][] toArray() {
        String[][] equipamentosArray = new String[this.size()][4];
        for (int i = 0; i < this.size(); i++) {
            equipamentosArray[i][0] = String.valueOf(this.get(i).getId());
            equipamentosArray[i][1] = this.get(i).getNome();
            equipamentosArray[i][2] = String.valueOf(this.get(i).getCustoDia());
            equipamentosArray[i][3] = this.get(i).getTipo();
        }
        return equipamentosArray;
    }

    public boolean idExists(String id) {
        try {
            int idInt = Integer.parseInt(id);
            for (Equipamento equipamento : this) {
                if (equipamento.getId() == idInt) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            return false; // Se não puder converter para int, o ID não existe.
        }
        return false;
    }

    public Equipamento getEquipamentoByNome(String nome) {
        for (Equipamento equipamento : this) {
            if (equipamento.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return equipamento;
            }
        }
        return null;
    }
}