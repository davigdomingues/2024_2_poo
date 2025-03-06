public class Main {
    public static void main(String[] args) {
        int[] somaFinal = new int[11]; //todos os valores de cada posição são atribuidos a zero por padrão.

        for (int i = 0; i < 36000; i++){
            Dados dados = new Dados();
            int a = dados.pegarValor();
            int b = dados.pegarValor();
            somaFinal[a + b - 2]++; /* menor valor eh 0 e o maior eh 12. Ou poderia usar: somaFinal[dados1.pegarValor() + dados2.pegarValor() - 2]++,
            tal que haja o objeto dados1 e dados2 em função da classe Dados.
            Esse arranjo em somaFinal é a mesma desta estrutura:
            if (a + b == 2) somaFinal[0]++;
            if (a + b == 3) somaFinal[1]++;
            if (a + b == 4) somaFinal[2]++;
            if (a + b == 5) somaFinal[3]++;
            if (a + b == 6) somaFinal[4]++;
            if (a + b == 7) somaFinal[5]++;
            if (a + b == 8) somaFinal[6]++;
            if (a + b == 9) somaFinal[7]++;
            if (a + b == 10) somaFinal[8]++;
            if (a + b == 11) somaFinal[9]++;
            if (a + b == 12) somaFinal[10]++;
            */
        }

        for (int j : somaFinal) System.out.print(j + " \t"); /*for aprimorado que é igual a:
        for (int j = 0; j < somaFinal.length; j++)
            System.out.print(somaFinal[j] + " \t");
        */
    }
}