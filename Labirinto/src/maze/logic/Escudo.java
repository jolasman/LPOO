package maze.logic;

import java.io.Serializable;
import java.util.Random;

public class Escudo implements Serializable{
		
	private int escudoX;
	private int escudoY;
	private boolean ativado =false;
	
	
	public Escudo(int x, int Y){
		escudoX=x;
		escudoY=Y;
	}
	
	public Escudo(char[][]labirinto, int tamanho){
		
		Random ran= new Random();
		do {
			escudoX=ran.nextInt(tamanho-1);
			escudoY=ran.nextInt(tamanho-1);

			if(labirinto[escudoY][escudoX]==' ')
			{
				labirinto[escudoY][escudoX]='P';

				break;
			}

		}while(true);
	
		labirinto[escudoY][escudoX]='P';
		
	}


	public int getEscudoX() {
		return escudoX;
	}


	public void setEscudoX(int escudoX) {
		this.escudoX = escudoX;
	}


	public int getEscudoY() {
		return escudoY;
	}


	public void setEscudoY(int escudoY) {
		this.escudoY = escudoY;
	}


	public boolean isAtivado() {
		return ativado;
	}


	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}
	
	
	
	
		
}
