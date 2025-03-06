// Classe Data
public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor
    public Data(int dia, int mes, int ano) {
        if (eValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    // Método eValida
    public boolean eValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > 31) {
            return false;
        }
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            return false;
        }
        if (mes == 2) {
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                if (dia > 29) {
                    return false;
                }
            } else {
                if (dia > 28) {
                    return false;
                }
            }
        }
        return true;
    }

    // Métodos set/get
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (eValida(dia, this.mes, this.ano)) {
            this.dia = dia;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (eValida(this.dia, mes, this.ano)) {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (eValida(this.dia, this.mes, ano)) {
            this.ano = ano;
        }
    }
}

// Aplicativo TestData
import java.util.Scanner;
public class TestData {
    public static void main(String[] args) {
        // Testando datas válidas e inválidas
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Data:");
		System.out.print("Dia: ");
		int dia = sc.nextInt();
		System.out.print("Mes: ");
		int mes = sc.nextInt();
		System.out.print("Ano: ");
		int ano = sc.nextInt();
		
		
        Data data = new Data(dia, mes, ano); // passam-se argumentos, pois auxiliarão no construtor definido na classe Data.

        // Exibindo os resultados
        System.out.println("Data: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno());
		
		/*Se não usar a classe Scanner, pode - se usar os setters da classe Data:
		Data.setDia(dia);
		Data.setMes(mes);
		Data.setAno(ano);
		
		Exibindo os resultados
        System.out.println("Data: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno());
		
		Obs: neste caso, os setters são privados!
		*/
}