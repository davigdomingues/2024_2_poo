public class Main {
    public static void main(String[] args) {
        // Testando com tipos diferentes
        Pair<Integer, String> pair1 = new Pair<>(1, "Um");
        /* O uso de setters, nesse caso, é redundante, porque a classe já tem argumentos. Eles seriam mais uteis,
        se o construtor não tivesse argumentos */
        pair1.setFirst(1);
        pair1.setSecond("Um");

        Pair<Double, Double> pair2 = new Pair<>(2.0, 2.0);
        /* O uso de setters, nesse caso, é redundante, porque a classe já tem argumentos. Eles seriam mais uteis,
        se o construtor não tivesse argumentos */
        pair2.setFirst(2.0);
        pair2.setSecond(2.0);

        Pair<String, String> pair3 = new Pair<>("Teste", "Teste");
        /* O uso de setters, nesse caso, é redundante, porque a classe já tem argumentos. Eles seriam mais uteis,
        se o construtor não tivesse argumentos */
        pair3.setFirst("Teste");
        pair3.setSecond("Teste");

        // Teste dos métodos get
        System.out.println("Primeiro par: " + pair1.getFirst() + ", " + pair1.getSecond());
        System.out.println("Segundo par: " + pair2.getFirst() + ", " + pair2.getSecond());
        System.out.println("Terceiro par: " + pair3.getFirst() + ", " + pair3.getSecond());

        // Teste dos métodos equalsTo
        System.out.println("pair1 equalsTo: " + pair1.equalsTo());
        System.out.println("pair2 equalsTo: " + pair2.equalsTo());
        System.out.println("pair3 equalsTo: " + pair3.equalsTo());

        // Teste dos métodos classEqualsTo
        System.out.println("pair1 classEqualsTo: " + pair1.classEqualsTo());
        System.out.println("pair2 classEqualsTo: " + pair2.classEqualsTo());
        System.out.println("pair3 classEqualsTo: " + pair3.classEqualsTo());
    }
}