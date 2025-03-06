package pacote2; /* Lembre-se de que os nomes dos pacotes devem estar em letras
minúsculas por convenção.
Certifique-se de que a estrutura de diretórios esteja correta ao compilar
e executar o programa.

Compilação no terminal:
javac pacote1/*.java pacote2/*.java

Execução no terminal:
java pacote2.TesteCalculadora
*/

import java.util.Scanner;

public class TesteCalculadora {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String operacao;

        // Menu de operação
        operacao = exibirMenuOperacao();

        // Realiza a operação escolhida
        double resultado;
        switch (operacao) {
            case "Adicao":
                resultado = realizarOperacao(calculadora::adicao);
                break;

            case "Subtracao":
                resultado = realizarOperacao(calculadora::subtracao);
                break;

            case "Multiplicacao":
                resultado = realizarOperacao(calculadora::multiplicacao);
                break;

            case "Divisao":
                resultado = realizarOperacao(calculadora::divisao);
                break;

            case "Resto":
                resultado = realizarOperacao(calculadora::resto);
                break;

            default:
                System.out.println("Operação inválida!");
                return;
        }

        System.out.println("Resultado: " + resultado);
    }

    // Exibe o menu e recebe a operação do usuário
    private static String exibirMenuOperacao() {
        System.out.println("Informe qual das operacoes deseja realizar:");
        System.out.println("Adicao");
        System.out.println("Subtracao");
        System.out.println("Multiplicacao");
        System.out.println("Divisao");
        System.out.println("Resto");
        return scanner.nextLine();
    }

    // Método para realizar a operação
    private static double realizarOperacao(Operacao operacao) {
        int a, b;

        // Solicita e valida os números inseridos
        do {
            System.out.print("Informe dois números: ");
            String[] numeros = scanner.nextLine().split(" ");

            if (numeros.length != 2) {
                System.out.println("Por favor, insira exatamente dois números.");
                continue;
            }

            try {
                a = Integer.parseInt(numeros[0]);
                b = Integer.parseInt(numeros[1]);
                return operacao.executar(a, b); // Chama a operação selecionada

            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira números válidos.");
            }
        } while (true);
    }
}