import java.util.Scanner;

public class EnemAdministracao {
    private String[] nomeCandidato ;
    private String[] CPFCandidato;
    private int[] idadeCandidato;
    private final Scanner sc;

    public EnemAdministracao(int totalCandidatos) {
        String[] nomeCandidato = new String[totalCandidatos];
        String[] CPFCandidato = new String[totalCandidatos];
        int[] idadeCandidato = new int[totalCandidatos];
        sc = new Scanner(System.in);
    }

    public void cadastro(int i, String[] nomeCandidato, String[] CPFCandidato, int[] idadeCandidato) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do candidato: ");
        nomeCandidato[i] = sc.next();

        System.out.print("CPF do candidato: ");
        CPFCandidato[i] = sc.next();

        System.out.println("Idade do candidato: ");
        idadeCandidato[i] = sc.nextInt();

        System.out.println("Candidato cadastrado com sucesso!");
        Thread.sleep(5000); //o programa "pausa" por 5 segundos = 5000 milissegundo.
        System.out.print("\033c"); //equivalente ao clear screen.
    }

    static void candidatosLista(int i, String[] nomeCandidato, String[] CPFcandidato) throws InterruptedException{
        if (i > 0){
            for (int j = 0; j < i; j++){
                System.out.print("Candidato " + (j + 1) + ": " + nomeCandidato[j]);
                System.out.print("\tCPF: " + CPFcandidato[j]);
                System.out.print("\n");
            }
            Thread.sleep(5000);
            System.out.print("\033c"); //equivalente ao clear screen.
        }

        else{
            System.out.println("Nenhum candidato foi cadastrado!");
            Thread.sleep(3000);
            System.out.print("\033c"); //equivalente ao clear screen.
        }
    }

    static void totalDeCandidatos(int i, EnemAdministracao []cadastrado, int totalCandidatos) throws InterruptedException{
        if (i > 0){
            System.out.println("Ha " + cadastrado.length + " candidatos cadastrados.\nO limite" +
                    "eh de " + totalCandidatos + " candidatos nesta edicao do Enem");
            Thread.sleep(5000);
            System.out.print("\033c"); //equivalente ao clear screen.
        }

        else{
            System.out.println("Nenhum candidato foi cadastrado!");
            Thread.sleep(3000);
            System.out.print("\033c"); //equivalente ao clear screen.
        }
    }
}
