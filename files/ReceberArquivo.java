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

import dados.Colecao.*;
import dados.Equipamento.Equipamento;
import files.LerArquivos.LerArquivoAtendimentos;
import files.LerArquivos.LerArquivoEquipes;
import files.LerArquivos.lerArquivoEquipamentos;

public class ReceberArquivo {
    private Scanner entrada = new Scanner(System.in); // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out; // Guarda a saida padrao - tela(console)

    // Construtor
    public ReceberArquivo(String pathDoArquivo) {
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
                ColecaoEquipamento equipamentos = ColecaoEquipamento.getInstance();
                new lerArquivoEquipamentos(entrada, (ColecaoEquipamento) equipamentos);
                break;

            case "codinome;quantidade;latitude;longitude":
                ColecaoEquipe equipes = ColecaoEquipe.getInstance();
                new LerArquivoEquipes(entrada, (ColecaoEquipe) equipes);
                break;

            case "cod;dataInicio;duracao;status;codigo":
                ColecaoAtendimento atendimentos = ColecaoAtendimento.getInstance();
                new LerArquivoAtendimentos(entrada, (ColecaoAtendimento) atendimentos);
                break;
            default:
                // Handle other cases or show an error message
                break;
        }

    }

}