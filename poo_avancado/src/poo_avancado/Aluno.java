package poo_avancado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aluno {
	public String nome;
	public double[] notas;
	
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
			Arrays.toString(notas);
			soma += nota;
		}
		
		return soma / notas.length;
	}
	
	@Override
	public String toString() {
		return 	"Nome: " + getNome()
				+ " | Notas: " + Arrays.toString(notas) 
				+ " | Situacao: " + getSituacao();
	}

	public String getSituacao() {
		double media = getMedia();
		if (media >= 7)	return "Aprovado";
		if (media >= 5) return "Recuperação";
		return "Reprovado";
	}
	
	static int lerQuantidadeAvaliacoes(int quantidadeAvaliacoes, Scanner scanner) {

		while (true) {

            if (scanner.hasNextInt()) {
            	quantidadeAvaliacoes = scanner.nextInt();
                scanner.nextLine();  
                
                if (quantidadeAvaliacoes > 0) {
                	System.out.printf("Quantidade definida: %d %n", quantidadeAvaliacoes);
                    break;
                } else {
                    System.out.println("Número inteiro inválido! O número deve ser maior que zero.");
                	System.out.println("Digite a quantidade novamente:");
                } 
            }
        }
		
		return quantidadeAvaliacoes;
	}
	
	static double lerNotas(String string, Scanner scanner) {
		while (true) {

            System.out.print(string);

            if (scanner.hasNextDouble()) {

                double nota = scanner.nextDouble();
                scanner.nextLine();

                if (nota >= 0 && nota <= 10) {
                    return nota;
                }

                System.out.println("Digite uma nota entre 0 e 10.");

            } else {

                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }
	}

	static void cadastrar(Scanner scanner, ArrayList<Aluno> alunos, int quantidadeAvaliacoes) {
        
		System.out.println();
		System.out.println("SISTEMA DE CADASTRO");

		scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		
		nome = normalizarNome(nome);

		double[] notas = new double[quantidadeAvaliacoes]; // 1 semestre = 4 bimestres
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = lerNotas("Nota " + (i + 1) + ": ", scanner);
		}

		Aluno aluno = new Aluno(nome, notas);
		
		System.out.println();
		System.out.printf("Aluno: %s %n", aluno);
		System.out.println("Aluno foi cadastrado! \n");
		System.out.printf("Nome: %s %n", aluno.getNome());
		System.out.printf("Media: %.1f %n", aluno.getMedia());
		System.out.printf("Situacao: %s %n", aluno.getSituacao());
		System.out.println();
		System.out.println();
		
		alunos.add(aluno);
	}

	static void listar(ArrayList<Aluno> alunos) {
		 if (alunos.isEmpty()) {
	            System.out.println("Nenhum aluno cadastrado.");
	            return;
	     }
		
		System.out.println("==== ALUNOS ====");
			
			for (Aluno aluno : alunos) {
				System.out.printf(
						"%s %n",
						aluno);
			}
	}
	
	static String emitirRelatorio(Aluno[] turma) {
		StringBuilder relatorio = new StringBuilder();
		
		
		relatorio.append("RELATORIO \n");
		relatorio.append("-------------- \n");
		
		for (Aluno aluno : turma) {
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
	
	static void buscarPorNome(Scanner scanner, ArrayList<Aluno> alunos) {
		
		if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        }

        System.out.print("Digite o nome ou parte do nome: ");
        String busca = scanner.nextLine().trim();

        if (busca.isEmpty()) {
            System.out.println("Digite um nome para realizar a busca.");
        }

        boolean encontrado = false;

        for (Aluno aluno : alunos) {

            if (aluno.getNome().toLowerCase().contains(busca.toLowerCase())) {

                System.out.println("\nNome: " + aluno.getNome());
                System.out.println("Notas: " + Arrays.toString(aluno.notas));
                System.out.printf("Média: %.1f%n", aluno.getMedia());
                System.out.println("Situação: " + aluno.getSituacao());

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum aluno encontrado.");
        }
        
	}
	
	
	static String exibirEnsalamento(Aluno[] turma, String[][] lugares) {

		StringBuilder ensalamento = new StringBuilder();
		
		
		ensalamento.append("ENSALAMENTO \n");
		ensalamento.append("-------------- \n");

		
		for (int i = 0; i < turma.length; i++) {
			
		    for (int j = 0; j < lugares[i].length; j++) {

		    	lugares[i][j] = turma[i].getNome();
		    	
		    	ensalamento.append(String.format(
		    			"Posicao: %d Estudante: %s %n",
		    			i + 1,
		    			lugares[i][j]));
		    }
		}
		
		return ensalamento.toString();
	}

	static void exibirMetricas(Aluno[] turma) {

        double maior = turma[0].getMedia();
        double menor = turma[0].getMedia();
        double soma = 0;

        for (Aluno aluno : turma) {

            soma += aluno.getMedia();

            if (soma > maior) {
               maior = aluno.getMedia();
            }

            if (soma < menor) {
               menor = aluno.getMedia();
            }
        }

        double mediaTurma = soma / turma.length;

        System.out.println("METRICAS \n");
        System.out.printf("Maior nota: %.1f%n", maior);
        System.out.printf("Menor nota: %.1f%n", menor);
        System.out.printf("Média da turma: %.1f%n", mediaTurma);
    }
}