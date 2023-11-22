import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        // Inicio
        try {
            Scanner s = new Scanner(System.in);
            int x = s.nextInt();
            List<Integer> a = new ArrayList<>(x);
            int y = s.nextInt();
            a.set(y, x);
            System.out.println(x / y);
        } catch (IllegalArgumentException e) {
            throw new Error("Erro de parametro Inválido");
        } catch (ArithmeticException e) {
            throw new Error("Erro de divisão por 0");
        } catch (IndexOutOfBoundsException e) {
            throw new Error("Erro de índice inválido");
        } catch (NumberFormatException e) {
            throw new Error("Erro de tipo inválido");
        } catch (Exception e) {
            throw new Error("Erro geral");
        }
        // Fim
    }
}
