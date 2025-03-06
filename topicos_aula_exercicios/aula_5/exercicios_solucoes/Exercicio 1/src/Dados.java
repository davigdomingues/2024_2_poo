import java.util.Random;
public class Dados {
    Random random = new Random();
    public int pegarValor(){
        return random.nextInt(1, 7); // funciona tal que menor <= x < maior
    }
}