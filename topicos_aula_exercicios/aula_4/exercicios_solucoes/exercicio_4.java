import java.util.Scanner;
public class NumeroPerfeito {
public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int soma = 0, maior, menor;
   //int number = 0;
   
	System.out.print("Informe o primeiro numero de interese: ");
	int num1 = sc.nextInt();

	System.out.print("Informe o primeiro numero de interese: ");
	int num2 = sc.nextInt();

	if (num1 > num2){
		maior = num1;
		menor = num2;
	}

	else {
		maior = num2;
		menor = num1;
	}

	/*Ou se pode usar essa estrutura:
		menor = Math.min(num1, num2);
		maior = Math.max(num1, num2);
		
		number = menor;

	System.out.println("Numeros perfeitos entre " + menor + " e " + maior + ":");
	while (number < maior) {
		//while (number <= menor)
			//number++;
		if (perfect(number, soma) == number)
			System.out.println(number);
		number++;
	}
}

	public static int perfect(int number, int soma){
		for (int i = 1; i < number; i++)
			if (number%i == 0) soma += i;
		return soma;
	}
}