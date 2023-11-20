package dados.Equipamento;

import java.util.ArrayList;

public class Colecao {

    private ArrayList<Equipamento> equipamentos;

    public Colecao() {
        equipamentos = new ArrayList<Equipamento>();
    }

    public void adicionar(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void remover(Equipamento equipamento) {
        equipamentos.remove(equipamento);
    }
}
