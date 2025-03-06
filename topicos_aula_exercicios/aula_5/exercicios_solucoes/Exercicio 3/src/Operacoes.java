public class Operacoes {
    public static void processo(String opcao, int N, double[] vetorN){
        int i;
        switch (opcao){
            case "soma":
                double resultadoSoma = 0.0;
                for (i = 0; i < N; i++)
                    resultadoSoma += vetorN[i];
                System.out.println("Resposta: " + resultadoSoma);
                System.out.println();
                break;

            case "media":
                double resultadoMedia = 0.0;
                for (i = 0; i < N; i++)
                    resultadoMedia += vetorN[i];
                System.out.println("Resposta: " + (resultadoMedia/N));
                System.out.println();
                break;

            case "maior":
                double maior = 0;
                for (i = 0; i < N; i++)
                    maior = Math.max(vetorN[0], vetorN[i]);
                System.out.println("Resultado: " + maior);
                System.out.println();
                break;

            case "menor":
                double menor = 0;
                for (i = 0; i < N; i++)
                    menor = Math.min(vetorN[0], vetorN[i]);
                System.out.println("Resultado: " + menor);
                System.out.println();
                break;

            case "exit":
                System.out.println("Saindo...");
                break; //é imperativo, pois ativa um comando de baixo nível de interrupção abrupta
        }
    }
}