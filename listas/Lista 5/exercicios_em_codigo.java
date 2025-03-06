import java.util.Scanner;

public class Companhia {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(3000);
        String opcao;
        
        do {
            Thread.sleep(2000);
            scanner.nextLine();  // Limpar o buffer
            System.out.println("Bem-vindo(a) ao sistema de cálculo do salário do trabalhador brasileiro!\n");
            System.out.println("Opções de cálculo de lucro hipotético:");
            System.out.println("Empregado assalariado");
            System.out.println("Empregado por hora trabalhada");
            System.out.println("Empregado por comissão");
            System.out.println("Empregado por comissão assalariado");
            System.out.println("Sair");
            System.out.print("\nDigite a opção a ser escolhida: ");
            opcao = scanner.nextLine();
            
            if (opcao.equalsIgnoreCase("empregado assalariado")) {
                Thread.sleep(3000);
                System.out.println("Informe o salário deste trabalhador brasileiro: ");
                double salarioSemanal = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                
                EmpregadosAssalariados empregadosAssalariado = new EmpregadosAssalariados(salarioSemanal);
                
                Thread.sleep(3000);
                System.out.println("Então, ele ganha ao total: " + empregadosAssalariado.calcularPagamento());
            }
            
            if (opcao.equalsIgnoreCase("empregado por hora trabalhada")) {
                Thread.sleep(3000);
                System.out.println("Informe o quanto este trabalhador brasileiro ganha por hora: ");
                double salarioPorHora = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                
                EmpregadosPorHora empregadosPorHora = new EmpregadosPorHora(salarioPorHora);
                
                Thread.sleep(3000);
                System.out.print("Quantas horas ele trabalha? ");
                double horasTrabalhadas = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                Thread.sleep(2000);
                
                try {
                    double salarioFinal = empregadosPorHora.calcularPagamento(horasTrabalhadas);
                    System.out.println("Assim, ele ganha ao todo: " + salarioFinal);
                    
                } catch (CondicoesTrabalhoIlegais e) {
                    System.out.println("Erro: " + e.getMessage()); // Imprimirá a frase definida na classe, no caso do lançamento do erro.
                    
                } finally {
                    System.out.println("Os ganhos desse trabalhador foram processados!");
                }
            }
            
            if (opcao.equalsIgnoreCase("empregado por comissão")) {
                Thread.sleep(3000);
                System.out.println("Informe o total do lucro das vendas do estabelecimento onde trabalha o brasileiro: ");
                double lucroTotal = scanner.nextDouble();
                System.out.println("Informe o percentual de participação da comissão deste trabalhador brasileiro em seu local de trabalho (use escala normal): ");
                double participacaoPercentual = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                
                EmpregadosDeComissao empregadosDeComissao = new EmpregadosDeComissao(participacaoPercentual, lucroTotal);
                
                try {
                    double salarioFinal = empregadosDeComissao.calcularPagamento();
                    System.out.println("Assim, ele ganha ao todo: " + salarioFinal);
                    
                } catch (CondicoesTrabalhoIlegais e) {
                    System.out.println("Erro: " + e.getMessage()); // Imprimirá a frase definida na classe, no caso do lançamento do erro.
                    
                } finally {
                    System.out.println("Os ganhos desse trabalhador foram processados!");
                }
            }
            
            if (opcao.equalsIgnoreCase("empregado por comissão assalariado")) {
                Thread.sleep(3000);
                System.out.println("Informe o total do lucro das vendas do estabelecimento onde trabalha o brasileiro: ");
                double lucroTotal = scanner.nextDouble();
                System.out.println("Informe o percentual de participação da comissão deste trabalhador brasileiro em seu local de trabalho (use escala normal): ");
                double participacaoPercentual = scanner.nextDouble();
                System.out.println("Informe o salário deste trabalhador brasileiro: ");
                double salarioSemanal = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                
                EmpregadosDeComissaoAssalariados empregadosDeComissaoAssalariados = new EmpregadosDeComissaoAssalariados(participacaoPercentual, lucroTotal, salarioSemanal);
                
                Thread.sleep(3000);
                System.out.println("Então, ele ganha ao total: " + empregadosDeComissaoAssalariados.calcularPagamento());
            }
            
            Thread.sleep(2000);
            System.out.println("Deseja continuar a interação?");
            System.out.println("Sim");
            System.out.println("Não");
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextLine();
            
        } while (!opcao.equalsIgnoreCase("não"));
        
        scanner.close();
    }
}

abstract class Empregados{
    public abstract double calcularPagamento() throws CondicoesTrabalhoIlegais;
}

public class EmpregadosAssalariados extends Empregados {
	private double salarioSemanal;

	public EmpregadosAssalariados(double salarioSemanal) {
		this.salarioSemanal = salarioSemanal;
	}

	@Override
	public double calcularPagamento() {
		return salarioSemanal;
	}
}

public class EmpregadosPorHora extends Empregados {
    private double salarioPorHora;
    
    public EmpregadosPorHora(double salarioPorHora){
        this.salarioPorHora = salarioPorHora;
    }
    
    @Override
    public double calcularPagamento(double horasTrabalhadas){
        if (horasTrabalhadas > 60)
            throw new CondicoesTrabalhoIlegais("A quantia de horas trabalhadas excede a permitida por lei!");

        return horasTrabalhadas * salarioPorHora;
    }
}

public class EmpregadosDeComissao extends Empregados {
    private double comissaoPercentual;
    private double totalVendas;
    
    public EmpregadosDeComissao(double comissaoPercentual, double totalVendas){
        this.comissaoPercentual = comissaoPercentual/100; //cálculo direto do percentual
        this.totalVendas = totalVendas;
    }
    
    @Override
    public double calcularPagamento(){
        if (comissaoPercentual < 0.1)
            throw new CondicoesTrabalhoIlegais("O percentual de participacao esta abaixo do minimo previsto na lei!");
            
        return comissaoPercentual * totalVendas;
    }
}

public class EmpregadosDeComissaoAssalariados extends Empregados {
    private double comissaoPercentual;
    private double totalVendas;
    private double salarioFixo;
    
    public EmpregadosDeComissaoAssalariados(double comissaoPercentual, double totalVendas, double salarioFixo){
        this.comissaoPercentual = comissaoPercentual/100; //cálculo direto do percentual
        this.totalVendas = totalVendas;
        this.salarioFixo = salarioFixo;
    }
    
    @Override
    public double calcularPagamento(){
        return salarioFixo + (comissaoPercentual * totalVendas);
    }
}

public class CondicoesTrabalhoIlegais extends Exception {
    public CondicoesTrabalhoIlegais(String mensagem){
        super(mensagem);
    }
}