import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Dados de exemplo fornecidos
        List<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Total de elementos a serem declarados: ");
        int limite = scanner.nextInt();
        System.out.println();
        
        // Coletando os valores fornecidos
        for (int i = 0; i < limite; i++){
            System.out.print("Valor " + (i+1) + ": ");
            int x = scanner.nextInt();
            numeros.add(x);
        }
        
        // Usar um Set para garantir que os elementos sejam únicos (não mantém ordem)
        Set<Integer> elementosUnicos = new HashSet<>(numeros);
        
        // Lista de frequências
        List<Integer> frequencias = new ArrayList<>();

        // Contar as frequências de cada elemento único
        for (Integer elem : elementosUnicos) {
            int count = 0;
            for (Integer n : numeros) {
                if (n.equals(elem))
                    count++;
            }
            
            frequencias.add(count);
        }

        // Criando a lista bidimensional (2 listas internas)
        List<List<Integer>> listaBidimensional = new ArrayList<>();

        // Adicionar elementos e suas frequências na lista bidimensional
        List<Integer> elementosList = new ArrayList<>(elementosUnicos);
        listaBidimensional.add(elementosList); // Primeira dimensão (elementos)
        listaBidimensional.add(frequencias);   // Segunda dimensão (frequências)

        // Exibindo a matriz resultante
        System.out.println("\nMatriz Bidimensional (Elementos e Frequências):\n");

        // Usando enhanced for
        List<Integer> elementos = listaBidimensional.get(0);
        List<Integer> frequencias = listaBidimensional.get(1);

        for (int i = 0; i < elementos.size(); i++) {
            Integer elemento = elementos.get(i);
            Integer frequencia = frequencias.get(i);
            System.out.println("Elemento: " + elemento + " | Frequência: " + frequencia);
        }

        scanner.close();
    }
}