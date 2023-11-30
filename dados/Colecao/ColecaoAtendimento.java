package dados.Colecao;

import java.util.ArrayList;

import dados.Atendimento.Atendimento;

public class ColecaoAtendimento extends ArrayList<Atendimento> {

    private static ColecaoAtendimento instance;

    private ColecaoAtendimento() {
        super();
    }

    public static ColecaoAtendimento getInstance() {
        if (instance == null) {
            instance = new ColecaoAtendimento();
        }
        return instance;
    }

    public void adicionar(Atendimento atendimento) {
        this.add(atendimento);
    }

    public void remover(Atendimento atendimento) {
        this.remove(atendimento);
    }

    public String[][] toArray() {
        String[][] atendimentosArray = new String[this.size()][4];
        for (int i = 0; i < this.size(); i++) {
            atendimentosArray[i][0] = String.valueOf(this.get(i).getCod());
            atendimentosArray[i][1] = String.valueOf(this.get(i).getDataInicio());
            atendimentosArray[i][2] = String.valueOf(this.get(i).getDuracao());
            atendimentosArray[i][3] = this.get(i).getStatus().toString();
        }
        return atendimentosArray;
    }

    // Implemente métodos específicos, se necessário

    public boolean codExists(int cod) {
        for (Atendimento atendimento : this) {
            if (atendimento.getCod() == cod) {
                return true;
            }
        }
        return false;
    }
}
