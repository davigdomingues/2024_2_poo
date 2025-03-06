import java.util.Scanner;

public class Universidade{
    public static void main(String args[]){
        Scanner sc;
        String opcaoMenu, opcaoMenu2;
        Disciplina arrayDisciplina[];   // array de disciplinas cadastradas
        Aluno arrayAluno[];          // array de alunos cadastrados

        int nroAlunos,        // nro alunos cadastrados
                nroDisciplinas,    // nro disciplinas cadastradas
                maxAlunos,        // nro maximo de alunos
                maxDisciplinas;    // nro maxima de disciplinas

        // variaveis informacoes alunos
        String codigo;
        String nome;
        String curso;
        String orientador;
        float notaGrad;
        char conceitoPos;
        AlunoGraduacao alunoGrad, arrayAlunosGrad[];
        AlunoPosGraduacao alunoPosGrad, arrayAlunosPosGrad[];
        Aluno aluno;
        String disciplinasMatriculadas[];

        // variaveis informacoes disciplinas
        int carga;
        float[] arrayNotasGrad;
        char[] arrayConceitosPos;

        DisciplinaGraduacao disciplinaGrad, arrayDisciplinasGrad[];
        DisciplinaPosGraduacao disciplinaPosGrad, arrayDisciplinasPosGrad[];
        Disciplina disciplina;

        // verificar argumentos programa
        if (args.length != 2){
            System.err.println("Erro execucao programa: falta argumento(s)");
            System.err.println("Uso: java Universidade <nro_maximo_disciplinas> <nro_maximo_alunos>");
            System.exit(0);
        }

        // extrair argumentos
        maxDisciplinas = Integer.parseInt(args[0]);
        maxAlunos = Integer.parseInt(args[1]);

        //inicializacao
        sc = new Scanner(System.in);
        arrayDisciplina = new Disciplina[maxDisciplinas];
        arrayAluno = new Aluno[maxAlunos];
        nroDisciplinas = 0;
        nroAlunos = 0;

        do{
            mostraMenuOpcoes();
            opcaoMenu = sc.nextLine();

            switch(opcaoMenu){
                case "grad":
                    do{
                        mostraMenuOpcoesGrad();
                        opcaoMenu2 = sc.nextLine();
                        switch(opcaoMenu2){
                            case "disciplina": // cadastro nova disciplina graduacao
                                // verifica se pode cadastrar nova disciplina
                                if (nroDisciplinas < arrayDisciplina.length){
                                    System.out.println("-- Cadastro nova disciplina --");
                                    System.out.print("Entre com o codigo da disciplina: ");
                                    codigo = sc.nextLine();

                                    // verifica se disciplina ja esta cadastrada
                                    disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);

                                    if (disciplina == null){ // disciplina nao encontrada - cadastrar nova disciplina
                                        System.out.print("Entre com o nome da disciplina: ");
                                        nome = sc.nextLine();

                                        System.out.print("Entre com a carga da disciplina: ");
                                        carga = Integer.parseInt(sc.nextLine());

                                        // cria e adiciona disciplina no array
                                        arrayDisciplina[nroDisciplinas] = new DisciplinaGraduacao(codigo, nome, carga, maxAlunos);
                                        nroDisciplinas++;
                                    }
                                    else {
                                        System.err.println("Erro: disciplina com codigo ja cadastrado");
                                    }
                                }
                                else {
                                    System.err.println("Numero maximo de disciplinas já atingido");
                                }
                                break;
                            case "aluno": // cadastro novo aluno graduacao
                                // verifica se pode cadastrar novo aluno
                                if (nroAlunos < arrayAluno.length){
                                    System.out.println("-- Cadastro novo aluno --");
                                    System.out.print("Entre com o codigo do aluno: ");
                                    codigo = sc.nextLine();

                                    // verifica se aluno com codigo ja cadastrado
                                    aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                    if (aluno == null){ // aluno nao encontrado - cadastrar novo aluno
                                        System.out.print("Entre com o nome do aluno: ");
                                        nome = sc.nextLine();

                                        System.out.print("Entre com o curso do aluno: ");
                                        curso = sc.nextLine();

                                        // cria e adiciona aluno no array
                                        arrayAluno[nroAlunos] = new AlunoGraduacao(codigo, nome, curso, maxDisciplinas);
                                        nroAlunos++;
                                    } else{
                                        System.err.println("Erro: aluno com codigo ja cadastrado");
                                    }
                                } else{
                                    System.err.println("Nro maximo de alunos alcancado");
                                }
                                break;
                            case "matricula": // matricula aluno em disciplina graduacao
                                System.out.println("-- Cadastro nova matricula aluno em disciplina --");

                                // obtem o codigo do aluno a ser matriculado
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null){ // aluno encontrado - 
                                    // verificar se se trata de aluno da graduacao
                                    if (aluno instanceof AlunoGraduacao){
                                        // obter o codigo da disciplina onde o aluno sera matriculado
                                        System.out.print("Entre com o codigo da disciplina: ");
                                        codigo = sc.nextLine();

                                        // obtem disciplina com o respectivo codigo
                                        disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);

                                        // verifica se disciplina foi encontrada
                                        if (disciplina != null){ // disciplina encontrada
                                            // verifica se se trata de disciplina de graduacao
                                            if (disciplina instanceof DisciplinaGraduacao){
                                                // tenta matricular aluno na disciplina
                                                disciplinaGrad = (DisciplinaGraduacao)disciplina;
                                                alunoGrad = (AlunoGraduacao)aluno;
                                                if (disciplinaGrad.addMatricula(alunoGrad) && alunoGrad.addDisciplina(codigo))
                                                    System.out.println("Matricula realizada com sucesso");
                                                else
                                                    System.err.println("Erro na matricula do aluno na disciplina ");
                                            }
                                            else {
                                                System.err.println("Erro: disciplina nao e' da graduacao");
                                            }
                                        } else {
                                            System.err.println("Erro: disciplina nao encontrada");
                                        }
                                    }
                                    else {
                                        System.err.println("Erro: aluno nao e' da graduacao");
                                    }
                                }
                                else {
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "lista": // obter lista de alunos matriculados em disciplina graduacao
                                // obter o codigo da disciplina 
                                System.out.print("Entre com o codigo da disciplina: ");
                                codigo = sc.nextLine();

                                // obter a disciplina
                                disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                if (disciplina != null) {
                                    // verificar se disciplina da graduacao
                                    if (disciplina instanceof DisciplinaGraduacao){
                                        disciplinaGrad = (DisciplinaGraduacao)disciplina;
                                        arrayAlunosGrad = disciplinaGrad.getMatriculados();
                                        System.out.println();
                                        System.out.println(" -- Lista Alunos Matriculados em " + disciplinaGrad.getCodDisciplina() +
                                                " " + disciplinaGrad.getNomeDisciplina() + " --");
                                        for (int i = 0; i < arrayAlunosGrad.length; i++){
                                            System.out.println(" --> " + arrayAlunosGrad[i].getCodAluno() + " " +
                                                    arrayAlunosGrad[i].getNome());
                                        }
                                    } else{
                                        System.err.println("Erro: disciplina nao e' da graduacao");
                                    }
                                } else{
                                    System.err.println("Erro: disciplina nao encontrada");
                                }
                                break;
                            case "nota": // cadastro nota aluno em disciplina graduacao
                                System.out.println("-- Cadastro de nota de aluno em disciplina --");

                                // obtem o codigo do aluno
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null){ // aluno encontrado 
                                    // verificar se aluno de graduacao
                                    if (aluno instanceof AlunoGraduacao){
                                        // obter o codigo da disciplina onde o aluno esta matriculado
                                        System.out.print("Entre com o codigo da disciplina: ");
                                        codigo = sc.nextLine();

                                        disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                        if (disciplina != null){ // disciplina encontrada
                                            // verificar se disciplina graduacao
                                            if (disciplina instanceof DisciplinaGraduacao){
                                                // ler a nota do aluno
                                                System.out.print("Entre com o nota do aluno: ");
                                                notaGrad = Float.parseFloat(sc.nextLine());

                                                alunoGrad = (AlunoGraduacao)aluno;
                                                disciplinaGrad = (DisciplinaGraduacao)disciplina;

                                                // tenta adicionar nota do aluno na disciplina
                                                if (disciplinaGrad.addNota(alunoGrad, notaGrad))
                                                    System.out.println("Nota atribuida com sucesso");
                                                else
                                                    System.out.println("Erro: aluno nao matriculado na disciplina");
                                            } else {
                                                System.err.println("Erro: disciplina nao e' da graduacao");
                                            }
                                        } else {
                                            System.err.println("Erro: disciplina nao encontrada");
                                        }
                                    } else {
                                        System.err.println("Erro: aluno nao e' da graduacao");
                                    }
                                } else {
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "boletim": // obter o boletim de notas de disciplina graduacao
                                System.out.println("-- Obter o boletim de notas de uma disciplina --");

                                // obter o codigo da disciplina
                                System.out.print("Entre com o codigo da disciplina: ");
                                codigo = sc.nextLine();

                                disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                if (disciplina != null){ // disciplina encontrada
                                    // verificar se disciplina graduacao
                                    if (disciplina instanceof DisciplinaGraduacao){
                                        // obter alunos matriculados na disciplina
                                        disciplinaGrad = (DisciplinaGraduacao)disciplina;
                                        arrayAlunosGrad = disciplinaGrad.getMatriculados();
                                        System.out.println();
                                        System.out.println(" -- Notas Alunos Disciplina " + disciplinaGrad.getCodDisciplina() +
                                                " " + disciplinaGrad.getNomeDisciplina() + " --");
                                        for (int i = 0; i < arrayAlunosGrad.length; i++){
                                            System.out.println(" --> " + arrayAlunosGrad[i].getCodAluno() + " " +
                                                    arrayAlunosGrad[i].getNome() + " " +
                                                    disciplinaGrad.getNotaAluno(arrayAlunosGrad[i]));
                                        }
                                    } else {
                                        System.err.println("Erro: disciplina nao e' da graduacao");
                                    }
                                } else {
                                    System.err.println("Erro: disciplina nao encontrada");
                                }
                                break;
                            case "historico": // obter o historico do aluno nas disciplinas
                                System.out.println("-- Cadastro de nota de aluno em disciplina --");

                                // obtem o codigo do aluno
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null){ // aluno encontrado 
                                    // verificar se aluno de graduacao
                                    if (aluno instanceof AlunoGraduacao){
                                        // recuperar lista disciplinas aluno esta matriculado
                                        alunoGrad = (AlunoGraduacao)aluno;

                                        System.out.println(" -- Historico Aluno " + alunoGrad.getCodAluno() +
                                                " " + alunoGrad.getNome() + " --");
                                        disciplinasMatriculadas = alunoGrad.getMatriculasDisciplina();
                                        for (int i = 0; i < disciplinasMatriculadas.length; i++){
                                            disciplinaGrad = (DisciplinaGraduacao)getDisciplina(arrayDisciplina,
                                                    nroDisciplinas, disciplinasMatriculadas[i]);
                                            System.out.println(" --> " + disciplinaGrad.getCodDisciplina() + " " +
                                                    disciplinaGrad.getNomeDisciplina() + " " +
                                                    disciplinaGrad.getNotaAluno(alunoGrad));
                                        }
                                    } else{
                                        System.err.println("Erro: aluno nao e' da graduacao");
                                    }
                                } else{
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "voltar": // voltar para menu anterior
                                break;
                            default:
                                System.err.println("Opcao invalida: " + opcaoMenu2);
                        } // fim switch 2
                        System.out.println();   // pula linha
                    } while(!opcaoMenu2.equals("voltar"));
                    break;
                case "pos":
                    do{
                        mostraMenuOpcoesPosGrad();
                        opcaoMenu2 = sc.nextLine();
                        switch(opcaoMenu2){
                            case "disciplina": // cadastro nova disciplina pos graduacao
                                // verifica se pode cadastrar nova disciplina
                                if (nroDisciplinas < arrayDisciplina.length){
                                    System.out.println("-- Cadastro nova disciplina --");
                                    System.out.print("Entre com o codigo da disciplina: ");
                                    codigo = sc.nextLine();

                                    // verifica se disciplina ja existe
                                    disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                    if (disciplina == null){ // disciplina nao encontrada - cadastrar nova disciplina
                                        System.out.print("Entre com o nome da disciplina: ");
                                        nome = sc.nextLine();

                                        System.out.print("Entre com a carga da disciplina: ");
                                        carga = Integer.parseInt(sc.nextLine());

                                        // cria e adiciona disciplina no array
                                        arrayDisciplina[nroDisciplinas] = new DisciplinaPosGraduacao(codigo, nome, carga, maxAlunos);
                                        nroDisciplinas++;
                                    } else{
                                        System.err.println("Erro: disciplina com codigo ja cadastrado");
                                    }
                                } else{
                                    System.err.println("Nro maximo de disciplinas alcancado");
                                }
                                break;
                            case "aluno": // cadastro novo aluno pos-graduacao
                                // verifica se pode cadastrar novo aluno
                                if (nroAlunos < arrayAluno.length){
                                    System.out.println("-- Cadastro novo aluno --");
                                    System.out.print("Entre com o codigo do aluno: ");
                                    codigo = sc.nextLine();

                                    // verifica se aluno com codigo ja cadastrado
                                    aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                    if (aluno == null){ // aluno nao encontrado - cadastrar novo aluno
                                        System.out.print("Entre com o nome do aluno: ");
                                        nome = sc.nextLine();

                                        System.out.print("Entre com o curso do aluno: ");
                                        curso = sc.nextLine();

                                        System.out.print("Entre com o orientador do aluno: ");
                                        orientador = sc.nextLine();

                                        // cria e adiciona aluno no array
                                        arrayAluno[nroAlunos] = new AlunoPosGraduacao(codigo, nome, curso, orientador, maxDisciplinas);
                                        nroAlunos++;
                                    } else {
                                        System.err.println("Erro: aluno com codigo ja cadastrado");
                                    }
                                } else {
                                    System.err.println("Nro maximo de alunos alcancado");
                                }
                                break;
                            case "matricula": // matricula aluno em disciplina pos-graduacao
                                System.out.println("-- Cadastro nova matricula aluno em disciplina --");

                                // obtem o codigo do aluno a ser matriculado
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null) { // aluno encontrado
                                    // verificar se aluno pos-graduacao
                                    if (aluno instanceof AlunoPosGraduacao){
                                        // obter o codigo da disciplina onde o aluno sera matriculado
                                        System.out.print("Entre com o codigo da disciplina: ");
                                        codigo = sc.nextLine();

                                        disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                        if (disciplina != null) { // disciplina encontrada
                                            // verificar se disciplina pos-graduacao
                                            if (disciplina instanceof DisciplinaPosGraduacao) {
                                                // tenta matricular aluno na disciplina
                                                alunoPosGrad = (AlunoPosGraduacao)aluno;
                                                disciplinaPosGrad = (DisciplinaPosGraduacao)disciplina;
                                                if (disciplinaPosGrad.addMatricula(alunoPosGrad) && alunoPosGrad.addDisciplina(codigo))
                                                    System.out.println("Matricula realizada com sucesso");
                                                else
                                                    System.out.println("Erro na matricula do aluno na disciplina ");
                                            }
                                            else {
                                                System.err.println("Erro: disciplina nao e' da pos-graduacao");
                                            }
                                        }
                                        else {
                                            System.err.println("Erro: disciplina nao encontrada");
                                        }
                                    }
                                    else {
                                        System.err.println("Erro: aluno nao e' da pos-graduacao");
                                    }
                                }
                                else {
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "lista": // obter lista de alunos matriculados em disciplina graduacao
                                // obter o codigo da disciplina 
                                System.out.print("Entre com o codigo da disciplina: ");
                                codigo = sc.nextLine();

                                // obter a disciplina
                                disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                if (disciplina != null){
                                    // verificar se disciplina pos-graduacao
                                    if (disciplina instanceof DisciplinaPosGraduacao){
                                        disciplinaPosGrad = (DisciplinaPosGraduacao)disciplina;
                                        arrayAlunosPosGrad = disciplinaPosGrad.getMatriculados();
                                        System.out.println();   // pula linha
                                        System.out.println(" -- Lista Alunos Matriculados em " + disciplinaPosGrad.getCodDisciplina() +
                                                " " + disciplinaPosGrad.getNomeDisciplina() + " --");
                                        for (int i = 0; i < arrayAlunosPosGrad.length; i++){
                                            System.out.println(" --> " + arrayAlunosPosGrad[i].getCodAluno() + " " +
                                                    arrayAlunosPosGrad[i].getNome());
                                        }
                                    }
                                    else {
                                        System.err.println("Erro: disciplina nao e' da pos-graduacao");
                                    }
                                }
                                else {
                                    System.err.println("Erro: disciplina nao encontrada");
                                }
                                break;
                            case "conceito": // cadastro nota aluno em disciplina pos-graduacao
                                System.out.println("-- Cadastro de conceito de aluno em disciplina --");

                                // obtem o codigo do aluno
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null){ // aluno encontrado - buscar disciplina
                                    // verifica se aluno pos-graduacao
                                    if (aluno instanceof AlunoPosGraduacao){
                                        // obter o codigo da disciplina onde o aluno esta matriculado
                                        System.out.print("Entre com o codigo da disciplina: ");
                                        codigo = sc.nextLine();

                                        disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                        if (disciplina != null){ // disciplina encontrada
                                            // verifica se disciplina pos-graduacao
                                            if (disciplina instanceof DisciplinaPosGraduacao){
                                                // ler a nota do aluno
                                                System.out.print("Entre com o conceito do aluno (A, B, C ou R): ");
                                                conceitoPos = sc.nextLine().charAt(0);

                                                // tenta adicionar nota do aluno na disciplina
                                                alunoPosGrad = (AlunoPosGraduacao)aluno;
                                                disciplinaPosGrad = (DisciplinaPosGraduacao)disciplina;
                                                if (disciplinaPosGrad.addConceito(alunoPosGrad, conceitoPos))
                                                    System.out.println("Conceito atribuido com sucesso");
                                                else
                                                    System.out.println("Erro: aluno nao matriculado na disciplina");
                                            } else{
                                                System.err.println("Erro: disciplina nao e' da pos-graduacao");
                                            }
                                        }
                                        else
                                        {
                                            System.err.println("Erro: disciplina nao encontrada");
                                        }
                                    }
                                    else {
                                        System.err.println("Erro: aluno nao e' da pos-graduacao");
                                    }
                                }
                                else
                                {
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "boletim": // obter o boletim de notas de disciplina pos-graduacao
                                System.out.println("-- Obter o boletim de notas de uma disciplina --");

                                // obter o codigo da disciplina
                                System.out.print("Entre com o codigo da disciplina: ");
                                codigo = sc.nextLine();

                                disciplina = getDisciplina(arrayDisciplina, nroDisciplinas, codigo);
                                if (disciplina != null){ // disciplina encontrada
                                    // verifica se disciplina pos-graduacao
                                    if (disciplina instanceof DisciplinaPosGraduacao){
                                        // obter alunos matriculados na disciplina
                                        disciplinaPosGrad = (DisciplinaPosGraduacao)disciplina;
                                        arrayAlunosPosGrad = disciplinaPosGrad.getMatriculados();
                                        System.out.println();
                                        System.out.println(" -- Notas Alunos Disciplina " + disciplinaPosGrad.getCodDisciplina() +
                                                " " + disciplinaPosGrad.getNomeDisciplina() + " --");
                                        for (int i = 0; i < arrayAlunosPosGrad.length; i++){
                                            System.out.println(" --> " + arrayAlunosPosGrad[i].getCodAluno() + " " +
                                                    arrayAlunosPosGrad[i].getNome() + " " +
                                                    disciplinaPosGrad.getConceitoAluno(arrayAlunosPosGrad[i]));
                                        }
                                    } else {
                                        System.err.println("Erro: disciplina nao e' da pos-graduacao");
                                    }
                                } else{
                                    System.err.println("Erro: disciplina nao encontrada");
                                }
                                break;
                            case "historico": // obter o historico do aluno nas disciplinas
                                System.out.println("-- Cadastro de nota de aluno em disciplina --");

                                // obtem o codigo do aluno
                                System.out.print("Entre com o codigo do aluno: ");
                                codigo = sc.nextLine();

                                // recupera o aluno
                                aluno = getAluno(arrayAluno, nroAlunos, codigo);
                                if (aluno != null){ // aluno encontrado 
                                    // verificar se aluno de pos-graduacao
                                    if (aluno instanceof AlunoPosGraduacao){
                                        // recuperar lista disciplinas aluno esta matriculado
                                        alunoPosGrad = (AlunoPosGraduacao)aluno;

                                        System.out.println(" -- Historico Aluno " + alunoPosGrad.getCodAluno() +
                                                " " + alunoPosGrad.getNome() + " --");
                                        disciplinasMatriculadas = alunoPosGrad.getMatriculasDisciplina();
                                        for (int i = 0; i < disciplinasMatriculadas.length; i++){
                                            disciplinaPosGrad = (DisciplinaPosGraduacao)getDisciplina(arrayDisciplina,
                                                    nroDisciplinas, disciplinasMatriculadas[i]);
                                            System.out.println(" --> " + disciplinaPosGrad.getCodDisciplina() + " " +
                                                    disciplinaPosGrad.getNomeDisciplina() + " " +
                                                    disciplinaPosGrad.getConceitoAluno(alunoPosGrad));
                                        }
                                    } else{
                                        System.err.println("Erro: aluno nao e' da pos-graduacao");
                                    }
                                } else{
                                    System.err.println("Erro: aluno nao encontrado");
                                }
                                break;
                            case "voltar": // voltar para menu anterior
                                break;
                            default:
                                System.err.println("Opcao invalida: " + opcaoMenu2);
                        } // fim switch 2

                        System.out.println();   // pula linha

                    }
                    while(!opcaoMenu2.equals("voltar"));

                    break;

                case "exit":
                    System.exit(0);
                default:
                    System.err.println("Opcao invalida: " + opcaoMenu);
            } // fim switch

            System.out.println();   // pula linha
        } while(true);
    } // fim main

    public static void mostraMenuOpcoes(){
        System.out.println("Escolha a opcao:");
        System.out.println("<grad> Menu de opcoes para graduacao");
        System.out.println("<pos> Menu de opcoes para pos-graduacao");
        System.out.println("<exit> Sair do programa");
        System.out.println();   // pula linha
    }

    public static void mostraMenuOpcoesGrad(){
        System.out.println("Escolha a opcao:");
        System.out.println("<disciplina> Adicionar nova disciplina");
        System.out.println("<aluno> Adicionar novo aluno");
        System.out.println("<matricula> Matricular um aluno em uma disciplina");
        System.out.println("<lista> Obter lista de alunos matriculados em uma disciplina");
        System.out.println("<nota> Cadastrar nota de um aluno em uma disciplina");
        System.out.println("<boletim> Mostrar o boletim de notas de disciplina");
        System.out.println("<historico> Mostrar historico de aluno ");
        System.out.println("<voltar> Voltar menu anterior");
        System.out.println();   // pula linha
    }

    public static void mostraMenuOpcoesPosGrad(){
        System.out.println("Escolha a opcao:");
        System.out.println("<disciplina> Adicionar nova disciplina");
        System.out.println("<aluno> Adicionar novo aluno");
        System.out.println("<matricula> Matricular um aluno em uma disciplina");
        System.out.println("<lista> Obter lista de alunos matriculados em uma disciplina");
        System.out.println("<conceito> Cadastrar conceito de um aluno em uma disciplina");
        System.out.println("<boletim> Mostrar o boletim de conceitos de disciplina");
        System.out.println("<historico> Mostrar historico de aluno ");
        System.out.println("<voltar> Voltar menu anterior");
        System.out.println();   // pula linha
    }

    public static Aluno getAluno(Aluno[] arrayAluno, int nroAlunos, String codigo){

        for (int i = 0; i < nroAlunos; i++)
            if (arrayAluno[i].getCodAluno().equals(codigo))
                return arrayAluno[i];

        // aluno nao encontrado
        return null;
    }

    public static Disciplina getDisciplina(Disciplina[] arrayDisciplina, int nroDisciplinas, String codigo){

        for (int i = 0; i < nroDisciplinas; i++)
            if (arrayDisciplina[i].getCodDisciplina().equals(codigo))
                return arrayDisciplina[i];

        // disciplina nao encontrada
        return null;
    }
}

public class DisciplinaPosGraduacao extends Disciplina{
    private char[] ArrayConceitos; //nota em letra que representa o intervalo numerico (A, B, ...)
    private int maxMatriculados;

    public DisciplinaPosGraduacao(String nome, String codigo, int carga, int maxMatriculados){
        super(nome, codigo, carga);
        this.maxMatriculados = maxMatriculados;
    }

    public boolean addConceito(AlunoPosGraduacao alunoPosGraduacao, char conceito){
        if (nroAlunos < maxMatriculados && getAluno(alunoPosGraduacao) >= 0){
            ArrayConceitos[getAluno(alunoPosGraduacao)] = conceito;
            nroAlunos++;
            return true;
        }
        return false;
    }

    public boolean addMatricula(AlunoPosGraduacao alunoPosGraduacao){
        if (nroAlunos < maxMatriculados){
            ArrayAlunos[getAluno(alunoPosGraduacao)] = alunoPosGraduacao;
            nroAlunos++;
            return true;
        }
        return false;
    }

    public AlunoPosGraduacao[] getMatriculados(){
        return (AlunoPosGraduacao[]) ArrayAlunos;
    }

    public char[] getConceitos(){
        return ArrayConceitos;
    }

    public char getConceitoAluno(AlunoPosGraduacao alunoPosGraduacao){
        return ArrayConceitos[getAluno(alunoPosGraduacao)];
    }
}

public class AlunoPosGraduacao extends Aluno{
    private String[] orientador;

    public AlunoPosGraduacao(String codigo, String nome, String curso, String[] orientador, int maxDisciplinas){
        super(nome, codigo, curso, maxDisciplinas);
        this.orientador = orientador;
    }
}

public class Aluno {
    private String nome, codigo, curso;
    private int maxDisciplinas;
    private String[] arrayDisciplinasMatriculadas;

    public Aluno(String codigo, String nome, String curso, int maxDisciplinas){
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
        this.maxDisciplinas = maxDisciplinas;
    }

    public boolean addDisciplina(String codDisciplina){

    }

    public String[] getMatriculasDisciplina(){ // mostra o codigo das disciplinas até então cadastradas
        return arrayDisciplinasMatriculadas;
    }
}

public class Disciplina {
    private String nome, codigo;
    private int carga;
    protected Aluno[] ArrayAlunos;
    protected int nroAlunos;

    public Disciplina(String nome, String codigo, int carga){
        this.nome = nome;
        this.codigo = codigo;
        this.carga = carga;
    }

    protected int getAluno(Aluno aluno){
        for (int j = 0; j < ArrayAlunos.length; j++){
            if (ArrayAlunos[j] == aluno) return j; /*compara qual o endereço em que um
            objeto aluno instanciado foi armazenado na memória*/
        }
        return -1;
    }
}

public class DisciplinaGraduacao extends Disciplina{
    private float[] ArrayNotas;
    private int maxMatriculados;

    public DisciplinaGraduacao(String nome, String codigo, int carga, int maxMatriculados){
        super(nome, codigo, carga);
        this.maxMatriculados = maxMatriculados;
    }

    //ArrayAlunos = new float[maxMatriculados]; --> ??

    public boolean addMatricula(AlunoGraduacao alunoGraduacao){
        if (nroAlunos < maxMatriculados){
            ArrayAlunos[nroAlunos] = alunoGraduacao;
            nroAlunos++;
            return true;
        }

        return false;
    }

    public boolean addNota(AlunoGraduacao alunoGraduacao, float nota){
        if (nroAlunos < maxMatriculados && getAluno(alunoGraduacao) >= 0){
            ArrayNotas[getAluno(alunoGraduacao)] = nota;
            return true;
        }
        return false;
    }

    public AlunoGraduacao[] getMatriculados(){
        return (AlunoGraduacao[]) (ArrayAlunos); //casting, que retorna o total de matriculados no momento.
    }

    public float[] getNotas(){
        return ArrayNotas;
    }

    public float getNotaAluno(AlunoGraduacao alunoGraduacao){
        return ArrayNotas[getAluno(alunoGraduacao)];
    }
}

public class AlunoGraduacao extends Aluno{
    public AlunoGraduacao(String nome, String codigo, String curso, int maxDisciplinas){
        super(nome, codigo, curso, maxDisciplinas);
    }
}