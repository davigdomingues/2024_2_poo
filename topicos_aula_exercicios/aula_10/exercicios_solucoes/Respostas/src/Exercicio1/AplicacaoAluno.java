//Exercício 1
package Exercicio1;

import java.lang.reflect.Field;
import java.util.Scanner;

public class AplicacaoAluno {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bem-vindo à USP, colega!\nSistema inicializando......");
        Thread.sleep(5000);

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do Aluno a ser cadastrado: ");
        String nome = sc.nextLine();
        System.out.println("Informe o curso do Aluno a ser cadastrado: ");
        String curso = sc.nextLine();
        System.out.println("Informe o código do Aluno a ser cadastrado: ");
        String codigo = sc.nextLine();

        Aluno aluno = new Aluno(nome, curso, codigo);

        System.out.println("Cadastrando....");
        Thread.sleep(5000);

        System.out.println("Aluno " + aluno.nomeAluno() + " cadastrado com sucesso!");
        System.out.println("Informacoes associadas:");
        System.out.println(aluno); /* chamada automática do método toString, ou seja, é o
            mesmo que escrever: System.out.println(aluno.toString());*/

        Field[] campos = aluno.getClass().getDeclaredFields();
        for (Field campo : campos) {
            if (campo.getName().equals("cursoAluno")) {
                campo.setAccessible(true);
                System.out.println("Modificando o valor do campo: " + campo.getName());

                try {
                    campo.set(aluno, "Computacao");
                    System.out.println("Cadastrando....");
                    Thread.sleep(5000);

                    System.out.println("Aluno " + aluno.nomeAluno() + " cadastrado com sucesso!");
                    System.out.println("Informacoes associadas:");
                    System.out.println(aluno); /* chamada automática do método toString, ou seja, é o
                        mesmo que escrever: System.out.println(aluno.toString());*/
                } catch (IllegalAccessException e) {
                    System.err.println("Erro ao modificar o campo " + campo.getName());
                }
            }
        }
    }
}