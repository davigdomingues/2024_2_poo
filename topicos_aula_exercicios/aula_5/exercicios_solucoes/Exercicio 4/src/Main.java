import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);  // Define a localidade para US

        System.out.print("Total de vendedores: ");
        int totalVendedores = sc.nextInt();

        while (totalVendedores <= 0){
            System.out.print("Total de vendedores: ");
            totalVendedores = sc.nextInt();
        }

        System.out.print("Informe o total de produtos disponiveis que a loja pode vender: ");
        int totalProdutos = sc.nextInt();
        int[] arrayProdutos = new int[totalProdutos];
        String[] nomeItem = new String[totalProdutos];
        double[] precoItem = new double[totalProdutos];
        int[][] totalVendas = new int[totalVendedores][totalProdutos];
        //int[] limiteVendas = new int[totalProdutos];

        for (int i = 0; i < arrayProdutos.length; i++) {
            System.out.print("Nome do produto " + (i + 1) + ": ");
            nomeItem[i] = sc.next();

            while (nomeItem[i].isEmpty()){ //mesmo que nomeItem[i].equals("");
                System.out.print("Nome do produto " + (i + 1) + ": ");
                nomeItem[i] = sc.next();
            }

            System.out.print("Numero do produto " + (i + 1) + ": ");
            arrayProdutos[i] = sc.nextInt();

            while (arrayProdutos[i] <= 0){
                System.out.print("Numero do produto " + (i + 1) + ": ");
                arrayProdutos[i] = sc.nextInt();
            }

            System.out.print("Valor do produto " + (i + 1) + ": ");
            precoItem[i] = sc.nextDouble();

            while (precoItem[i] <= 0){
                System.out.print("Valor do produto " + (i + 1) + ": ");
                precoItem[i] = sc.nextDouble();
            }
        }

        for (int i = 0; i < totalVendedores; i++){
            System.out.print("Ate qual produto o vendedor " + (i + 1) + " pode realizar vendas? ");
            int limiteVendas = sc.nextInt();

            while (limiteVendas <= 0 || limiteVendas > totalProdutos){
                System.out.print("Ate qual produto o vendedor " + (i + 1) + " pode realizar vendas? ");
                limiteVendas = sc.nextInt();
            }

            for (int j = 0; j < limiteVendas; j++) {
                System.out.print("Total de vezes que o produto " + (j + 1) + " foi vendido: ");
                totalVendas[i][j] = sc.nextInt();

                while (totalVendas[i][j] < 0){
                    System.out.print("Total de vezes que o produto " + (j + 1) + " foi vendido: ");
                    totalVendas[i][j] = sc.nextInt();

                }
            }
        }

        System.out.println("\nInformacoes dispostas:");

        int vendedorMaisSucedido = 0;
        int maiorQuantidadeVendida = 0;
        double maiorPrecoVendido1 = 0;
        //double maiorPrecoVendido2 = 0;
        int maiorVolumeVendas = 0;
        int vendedorMaiorVolumeVendas = 0;
        double lucroFinal = 0.0;

        /* versão que fiz antes.... (nos primórdios, o programa funcionava, mas essa parte
        foi a que deu problemas, porque havia um erro na indicação de qual vendedor, de
        fato, conseguiu vender a maior quantidade de produtos......)

        int X = 0;
        for (int i = 0; i < totalVendas.length; i++)
            X = Math.max(limiteVendas[0], limiteVendas[i]);
        int[] somaVendas = new int[X]; --> Poderíamos usar noções mais avançadas de ponteiros,
        ou até mesmo a noção de arrays multidimensionais (regulares ou irregulares), mas a
        efeito de simplificação da resolução, decidi apenas encontrar o maior limiteVendas[i]
        para fazer uma "alocação universal", apesar da presença de lixo de memória, nesse caso,
        ser inevitável.
        */

        // Calculo do total de vendedores e o melhor dentre eles
        for (int i = 0; i < totalVendedores; i++) {
            int totalVendasVendedor = 0;
            for (int j = 0; j < totalProdutos; j++) {
                totalVendasVendedor += totalVendas[i][j];
                lucroFinal += totalVendas[i][j] * precoItem[j];

                // Verifica a maior quantidade vendida de um único produto
                if (totalVendas[i][j] > maiorQuantidadeVendida) {
                    maiorQuantidadeVendida = totalVendas[i][j];
                    vendedorMaisSucedido = i + 1; // Store 1-based index
                    maiorPrecoVendido1 = precoItem[j];
                }
            }

            /* Verifica qual vendedor vendeu a maior quantidade de produtos, ou seja,
            a variedade de produtos envolvida
            */
            if (totalVendasVendedor > maiorVolumeVendas) {
                maiorVolumeVendas = totalVendasVendedor;
                vendedorMaiorVolumeVendas = i + 1; // Store 1-based index
            }
        }

        /* versão que fiz antes..... (--> pior que funcionava kkkkkk)
        int maiorSomaVendas = 0;


        for (int i = 0; i < arrayProdutos.length; i++){

            for (int j = 0; j < limiteVendas[i]; j++){
                if (maiorQuantidadeVenda < totalVendas[j] ) {
                    maiorQuantidadeVenda = totalVendas[j];
                    maiorPrecoVendido1 = precoItem[j];

                    for (int a = 0, b = 0; a < limiteVendas[j]; a++, b++){
                        somaVendas[b] += totalVendas[j];

                        if (maiorSomaVendas < somaVendas[b]){
                            maiorSomaVendas = somaVendas[b];
                            vendedorMaisSucedido = b + 1;
                        }
                    }
                }
            }

            for (int l = 0; l < totalVendedores; l++){
                if (maiorVolumeVendas < limiteVendas[l]){
                    maiorVolumeVendas = limiteVendas[l];
                    vendedorMaiorVolumeVendas = l + 1;
                    maiorPrecoVendido2 = precoItem[l];
                }
            }

            for (int b = 0, c = 0; b < limiteVendas[c]; b++, c++){
                for (int k = 0; k < totalProdutos; k++){
                    for (int a = 0; a < totalVendas[k]; a++){
                        lucroFinal += totalVendas[a]*precoItem[a];
                    }
                }
            }
        }
        */

        System.out.println("\nDados relevantes:");
        System.out.println("Vendedor com o maior número de itens vendidos: " + vendedorMaisSucedido + "\nMaior valor dessas vendas: " + maiorPrecoVendido1);
        System.out.println("Vendedor com o maior volume de vendas: " + vendedorMaiorVolumeVendas);
        System.out.println("Valor total das vendas realizadas pela loja: " + lucroFinal);

        sc.close();
    }
}