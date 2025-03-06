import java.util.Scanner;

public class Matriz {
    private static Scanner sc;
    static void verificar(int valor){
        sc = new Scanner(System.in);

        while (valor <= 0){
            System.out.print("Informe um valor estritamente positivo e inteiro: ");
            valor = sc.nextInt();
        }
    }

    static void preencher(int[][] matriz, int linha, int coluna){
        sc = new Scanner(System.in);

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++){
                System.out.print("Valor da linha " + (i+1) + " coluna " + (j+1) + ": ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public void multiplicacaoMatriz(int linhas1, int linhas2, int colunas2, int[][] matriz1, int[][] matriz2){
        int[][] resultado = new int[linhas1][colunas2];

        for (int i = 0; i < linhas1; i++){
            for (int j = 0; j< colunas2; j++){
                for (int k = 0; k < linhas2; k++)
                    resultado[i][j] += matriz1[i][k] + matriz2[k][j];
            }
        }

        for (int i = 0; i < linhas1; i++){
            for (int j = 0; j < colunas2; j++)
                System.out.print(resultado[i][j] + " \t");
            System.out.print("\n");
        }
    }
}