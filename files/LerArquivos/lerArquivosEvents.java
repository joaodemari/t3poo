package files.LerArquivos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dados.Colecao.ColecaoEvents;
import dados.events.Event;

public class lerArquivosEvents<t> {

    private ColecaoEvents colecao;

    public lerArquivosEvents(Scanner entrada, ArrayList<t> events) {
        this.colecao = (ColecaoEvents) events;
        while (entrada.hasNextLine()) {
            try {
                String linha = entrada.nextLine();
                String[] dados = linha.split(";");
                dados = Arrays.stream(dados)
                        .map(String::trim)
                        .toArray(String[]::new);
                String codigo = dados[0];
                String data = dados[1];
                double latitude = Double.parseDouble(dados[2]);
                double longitude = Double.parseDouble(dados[3]);

                Event event = new Event(codigo, data, latitude, longitude);
                colecao.adicionarEvent(event);
            } catch (Exception e) {
                System.out.println("Erro ao ler a linha do arquivo de eventos.");
                System.out.println(e);
            }
        }
    }
}
