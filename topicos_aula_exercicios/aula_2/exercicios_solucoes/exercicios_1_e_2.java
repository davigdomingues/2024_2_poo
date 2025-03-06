public class Fibonacci { // printar na tela os 10 primeiros termos da sequência de Fibonacci (fn = fn-1 + fn-2) --> exercícios 1 e 2.

  public static void main(String[] args) {
   
	int a = 0, b = 1, termo = 0, somatorio = 0;
	int[] termos = new int[10];
	float media = 0.0F;
   
	System.out.println("10 primeiros termos da sequencia de Fibonacci:");
   
	for (int i = 0; i < termos.length; i++){
		termo = b + a;
		termos[i] = termo;
		System.out.println(termo + "");
		b = a;
		a = termo;
		somatoria += termos[i];
	}
	media = (float)somatoria/termos.length;
 
	System.out.println("Media aritmetica dos 10 primeiros termos da sequencia de Fibonacci: " + media);
	System.out.println("Somatoria dos 10 primeiros termos da sequencia de Fibonacci: " + somatoria);
  }
}