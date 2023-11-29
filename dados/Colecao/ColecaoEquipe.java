package dados.Colecao;

import java.util.ArrayList;

import dados.Equipe;

public class ColecaoEquipe extends ArrayList<Equipe> {

    public ColecaoEquipe() {
        super();
    }

    public void adicionarEquipe(Equipe equipe) {
        this.add(equipe);
    }

    public void removerEquipe(Equipe equipe) {
        this.remove(equipe);
    }

    public String[] toCodinomeArray() {
        String[] codinomes = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            codinomes[i] = this.get(i).getCodigo();
        }
        return codinomes;
    }

    public Equipe getEquipeByCodinome(String codinome) {
        for (Equipe equipe : this) {
            if (equipe.getCodigo().toLowerCase().contains(codinome.toLowerCase())) {
                return equipe;
            }
        }
        return null;
    }

    public String[][] toMatrix() {
        String[][] equipesArray = new String[this.size()][4];
        for (int i = 0; i < this.size(); i++) {
            equipesArray[i][0] = this.get(i).getCodigo();
            equipesArray[i][1] = String.valueOf(this.get(i).getQuantidadeMembros());
            equipesArray[i][2] = String.valueOf(this.get(i).getLatitude());
            equipesArray[i][3] = String.valueOf(this.get(i).getLongitude());
        }
        return equipesArray;
    }

    public boolean codinomeExists(String codinome) {
        for (Equipe equipe : this) {
            if (equipe.getCodigo().equals(codinome)) {
                return true;
            }
        }
        return false;
    }
}
