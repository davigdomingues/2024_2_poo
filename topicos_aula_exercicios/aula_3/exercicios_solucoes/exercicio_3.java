public class Invoice {
    private String nroFatura, descricaoItem;
    private int quantidadeComprada;
    private double precoItem;
    
    //construtor padrão --> realiza inicialização padrão, antes da atribuição durante o código.
    public Invoice(String nroFatura, String descricaoItem, int quantidadeComprada, double precoItem) {
        this.nroFatura = nroFatura;
        this.descricaoItem = descricaoItem;
        this.quantidadeComprada = quantidadeComprada;
        
        if (precoItem < 0.0) this.precoItem = 0.0;
        else this.precoItem = precoItem;
    }
    
    public String getNroFatura() {
        return nroFatura;
    }
    
    public void setNumeroFatura(String numeroFatura) {
        this.nroFatura = nroFatura;
    }
    
     public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
    
    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        if (precoItem < 0.0) {
            this.precoItem = 0.0;
        } else {
            this.precoItem = precoItem;
        }
    }
    
    public double getInvoiceAmount(int quantidadeComprada, double precoItem){
        return quantidadeComprada*precoItem;
    }
}

import java.util.Scanner;
public class TestInvoice {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.print("Numero da fatura: ");
		String nroFatura = sc.next();
		System.out.print("Descrição do item: ");
		String descricao = sc.next();
		System.out.print("Quantidade comprada: ");
		int total = sc.nextInt();
		System.out.print("Preco do item: ");
		double precoItem = sc.nextDouble();
		
		Invoice usuario = new Invoice(nroFatura, descricao, total, precoItem);
		
		System.out.println("Resultados associados:");
		System.out.println("Fatura: " + usuario.getNroFatura());
        System.out.println("Descicao: " + usuario.getDescricaoItem());
        System.out.println("Total comprado: " + usuario.getQuantidadeComprada());
        System.out.println("Preco individual do item: " + usuario.getPrecoItem());
        System.out.println("Total gasto pelo consumidor: " + usuario.getInvoiceAmount(total, precoItem));
        
        sc.close();
	}
}