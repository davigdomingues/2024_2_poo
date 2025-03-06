import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    LinkedHashSet<Integer> listaInteirosSemDuplicatas = new LinkedHashSet<Integer>();
	    
	    System.out.print("Quantos numeros deseja inserir? ");
	    int totalNumeros = sc.nextInt();
	    
	    for (int i = 0; i < totalNumeros; i++){
	        System.out.print("Numero " + (i+1) + ": ");
	        int numero = sc.nextInt();
	        listaInteirosSemDuplicatas.add(numero);
	    }
	    
	    List<Integer> listaInteiros = new ArrayList<Integer>(listaInteirosSemDuplicatas);
	    Collections.sort(listaInteiros);
	    
		System.out.println("Lista de inteiros ordenada e sem duplicatas:");
		for (Integer resultado : listaInteiros)
		    System.out.print(resultado + " ");
		    
		sc.close();
	}
}