//Exercício 1:
/*import java.util.Scanner;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Informe o tamanho do array desejado: ");
    int tamanho = sc.nextInt();

    double[] array = new double[tamanho];

    MinMaxArray.preencherArray(array, tamanho);
    System.out.println(MinMaxArray.maiorElemento(array, tamanho));
    System.out.println(MinMaxArray.menorElemento(array, tamanho));

}

//Exercício 2:
import java.util.Scanner;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Informe o tamanho do array desejado: ");
    int tamanho = sc.nextInt();

    int[] array = new int[tamanho];

    System.out.print("Informe um numero qualquer: ");
    int qualquer = sc.nextInt();

    OcorrenciasArray.preencherArray(array);
    OcorrenciasArray.operacoesArray(array, qualquer);
}
*/

/*Exercício 6:
import java.util.Scanner;

public static void Main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Informe um numero: ");
    int a = sc.nextInt();

    System.out.print("Informe outro numero: ");
    int b = sc.nextInt();

    IntervaloManipulacao operacao = new IntervaloManipulacao();
    operacao.maiorOumenor(a, b);
    operacao.operacoes();
    operacao.vetorNaoRepetitivo();
    operacao.vetorFinalImpresso();
}
*/

/*Exercício 7:
import java.util.Scanner;

    public static void main(String[] args) throws InterruptedException {
        if (args.length < 1){
            System.out.println("Tamanho de argumento pequeno...");
            return;
        }

        int totalCandidatos = Integer.parseInt(args[0]);

        Scanner sc = new Scanner(System.in);
        int opcao, i = 0;
        String[] nomeCandidato = new String[totalCandidatos];
        String[] CPFCandidato = new String[totalCandidatos];
        int[] idadeCandidato = new int[totalCandidatos];

        System.out.println("Seja bem-vindo à interface do Enem! Qual opção deseja realizar?");

        do {
            System.out.println("1 - Cadastrar candidatos");
            System.out.println("2 - Listar candidatos");
            System.out.println("3 - Contar candidatos");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();

            System.out.println("\nOpção selecionada com sucesso!");

            // Cria uma nova instância de EnemAdministracao
            EnemAdministracao[] cadastrado = new EnemAdministracao[totalCandidatos];
            switch (opcao) {
                case 1:
                    Thread.sleep(5000);
                    System.out.print("\033c"); // Clear screen

                    if (i < totalCandidatos) {
                        cadastrado[i] = new EnemAdministracao();
                        cadastrado[i].cadastro(i, nomeCandidato, CPFCandidato, idadeCandidato);
                        i++;
                    } else {
                        System.out.println("\nO número máximo de candidatos foi atingido!");
                        Thread.sleep(3000);
                        System.out.print("\033c"); // Clear screen
                    }
                    break;
                case 2:
                    Thread.sleep(5000);
                    System.out.print("\033c");
                    EnemAdministracao.candidatosLista(i, nomeCandidato, CPFCandidato);
                    break;
                case 3:
                    Thread.sleep(5000);
                    System.out.print("\033c");
                    EnemAdministracao.totalDeCandidatos(i, cadastrado, totalCandidatos);
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);
    }
 */

//Exercício 8:
import static java.util.Arrays.deepToString; //método que serve para imprimir arrays em Java.....

public static void main(String[] args) {
    if (args.length < 4) {
        System.out.println("Por favor, forneça quatro argumentos: linha1 coluna1 linha2 coluna2.");
        return;
    }

    int linha1 = Integer.parseInt(args[0]);
    int coluna1 = Integer.parseInt(args[1]);
    int linha2 = Integer.parseInt(args[2]);
    int coluna2 = Integer.parseInt(args[3]);

    if (linha1 == linha2 && coluna1 == coluna2) {
        MatrizSoma soma = new MatrizSoma(linha1, coluna1);
        soma.preencherMatriz1();
        soma.preencherMatriz2();

        int[][] valorFinal = soma.somaMatrizes();
        System.out.println(deepToString(valorFinal));
    } else {
        System.out.println("Soma de matrizes impossivel de ser realizada!");
    }
}
