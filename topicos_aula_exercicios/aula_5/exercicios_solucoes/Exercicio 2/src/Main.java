import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o total de linhas da primeira matriz de interesse: ");
        int linhas1 = sc.nextInt();
        Matriz.verificar(linhas1);

        System.out.print("Informe o total de colunas da matriz de interesse: ");
        int colunas1 = sc.nextInt();
        Matriz.verificar(colunas1);

        System.out.print("Informe o total de linhas da segunda matriz de interesse: ");
        int linhas2 = sc.nextInt();
        Matriz.verificar(linhas2);

        System.out.print("Informe o total de colunas da segunda matriz de interesse: ");
        int colunas2 = sc.nextInt();
        Matriz.verificar(colunas2);

        int[][] matriz1 = new int[linhas1][colunas1];
        int[][] matriz2 = new int[linhas2][colunas2];

        if (linhas2 == colunas1){
            Matriz matrix = new Matriz();

            Matriz.preencher(matriz1, linhas1, colunas1);
            Matriz.preencher(matriz2, linhas2, colunas2);
            matrix.multiplicacaoMatriz(linhas1, linhas2, colunas2, matriz1, matriz2);
        }

        else System.out.println("Multiplicacao matricial inexistente!");
    }
}