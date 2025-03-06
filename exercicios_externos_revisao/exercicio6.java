import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    ArrayList<String> listaNomesArray = new ArrayList<>();
	    Scanner scanner = new Scanner(System.in);
	    
	    int opcao;
	    String nomeAdicionar, nomeRemover, nomeBuscado;
	    
	    do{
	        System.out.println("(1) Adicionar nomes na lista");
	        System.out.println("(2) Imprimir todos os nomes da lista");
	        System.out.println("(3) Remover nome lista");
	        System.out.println("(4) Verificar se um nome esta na lista");
	        System.out.println("(5) Sair");
	        opcao = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(opcao){
	            case 1:
	                System.out.print("Qual nome deseja adicionar na lista? ");
	                nomeAdicionar = scanner.nextLine();
	                listaNomesArray.add(nomeAdicionar);
	                break;
	                
	            case 2:
	                System.out.println("Lista atual de nomes:");
	                for (String nome : listaNomesArray)
	                    System.out.println(nome);
	                break;
	                
	            case 3:
	                System.out.print("Qual nome deseja remover na lista? ");
	                nomeRemover = scanner.nextLine();
	                listaNomesArray.remove(nomeRemover);
	                break;
	                
	            case 4:
	                System.out.print("Qual nome deseja procurar na lista? ");
	                nomeBuscado = scanner.nextLine();
	                
	                if (listaNomesArray.contains(nomeBuscado)){
	                    System.out.println("O nome " + nomeBuscado + " esta na lista, na posicao " + listaNomesArray.indexOf(nomeBuscado));
	                    
	                    System.out.println("Nomes após a remoção:");
                        Iterator<String> iterator = listaNomesArray.iterator();
                    
                        while (iterator.hasNext())
                            System.out.println(iterator.next());
	                }
	                    
	                else 
	                    System.out.println("O nome " + nomeBuscado + " nao esta na lista");
	                    
	                break;
	                
	            case 5:
	                System.out.println("Saindo...");
	                break;
	        }
	        
	    } while (opcao != 5);
		
		scanner.close();
	}
}