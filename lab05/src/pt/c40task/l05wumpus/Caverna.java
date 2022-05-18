package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] layout;
	
	public Caverna() {
		layout = new Sala[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				layout[i][j] = new Sala();
			}
		}
	}
	
	public boolean verificarPosicao(int linha, int coluna) {
		boolean valido = false;
		
		if (linha >= 0 && linha <= 3 && coluna >= 0 && coluna <= 3) {
			valido = true;
		}
		
		return valido;
	}
	
	public void conectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		
		if (verificarPosicao(linha, coluna) == true) { //verifiaï¿½ï¿½o de validade de posicionamento
			int sucesso = layout[linha][coluna].addComponente(comp);
			if (sucesso == -1) {
				System.out.println("Erro: posicionamento invalido de componente.");
			}
		}
	}
	
	public void desconectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		
		if (verificarPosicao(linha, coluna) == true) { //verifiaï¿½ï¿½o de validade de posicionamento
			layout[linha][coluna].removerComponente(comp);
		}
	}
	
	public Sala getSala(int linha, int coluna) {
		return layout[linha][coluna];
	}
	
	public char[][] getCaverna() {
		//Retorna uma versï¿½o em String da caverna, levando em conta prioridades.
		char cavernaChar[][] = new char[4][4];
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (layout[i][j].getVisitado() == false) {
					cavernaChar[i][j] = '-';
				}
				
				else {
					cavernaChar[i][j] = layout[i][j].getMaiorPrioridade().getId();
				}
			}
		}
		
		return cavernaChar;
	}
	
	//TEMPORï¿½RIO!!!
	//TEMPORï¿½RIO!!!
	public void imprimirCaverna() {
		char[][] cavernaStr = this.getCaverna();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(cavernaStr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
