package tarefaModulo2;
import java.io.*;

public class Labirinto {
	private char[][] labirinto;
	private String fileName;

	public char[][] carregaLabirinto(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);

			int numL = Integer.parseInt(in.readLine());
			int numC = Integer.parseInt(in.readLine());

			this.labirinto = new char[numL][numC];

			for (numL = 0; numL < labirinto.length; numL++) {
				String linhaLabirinto = in.readLine();
				for (numC = 0; numC < labirinto[0].length; numC++) {
					labirinto[numL][numC] = linhaLabirinto.charAt(numC);
				}
			}

			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + fileName + "\" não existe.");
			System.out.println("Finalizando sistema...");
			System.exit(1);

		} catch (IOException e) {
			System.out.println("Erro na leitura de " + fileName + ".");
			System.out.println("Finalizando sistema...");
			System.exit(1);
			
		}
		return labirinto;
	}

	public boolean labirinto(char[][] labirinto) {
		this.labirinto = carregaLabirinto(fileName);
		return verificaLabirinto(0, 0);
	}

	private boolean verificaLabirinto(int linha, int coluna) {
		if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length
				|| labirinto[linha][coluna] == 'X' || labirinto[linha][coluna] == 'V') {
			return false;
		}
		if (labirinto[linha][coluna] == 'D') {
			return true;
		}

		labirinto[linha][coluna] = 'V';
		if (verificaLabirinto(linha - 1, coluna) || verificaLabirinto(linha + 1, coluna)
				|| verificaLabirinto(linha, coluna - 1) || verificaLabirinto(linha, coluna + 1)) {
			return true;
		}

		labirinto[linha][coluna] = ' ';
		
		return false;
	}

	public char[][] getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
