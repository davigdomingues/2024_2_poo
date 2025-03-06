public class Pilha {
    private final int tamanho;
    private int topo;
    private final Object[] elementos; // Array de Object

    public Pilha(int tamanho) {
        this.tamanho = tamanho > 0 ? tamanho : 10; // valida o tamanho
        this.topo = -1; // Pilha inicializada como vazia
        this.elementos = new Object[this.tamanho]; // cria o objeto Pilha
    }

    public void empilha(Object valorEmpilhar) {
        if (topo == (tamanho - 1)) // se a pilha estiver cheia
            throw new PilhaException(String.format("A pilha está cheia, não é possível empilhar %s", valorEmpilhar));
        elementos[++topo] = valorEmpilhar; // insere valorEmpilhar na Pilha
    }

    public Object desempilha() {
        if (topo == -1) // se pilha estiver vazia
            throw new PilhaException("A pilha está vazia, não é possível desempilhar.");
        return elementos[topo--]; // remove e retorna o elemento do topo da Pilha
    }

    public boolean isEmpty() {
        return topo != -1;
    }

    public boolean isFull() {
        return topo != (tamanho - 1);
    }
}