import java.util.Scanner;

public class AplicacaoCalculadora {
    private static final Scanner sc = new Scanner(System.in);
    private static int a = 0,  b = 0;

    public static void main(String[] args) {
        int escolha;

        do{
            escolha = menuPrincipal();
            Calculadora calculos = new Calculadora();

            // No método da classe AplicacaoCalculadora
            switch (escolha){
                case 1:
                    menuSecundario();
                    System.out.println("Resultado: " + calculos.adicao(a, b));
                    System.out.println();
                    break;

                case 2:
                    menuSecundario();
                    System.out.println("Resultado: " + calculos.subtracao(a, b));
                    System.out.println();
                    break;

                case 3:
                    menuSecundario();
                    System.out.println("Resultado: " + calculos.multiplicacao(a, b));
                    System.out.println();
                    break;

                case 4:
                    try {
                        menuSecundario();
                        System.out.println("Resultado: " + calculos.divisao(a, b));

                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    System.out.println();
                    break;

                case 5:
                    try {
                        menuSecundario();
                        System.out.println("Resultado: " + calculos.resto(a, b));

                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    System.out.println();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("A opcao deve ser de 1 a 6!!\n");
                    break;
            }

        } while (escolha != 6);
    }

    private static int menuPrincipal(){
        int opcao ;
        System.out.println("Informe a operacao desejada:");
        System.out.println("1 - SOMAR");
        System.out.println("2 - SUBTRAIR");
        System.out.println("3 - MULTIPLICAR");
        System.out.println("4 - DIVISAO");
        System.out.println("5 - RESTO DE DIVISAO");
        System.out.println("6 - SAIR\n");
        opcao = sc.nextInt();
        sc.nextLine(); // Consumo da nova linha, para limpar o buffer e fazer funcionar o método split.

        return opcao;
    }

    private static void menuSecundario(){
        String[] numerosDeclarados;

        do {
            System.out.println("Informe os numeros de interesse (ex: 10 20): ");
            String numeros = sc.nextLine();
            numerosDeclarados = numeros.split(" "); // Usa espaço como delimitador

            if (numerosDeclarados.length != 2)
                System.out.println("Por favor, insira exatamente dois números.");

            else {
                try {
                    a = Integer.parseInt(numerosDeclarados[0]);
                    b = Integer.parseInt(numerosDeclarados[1]);

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Por favor, insira números inteiros.");
                }
            }
        } while (numerosDeclarados.length != 2);
    }
}