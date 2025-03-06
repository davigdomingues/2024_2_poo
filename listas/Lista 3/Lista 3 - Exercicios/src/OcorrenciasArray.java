import java.util.Scanner;
public class OcorrenciasArray {
    public static void preencherArray(int[] array){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++){
            System.out.print("Valor do elemento " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

    }

    public static void operacoesArray(int[] array, int numeroInformado){
        int count = 0, k = 0;
        int[] aux = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroInformado) {
                aux[k] = i;
                k++;
                count++;
            }
        }

        if (count >= 2) System.out.print("[" + count + ", " + aux[k - 1] + "]");
        else if(count == 1) System.out.println("[" + numeroInformado + ", -1]");
        else System.out.print("[-1, -1]");
    }
}