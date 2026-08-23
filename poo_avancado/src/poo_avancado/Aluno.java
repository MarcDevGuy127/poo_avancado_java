package poo_avancado;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
	private String nome;
	private double nota1, nota2;
	private double media;

	public Aluno(String nome, double nota1, double nota2, double media) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
	}

	public String getNome() {
		return nome;
	}

	public double getMedia() {
		media = (nota1 + nota2) / 2.0;
		return media;
	}

	public String getSituacao() {
		if (media >= 7)
			return "Aprovado";
		else if (media >= 5)
			return "Recuperação";
		else
			return "Reprovado";
	}

	static void cadastrar(Scanner scanner, ArrayList<Aluno> alunos) {
		System.out.println();
		System.out.println("SISTEMA DE CADASTRO");

		scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		
		nome = normalizarNome(nome);

		System.out.println("Nota 1: ");
		double nota1 = scanner.nextDouble();

		System.out.println("Nota 2: ");
		double nota2 = scanner.nextDouble();

		double media = 0;

		Aluno aluno = new Aluno(nome, nota1, nota2, media);

		media = aluno.getMedia();

		alunos.add(aluno);

		System.out.println();
		System.out.println("Aluno foi cadastrado! \n");
		System.out.printf("Nome: %s \n", aluno.getNome());
		System.out.printf("Média: %.1f \n", aluno.getMedia());
		System.out.printf("Situacao: %s \n", aluno.getSituacao());
		System.out.println();
	}

	static void listar(ArrayList<Aluno> alunos) {
		
		for (Aluno aluno : alunos) {
			// String join
			System.out.printf(
					"% 20s | %4.1f | % 12s%n",
					aluno.getNome(),
					aluno.getMedia(), 
					aluno.getSituacao());
		}
	}
	
	static void emitirRelatorio(ArrayList<Aluno> alunos) {
		StringBuilder relatorio = new StringBuilder();
		
		
		relatorio.append("RELATORIO \n");
		relatorio.append("-------------- \n");
		
		for (Aluno aluno : alunos) {
			System.out.printf(
					"% 20s | %4.1f | % 12s%n",
					aluno.getNome(),
					aluno.getMedia(), 
					aluno.getSituacao());
		}
		System.out.println(relatorio.toString());
	}
	
	static String normalizarNome(String nome) {
		nome = nome.trim().toLowerCase();
		
		if (nome.isEmpty()) {
			System.out.println("Nome nao pode ficar vazio.");
			return nome;
		}
		
		return nome.substring(0, 1).toUpperCase() 
				+ nome.substring(1);
	}
	
	static Aluno buscarPorNome(ArrayList<Aluno> alunos, String nome) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n");
		System.out.println("Nome ou parte do nome: ");
		String busca = scanner.nextLine();
		
		Aluno encontrado = buscarPorNome(alunos, nome);
		
		if (encontrado == null) {
			System.out.println("Aluno nao encontrado");
		}
		
		for (Aluno aluno : alunos) {
			if (aluno.getNome().toLowerCase()
					.contains(nome.trim().toLowerCase())) {
				return aluno;
			}
		}
		
		scanner.close();
		return null;
	}
}
