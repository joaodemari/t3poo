package files;

// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import dados.Colecao.ColecaoEquipamento;
import dados.Equipamento.Equipamento;

public class ReceberArquivo<T> {
    private Scanner entrada = new Scanner(System.in); // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out; // Guarda a saida padrao - tela(console)
    private ArrayList<T> colecao;

    // Construtor
    public ReceberArquivo(String pathDoArquivo, ArrayList<T> colecao) {
        this.colecao = colecao;
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader(pathDoArquivo));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida); // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);

        // Implemente aqui o seu codigo adicional do construtor
    }

    // Restaura E/S padrao de tela(console)/teclado
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }

    public void lerDados() {
        String primeiraLinha = entrada.nextLine();
        switch (primeiraLinha) {
            case "identificador;nome;custodiario;codinome;tipo;capacidade_combustivel;carga":
                new lerArquivoEquipamentos<T>(entrada, colecao);
                break;
            case "codinome;quantidade;latitude;longitude":
                new lerArquivoEquipes<T>(entrada, colecao);
                break;
            default:
                break;
        }
    }

}