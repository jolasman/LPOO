package maze.logic;
import java.io.Serializable;
import java.util.Random;

/**
 * class que implementa as funcionalidades referentes ao heroi.
 * nesta classe e possivel saber-se se o heroi possui o escudo, esta armado, esta morto, ou nao, utilizando os metodos criados.
 *
 */
public class Heroi implements Serializable{

	private int X;
	private int Y;

	private   boolean armado=false;
	private  boolean escudado=false;
	private  char carater='H';
	private  boolean morto=false;

	private  int modo=0;
	private  boolean fimJogo=false;


<<<<<<< HEAD

/**
 * retorna o modo do jogo
 * @return modo do jogo (aleatorio ou static)
 */
=======
	public Heroi(int x,int y){
		X=x;
		Y=y;
	}

>>>>>>> origin/master
	public  int getModo() {
		return modo;
	}
	/**
	 * coloca o valor do parametro recebido como o valor de modo
	 * @param mod modo a fixar
	 */
	public  void setModo(int mod) {
		modo = mod;
	}
	/**
	 * retorna o valor de fimJogo
	 * @return fimJogo
	 */
	public  boolean isFimJogo() {
		return fimJogo;
	}
	/**
	 * coloca o valor do parametro recebido como o valor de fimJogo
	 * @param fimJog se acabou ou nao o jogo
	 */
	public  void setFimJogo(boolean fimJog) {
		fimJogo = fimJog;
	}
	/**
	 * retorna o valor de morto
	 * @return morto
	 */
	public  boolean isMorto() {
		return morto;
	}
	/**
	 * coloca o valor do parametro recebido como o valor de morto
	 * @param mort se o heroi esta morto ou nao
	 */
	public  void setMorto(boolean mort) {
		morto = mort;
	}
	/**
	 * retorna o valor de escudado
	 * @return escudado
	 */
	public  boolean isEscudado() {

		return escudado;
	}
	/**
	 * coloca o valor do parametro recebido como o valor de escudado.
	 * @param escudad se o heroi tem escudo ou nao
	 */
	public  void setEscudado(boolean escudad) {

		if(armado)
			carater='K';
		else
			carater='O';

		escudado = escudad;
	}
	/**
	 * retorna o valor de armado
	 * @return armado
	 */
	public  boolean isArmado() {
		return armado;
	}
	/**
	 * coloca o valor do parametro recebido como o valor de armado
	 * @param armad se o heroi tem espada ou nao
	 */
	public void setArmado(boolean armad) {

		if(escudado)
			carater='K';
		else
			carater='A';

		armado = armad;
	}
	/**
	 * retorna o caracter que esta no labirinto
	 * @return caracter
	 */
	public  char getCarater() {
		return carater;
	}
/**
 * coloca o valor do parametro recebido como o valor de caracter
 * @param carate o caracter do heroi
 */
	public  void setCarater(char carate) {
		carater = carate;
	}
	/**
	 * retorna a posicao X do heroi
	 * @return X
	 */
	public int getHeroiX() {
		return X;
	}
	/**
	 * coloca o valor do parametro recebido como o valor da posicao do heroi em X
	 * @param heroiX posicao do heroi em X
	 */
	public void setHeroiX(int heroiX) {
		this.X = heroiX;
	}
	/**
	 * retorna a posicao Y do heroi
	 * @return Y
	 */
	public int getHeroiY() {
		return Y;
	}
	/**
	 * coloca o valor do parametro recebido como o valor da posicao do heroi em Y
	 * @param heroiY posicao do heroi em Y
	 */
	public void setHeroiY(int heroiY) {
		this.Y = heroiY;
	}
/**
 * cria o heroi numa posicao aleatoria ou static dependendo do modo de jogo. 
 * @param labirinto labirinto de jogo
 * @param tamanho tmanho do labirinto
 * @param modo modo de jogo (aleatorio ou static)
 */
	public Heroi(char[][] labirinto,int tamanho,int modo) {

		this.modo=modo;
		if(modo==0){

			Random ran= new Random();
			do {
				X=ran.nextInt(tamanho-1);
				Y=ran.nextInt(tamanho-1);

				if(labirinto[Y][X]==' ')
				{
					labirinto[Y][X]='H';

					break;
				}

			}while(true);
			return;
		}
		X=1;
		Y=1;
		labirinto[Y][X]='H';
	}

}
