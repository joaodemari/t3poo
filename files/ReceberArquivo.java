package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import dados.Colecao.*;
import dados.Equipamento.Equipamento;
import dados.events.Event;
import files.LerArquivos.LerArquivoAtendimentos;
import files.LerArquivos.LerArquivoEquipes;
import files.LerArquivos.lerArquivoEquipamentos;

public class ReceberArquivo<T> {
    private Scanner entrada = new Scanner(System.in);
    private ArrayList<T> colecao;
    private ColecaoEvents events;

    public ReceberArquivo(String pathDoArquivo, ArrayList<T> colecao, ColecaoEvents events) {
        this.colecao = colecao;
        this.events = events;
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader(pathDoArquivo));
            entrada = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        entrada.useLocale(Locale.ENGLISH);
    }

    public ReceberArquivo(String pathDoArquivo, ArrayList<T> colecao) {
        this.colecao = colecao;
        this.events = null;
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader(pathDoArquivo));
            entrada = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        entrada.useLocale(Locale.ENGLISH);
    }

    public void lerDados() {
        String primeiraLinha = entrada.nextLine();
        switch (primeiraLinha) {
            case "identificador;nome;custodiario;codinome;tipo;capacidade_combustivel;carga":
                new lerArquivoEquipamentos(entrada, (ColecaoEquipamento) colecao);
                break;
            case "codinome;quantidade;latitude;longitude":
                new LerArquivoEquipes(entrada, (ColecaoEquipe) colecao);
                break;
            case "cod;dataInicio;duracao;status;codigo":
                new LerArquivoAtendimentos(entrada, (ColecaoAtendimento) colecao, events);
                break;
            default:
                break;
        }
    }
}