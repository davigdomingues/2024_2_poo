import java.util.Locale; /*A classe Locale em Java, que faz parte do pacote java.util,
é usada para representar uma região geográfica, política ou cultural específica.
Ela é essencial para a internacionalização de aplicativos, permitindo que o software
se adapte a diferentes convenções de idioma, formatação de datas, números, moedas, etc.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mirela = new Scanner(System.in);
        String opcao;
        int i;
        mirela.useLocale(Locale.US);  // Define a localidade para US

        do {
            System.out.print("Informe quantos numeros deseja realizar a operacao a ser decidida: ");
            int N = mirela.nextInt();

            while (N <= 0){
                System.out.print("Informe quantos numeros deseja realizar a operacao a ser decidida: ");
                N = mirela.nextInt();
            }

            System.out.println();
            double[] vetorN = new double[N];

            for (i = 0; i < N; i++){
                System.out.print("Numero " + (i + 1) + ": ");
                vetorN[i] = mirela.nextDouble();
            }

            System.out.println("Qual das operacoes deseja executar?");
            System.out.println("\nsoma");
            System.out.println("media");
            System.out.println("maior");
            System.out.println("menor");
            System.out.println("exit");
            System.out.print("\nOpcao: ");
            opcao = mirela.next();

            Operacoes.processo(opcao, N, vetorN);

        } while (opcao.equals("soma") || opcao.equals("media") || opcao.equals("maior") || opcao.equals("menor"));

        mirela.close();
    }
}