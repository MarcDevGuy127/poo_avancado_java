package poo_avancado;

import java.util.ArrayList;
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
	
	static double lerNotas(String string, Scanner scanner) {
		System.out.print(string);
		return scanner.nextDouble();
	}

	static void cadastrar(Scanner scanner, ArrayList<Aluno> alunos) {
				System.out.println();
				System.out.println("SISTEMA DE CADASTRO");

				scanner.nextLine();
				System.out.println("Nome: ");
				String nome = scanner.nextLine();
				
				nome = normalizarNome(nome);

				double[] notas = new double[4]; // 1 semestre = 4 bimestres
				
				for (int i = 0; i < notas.length; i++) {
					notas[i] = lerNotas("Nota " + (i + 1) + ": ", scanner);
				}

				scanner.nextLine();

				Aluno aluno = new Aluno(nome, notas);
				
				System.out.println();
				System.out.println("Aluno foi cadastrado! \n");
				System.out.printf("Nome: %s %n", aluno.getNome());
				System.out.printf("Media: %.1f %n", aluno.getMedia());
				System.out.printf("Situacao: %s %n", aluno.getSituacao());
				System.out.println();
				System.out.println();
				
				alunos.add(aluno);
	}

	static void listar(ArrayList<Aluno> alunos) {
			System.out.println("==== ALUNOS ====");
			
			for (Aluno aluno : alunos) {
				System.out.printf(
				"%-20s | %4.1f | %12s %n",
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
					"%-20s | %4.1f | %12s %n",
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
			if (aluno != null &&
				aluno.getNome().equalsIgnoreCase(nome)) {
				return aluno;
			}
		}
		
		return null;
	}
	
	
	
	/*static Aluno buscarMaiorMedia(ArrayList<Aluno> alunos) {
		
		StringBuilder relatorioMaiorMedia = new StringBuilder();
		
		
		relatorioMaiorMedia.append("RELATORIO MAIOR MEDIA \n");
		relatorioMaiorMedia.append("-------------- \n");
		
		for (Aluno aluno : alunos) {
			if (aluno.getMedia() > alunos.length) {
				
			}
			relatorioMaiorMedia.append(String.format(
					"%-20s | %4.1f | %12s %n",
					aluno.getNome(),
					aluno.getMedia(), 
					aluno.getSituacao()
			));
		}
	}*/
}
