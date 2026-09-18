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
	
	public double[] getNotas() {
		return notas;
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

		double[] notas = new double[quantidadeAvaliacoes];
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = lerNotas("Nota " + (i + 1) + ": ", scanner);
		}

		Aluno aluno = new Aluno(nome, notas);
		
		System.out.println();
		System.out.printf("Aluno(a) %s foi cadastrado(a)! %n", aluno.getNome());
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
					"Nome: %-20s | Notas: %s | Média: %4.1f | Situação: %12s %n",
					aluno.getNome(),
					Arrays.toString(aluno.getNotas()),
					aluno.getMedia(), 
					aluno.getSituacao()
			);
		}
	}
	
	static void emitirRelatorio(ArrayList<Aluno> alunos) {
		System.out.println("RELATORIO");
		System.out.println("--------------");
		
		for (Aluno aluno : alunos) {
			System.out.printf(
					"Nome: %-20s | Notas: %s | Média: %4.1f | Situação: %12s %n",
					aluno.getNome(),
					Arrays.toString(aluno.getNotas()),
					aluno.getMedia(), 
					aluno.getSituacao()
			);
		}

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
		
		System.out.print("Digite o nome ou parte do nome do aluno: ");
		String busca = scanner.next();
		
		if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        }

        if (busca.isEmpty()) {
            System.out.println("Digite um nome para realizar a busca.");
        }

        boolean encontrado = false;

        for (Aluno aluno : alunos) {

            if (aluno.getNome().toLowerCase().contains(busca.toLowerCase())) {

                System.out.println("\nNome: " + aluno.getNome());
                System.out.println("Notas: " + Arrays.toString(aluno.getNotas()));
                System.out.printf("Média: %.1f%n", aluno.getMedia());
                System.out.println("Situação: " + aluno.getSituacao());

                encontrado = true;
            }
            
            if (!encontrado) {
                System.out.println("Nenhum aluno encontrado.");
            }
        }
        
	}
	
	
	static void mostrarNotasOrdenadas(Scanner scanner, ArrayList<Aluno> alunos) {
		
		System.out.print("Digite o nome ou parte do nome do aluno: ");
        
        String busca = scanner.next().trim();

		if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
		
        if (busca.isEmpty()) {
            System.out.println("Digite um nome.");
            return;
        }
        
        
        String alunoEncontrado = null;
        
        for (Aluno aluno : alunos) {

            if (aluno.getNome().equalsIgnoreCase(busca)/*.contains(busca)*/) {
                alunoEncontrado = aluno.toString();
                
                double[] notasOrdenadas = aluno.getNotas().clone();
                
                System.out.println("Notas desordenadas: " + Arrays.toString(notasOrdenadas));
                
                Arrays.sort(notasOrdenadas);
                
                System.out.println("Notas ordenadas: " + Arrays.toString(notasOrdenadas));
                
                alunoEncontrado.toString();
                break;
            }
            else if (alunoEncontrado == null) {
                System.out.println("Aluno não encontrado.");
                return;
            }

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

	static void mostrarEstatisticas(ArrayList<Aluno> alunos) {

		double soma = 0;
        double maiorMedia = alunos.get(0).getMedia();
        double menorMedia = alunos.get(0).getMedia();

        String alunoMaiorMedia = alunos.get(0).getNome();
        String alunoMenorMedia = alunos.get(0).getNome();
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        
        for (Aluno aluno : alunos) {
        	double media = aluno.getMedia();
            soma += media;

            if (media > maiorMedia) {
                maiorMedia = media;
                alunoMaiorMedia = aluno.getNome();
            }

            if (media < menorMedia) {
                menorMedia = media;
                alunoMenorMedia = aluno.getNome();
            }
        }

        double mediaTurma = soma / alunos.size();

        System.out.println("\n===== ESTATÍSTICAS DA TURMA =====");
        System.out.println("Quantidade de alunos: " + alunos.size());
        System.out.printf("Média geral da turma: %.1f%n", mediaTurma);
        System.out.printf("Maior média: %.1f - %s%n",
                maiorMedia, alunoMaiorMedia);
        System.out.printf("Menor média: %.1f - %s%n",
                menorMedia, alunoMenorMedia);
    }

}