package maze.logic;

import java.io.Serializable;
import java.util.Random;
/**
 * class onde sao tratados os dados referentes a utilizacao da espada no jogo.
 *e possivel gerar, colocar e saber a posicao da espada no labirinto atraves dos metodos desenvolvidos.
 */
public class Espada implements Serializable{

	private int espadaY;
	private int espadaX;

<<<<<<< HEAD
/**
 * retorna a posicao Y da espada.
 * @return espadaY
 */
=======


	public Espada(int x,int y){
		espadaX=x;
		espadaY=y;
	}
	
	
>>>>>>> origin/master
	public int getEspadaY() {
		return espadaY;
	}
/**
 * coloca a espada na posicao Y recebida como parametro.
 * @param espadaY posicao Y da espada
 */
	public void setEspadaY(int espadaY) {
		this.espadaY = espadaY;
	}
/**
 * retorna a posicao X da espada.
 * @return espadaX
 */
	public int getEspadaX() {
		return espadaX;
	}
/**
 * coloca a espada na posicao X recebida como parametro.
 * @param espadaX posicao X da espada
 */
	public void setEspadaX(int espadaX) {
		this.espadaX = espadaX;
	}
/**
 * cria a espada aleatoriamente ou num sitio predefenido dependendo do modo de jogo(aleatorio ou static)
 * @param labirinto labirinto de jogo
 * @param tamanho tamanho do labirinto
 * @param modo modo de jogo (aleatorio ou static)
 */
	public Espada(char[][] labirinto,int tamanho,int modo){

		if(modo==0){
			Random ran= new Random();
			do {

				espadaX=ran.nextInt(tamanho-1);
				espadaY=ran.nextInt(tamanho-1);


				if(labirinto[espadaY][espadaX]==' ')
				{
					labirinto[espadaY][espadaX]='E';
					break;
				}


			}while(true);
			return ;
		}
		espadaX=1;
		espadaY=8;
		labirinto[espadaY][espadaX]='E';
	}
}
