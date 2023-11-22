
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import dados.Equipamento.Colecao;
import dados.Equipamento.Equipamento;

public class ACMERescue {

    private Colecao equipamentos;

    public ACMERescue() {
        equipamentos = new Colecao();

        Equipamento equip1 = new Equipamento(1, "Equipamento 1", 10.0);
        Equipamento equip2 = new Equipamento(2, "Equipamento 2", 15.0);

        equipamentos.adicionar(equip1);
        equipamentos.adicionar(equip2);

        System.out.println(equipamentos.toString());

        // Criar a janela e passar a equipamentos de equipamentos

        new MenuEquipamento(equipamentos);

    }

}