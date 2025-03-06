import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> numeros = new java.util.LinkedList<>();
        String opcao;
        Scanner sc = new Scanner(System.in);
        int x, n, repeticao = 0;

        System.out.print("Informe o total de numeros a serem declarados: ");
        n = sc.nextInt();
        System.out.println("Declaracao de numeros inteiros:");

        do {
            System.out.println("Repeticao " + repeticao + ": ");
            for (int i = 0; i < n; i++){
                do{
                    System.out.print("Valor " + (i+1) + ": ");
                    x = sc.nextInt();
                } while (numeros.contains(x));
                numeros.add(i, x);
            }

            System.out.println("\nImpressao dos valores ate agora declarados:");
            for (Integer numero : numeros)
                System.out.println(numero);
            System.out.println();

            for (int i = 0; i < n; i++)
                numeros.add(i, 0);
            repeticao++;

            sc.nextLine();
            System.out.println("Deseja continuar a leitura de numeros? Se sim, digite /'sair'/");
            opcao = sc.nextLine();
            System.out.println();

        } while(!opcao.equalsIgnoreCase("sair"));
    }
}