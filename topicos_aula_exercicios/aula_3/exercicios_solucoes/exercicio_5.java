class IntNaoNeg {
        double calculaFatorial(int n){
            double fatorial = 1.0, euler = 0.0;
           
            if (n <=0){
                n = 0;
                fatorial = 1;
                System.out.println("Valor negativo ou nulo sera tomado como valor 0 para efeitos de simplificacao de calculos!");
            }
           
            else {
                for (int i = 0; i <= n; i++)
                    if (i == 0) euler = 1;
                    else{
                        fatorial *= i;
                        euler += 1/fatorial;
                    }
            }
           
            return euler;
        }
}