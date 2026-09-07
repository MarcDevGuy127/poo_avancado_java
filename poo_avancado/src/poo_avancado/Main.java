package poo_avancado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		// Aluno[] turma = new Aluno[4];
		
		alunos.add(new Aluno("João", new double[]{8.0, 7.5, 9.0, 7.0}));
		alunos.add(new Aluno("Marcelo", new double[]{9, 9, 0, 10}));
		alunos.add(new Aluno("Carlos", new double[]{8, 9, 0, 9}));
		
		int opcao = -1;
		
		do {
			System.out.println("SISTEMA DE CADASTRO");
			System.out.println("1 - Cadastrar novo aluno");
			System.out.println("2 - Listar alunos cadastrados");
			System.out.println("3 - Buscar por nome");
			System.out.println("4 - Emitir relatorio");
			System.out.println("5 - Buscar maior media da turma");
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
				Aluno.listar(alunos);
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
				System.out.println(Aluno.emitirRelatorio(alunos));
				break;
			/*case 5:
				Aluno.buscarMaiorMedia(alunos);
				break;*/
			default:
				System.out.println("Opcao invalida %n");
			}
		} while (opcao != 0);
		scanner.close();
	}

}
