import java.util.Scanner;
public class MinMaxArray {
    public static double[] preencherArray(double[] array, int limite){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < limite; i++){
            System.out.print("Valor do elemento " + (i + 1) + ": ");
            array[i] = sc.nextDouble();
        }

        return array;
    }
    public static double maiorElemento(double[] array, int limite){
        double maior = 0.0;
        for (int i = 0; i < limite; i++)
            maior = Math.max(array[i], array[0]);
        return  maior;
    }

    public static double menorElemento(double[] array, int limite){
        double menor = 0.0;
        for (int i = 0; i < limite; i++)
            menor = Math.min(array[i], array[0]);
        return  menor;
    }
}