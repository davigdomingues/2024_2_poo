import java.util.Scanner;
class ValoresLadoTriangulo {
    public static void main(String[] args){
        int[] lado = new int[3];
        boolean a = false, b = false, c = false;
        Scanner entrada = new Scanner(System.in);
       
        for (int i = 0; i < lado.length; i++){
            System.out.print("Informe o tamanho do lado " + (i + 1) + " do triangulo: ");
            lado[i] = entrada.nextInt();
            entrada.nextLine();
            while(lado[i] <= 0) {
                System.out.print("Triangulos nao podem ter lados nulos ou negativos...... informe um valor maior que zero! ");
                lado[i] = entrada.nextInt();
                entrada.nextLine();
            }
        }
       
        if (lado[0] <= lado[1] + lado[2]) a = true;
        if (lado[1] <= lado[0] + lado[2]) b = true;
        if (lado[2] <= lado[0] + lado[1]) c = true;
       
        if(!a || !b || !c) System.out.println("Triangulo impossivel");
        else System.out.println("Triangulo possivel");
    }
}