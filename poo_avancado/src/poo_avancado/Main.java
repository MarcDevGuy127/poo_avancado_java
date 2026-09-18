package poo_avancado;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		String[][] lugares = new String[3][1];
		
		//Aluno[] turma = new Aluno[3];
		
		//turma[0] = new Aluno("João", new double[]{8.0, 7.5, 9.0});
		//turma[1] = new Aluno("Maria", new double[]{7.0, 8.5, 9.0});
		//turma[2] = new Aluno("Pedro", new double[]{6.5, 7.0, 8.0});
		
		/*
		alunos.add(new Aluno("João", new double[]{8.0, 7.5, 9.0, 7.0}));
		alunos.add(new Aluno("Marcelo", new double[]{9, 9, 0, 10}));
		alunos.add(new Aluno("Carlos", new double[]{8, 9, 0, 9}));
		*/
		
		// Um Array possui um tamanho fixo de elementos/índices.
		// Já o ArrayList possui tamanho variável(que pode ser estendido) de elementos/índices.
		
		int opcao = -1;
		int quantidadeAvaliacoes = 0;
		
		System.out.println("Digite a quantidade de avaliacoes");
		quantidadeAvaliacoes = Aluno.lerQuantidadeAvaliacoes(quantidadeAvaliacoes, scanner);
		
		do {
			System.out.println("SISTEMA DE CADASTRO");
			System.out.println("1 - Cadastrar novo aluno");
			System.out.println("2 - Listar alunos cadastrados");
			System.out.println("3 - Buscar por nome");
			System.out.println("4 - Mostrar notas ordenadas");
			System.out.println("5 - Exibir metricas da turma");
			System.out.println("6 - Filtrar por situação");
			//System.out.println("7 - Exibir ensalamento da turma");
			System.out.println("0 - Sair do sistema");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 0:
				System.out.println("Encerrando programa...");
				break;
			case 1:
				Aluno.cadastrar(scanner, alunos, quantidadeAvaliacoes);
				break;
			case 2:
				Aluno.listar(alunos);
				break;
			case 3:
				Aluno.buscarPorNome(scanner, alunos);
				break;
			case 4:
				Aluno.mostrarNotasOrdenadas(scanner, alunos);
				break;
			case 5:
				Aluno.mostrarEstatisticas(alunos);
				break;
			//case 7:
				//Aluno.exibirEnsalamento(turma, lugares);
				//break;
			default:
				System.out.println("Opcao invalida %n");
			}
		} while (opcao != 0);
		scanner.close();
	}

}
