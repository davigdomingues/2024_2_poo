import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Double> alunoNotas = new HashMap<>();
    
    public static void main(String[] args) {
        int opcao;
        double notaAdicionar, notaNovaAdicionar;
        String nomeAdicionar, nomeRemover, nomeBuscado, nomeABuscar, nomeAlterar;
        
        do {
            System.out.println("(1) Adicionar alunos na lista de notas");
            System.out.println("(2) Imprimir o nome dos alunos presentes na lista e sua respectiva nota");
            System.out.println("(3) Alterar a nota de um aluno presente na lista");
            System.out.println("(4) Verificar se um aluno está na lista");
            System.out.println("(5) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer após nextInt()
            
            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    nomeAdicionar = scanner.nextLine();
                    System.out.print("Nota do aluno: ");
                    notaAdicionar = scanner.nextDouble();
                    alunoNotas.put(nomeAdicionar, notaAdicionar);
                    System.out.println("Valores inseridos com sucesso!");
                    break;
                
                case 2:
                    System.out.print("Qual nome do aluno deseja procurar? ");
                    nomeABuscar = scanner.nextLine();
                    boolean achou = false;
                    
                    for (Map.Entry<String, Double> entrada : alunoNotas.entrySet()) {
                        if (entrada.getKey().equals(nomeABuscar)) {
                            System.out.println("Aluno: " + entrada.getKey() + " | Nota: " + entrada.getValue());
                            achou = true;
                        }
                    }
                    
                    if (!achou) {
                        System.out.println("Aluno não encontrado...");
                    }
                    break;
                
                case 3:
                    System.out.print("Nome do aluno: ");
                    nomeAlterar = scanner.nextLine();
                    System.out.print("Nova nota do aluno: ");
                    notaNovaAdicionar = scanner.nextDouble();
                    alunoNotas.put(nomeAlterar, notaNovaAdicionar);  // Alterar nota usando put
                    System.out.println("Nota atualizada com sucesso!");
                    break;
                
                case 4:
                    System.out.print("Qual nome deseja procurar na lista? ");
                    nomeBuscado = scanner.nextLine();
                    
                    if (alunoNotas.containsKey(nomeBuscado))
                        System.out.println("O nome " + nomeBuscado + " está na lista.");
                    
					else
                        System.out.println("O nome " + nomeBuscado + " não está na lista.");
						
                    break;
                
                case 5:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
        } while (opcao != 5);
        
        scanner.close();
    }
}