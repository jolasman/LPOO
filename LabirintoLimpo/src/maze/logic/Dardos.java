package maze.logic;

import java.io.Serializable;
import java.util.Random;

public class Dardos implements Serializable{
	
	private int dardoY;
	private int dardoX;
	
	private boolean apanhado= false;

	public int getDardoY() {
		return dardoY;
	}

	public void setDardoY(int dardoY) {
		this.dardoY = dardoY;
	}

	public int getDardoX() {
		return dardoX;
	}

	public void setDardoX(int dardoX) {
		this.dardoX = dardoX;
	}

	public boolean isApanhado() {
		return apanhado;
	}

	public void setApanhado(boolean apanhado) {
		this.apanhado = apanhado;
	}
	
	
	public Dardos(int x, int y){
		dardoY=y;
		dardoX=x;
	}
	
	public Dardos(char[][] labirinto,int tamanho){
		
		Random ran= new Random();
		do {
			dardoY=ran.nextInt(tamanho-1);
			dardoX=ran.nextInt(tamanho-1);

			if(labirinto[dardoY][dardoX]==' ')
			{
				labirinto[dardoY][dardoX]='-';
				break;
			}

		}while(true);
		
		
		
		
	}
	
	

}
