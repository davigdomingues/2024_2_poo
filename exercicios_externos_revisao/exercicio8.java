import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    List<Integer> listaInteiros = new ArrayList<>();
	    
	    System.out.print("Quantos numeros deseja inserir? ");
	    int totalNumeros = sc.nextInt();
	    
	    for (int i = 0; i < totalNumeros; i++){
	        System.out.print("Numero " + (i+1) + ": ");
	        int numero = sc.nextInt();
	        listaInteiros.add(numero);
	    }
	    
	    Collections.sort(listaInteiros);
	    
		System.out.println("Lista de inteiros ordenada:");
		for (Integer resultado : listaInteiros)
		    System.out.print(resultado + " ");
		    
		sc.close();
	}
}