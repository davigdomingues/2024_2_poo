public class Pilha<T> {
    private final int tamanho;
    private int topo;
    private final T[] elementos;

    public Pilha(int tamanho) {
        this.tamanho = tamanho > 0 ? tamanho : 10; // valida o tamanho, que deve ser maior que 0
        this.topo = -1; // Pilha inicializada como vazia
        this.elementos = (T[]) new Object[this.tamanho]; // cria o objeto Pilha
    }

    // Insere o elemento na pilha
    public void empilha(T valorEmpilhar) {
        if (topo == (tamanho - 1)) { // se a pilha estiver cheia
            throw new PilhaException(String.format("A pilha está cheia, não é possível empilhar %s", valorEmpilhar));
        }
        elementos[++topo] = valorEmpilhar; // insere valorEmpilhar na Pilha
    }

    // Retorna o elemento superior se não estiver vazia; do contrário lança uma PilhaException
    public T desempilha() {
        if (topo == -1) { // se pilha estiver vazia
            throw new PilhaException("A pilha está vazia, não é possível desempilhar.");
        }
        return elementos[topo--]; // remove e retorna o elemento do topo da Pilha
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo != -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return topo != (tamanho - 1);
    }
}