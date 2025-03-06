import java.util.Scanner;

public class Somatorio { // termo geral = (-1)^n * (5*(i+1)/(2+i)) {primeiro termo é o A0 = 5/2}

    public static void main(String[] args){
        float soma1 = 0.0F, soma2 = 0.0F, soma = 0.0F, n; //obs: 0.0F é o mesmo que apenas 0.
       
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o total de termos de interesse para a execucao da soma: ");
        n = entrada.nextFloat();
       
        for (float i = 0F; i < n; i++) //cuidado com o casting do programa!!!
            soma += (Math.pow(-1, i))*(5*(i+1)/(2+i));
       
        System.out.println("");
        System.out.println("Resultado da soma dos n primeiros termos: " + soma);
    }
}