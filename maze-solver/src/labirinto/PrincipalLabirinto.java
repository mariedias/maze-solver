package tarefaModulo2;
import java.io.*;
import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) {
		Labirinto l = new Labirinto();
		String nomeArquivo;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo.txt: ");
		nomeArquivo = scanner.nextLine();
			
		l.setFileName(nomeArquivo);
		l.carregaLabirinto(nomeArquivo);
		
		File f = new File("saidaLabirinto.txt");
		try {
			FileWriter fr = new FileWriter(f);
			PrintWriter out = new PrintWriter (fr);
			
			if(l.labirinto(l.getLabirinto())) {
				out.println("Existe um caminho para o labirinto :)");
			}
			else {
				out.println("Não existe um caminho para o labirinto :(");
			}
			out.close();
			
			System.out.println("Verifique o arquivo 'saidaLabirinto.txt' para descobrir se existe um caminho para o labirinto!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever arquivo.");
		}
		
		scanner.close();
		
	}

}
 