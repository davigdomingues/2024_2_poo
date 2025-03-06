import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Queue<String> filaDeImpressao = new LinkedList<>();
	    Scanner sc = new Scanner(System.in);
	    
		System.out.print("Quantas tarefas deseja adicionar a fila? ");
		int limite = sc.nextInt();
		sc.nextLine();
		
		System.out.println("");
		for (int i = 0; i < limite; i++){
		    System.out.print("Tarefa " + (i+1) + ": ");
		    String tarefa = sc.nextLine();
		    filaDeImpressao.add(tarefa);
		}
		
		System.out.println("\nQueue final gerada:");
		for (String tarefasEmOrdem : filaDeImpressao)
		    System.out.println(tarefasEmOrdem);
	}
}