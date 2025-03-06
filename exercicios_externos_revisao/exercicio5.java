import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    List<Pagavel> funcionariosPagaveis = new ArrayList<>();
	    
	    System.out.println("Tipos de trabalhadores:\n");
	    System.out.println("Funcionario:");
	    System.out.print("Quanto ele ganha por hora trabalhada (o escravo CLT)? ");
	    double horasTrabalhadasDoFuncionario = sc.nextDouble();
	    
	    System.out.println();
	    
	    System.out.println("Freelancer anarco-capitalista:");
	    System.out.print("Quanto que o opressor ganha por hora? ");
	    double salarioDoOpressor = sc.nextDouble();
	    System.out.print("Quantas horas esse ser trabalha? ");
	    double horasTrabalhadasDoOpressor = sc.nextDouble();
	    
	    funcionariosPagaveis.add(new Funcionario(horasTrabalhadasDoFuncionario));
	    funcionariosPagaveis.add(new Freelancer(salarioDoOpressor, horasTrabalhadasDoOpressor));
	    
	    System.out.println();
	    for (Pagavel pagamento : funcionariosPagaveis)
	        System.out.println(pagamento.toString());
	    
	    sc.close();
	}
}

interface Pagavel{
    double calcularPagamento(); // não é abstract calcularPagamento() !
}

public class Funcionario implements Pagavel{
    private double salarioFixoPorHora;
    
    public Funcionario(double salarioFixoPorHora){
        this.salarioFixoPorHora = salarioFixoPorHora > 0 ? salarioFixoPorHora : 0;
    }
    
    @Override
    public double calcularPagamento(){
        return salarioFixoPorHora * 8;
    }
    
    public String toString(){
        return "Funcionario - Salario: " + calcularPagamento() + "\n";
    }
}

public class Freelancer implements Pagavel {
    private double valorHora;
    private double horasTrabalhadas;
    
    public Freelancer(double valorHora, double horasTrabalhadas){
        this.valorHora = valorHora > 0 ? valorHora : 0;
        this.horasTrabalhadas = horasTrabalhadas > 0 ? horasTrabalhadas : 0;
    }
    
    @Override
    public double calcularPagamento(){
        return (valorHora * horasTrabalhadas);
    }
    
    public String toString(){
        return "Freelancer - Salario: " + calcularPagamento() + "\n";
    }
}