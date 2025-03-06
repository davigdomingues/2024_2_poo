import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.print("Dia: ");
		int dia = sc.nextInt();
		
		while (dia < 1 || dia > 31){
		    System.out.print("Dia: ");
		    dia = sc.nextInt();
		}
		
		System.out.print("Mes (1 - janeiro, 2 - fevereiro, ...) : ");
		int mes = sc.nextInt();
		
		while (mes < 1 || mes > 12){
		    System.out.println("Mes (1 - janeiro, 2 - fevereiro, ...) : ");
		    mes = sc.nextInt();
		}
	
		System.out.print("Ano: ");
		int ano = sc.nextInt();
		
		while (ano < 0){
		    System.out.print("Ano: ");
		    ano = sc.nextInt();
		}
		
		switch (mes){
		    case 4: case 6: case 9: case 11:
		        while (dia > 30 || dia < 1){
		            System.out.print("Informe um novo dia: ");
		            dia = sc.nextInt();
		        }
		        break;
		  
		    case 2:
		        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                    while (dia > 29) {
                        System.out.print("Dia inválido para fevereiro em ano bissexto. Informe um novo dia: ");
                        dia = sc.nextInt();
                    }
                } else {
                    while (dia > 28) {
                        System.out.print("Dia inválido para fevereiro em ano não bissexto. Informe um novo dia: ");
                        dia = sc.nextInt();
                    }
                }
                break;
		}
		
		System.out.println(dia + "/" + mes + "/" + ano);
		
		switch(mes){
		    case 1: case 2: System.out.println("Estacao: Verao"); break;
		    
		    case 3:
		        if (dia < 23) 
                    System.out.println("Estação: Verão");
                else 
                    System.out.println("Estação: Outono");
		        break;
		        
		    case 4: case 5: System.out.println("Estacao: Outono"); break;
		    
		    case 6: 
		        if (dia < 21) 
                    System.out.println("Estação: Verão");
                else 
                    System.out.println("Estação: Outono");
		        break;
		       
		    case 7: case 8: System.out.println("Estacao: Inverno"); break;
		    
		    case 9: 
		        if (dia < 23) 
                    System.out.println("Estação: Verão");
                else 
                    System.out.println("Estação: Outono");
		        break;
		        
		    case 10: case 11: System.out.println("Estacao: Inverno"); break;
		    
		    case 12: 
		        if (dia < 23) 
                    System.out.println("Estação: Verão");
                else 
                    System.out.println("Estação: Outono");
		        break;
		}
		sc.close();
	}
}
