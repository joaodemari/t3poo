package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class ExportarArquivo<T> {
    public ExportarArquivo(String pathDoArquivo, Collection<T> dados) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathDoArquivo));

            for (T objeto : dados) {
                writer.write(objeto.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Erro ao exportar dados para o arquivo.");
            e.printStackTrace();
        }
    }
}
