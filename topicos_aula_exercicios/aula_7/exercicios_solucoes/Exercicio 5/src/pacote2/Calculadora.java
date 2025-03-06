package pacote2;

import pacote1.CalculadoraBasica;

public class Calculadora extends CalculadoraBasica {
    public double divisao(int a, int b) {
        if (b == 0) {
            System.out.println("Erro: Divisão por zero.");
            return 0;
        }

        return (double) a / b;
    }

    public double resto(int a, int b) {
        if (b == 0) {
            System.out.println("Erro: Resto por zero.");
            return 0;
        }

        return a % b;
    }
}