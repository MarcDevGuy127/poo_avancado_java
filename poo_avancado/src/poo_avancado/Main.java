package poo_avancado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		String[][] lugares = new String[3][1];
		
		Aluno[] turma = new Aluno[3];
		
		turma[0] = new Aluno("João", new double[]{8.0, 7.5, 9.0});
		turma[1] = new Aluno("Maria", new double[]{7.0, 8.5, 9.0});
		turma[2] = new Aluno("Pedro", new double[]{6.5, 7.0, 8.0});
		
		/*
		alunos.add(new Aluno("João", new double[]{8.0, 7.5, 9.0, 7.0}));
		alunos.add(new Aluno("Marcelo", new double[]{9, 9, 0, 10}));
		alunos.add(new Aluno("Carlos", new double[]{8, 9, 0, 9}));
		*/
		
		// Um Array possui um tamanho fixo de elementos/índices.
		// Já o ArrayList possui tamanho variável(que pode ser estendido) de elementos/índices.
		
		int opcao = -1;
		
		do {
			System.out.println("SISTEMA DE CADASTRO");
			System.out.println("1 - Cadastrar novo aluno");
			System.out.println("2 - Listar alunos cadastrados");
			System.out.println("3 - Buscar por nome");
			System.out.println("4 - Emitir relatorio");
			System.out.println("5 - Exibir metricas da turma");
			System.out.println("6 - Exibir ensalamento da turma");
			System.out.println("0 - Sair do sistema");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 0:
				System.out.println("Encerrando programa...");
				break;
			case 1:
				Aluno.cadastrar(scanner, alunos);
				break;
			case 2:
				System.out.println(Aluno.listar(turma));
				break;
			case 3:
				System.out.println("Nome ou parte do nome:");
				String busca = scanner.next();
				
				Aluno encontrado = Aluno.buscarPorNome(alunos, busca);
				
				if (encontrado == null) {
					System.out.println("Aluno nao encontrado");	
				} else {
					System.out.printf("%n %s | %.1f | %s",
							encontrado.getNome(),
							encontrado.getMedia(),
							encontrado.getSituacao());			
				}
				break;
			case 4:
				System.out.println(Aluno.emitirRelatorio(turma));
				break;
				
			case 5:
				Aluno.exibirMetricas(turma);
				break;
			case 6:
				System.out.println(Aluno.exibirEnsalamento(turma, lugares));
				break;
			default:
				System.out.println("Opcao invalida %n");
			}
		} while (opcao != 0);
		scanner.close();
	}

}
