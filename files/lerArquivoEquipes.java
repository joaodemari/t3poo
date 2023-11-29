package files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dados.Colecao.ColecaoEquipe;
import dados.Equipe;

public class lerArquivoEquipes<T> {

    private ColecaoEquipe colecao;

    public lerArquivoEquipes(Scanner entrada, ArrayList<T> equipes) {
        this.colecao = (ColecaoEquipe) equipes;
        while (entrada.hasNextLine()) {
            try {
                String linha = entrada.nextLine();
                String[] dados = linha.split(";");
                dados = Arrays.stream(dados)
                        .map(String::trim)
                        .toArray(String[]::new);

                String codinome = dados[0];
                int quantidadeMembros = Integer.parseInt(dados[1]);
                double latitude = Double.parseDouble(dados[2]);
                double longitude = Double.parseDouble(dados[3]);

                Equipe equipe = new Equipe(codinome, quantidadeMembros, latitude, longitude);
                colecao.adicionarEquipe(equipe);
            } catch (Exception e) {
                System.out.println("Erro ao ler a linha do arquivo de equipes.");
                System.out.println(e);
            }
        }
    }
}
