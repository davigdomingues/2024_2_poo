import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> conjunto1 = new HashSet<>();
		Set<Integer> conjunto2 = new HashSet<>();

		System.out.print("Quantos numeros deseja inserir no set 1? ");
		int totalNumeros1 = sc.nextInt();

		for (int i = 0; i < totalNumeros1; i++) {
			System.out.print("Numero " + (i+1) + ": ");
			int numero = sc.nextInt();
			conjunto1.add(numero);
		}

		System.out.print("\nQuantos numeros deseja inserir no set 2? ");
		int totalNumeros2 = sc.nextInt();

		for (int i = 0; i < totalNumeros2; i++) {
			System.out.print("Numero " + (i+1) + ": ");
			int numero = sc.nextInt();
			conjunto2.add(numero);
		}

		Set<Integer> uniao = new HashSet<>(conjunto1);
		Set<Integer> interseccao = new HashSet<>(conjunto1);

		uniao.addAll(conjunto2);
		interseccao.retainAll(conjunto2);

		System.out.println("\nUniao " + uniao);
		System.out.println("Interseccao " + interseccao);

		sc.close();
	}
}