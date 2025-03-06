import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        if (args.length < 4) {
            System.out.println("Por favor, forneça quatro argumentos: linha1 coluna1 linha2 coluna2.");
            return;
        }

        int linha1 = Integer.parseInt(args[0]);
        int coluna1 = Integer.parseInt(args[1]);
        int linha2 = Integer.parseInt(args[2]);
        int coluna2 = Integer.parseInt(args[3]);

        if (linha1 == linha2 && coluna1 == coluna2){
            MatrizSoma soma = new MatrizSoma(linha1, coluna1);
            soma.preencherMatriz1();
            soma.preencherMatriz2();

            int[][] valorFinal = soma.somaMatrizes();
            System.out.println(Arrays.deepToString(valorFinal));
        } else {
            System.out.println("Soma de matrizes impossivel de ser realizada!");
        }
    }
}