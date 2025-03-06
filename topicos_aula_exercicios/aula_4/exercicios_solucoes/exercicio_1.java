import java.util.Scanner;
public class Poupanca {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int parar = 1;
   
		while (parar != 0){
			TaxaJuros valor = new TaxaJuros();
   
			System.out.print("Informe o capital inicial: ");
			double capital = entrada.nextDouble();
			System.out.print("Informe o total de meses da aplicacao: ");
			double tempo_meses = entrada.nextDouble();

			System.out.println("Rendimento final da aplicacao informada: " + valor.Rendimento(tempo_meses, capital));
   
			System.out.print("Deseja parar de realizar aplicacoes? (Sim - qualquer valor, exceto 0/ Nao - digite 0) ");
			parar = entrada.nextInt();
		}
	}
}

public class TaxaJuros {
    private static double juros = 0.1;
   
    public double Rendimento(double meses, double capitalInicial) {
        return (capitalInicial*(Math.pow(1 + juros, meses)));
    }
   
    public TaxaJuros(){
        juros += 0.05;
   }
}