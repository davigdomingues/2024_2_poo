import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;

        System.out.println("Texto a ser declarado (digite '.' para sair):");
        frase = sc.nextLine();

        // Para armazenar as contagens de palavras
        Map<String, Integer> wordCount = new HashMap<>();

        // Continua lendo até o usuário digitar "."
        while (!frase.equals(".")) {
            // Remove pontuação e transforma em minúsculas
            frase = frase.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] palavras = frase.split("\\s+");

            for (String palavra : palavras) {
                if (!palavra.isEmpty())
                    wordCount.put(palavra, wordCount.getOrDefault(palavra, 0) + 1);
            }

            frase = sc.nextLine();
        }

        // Imprime as palavras e suas contagens
        System.out.println("Palavras repetidas:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() >= 1)
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        sc.close();
    }
}