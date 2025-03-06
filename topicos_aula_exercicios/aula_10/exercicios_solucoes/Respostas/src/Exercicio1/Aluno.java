//package Exercicio1;

/* Uma classe record é uma forma de criar classes de dados de forma simplificada,
imutável e declarativa*/
/*
public record Aluno(String nomeAluno, String cursoAluno, String codigoAluno) {

    public String toString() { // método pertencente à classe Object
        return nomeAluno + ", " + cursoAluno + ", " + codigoAluno + "\n";
    }
}
*/

// a classe Aluno foi feita na aula 6 (herança e polimorfismo)
package Exercicio1;

/* Uma classe record é uma forma de criar classes de dados de forma simplificada,
imutável e declarativa*/

import java.util.Objects;

public final class Aluno {
    private String nomeAluno;
    private String cursoAluno;
    private String codigoAluno;

    public Aluno(String nomeAluno, String cursoAluno, String codigoAluno) {
        this.nomeAluno = nomeAluno;
        this.cursoAluno = cursoAluno;
        this.codigoAluno = codigoAluno;
    }

    public String toString() { // método pertencente à classe Object
        return nomeAluno + ", " + cursoAluno + ", " + codigoAluno + "\n";
    }

    public String nomeAluno() {
        return nomeAluno;
    }

    public String cursoAluno() {
        return cursoAluno;
    }

    public String codigoAluno() {
        return codigoAluno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Aluno) obj;
        return Objects.equals(this.nomeAluno, that.nomeAluno) &&
                Objects.equals(this.cursoAluno, that.cursoAluno) &&
                Objects.equals(this.codigoAluno, that.codigoAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAluno, cursoAluno, codigoAluno);
    }

}