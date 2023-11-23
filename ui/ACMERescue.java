import dados.Equipamento.Colecao;

public class ACMERescue {

    private Colecao equipamentos;

    public ACMERescue() {
        equipamentos = new Colecao();
        new MenuEquipamento(equipamentos);

    }

}