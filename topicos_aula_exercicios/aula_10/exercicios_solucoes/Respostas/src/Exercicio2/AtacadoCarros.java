package Exercicio2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AtacadoCarros {

    // Método principal que recebe a classe Carro como parâmetro
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Marca do Carro: ");
        String marca = scanner.nextLine();

        System.out.println("Marca do Carro: ");
        String modelo = scanner.nextLine();

        System.out.println("Marca do Carro: ");
        int anoLancamento = scanner.nextInt();

        System.out.println("Marca do Carro: ");
        double precoCarro = scanner.nextDouble();

        Carro carro = criarCarroDinamicamente(marca, modelo, anoLancamento, precoCarro);

        if (carro != null)
            invocarMetodosDinamicamente(carro);
    }

    // Método para criar o Carro dinamicamente
    public static Carro criarCarroDinamicamente(String marca, String modelo, int anoLancamento, double precoCarro) {
        Class<?> classeCarro;

        try {
            // Carrega a classe Carro dinamicamente
            classeCarro = Class.forName("Exercicio2.Carro");  // Adicionando o pacote para evitar ClassNotFoundException
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Classe Carro não encontrada", ex);
        }

        Constructor<?> construtor;

        try {
            // Obtém o construtor da classe Carro
            construtor = classeCarro.getConstructor(String.class, String.class, int.class, double.class);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException("Construtor não encontrado", ex);
        }

        Carro carro;

        try {
            // Cria a instância de Carro dinamicamente
            carro = (Carro) construtor.newInstance(marca, modelo, anoLancamento, precoCarro);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException("Erro ao instanciar a classe Carro", ex);
        }

        return carro;
    }

    // Método para invocar os métodos de Carro dinamicamente
    public static void invocarMetodosDinamicamente(Carro carro) {
        // Obtém os métodos da classe Carro
        Method[] metodos = carro.getClass().getMethods();

        for (Method metodo : metodos) {
            if (metodo.getName().equalsIgnoreCase("setPreco")) {
                System.out.println("Método: " + metodo.getName());
                try {
                    // Passa o parâmetro esperado para o método setPreco
                    metodo.invoke(carro, 50000.0); // passando um valor para o preço
                } catch (Exception e) {
                    System.err.println("Erro ao modificar o campo " + metodo.getName());
                }
            }

            if (metodo.getName().equalsIgnoreCase("toString")) {
                System.out.println("Método: " + metodo.getName());
                try {
                    // Invoca o método toString dinamicamente
                    metodo.invoke(carro);
                } catch (Exception e) {
                    System.err.println("Erro ao invocar o método " + metodo.getName());
                }
            }
        }

        // Imprimir o objeto carro usando toString
        System.out.println(carro); // Isso chama o toString automaticamente
    }
}