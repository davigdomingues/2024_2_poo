import java.util.Scanner;

public class Main { //exercícios 1, 2, 4 e 5.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String finalizacao;
        boolean verificacao = true;

        while (verificacao){

            System.out.println("Pessoa:");

            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            System.out.print("CPF: ");
            String cpf = sc.next();

            System.out.print("Salário por hora: ");
            double salario = Double.parseDouble(sc.nextLine());

            System.out.print("Total de horas trabalhadas no dia de hoje: ");
            int totalTrabalhado = Integer.parseInt(sc.nextLine());

            Pessoa pessoa = new Pessoa(nome, idade, cpf, totalTrabalhado, salario);
            System.out.println("Há mais algum nome que deseja informar na folha de pagamento? (sim - tecle qualquer coisa, nao - " +
                    "digite 'fim') ");
            finalizacao = sc.next();

            if (finalizacao.equals("fim")){
                System.out.println("\nCaracteristicas das pessoas declaradas:");
                pessoa.print();
                verificacao = false;
            }
        }
        sc.close();
    }
}