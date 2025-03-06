//(exercício 3)
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<Integer, Conta> contas;
    private int numeroContaAtual;

    public Banco() {
        contas = new HashMap<>();
        numeroContaAtual = 1001;  // Inicia com o número da conta 1001
    }

    public boolean criarConta(String tipo, String nomeCliente, double saldoInicial) {
        Conta conta = null;
        
        if (tipo.equalsIgnoreCase("poupanca"))
            conta = new Poupanca(nomeCliente, numeroContaAtual++, saldoInicial);
        
        else if (tipo.equalsIgnoreCase("corrente"))
            conta = new Corrente(nomeCliente, numeroContaAtual++, saldoInicial, 1000);  // Limite de 1000
        
        else if (tipo.equalsIgnoreCase("investimento"))
            conta = new Investimento(nomeCliente, numeroContaAtual++, saldoInicial, 0.01);  // 1% rendimento diário

        if (conta != null) {
            contas.put(conta.getNumeroConta(), conta);
            
            System.out.println("Conta criada com sucesso.");
            return true;
        }
        
        return false;
    }

    public Conta buscarConta(int numeroConta) {
        return contas.get(numeroConta);
    }

    public void listarClientes() {
        for (Conta conta : contas.values())
            conta.exibirInformacoes();
    }

    public void menuCliente(Conta conta) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar saldo");
            
            if (conta instanceof Poupanca)
                System.out.println("4. Aplicar rendimento (Poupança)");

            if (conta instanceof Investimento)
                System.out.println("4. Aplicar rendimento (Investimento)");
                
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = sc.nextDouble();
                    
                    conta.depositar(valorDeposito);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = sc.nextDouble();
                    
                    conta.sacar(valorSaque);
                    break;
                    
                case 3:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                    
                case 4:
                    if (conta instanceof Poupanca) {
                        ((Poupanca) conta).aplicarRendimento();
                        System.out.println("Rendimento aplicado.");
                    } 
                    
                    else if (conta instanceof Investimento) {
                        System.out.print("Digite o número de dias para aplicar rendimento: ");
                        int dias = sc.nextInt();
                        
                        ((Investimento) conta).aplicarRendimento(dias);
                        System.out.println("Rendimento aplicado.");
                    }
                    
                    break;
            }
        } while (opcao != 0);
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Login (Cliente)");
            System.out.println("2. Criar Conta");
            System.out.println("3. Listar clientes (Admin)");
            System.out.println("0. Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();
                    
                    Conta conta = buscarConta(numeroConta);
                    
                    if (conta != null)
                        menuCliente(conta);
                    
                    else
                        System.out.println("Conta não encontrada.");
                        
                    break;
                    
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    sc.nextLine();  // Consome a nova linha
                    String nomeCliente = sc.nextLine();
                    
                    System.out.println("Escolha o tipo de conta (poupanca, corrente, investimento): ");
                    String tipo = sc.nextLine();
                    
                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = sc.nextDouble();
                    
                    criarConta(tipo, nomeCliente, saldoInicial);
                    break;
                    
                case 3:
                    listarClientes();
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.menuPrincipal();
    }
}

public abstract class Conta {
    protected String nomeCliente;
    protected int numeroConta;
    protected double saldo;

    public ContaBancaria(String nomeCliente, int numeroConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        
        return false;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        
        return false;
    }

    public abstract void exibirInformacoes();
}

public class Corrente extends Conta {
    private double limite;

    public ContaCorrente(String nomeCliente, int numeroConta, double saldo, double limite) {
        super(nomeCliente, numeroConta, saldo);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        
        System.out.println("Não é possível realizar saque: limite excedido.");
        return false;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Corrente - Cliente: " + nomeCliente + 
        ", Número: " + numeroConta + ", Saldo: " + saldo + ", Limite: " + limite);
    }
}

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Investimento extends Conta {
    private LocalDate dataUltimoDeposito;
    private double rendimentoDiario;

    public ContaInvestimento(String nomeCliente, int numeroConta, double saldo, double rendimentoDiario) {
        super(nomeCliente, numeroConta, saldo);
        this.rendimentoDiario = rendimentoDiario;
        this.dataUltimoDeposito = LocalDate.now();
    }

    @Override
    public boolean sacar(double valor) {
        long diasDesdeUltimoDeposito = ChronoUnit.DAYS.between(dataUltimoDeposito, LocalDate.now());
        
        if (diasDesdeUltimoDeposito >= 30 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        
        System.out.println("Não é possível sacar: saque só pode ser feito após 30 dias do último depósito.");
        return false;
    }

    public void aplicarRendimento(int dias) {
        saldo *= Math.pow((1 + rendimentoDiario), dias);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Investimento - Cliente: " + nomeCliente + ", Número: " + numeroConta + ", Saldo: " + saldo + ", Último Depósito: " + dataUltimoDeposito);
    }
}

public class Poupanca extends Conta {
    private static final double RENDIMENTO_FIXO = 0.05; // 5% de rendimento fixo

    public ContaPoupanca(String nomeCliente, int numeroConta, double saldo) {
        super(nomeCliente, numeroConta, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        
        System.out.println("Não é possível realizar saque: saldo insuficiente.");
        return false;
    }

    public void aplicarRendimento() {
        saldo += saldo * RENDIMENTO_FIXO;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Poupança - Cliente: " + nomeCliente + ", Número: " + numeroConta + ", Saldo: " + saldo);
    }
}