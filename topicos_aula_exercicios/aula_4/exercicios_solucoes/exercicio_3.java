import java.util.Scanner;
public class Operacoes {   // ParseInt é inútil nesse exercício, Mirella errou......
public static void main(String[] args) {
   float resultado = 0.0F;
   Scanner entrada = new Scanner(System.in);
   
	System.out.print("Informe o Primeiro valor: ");
	//int num1 = Integer.ParseInt(entrada.nextDouble()); // evita erros para valores decimais
	float num1 = entrada.nextFloat();
	
	System.out.print("Informe o Segundo valor: ");
	//int num2 = Integer.ParseInt(entrada.nextDouble()); // evita erros para valores decimais
	float num2 = entrada.nextFloat();
	
	System.out.println("Informe a Operacao de interesse:");
	System.out.print("div - divisao\ntime - multiplicacao\nsum - soma\nminus - subtracao\n");
	String operacao_numerica = entrada.next();
	
	System.out.println(BasicMath(num1, num2, operacao_numerica, resultado));
}

	public static float BasicMath(float num1, float num2, String operacao_numerica, float resultado){
		switch (operacao_numerica){
			case "sum":
				resultado = num1 + num2;
				break;
			case "minus":
				resultado = num1 - num2;
				break;
			case "time":
				resultado = num1 * num2;
				break;
			case "div":
				resultado = num1 / num2;
				break;
	}
   
		return resultado;
	}
}