import java.util.*;

/*Equivalente para o exercício:
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; // Importante!!
import java.util.Map;
import java.util.HashMap;
*/

public class Main{
	public static void main(String[] args) throws InterruptedException {
	    List<Pessoa> pessoas = new ArrayList<>();
	    Scanner sc = new Scanner(System.in);
	    int totalPessoas = 0;
	    
	    while (totalPessoas <= 0){
	        System.out.print("Quantas pessoas deseja envolver na lista? ");
	        totalPessoas = sc.nextInt();
	        Thread.sleep(2000);
	        
	        if (totalPessoas <= 0)
	            System.out.print("Por favor, coloque um numero valido\n\n");
	    }
	    
	    System.out.println();
	    
	    for (int i = 0; i < totalPessoas; i++){
	        System.out.println("Informacoes da pessoa " + (i+1) + ":");
	        
	        System.out.print("Nome: ");
	        sc.nextLine(); // Limpa o Buffer
	        String nome = sc.next();
	        
	        sc.nextLine(); // Limpa o Buffer
	        
	        System.out.print("Idade: ");
	        int idade = sc.nextInt();
	        
	        try {
                pessoas.add(new Pessoa(nome, idade));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
                i--;  // Repetir a iteração atual para a pessoa
            }
	        
	        System.out.print("Adicionando pessoa " + (i+1) + " a lista de pessoas..\n\n");
		    Thread.sleep(2000);
	    }
	    
	    Collections.sort(pessoas);
	    System.out.println("\nPessoas ordenadas por idade:");
	    for (Pessoa p : pessoas)
            System.out.println(p);
	    
        Map<String, Pessoa> mapa = new HashMap<>();
        for (Pessoa p : pessoas)
            mapa.put(p.getNome(), p);

        System.out.println("\nPessoas no mapa:");
        for (Map.Entry<String, Pessoa> entry : mapa.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
        
        sc.close();
    }
}

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade){
        this.nome = verificarNome(nome);
        this.idade = verificarIdade(idade);
    }
    
    private String verificarNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        return nome;
    }
    
    private int verificarIdade(int idade){
        return idade > 0 ? idade : 0;
    }
    
    @Override
    public String toString(){
        return nome + " - " + idade + " anos";
    }
    
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return Integer.compare(this.idade, outraPessoa.idade);  // Ordenação por idade
    }
    
     // Métodos getters (caso queira acessar nome e idade externamente)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
    // Métodos setters (caso queira permitir a modificação do nome e idade)
    public void setNome(String nome) {
        this.nome = verificarNome(nome);
    }

    public void setIdade(int idade) {
        this.idade = verificarIdade(idade);
    }
}