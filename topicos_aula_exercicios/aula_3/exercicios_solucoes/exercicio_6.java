import java.util.Scanner;
class Euler {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        IntNaoNeg numero = new IntNaoNeg();
       
        System.out.print("Informe o numero inteiro de interesse para a operacao desejada: ");
        int numInteiro = entrada.nextInt();
        entrada.nextLine();
       
        System.out.println("Valor final de aproximacao: " + numero.calculaFatorial(numInteiro));
    }
}