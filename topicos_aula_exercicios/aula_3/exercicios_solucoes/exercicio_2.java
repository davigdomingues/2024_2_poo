import java.util.Scanner;
class Serie{
    public static void main(String[] args){
        double media = 0.0;
        double maior = 0, menor = 0;
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Informe um total de numeros a serem declarados: ");
        int N = sc.nextInt();
        sc.nextLine();
       
        System.out.println("");
        while (N <= 0){
            System.out.println("Tem que ser um numero positivo cara kkkkkkkkkkkk");
            System.out.print("Informe um total de numeros a serem declarados: ");        
            N = sc.nextInt();
            sc.nextLine(); //libera buffer de memória.
            System.out.println("");
        }
       
        for (int i = 0; i < N; i++){
            System.out.print("Valor " + (i + 1) + ": ");
            double valor = sc.nextDouble();
           
            if (valor <= 0){
                System.out.print("Numero negativo ou nulo encontrado.... calculo interrompido");
                break;
            }
           
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
           
            media += valor;
           
            if (i == N - 1){
                System.out.println("");
                media /= 5;
                System.out.println("Maior valor: " + maior);
                System.out.println("Menor valor: " + menor);
                System.out.println("Media dos valores: " + media);
            }
        }
    }
}