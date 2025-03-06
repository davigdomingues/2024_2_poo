public class Main {
	public static void main(String[] args) {
	    Caixa<Integer> caixa1 = new Caixa<>();
	    Caixa<String> caixa2 = new Caixa<>();
	    
	    System.out.println("Caixa Integer: ");
	    caixa1.setItem(123);
	    System.out.println("Conteúdo surpresa: " + caixa1.getItem());
	    
	    System.out.println();
	    
	    System.out.println("Caixa String: ");
	    caixa2.setItem("Vai ficar tudo bem, se anime!");
	    System.out.println("Conteúdo surpresa: " + caixa2.getItem());
	}
}

public class Caixa<T> {
    private T item; // não é <T> aqui!
    
    public void setItem(T item){ // não é <T> aqui!
        this.item = item;
    }
    
    public T getItem(){ // não é <T> aqui!
        return item;
    }
}