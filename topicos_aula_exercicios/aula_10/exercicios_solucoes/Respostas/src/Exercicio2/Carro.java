//Exercício 2
package Exercicio2;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Carro(String marca, String modelo, int ano, double preco){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = anoCarro(ano);
        this.preco = precoCarro(preco);
    }

    private int anoCarro(int ano){
        return Math.max(ano, 1910);
    }

    private double precoCarro(double preco){
        if (preco <= 0)
            return 100000;
        else return preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return marca + ", " + modelo + ", " + ano + ", " + preco + "\n";
    }
}
