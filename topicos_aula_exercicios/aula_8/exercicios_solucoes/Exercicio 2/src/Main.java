public class Main {
    public static void main(String[] args) {
        double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
        int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        Pilha<Double> doublePilha = new Pilha<>(doubleElements.length);
        Pilha<Integer> integerPilha = new Pilha<>(integerElements.length);

        testEmpilhaDouble(doublePilha, doubleElements);
        testDesempilhaDouble(doublePilha);
        testEmpilhaInteger(integerPilha, integerElements);
        testDesempilhaInteger(integerPilha);
        System.out.println();
    }

    private static void testEmpilhaDouble(Pilha<Double> pilha, double[] elementos) {
        System.out.println("Empilhando elementos Double:");
        for (double elemento : elementos) {
            if (pilha.isFull()) {
                pilha.empilha(elemento);
                System.out.println("Empilhado: " + elemento);
            }

            else //Caso haja mais elementos declarados do que o total possível no vetor de empilhamento.
                System.out.println("Não é possível empilhar " + elemento + ": a pilha está cheia.");
        }
    }

    private static void testDesempilhaDouble(Pilha<Double> pilha) {
        System.out.println("Desempilhando elementos Double:");
        while (pilha.isEmpty()) {
            Double elemento = pilha.desempilha();
            System.out.println("Desempilhado: " + elemento);
        }
    }

    private static void testEmpilhaInteger(Pilha<Integer> pilha, int[] elementos) {
        System.out.println("Empilhando elementos Integer:");
        for (int elemento : elementos) {
            if (pilha.isFull()) {
                pilha.empilha(elemento);
                System.out.println("Empilhado: " + elemento);
            }

            else //Caso haja mais elementos declarados do que o total possível no vetor de empilhamento.
                System.out.println("Não é possível empilhar " + elemento + ": a pilha está cheia.");
        }
    }

    private static void testDesempilhaInteger(Pilha<Integer> pilha) {
        System.out.println("Desempilhando elementos Integer:");
        while (pilha.isEmpty()) {
            Integer elemento = pilha.desempilha();
            System.out.println("Desempilhado: " + elemento);
        }
    }
}