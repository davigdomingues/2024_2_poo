import java.util.Scanner;
public class IntervaloManipulacao {
    int maior = 0, menor = 0;
    int[] array = new int[10000];
    int[] aux = new int[10000];
    int[] arrayFinal = new int[10000];
    Scanner sc = new Scanner(System.in);

    public void maiorOumenor(int a, int b){
        maior = Math.max(a, b);
        menor = Math.min(a, b);
        System.out.println("Digite numeros quaisquer de " + menor + " ate " + maior + ":");
    }

    public void operacoes(){
        int numeroQualquer, i = 0, j = 0;
        String parada;

        do{
            numeroQualquer = sc.nextInt();
            array[i] = numeroQualquer;

            while (array[i] < menor || array[i] > maior){
                System.out.println("\nAmiguinho.... obedece o intervalo, por favor kkkkkk\nVamos tentar de novo:");
                numeroQualquer = sc.nextInt();
                array[i] = numeroQualquer;
            }

            aux[j] = array[i];
            i++;
            j++;

            System.out.println("Deseja interromper o ciclo? (sim - 'fim', nao - qualquer string)");
            parada = sc.next();
        } while (!parada.equals("fim"));
    }

    public void vetorNaoRepetitivo(){
        int count, k = 0;
        for (int i = 0; i < array.length; i++){
            count = 0;
            for (int j = 0; j < aux.length; j++){
                if (array[i] == aux[j]) count++;

                if (count < 2){
                    arrayFinal[k] = array[i];
                    k++;
                }
                if (count >= 2) continue;

                if (array[i] != aux[j]){
                    arrayFinal[k] = aux[i];
                    k++;
                }
            }
        }
    }

    public void vetorFinalImpresso(){
        System.out.println("Numeros informados em sequencia:");
        for (int i = 0; i < arrayFinal.length; i++)
            System.out.println(arrayFinal[i]);
    }
}
