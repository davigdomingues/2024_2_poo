public class Calculadora extends CalculadoraBasica implements OperacaoMatematicaAdicional{
    @Override
    public double divisao(int a, int b){
        if (b == 0)
            throw new ArithmeticException("Divisao por zero nao permitida.");
        return (double) a/b;
    }

    public int resto(int a, int b){
        if (b == 0)
            throw new ArithmeticException("Resto por zero nao existe.");
        return a%b;
    }
}