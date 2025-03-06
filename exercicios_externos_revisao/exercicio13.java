import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escreva qualquer expressão matemática: ");
        String expressao = sc.nextLine();
        
        String resultado = verificarBalanceamento(expressao) ? "Sim" : "Nao";
        System.out.println("Expressão válida: " + resultado);
    }
    
    public static boolean verificarBalanceamento(String expressao) {
        Stack<Character> pilha = new Stack<>();
        
        // Percorrer a expressão caractere por caractere
        for (char c : expressao.toCharArray()) {
            // Se o caractere for um dos tipos de parênteses de abertura, empilha
            if (c == '(' || c == '{' || c == '[') {
                pilha.push(c);
            } 
            // Se for um parêntese de fechamento
            else if (c == ')' || c == '}' || c == ']') {
                if (pilha.isEmpty()) {
                    return false; // Não há parêntese de abertura correspondente
                }
                
                // Verifica se o topo da pilha corresponde ao tipo correto de parêntese
                char topo = pilha.pop();
                if ((c == ')' && topo != '(') ||
                    (c == '}' && topo != '{') ||
                    (c == ']' && topo != '[')) {
                    return false; // Parênteses desbalanceados
                }
            }
        }
        
        // Se a pilha estiver vazia no final, todos os parênteses foram balanceados
        return pilha.isEmpty();
    }
}