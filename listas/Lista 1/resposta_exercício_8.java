import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Classe Pessoa
public class Pessoa {
    private String cpf;
    private LocalDate dataNascimento;
    private String nome;
    private String endereco;
    private String cidade;

    // Construtor
    public Pessoa(String cpf, String dataNascimento, String nome, String endereco, String cidade) {
        if (cpf.length() == 14) {
            this.cpf = cpf;
        } else {
            this.cpf = "000.000.000-00"; // Valor padrão
        }

        if (eDataValida(dataNascimento)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        } else {
            this.dataNascimento = LocalDate.of(2000, 1, 1); // Data padrão
        }

        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    // Método para validar a data de nascimento
    private boolean eDataValida(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Método para calcular a idade
    public int calcularIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    // Métodos de acesso e modificação
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() == 14) {
            this.cpf = cpf;
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (eDataValida(dataNascimento)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

// Aplicativo TestPessoa
import java.util.Scanner;

public class TestPessoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo os dados da pessoa
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        // Criando uma instância de Pessoa
        Pessoa pessoa = new Pessoa(cpf, dataNascimento, nome, endereco, cidade);

        // Exibindo os detalhes da pessoa
        System.out.println("\nDetalhes da Pessoa:");
        System.out.println("CPF: " + pessoa.getCpf());
        System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Endereço: " + pessoa.getEndereco());
        System.out.println("Cidade: " + pessoa.getCidade());
        System.out.println("Idade: " + pessoa.calcularIdade() + " anos");

        scanner.close();
    }
}
