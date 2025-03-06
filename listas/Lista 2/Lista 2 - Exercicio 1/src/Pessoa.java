public class Pessoa {
    private String nome;
    private int idade;
    private final String cpf; //obs: não é possível criar setter para cpf, pois ele é final, ou seja, invariável.
    private int quantidadeDeHorasTrabalhadas;
    private double salarioHora;

    public Pessoa(String nome, int idade, String cpf, int quantidadeDeHorasTrabalhadas, double salarioHora){
        if (cpf.length() == 14) this.cpf = cpf;
        else this.cpf = "000.000.000-00";

        if (nome.length() <= 40) this.nome = nome;
        else this.nome = "Mirela";

        if (idade < 0) this.idade = 0;
        else this.idade = idade;

        if (quantidadeDeHorasTrabalhadas <= 0 || quantidadeDeHorasTrabalhadas > 12) this.quantidadeDeHorasTrabalhadas = 0;
        else this.quantidadeDeHorasTrabalhadas = quantidadeDeHorasTrabalhadas;

        if (salarioHora <= 0 || salarioHora > 1000) this.salarioHora = 0;
        else this.salarioHora = salarioHora;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getCPF(){
        return cpf;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public int getQuantidadeDeHorasTrabalhadas(){
        return quantidadeDeHorasTrabalhadas;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setQuantidadeDeHorasTrabalhadas(int quantidadeDeHorasTrabalhadas){
        this.quantidadeDeHorasTrabalhadas = quantidadeDeHorasTrabalhadas;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public double calcularSalario(){
        return (double) StaticMath.multiplicar(this.quantidadeDeHorasTrabalhadas, this.salarioHora);
    }

    public void print() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Número de Horas Trabalhadas: " + this.getQuantidadeDeHorasTrabalhadas());
        System.out.println("Salário Hora: " + this.getSalarioHora());
        System.out.println("Salário: " + this.calcularSalario());
    }
}