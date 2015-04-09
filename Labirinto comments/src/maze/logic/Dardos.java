<<<<<<< HEAD
package maze.logic;

import java.io.Serializable;
import java.util.Random;
/**
 * class onde sao tratados os dados referentes a utilizacao dos dardos por parte do heroi
  */
public class Dardos implements Serializable{
	
	private int dardoY;
	private int dardoX;
	
	private boolean apanhado= false;
/**
 * 
 * @return a posicao y do dardo
 */
	public int getDardoY() {
		return dardoY;
	}
/**
 * 
 * @param dardoY sera o valor da posicao y do dardo
 */
	public void setDardoY(int dardoY) {
		this.dardoY = dardoY;
	}
/**
 * 
 * @return aposicao x do dardo
 */
	public int getDardoX() {
		return dardoX;
	}
/**
 * 
 * @param dardoX sera o valor da posicao x do dardo
 */
	public void setDardoX(int dardoX) {
		this.dardoX = dardoX;
	}
/**
 *retorna se o dardo foi apanhado ou nao
 * @return apanhado
 */
	public boolean isApanhado() {
		return apanhado;
	}
/**
 * 
 * @param apanhado e colocado como o valor de apanhado
 */
	public void setApanhado(boolean apanhado) {
		this.apanhado = apanhado;
	}
	
	/**
	 * gera aleatoriamente a posicao dos dardos no labirinto
	 * @param labirinto labirinto que foi construido
	 * @param tamanho tamanho do labirinto
	 */
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
=======
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
>>>>>>> origin/master
