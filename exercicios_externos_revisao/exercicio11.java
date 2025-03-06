import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> contagemPalavras = new HashMap<>();
        
        System.out.println("Digite um texto qualquer:");
        String texto = sc.nextLine();

        // Divide o texto em palavras
        String[] palavrasCapturadas = texto.split("\\s+");
        
        // Conta a ocorrência de cada palavra
        for (String palavra : palavrasCapturadas) {
            // Remove pontuações (caso haja) e converte para minúsculas
            palavra = palavra.replaceAll("[^a-zA-ZáàãâäåéèêëíìîïóòôöúùûüçÇ]", "").toLowerCase();
            
            // Se a palavra já estiver no Map, incrementa a contagem
            contagemPalavras.put(palavra, contagemPalavras.getOrDefault(palavra, 0) + 1);
        }
        
        // Convertendo o Map para uma lista de entradas (Map.Entry)
        List<Map.Entry<String, Integer>> listaContagem = new ArrayList<>(contagemPalavras.entrySet());

        // Ordenar a lista de palavras primeiro por contagem e depois por palavra
        Collections.sort(listaContagem, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                // Ordenar primeiro por contagem (decrescente)
                int cmp = entry2.getValue().compareTo(entry1.getValue());
                if (cmp == 0) {
                    // Se as contagens forem iguais, ordenar por palavra (alfabeticamente)
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                return cmp;
            }
        });
        
        // Exibindo as contagens personalizadas
        System.out.println("\nContagem de palavras:");
        for (Map.Entry<String, Integer> entry : listaContagem) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        sc.close();
    }
}