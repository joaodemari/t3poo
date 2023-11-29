package files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import dados.Colecao.ColecaoEquipamento;
import dados.Equipamento.*;

public class lerArquivoEquipamentos<T> {

    private ColecaoEquipamento colecao;

    public lerArquivoEquipamentos(Scanner entrada, ArrayList<T> equipamentos) {
        this.colecao = (ColecaoEquipamento) equipamentos;
        while (entrada.hasNextLine()) {
            try {
                String linha = entrada.nextLine();
                String[] dados = linha.split(";");
                dados = Arrays.stream(dados)
                        .map(String::trim)
                        .toArray(String[]::new);
                Equipamento equipamento = null;
                switch (dados[4]) {
                    case "1":
                        equipamento = new Barco(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]),
                                Integer.parseInt(dados[5]));
                        break;
                    case "2":
                        equipamento = new CaminhaoTanque(Integer.parseInt(dados[0]), dados[1],
                                Double.parseDouble(dados[2]),
                                Double.parseDouble(dados[5]));
                        break;
                    case "3":
                        equipamento = new Escavadeira(Integer.parseInt(dados[0]), dados[1],
                                Double.parseDouble(dados[2]),
                                Combustivel.getCombustivel(dados[5]), Double.parseDouble(dados[6]));
                        break;
                    default:
                        break;
                }
                if (equipamento == null) {
                    throw new InputMismatchException("Tipo de equipamento inválido.");
                }
                colecao.adicionar(equipamento);
            } catch (Exception e) {
                System.out.println("erro");
                System.out.println(e);
            }
        }
    }
}
