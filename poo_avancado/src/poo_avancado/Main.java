package poo_avancado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		/* teste de emissao de relatorio
		 * alunos.add(new Aluno("Marcelo", 9, 9, 0));
		 * alunos.add(new Aluno("Carlos", 8, 9, 0));
		 * StringBuilder relatorio = new StringBuilder(); */
		
		
		Aluno.emitirRelatorio(alunos);
		
		int opcao = -1;
		
		do {
			System.out.println("SISTEMA DE CADASTRO");
			System.out.println("1 - Cadastrar novo aluno");
			System.out.println("2 - Listar alunos cadastrados");
			// System.out.println("3 - Emitir relatorio");
			System.out.println("3 - Buscar por nome");
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
			/* case 3:
				Aluno.emitirRelatorio(alunos); */
			case 3:
				Aluno.buscarPorNome(scanner, alunos, null);
			default:
				System.out.println("Opcao invalida \n");
			}
		} while (opcao != 0);
		scanner.close();
	}

}
