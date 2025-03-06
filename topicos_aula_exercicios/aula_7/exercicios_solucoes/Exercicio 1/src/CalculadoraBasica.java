public class CalculadoraBasica implements OperacaoMatematica{ //somente para o exercicio 1
    @Override
    public int adicao(int a, int b) {
        return a+b;
    }

    @Override
    public int subtracao(int a, int b) {
        return a-b;
    }

    @Override
    public int multiplicacao(int a, int b) {
        return a*b;
    }
}