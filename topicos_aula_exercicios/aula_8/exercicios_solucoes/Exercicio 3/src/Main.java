public class Main {
    public static void main(String[] args) {
        double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
        int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        Pilha doublePilha = new Pilha(6);
        Pilha integerPilha = new Pilha(11);

        testEmpilhaDouble(doublePilha, doubleElements);
        testDesempilhaDouble(doublePilha);
        testEmpilhaInteger(integerPilha, integerElements);
        testDesempilhaInteger(integerPilha);
        System.out.println();
    }

    private static void testEmpilhaDouble(Pilha pilha, double[] elementos) {
        System.out.println("Empilhando elementos Double:");
        for (double elemento : elementos) {
            if (pilha.isFull()) {
                pilha.empilha(elemento); // Empilha como Double
                System.out.println("Empilhado: " + elemento);
            }

            else
                System.out.println("Não é possível empilhar " + elemento + ": a pilha está cheia.");
        }
    }

    private static void testDesempilhaDouble(Pilha pilha) {
        System.out.println("Desempilhando elementos Double:");
        while (pilha.isEmpty()) {
            Object elemento = pilha.desempilha(); // Retorna como Object
            System.out.println("Desempilhado: " + elemento); // Pode ser tratado como Object
        }
    }

    private static void testEmpilhaInteger(Pilha pilha, int[] elementos) {
        System.out.println("Empilhando elementos Integer:");
        for (int elemento : elementos) {
            if (pilha.isFull()) {
                pilha.empilha(elemento); // Empilha como Integer
                System.out.println("Empilhado: " + elemento);
            }

            else
                System.out.println("Não é possível empilhar " + elemento + ": a pilha está cheia.");
        }
    }

    private static void testDesempilhaInteger(Pilha pilha) {
        System.out.println("Desempilhando elementos Integer:");
        while (pilha.isEmpty()) {
            Object elemento = pilha.desempilha(); // Retorna como Object
            System.out.println("Desempilhado: " + elemento); // Pode ser tratado como Object
        }
    }
}