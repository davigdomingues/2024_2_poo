import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        List<Animal> animais = new ArrayList<>();
        
        animais.add(new Cachorro());
        animais.add(new Gato());
        
        for (Animal animal : animais){
            animal.fazerSom();
            animal.mover();
            System.out.println();
        }
    }
}

abstract class Animal{
    public abstract void mover();
    
    public void fazerSom(){
        System.out.print("Animal: " + this.getClass().getSimpleName() + "\n");
        System.out.print("Som de Animal: ");
    }
}

public class Cachorro extends Animal{
    @Override
    public void mover(){
        System.out.println("Movimentacao: Corre");
    }
    
    @Override
    public void fazerSom(){
        super.fazerSom();
        System.out.println("Au Au");
    }
}

public class Gato extends Animal{
    @Override
    public void mover(){
        System.out.println("Movimentacao: Anda devagar");
    }
    
    @Override
    public void fazerSom(){
        super.fazerSom();
        System.out.println("Miau");
    }
}