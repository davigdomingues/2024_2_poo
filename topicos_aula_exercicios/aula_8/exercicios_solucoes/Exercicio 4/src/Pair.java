public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    // Métodos get e set para o primeiro elemento
    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    // Métodos get e set para o segundo elemento
    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    // Método para comparar os dois elementos
    public boolean equalsTo() {
        if (first == null || second == null)
            return false;
        return first.equals(second);
    }

    // Método para comparar as classes dos dois elementos
    public boolean classEqualsTo() {
        if (first == null || second == null)
            return false;
        return first.getClass().equals(second.getClass());
    }
}