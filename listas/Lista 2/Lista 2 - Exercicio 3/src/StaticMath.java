public class StaticMath {
    //private final double PI = Math.PI;
    // private final double EULER = Math.E;

    public static double potencia(double base, double expoente){
        return Math.pow(base, expoente);
    }

    public static int maximo(int number1, int number2){
        return Math.max(number1, number2);
        /* estrutura idêntica à esta:
        if (number1 > number2) return number1;
        else return number2;
         */
    }

    public static int minimo(int number1, int number2){
        return Math.min(number1, number2);
        /* estrutura idêntica à esta:
        if (number1 < number2) return number1;
        else return number2;
         */
    }

    public static int absoluto(int number){
        return Math.abs(number); //método Math java que retorna o módulo do valor informado na main.
    }

    public static double multiplicar(double number1, double number2){
        return number1*number2;
    }
}
