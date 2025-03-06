public class Main {
    public static void main(String[] args) {
        Integer[] vetor = {1, 2, 3, 4, 5};
        imprimeVetor(vetor);
        Double[] vetorDouble = {1.1, 2.2, 3.3, 4.4, 5.5};
        imprimeVetor(vetorDouble);
        Character[] vetorChar = {'a', 'b', 'c', 'd', 'e'};
        imprimeVetor(vetorChar);
    }

    public static void imprimeVetor(Object[] vetor){
        System.out.print("Esse é o vetor de entrada: ");
        for (Object o : vetor)
            System.out.print(o + " ");
        System.out.println();
    }
}

/*
idem a:
public class Main{
    public static void main(String[] args) {
        Integer[] vetor = {1, 2, 3, 4, 5};
          imprimeVetor(vetor);
        Double[] vetorDouble = {1.1, 2.2, 3.3, 4.4, 5.5};
        imprimeVetor(vetorDouble);
        Character[] vetorChar = {'a', 'b', 'c', 'd', 'e'};
        imprimeVetor(vetorChar);
    }

    public static <T> void imprimeVetor(T[] vetor){
        System.out.print("Esse é o vetor de entrada: ");
        for (int i = 0; i < vetor.length; i++)
            System.out.print(vetor[i] + " ");
        System.out.println();
    }
}
 */