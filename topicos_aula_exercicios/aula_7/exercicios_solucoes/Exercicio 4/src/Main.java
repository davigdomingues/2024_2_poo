import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Hello and welcome!\nInforme a operacao de interesse:\n");
        System.out.println("(1) adicao\n(2) subtracao\n(3) multiplicacao");
        String operacao = sc.nextLine();

        // Leitura simultanea de dois numeros separados por espaco:
        System.out.println("Digite dois números (separados por espaço):");
        String input = sc.nextLine(); // Lê toda a linha de entrada.

        String[] numeros = input.split(" "); /*Divide a linha em um array de strings,
        usando o espaço como delimitador.*/
        int a = Integer.parseInt(numeros[0]); //Converte as strings em inteiros.
        int b = Integer.parseInt(numeros[1]);

        System.out.println("Resultado: " + operacaoMatematica(a, b, operacao));
    }

    public static int operacaoMatematica(int a, int b, String operacaoInformada){
        if (operacaoInformada.equalsIgnoreCase("adicao"))
            return a + b;

        else if (operacaoInformada.equalsIgnoreCase("subtracao"))
            return a - b;

        else if (operacaoInformada.equalsIgnoreCase("multiplicacao"))
            return a * b;

        try {
            throw new IOException("Operacao informada eh invalida");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}