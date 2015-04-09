package maze.logic;

import java.io.Serializable;
import java.util.Random;
/**
 * class onde sao implementados os metodos necessarios para gerar e modificar os dados referentes ao escudo.
 *
 */
public class Escudo implements Serializable{
		
	private int escudoX;
	private int escudoY;
	private boolean ativado =false;
	
<<<<<<< HEAD
	/**
	 * cria o escudo se o modo for aleatorio, caso contrario nao e criado
	 * @param labirinto labirinto de jogo
	 * @param tamanho tamanho do labirinto
	 */
=======
	
	public Escudo(int x, int Y){
		escudoX=x;
		escudoY=Y;
	}
	
>>>>>>> origin/master
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

	/**
	 * retorna a posicao X do escudo
	 * @return escudoX
	 */
	public int getEscudoX() {
		return escudoX;
	}
	/**
	 * coloca o escudo na posicao X recebida como parametro.
	 * @param escudoX posicao x do escudo
	 */
	public void setEscudoX(int escudoX) {
		this.escudoX = escudoX;
	}
	/**
	 * retorna a posicao Y do escudo
	 * @return escudoY
	 */
	public int getEscudoY() {
		return escudoY;
	}
	/**
	 * coloca o escudo na posicao Y recebida como parametro.
	 * @param escudoY posicao Y do escudo
	 */
	public void setEscudoY(int escudoY) {
		this.escudoY = escudoY;
	}
	/**
	 * retorna se o heroi tem ou nao o escudo (activado/nao activado)
	 * @return ativado
	 */
	public boolean isAtivado() {
		return ativado;
	}
	/**
	 * coloca o valor recebido como parametro como o valor de activado.
	 * @param ativado se tem o escudo ou nao
	 */
	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}
}
