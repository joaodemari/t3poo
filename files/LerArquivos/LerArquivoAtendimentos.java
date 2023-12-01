package files.LerArquivos;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEvents;
import dados.events.Event;
import dados.Atendimento.Atendimento;
import dados.Atendimento.Status;

public class LerArquivoAtendimentos {

    public LerArquivoAtendimentos(Scanner entrada, ColecaoAtendimento atendimentos, ColecaoEvents events) {
        while (entrada.hasNextLine()) {
            try {
                String linha = entrada.nextLine();
                String[] dados = linha.split(";");
                dados = Arrays.stream(dados)
                        .map(String::trim)
                        .toArray(String[]::new);

                int cod = Integer.parseInt(dados[0]);
                System.out.println(cod);

                String dataInicio = dados[1];

                System.out.println(dataInicio);
                int duracao = Integer.parseInt(dados[2]);
                System.out.println(duracao);
                Status status = Status.getStatus(dados[3]);
                System.out.println(status);

                Event event = events.getEventByCodiigo(dados[4]);
                if (event == null)
                    throw new Exception("Evento não encontrado.");
                Atendimento atendimento = new Atendimento(cod, dataInicio, duracao, event);
                atendimento.setStatus(status);

                atendimentos.adicionar(atendimento);
            } catch (Exception e) {
                System.out.println("Erro ao ler a linha do arquivo de atendimentos.");
                System.out.println(e.getMessage());
            }
        }
    }
}
