package poo_avancado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aluno {
	private String nome;
	private double[] notas;
	
	public Aluno(String nome, double[] notas) {
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public double getMedia() {
		if (notas == null || notas.length == 0) {
			return 0;
		}
		
		double soma = 0;
		for (double nota : notas) {
			soma += nota;
		}
		
		return soma / notas.length;
	}

	public String getSituacao() {
		double media = getMedia();
		if (media >= 7)	return "Aprovado";
		if (media >= 5) return "Recuperação";
		return "Reprovado";
	}
	
	static double lerNotas(Scanner scanner, String string) {
		return scanner.nextDouble();
	}

	static void cadastrar(Scanner scanner, ArrayList<Aluno> alunos) {
		System.out.println();
		System.out.println("SISTEMA DE CADASTRO");

		scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		
		nome = normalizarNome(nome);

		double[] notas = new double[4];
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = lerNotas(scanner,"Nota " + (i + 1) + ": %d");
		}

		scanner.nextLine();
		
		//Aluno[] turma = new Aluno[3];
		
		Aluno aluno = new Aluno(nome, notas);
		//Aluno[] turma = new Aluno[3];

		aluno.getMedia();

		alunos.add(aluno);

		System.out.println();
		System.out.println("Aluno foi cadastrado! %n");
		System.out.printf("Nome: %s %n", aluno.getNome());
		System.out.printf("Média: %.1f %n", aluno.getMedia());
		System.out.printf("Situacao: %s %n", aluno.getSituacao());
		System.out.println();
	}

	static void listar(Aluno[] turma) {
		
		System.out.println("==== ALUNOS ====");
		
		for (Aluno aluno : turma) {
			
			System.out.printf(
					"%n %-20s | %4.1f | %12s %n",
					aluno.getNome(),
					aluno.getMedia(), 
					aluno.getSituacao());
		}
	}
	
	static String emitirRelatorio(ArrayList<Aluno> alunos) {
		StringBuilder relatorio = new StringBuilder();
		
		
		relatorio.append("RELATORIO \n");
		relatorio.append("-------------- \n");
		
		for (Aluno aluno : alunos) {
			relatorio.append(String.format(
					"%-20s | %4.1f | %12s%n",
					aluno.getNome(),
					aluno.getMedia(), 
					aluno.getSituacao()
			));
		}

		return relatorio.toString();
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
		
		for (Aluno aluno : alunos) {
			if (aluno.getNome().toLowerCase()
					.contains(nome.trim().toLowerCase())) {
				return aluno;
			}
		}
		
		return null;
	}
}
