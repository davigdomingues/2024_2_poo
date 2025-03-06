import java.util.Scanner;
public class Esfera {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Raio: ");
        double raio = sc.nextDouble();
        Medidas valor = new Medidas();
       
        System.out.println("Respostas associadas a medida do raio informado:");
        System.out.println("Perimetro: " + valor.Perimetro(raio));
        System.out.println("Area: " + valor.Area(raio));
        System.out.println("Volume: " + valor.Volume(raio));
    }
}

public class Medidas {
    public double Area (double r){
        return (Math.pow(r,2)*Math.PI);
    }
   
    public double Volume (double r){
        return ((4*Math.pow(r,3)*Math.PI)/3);
    }
   
    public double Perimetro (double r){
        return (2*r*Math.PI);
    }
}