import java.util.Scanner;
public class MatrizSoma {
    private final int[][] matriz1;
    private final int[][] matriz2;
    private final Scanner sc;

    public MatrizSoma(int linhas, int colunas) { //construtor de inicialização padrão.
        matriz1 = new int[linhas][colunas];
        matriz2 = new int[linhas][colunas];
        sc = new Scanner(System.in);
    }

    void preencherMatriz1() {
        for (int i = 0; i < matriz1.length; i++){
            for (int j = 0; j < matriz1[0].length; j++){
                System.out.print("Valor do elemento da matriz 1, linha " + (i + 1) + " coluna " + (j + 1) + ": ");
                matriz1[i][j] = sc.nextInt();
            }
        }
        System.out.print("\n");
    }

    void preencherMatriz2() {
        for (int i = 0; i < matriz2.length; i++){
            for (int j = 0; j < matriz2[0].length; j++){
                System.out.print("Valor do elemento da matriz 2, linha " + (i + 1) + " coluna " + (j + 1) + ": ");
                matriz2[i][j] = sc.nextInt();
            }
        }
        System.out.print("\n");
    }

    public int[][] somaMatrizes() {
        int[][] matrizFinal = new int[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++){
            for (int j = 0; j < matriz1[0].length; j++){
                matrizFinal[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizFinal;
    }
}