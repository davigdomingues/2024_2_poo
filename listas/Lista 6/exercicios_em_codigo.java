public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "{" + first + ", " + second + "}";
    }
}

import java.util.List;
import java.util.ArrayList;

public class Dictionary<F, S> {
    private List<Pair<F, S>> pairs;

    public Dictionary() {
        pairs = new ArrayList<>();
    }

    // Método para adicionar um par
    public void add(F key, S value) {
        // Verificar se a chave já existe
        for (Pair<F, S> pair : pairs) {
            if (pair.getFirst().equals(key)) {
                throw new IllegalArgumentException("Chave já existe no dicionário.");
            }
        }
        // Se a chave não existe, adicionar o par
        pairs.add(new Pair<>(key, value));
    }

    // Método para buscar um par pela chave
    public Pair<F, S> getPairByKey(F key) {
        for (Pair<F, S> pair : pairs) {
            if (pair.getFirst().equals(key))
                return pair;
        }
        return null; // Caso a chave não seja encontrada
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/* Essa implementação da Main não deve ser levada a fundo, somente pesquisei a 
efeito de curiosidade para ter uma ideia de como seria de forma genárica a aplicação do Dictionary na Main()*/
public class Main {
    // Método genérico para tentar converter uma string em um tipo específico
    private static <T> T convertStringToType(String input, Class<T> type) {
        if (type == Integer.class)
            return type.cast(Integer.parseInt(input));
            
        else if (type == Double.class)
            return type.cast(Double.parseDouble(input));
            
        else if (type == String.class)
            return type.cast(input);
            
        else
            throw new IllegalArgumentException("Tipo não suportado.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quais tipos de classes empacotadas deseja que o dicionário tenha?");
        System.out.println("Digite o tipo de chave (ex: Integer, String) e o tipo de valor (ex: Integer, String):");
        String[] tipos = sc.nextLine().split(" ");
        
        Class<?> tipoChave = null, tipoValor = null;
		
        try {
            tipoChave = Class.forName(tipos[0]);
            tipoValor = Class.forName(tipos[1]);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar as classes: " + e.getMessage());
            return;
        }

        // Criar o dicionário genérico com tipos definidos
        Dictionary<Object, Object> dictionary = new Dictionary<>();

        while (true) {
            System.out.println("Seja bem-vindo ao sistema do dicionário! O que deseja fazer?");
            System.out.println("(1) Adicionar pares");
            System.out.println("(2) Encontrar pares");
            System.out.println("(3) Sair");
            System.out.print("Opção desejada: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            while (opcao < 1 || opcao > 3) {
                System.out.print("Opção inválida, por favor, refaça sua escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("Informe os argumentos a serem adicionados no dicionário (chave e valor):");
                        String[] argumentos = sc.nextLine().split(" ");
                        
                        // Converter os inputs para os tipos corretos
                        Object chave = convertStringToType(argumentos[0], tipoChave);
                        Object valor = convertStringToType(argumentos[1], tipoValor);

                        dictionary.add(chave, valor);
                        
                    } catch (IllegalArgumentException | NumberFormatException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    
                    break;

                case 2:
                    System.out.println("Informe a chave de busca (primeiro elemento do par): ");
                    String chaveBusca = sc.nextLine();
                    
                    try {
                        // Converter a chave para o tipo correto
                        Object chaveBuscaConvertida = convertStringToType(chaveBusca, tipoChave);
                        Pair<Object, Object> pair = dictionary.getPairByKey(chaveBuscaConvertida);
                        if (pair == null)
                            System.out.println("Par não localizado.");
                        
                        else
                            System.out.println("Par encontrado: " + pair);
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Erro na conversão da chave.");
                    }
                    
                    break;

                case 3:
                    System.out.println("Saindo...");
                    return;
            }
        }
        
        sc.close();
    }
}