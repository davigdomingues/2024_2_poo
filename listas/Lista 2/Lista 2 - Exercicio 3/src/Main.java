import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = 1;

        while (loop == 1){
            System.out.println("1 - Potencia: ");
            System.out.println("2 - Maximo: ");
            System.out.println("3 - Minimo: ");
            System.out.println("4 - Modulo: ");
            System.out.println("5 - Multiplicar: ");
            System.out.print("Informe quais operações deseja fazer: ");

            int decisao = sc.nextInt();
            sc.nextLine();

            while (decisao < 1 || decisao > 5){
                System.out.print("\nInforme um dos numeros apenas, por favor: ");
                decisao = sc.nextInt();
            }

            /* em casos como StaticMath.potencia(base, expoente), pode-se usar um objeto instan-
            ciado, mas não há necessidade, pois o método pode muito bem ser acessado pela classe
            criada anteriormente. Logo, instanciar um objeto, neste caso, se torna desnecessário.

            Ou seja, não precisa fazer:
            StaticMath operacao = new StaticMath();
            ...
            operacao.potencia(base, expoente);
            ...
             */

            switch (decisao){
                case 1:
                    System.out.print("Informe a base do numero: ");
                    double base = sc.nextDouble();
                    System.out.print("Informe o expoente do numero: ");
                    double expoente = sc.nextDouble();

                    System.out.println("Resultado final: " + StaticMath.potencia(base, expoente));
                    break;

                case 2:
                    System.out.print("Informe o primeiro numero: ");
                    int number1 = sc.nextInt();
                    System.out.print("Informe o segundo numero: ");
                    int number2 = sc.nextInt();

                    System.out.println("Maior numero: " + StaticMath.maximo(number1, number2));
                    break;

                case 3:
                    System.out.print("Informe o primeiro numero numero: ");
                    int a = sc.nextInt();
                    System.out.print("Informe o segundo numero: ");
                    int b = sc.nextInt();

                    System.out.println("Menor numero: " + StaticMath.minimo(a, b));
                    break;

                case 4:
                    System.out.print("Informe o numero: ");
                    int number = sc.nextInt();

                    System.out.println("Modulo do numero (valor absoluto): " + StaticMath.absoluto(number));
                    break;

                case 5:
                    System.out.print("Informe o primeiro numero: ");
                    double c = sc.nextInt();
                    System.out.print("Informe o segundo numero: ");
                    double d = sc.nextInt();

                    System.out.println("Resultado final: " + StaticMath.multiplicar(c, d));
                    break;
            }

            System.out.println("Deseja continuar com outra operacao? (sim - 1, nao - qualquer outro valor)");
            loop = sc.nextInt();
        }
    }
}