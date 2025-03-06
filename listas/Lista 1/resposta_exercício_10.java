import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.print("Palavra: ");
		String palavra = sc.nextLine();
		
		for (int i = 0; i < palavra.length(); i++){
		    int caractere = (palavra.charAt(i));
		    System.out.println(palavra.charAt(i) + " = " + caractere);
		}
		
	}
}