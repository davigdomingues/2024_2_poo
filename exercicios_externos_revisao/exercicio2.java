import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Circulo: ");
	    System.out.print("Raio: ");
	    double raio = scanner.nextDouble();
	    
	    System.out.println();
	    
	    System.out.println("Retangulo: ");
	    System.out.print("Largura: ");
	    double largura = scanner.nextDouble();
	    System.out.print("Altura: ");
	    double altura = scanner.nextDouble();
	    
	    Circulo circulo = new Circulo(raio);
	    Retangulo retangulo = new Retangulo(largura, altura);
	    
		System.out.println("Calculo das areas das figuras associadas: ");
		System.out.println("Circulo: " + circulo.calcularArea());
		System.out.println("Circulo: " + retangulo.calcularArea());
		
		scanner.close();
	}
}

abstract class Forma{
    public abstract double calcularArea();
}

public class Circulo extends Forma{
    private double raio;
    
    public Circulo(double raio){
        this.raio = verificarRaio(raio);
    }
    
    private double verificarRaio(double raio){
        return raio > 0 ? raio : 0;
    }
    
    @Override
    public double calcularArea(){
        return (Math.PI * Math.pow(raio, 2));
    }
}

public class Retangulo extends Forma{
    private double largura, altura;
    
    public Retangulo(double largura, double altura){
        this.largura = verificarLargura(largura);
        this.altura = verificarAltura(altura);
    }
    
    private double verificarLargura(double largura){
        return largura > 0 ? largura : 0;
    }
    
    private double verificarAltura(double altura){
        return altura > 0 ? altura : 0;
    }
    
    @Override
    public double calcularArea(){
        return (altura * largura);
    }
}