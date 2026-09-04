package poo_avancado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		Aluno[] turma = new Aluno[3];

		turma[0] = new Aluno("João", new double[]{8.0, 7.5, 9.0});
		turma[1] = new Aluno("Maria", new double[]{7.0, 8.5, 9.0});
		turma[2] = new Aluno("Pedro", new double[]{6.5, 7.0, 8.0});
		
		//Aluno.emitirRelatorio(alunos);
		
		int opcao = -1;
		
		do {
			System.out.println("SISTEMA DE CADASTRO");
			System.out.println("1 - Cadastrar novo aluno");
			System.out.println("2 - Listar alunos cadastrados");
			System.out.println("3 - Buscar por nome");
			System.out.println("4 - Emitir relatorio");
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
					System.out.printf("%s | %.1f | %s%n",
							encontrado.getNome(),
							encontrado.getMedia(),
							encontrado.getSituacao());			
				}
				break;
			case 4:
				System.out.println(Aluno.emitirRelatorio(alunos));
				break;
			default:
				System.out.println("Opcao invalida%n");
			}
		} while (opcao != 0);
		scanner.close();
	}

}
