<<<<<<< HEAD
package maze.logic;
import java.io.Serializable;
import java.util.Random;

/**
 * class que trada os dados referentes aos dragoes.
 * trata da posicao, movimentos e se cospe fogo, anda, adormece ou nao
 *
 */
public class Dragao implements Serializable {

	private static final char ESPACO = ' ';
	private  static final char ESPADA ='E';
	private static final char DRAGAO ='D';


	private int modo;
	private int anda;
	private int cospe;
	private int dorme;
	private int dragaoY ;
	private int dragaoX ;
	private boolean morreu=false;
	private boolean emCimaEspada=false;
	private boolean emCimaEscudo=false;
	private boolean emCimaDardo=false;
	private boolean adormecido;	
/**
 * retorna se o dragao esta em cima da espada
 * @return emCimaEspada
 */
	public boolean isEmCimaEspada() {
		return emCimaEspada;
	}
	/**
	 * coloca o boolean emCimaEspada com o valor recebido no parametro
	 * @param emCimaEspada
	 */
	public void setEmCimaEspada(boolean emCimaEspada) {
		this.emCimaEspada = emCimaEspada;
	}
	/**
	 * retorna se o dragao esta em cima do escudo
	 * @return emCimaEscudo
	 */
	public boolean isEmCimaEscudo() {
		return emCimaEscudo;
	}
	/**
	 * coloca o boolean emCimaEscudo com o valor recebido no parametro
	 * @param emCimaEscudo
	 */
	public void setEmCimaEscudo(boolean emCimaEscudo) {
		this.emCimaEscudo = emCimaEscudo;
	}
	/**
	 * retorna se o dragao esta em cima do dardo
	 * @return emCimaDardo
	 */
	public boolean isEmCimaDardo() { 
		return emCimaDardo;
	}
	/**
	 * coloca o boolean emCimaDardo com o valor recebido no parametro
	 * @param emCimaDardo
	 */
	public void setEmCimaDardo(boolean emCimaDardo) {
		this.emCimaDardo = emCimaDardo;
	}

/**
 * retorna se o dragao esta adormecido
 * @return adormecido
 */
	public boolean isAdormecido() {
		return adormecido;
	}
	/**
	 * coloca o boolean adormecido com o valor recebido no parametro
	 * @param adormecido
	 */
	public void setAdormecido(boolean adormecido) {
		this.adormecido = adormecido;
	}

/**
 * retorna se o dragao esta morto
 * @return morreu
 */
	public boolean isMorreu() {
		return morreu;
	}
	/**
	 * coloca o boolean morreu com o valor recebido no parametro
	 * @param morreu
	 */
	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	/**
	 * retorna a posicao Y do dragao
	 * @return dragaoY
	 */
	public int getDragaoY() {
		return dragaoY;
	}
	/**
	 * coloca o valor dragaoY com o valor recebido no parametro
	 * @param dragaoY
	 */
	public void setDragaoY(int dragaoY) {
		this.dragaoY = dragaoY;
	}
	/**
	 * retorna a posicao X do dragao
	 * @return dragaoX
	 */
	public int getDragaoX() {
		return dragaoX;
	}
	/**
	 * coloca o valor dragaoX com o valor recebido no parametro
	 * @param dragaoX
	 */
	public void setDragaoX(int dragaoX) {
		this.dragaoX = dragaoX;
	}
/**
 * cria um dragao no labirinto com as caracteristicas que lhe sao passadas como parametros
 * @param labirinto o labirinto onde vai ser criado o dragao
 * @param tamanho tamanho do labirinto
 * @param cospe se cospe fogo ou nao
 * @param anda se o dragao se movimenta ou nao
 * @param dorme se dorme ou nao
 * @param modo se o labirinto e aleatorio ou static
 */
	public Dragao(char[][]labirinto, int tamanho,int cospe, int anda,int dorme, int modo) {

		this.dorme=dorme;
		this.cospe=cospe;
		this.anda=anda;
		this.modo=modo;

		if(modo==0){

			Random ran= new Random();
			do {
				dragaoX=ran.nextInt(tamanho-1);
				dragaoY=ran.nextInt(tamanho-1);

				if(labirinto[dragaoY][dragaoX]==ESPACO)
				{
					labirinto[dragaoY][dragaoX]=DRAGAO;

					break;
				}

			}while(true);
			return;
		}
		dragaoX=1;
		dragaoY=3;
		labirinto[dragaoY][dragaoX]=DRAGAO;


	}
/**
 * faz a verificacao para que o dragao seja morto pelo heroi com o dardo
 * @param labirinto labirinto do jogo
 * @param heroiY posicao do heroi em Y
 * @param heroiX posicao do heroi em X
 * @return
 */
	public boolean morreComDardo(char[][] labirinto,int heroiY,int heroiX){


		if(labirinto[heroiY][heroiX]=='X')
			return false;
		
		if(heroiX==dragaoX)
		{ 
			if(heroiY<dragaoY){
				for(int i= heroiY;i<dragaoY;i++){
					if(labirinto[i][dragaoX]=='X')
						return false;
				}
				morreu=true;
				return true;
			}
			else{
				for(int i= dragaoY;i<heroiY;i++){
					if(labirinto[i][dragaoX]=='X')
						return false;
				}
				morreu=true;
				return true;
			}

		}
		else if(heroiY==dragaoY){
			if(heroiX<dragaoX){
				for(int i= heroiX;i<dragaoX;i++){
					if(labirinto[dragaoY][i]=='X')
						return false;
				}
				morreu=true;
				return true;
			}
			else{
				for(int i= dragaoX;i<heroiX;i++){
					if(labirinto[dragaoY][i]=='X')
						return false;
				}
				morreu=true;
				return true;
			}

		}


		return false;
	}
/**
 * funcao onde sao tratados os movimentos do dragao
 * @param labirinto labirinto do jogo
 * @param Y posicao em Y
 * @param X posicao em X
 * @return
 */
	public boolean moveDragao(char [][] labirinto,int Y, int X)
	{


		if(anda==1){
			if(labirinto[dragaoY+Y][dragaoX+X]=='P' && !adormecido){
				emCimaEscudo=true;
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='C';
				return true;
			}

			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPADA && !adormecido){
				emCimaEspada=true;
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='F';
				return true;
			}	

			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO && emCimaEspada  ){ 
				labirinto[dragaoY][dragaoX]=ESPADA;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaEspada=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO && emCimaEscudo ){
				labirinto[dragaoY][dragaoX]='P';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaEscudo=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]=='-' && !emCimaDardo ){
				labirinto[dragaoY][dragaoX]=' ';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='W';
				emCimaDardo=true;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==' ' && emCimaDardo ){
				labirinto[dragaoY][dragaoX]='-';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaDardo=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO){ 
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				return true;
			}
		}
		return false;
	}

/**
 *funcao que verifica o estado do dragao perante o heroi. se o dragao morreu, se matou o horoi ou se esta em movimento longe do heroi, ou perto
 * @param armado estado em que o heroi possui espada
 * @param escudado estado em que o heroi possui escudo
 * @param heroiX posicao X do heroi
 * @param heroiY posicao Y do heroi
 * @param labirinto labirinto do jogo
 * @return 1 se o dragao matou o heroi e 0 se o dragao esta morto ou adormecido
 */
	public int verificaDragao(boolean armado,boolean escudado,int heroiX,int heroiY,char[][]labirinto){

		if(morreu || adormecido )
			return 0;

		if(labirinto[heroiY][heroiX]=='X'){
			return 0;
		}
		
		
		if(cospe==1){
			if(heroiX==dragaoX)
			{ 
				if(!escudado){

					if(heroiY+3==dragaoY)
						if(labirinto[heroiY+2][heroiX]!='X'&& labirinto[heroiY+1][heroiX]!='X')
							return 1; 
					if(heroiY-3==dragaoY)
						if(labirinto[heroiY-2][heroiX]!='X' && labirinto[heroiY-1][heroiX]!='X')
							return 1;
 
					if(heroiY+2==dragaoY)
						if(labirinto[heroiY+1][heroiX]!='X')
							return 1; 
					if(heroiY-2==dragaoY)
						if(labirinto[heroiY-1][heroiX]!='X' )
							return 1;
				}
				else if(!escudado && armado || !escudado && !armado ||escudado &&!armado) 
					if((heroiY+1)==(dragaoY)||(heroiY-1==dragaoY))
					{
						return 1; 
					}

			}
			else if(heroiY==dragaoY)
			{

				if(!escudado){
					if(heroiX+3==dragaoX)
						if(labirinto[heroiY][heroiX+2]!='X' && labirinto[heroiY][heroiX+1]!='X')
							return 1; 
					if(heroiX-3==dragaoX)
						if(labirinto[heroiY][heroiX-2]!='X' && labirinto[heroiY][heroiX-1]!='X')
							return 1;

					if(heroiX+2==dragaoX)
						if(labirinto[heroiY][heroiX+1]!='X')
							return 1; 
					if(heroiX-2==dragaoX)
						if(labirinto[heroiY][heroiX-1]!='X' )
							return 1;
				}
				else if(!escudado && armado || !escudado && !armado||escudado &&!armado) 
					if((heroiX+1)==(dragaoX)||(heroiX-1==dragaoX))
					{
						return 1; 
					}
			}
		}
		else{
			if(!armado){
				if(heroiY==dragaoY){
					if((heroiX+1)==(dragaoX)||(heroiX-1==dragaoX))
					{
						return 1; 
					}
				}
				else if(heroiX==dragaoX){
					if((heroiY+1)==(dragaoY)||(heroiY-1==dragaoY))
					{
						return 1; 
					}

				}

			}
		}
		return 0;
	}
}
=======
package maze.logic;
import java.io.Serializable;
import java.util.Random;


public class Dragao implements Serializable {

	private static final char ESPACO = ' ';
	private  static final char ESPADA ='E';
	private static final char DRAGAO ='D';


	private int modo;
	private int anda;
	private int cospe;
	private int dorme;
	private int dragaoY ;
	private int dragaoX ;
	private boolean morreu=false;
	private boolean emCimaEspada=false;
	private boolean emCimaEscudo=false;
	private boolean emCimaDardo=false;
	private boolean adormecido=false;

	public boolean isEmCimaEspada() {
		return emCimaEspada;
	}
	public void setEmCimaEspada(boolean emCimaEspada) {
		this.emCimaEspada = emCimaEspada;
	}
	public boolean isEmCimaEscudo() {
		return emCimaEscudo;
	}
	public void setEmCimaEscudo(boolean emCimaEscudo) {
		this.emCimaEscudo = emCimaEscudo;
	}
	public boolean isEmCimaDardo() { 
		return emCimaDardo;
	}
	public void setEmCimaDardo(boolean emCimaDardo) {
		this.emCimaDardo = emCimaDardo;
	}




	public boolean isAdormecido() {
		return adormecido;
	}
	public void setAdormecido(boolean adormecido) {
		this.adormecido = adormecido;
	}


	public boolean isMorreu() {
		return morreu;
	}
	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	public int getDragaoY() {
		return dragaoY;
	}
	public void setDragaoY(int dragaoY) {
		this.dragaoY = dragaoY;
	}
	public int getDragaoX() {
		return dragaoX;
	}
	public void setDragaoX(int dragaoX) {
		this.dragaoX = dragaoX;
	}

	public Dragao(int x, int y,int cospe,int anda,int dorme){
		dragaoX=x;
		dragaoY=y;
		this.dorme=dorme;
		this.cospe=cospe;
		this.anda=anda;
		
		
	}
	
	
	public Dragao(char[][]labirinto, int tamanho,int cospe, int anda,int dorme, int modo) {

		this.dorme=dorme;
		this.cospe=cospe;
		this.anda=anda;
		this.modo=modo;

		if(modo==0){

			Random ran= new Random();
			do {
				dragaoX=ran.nextInt(tamanho-1);
				dragaoY=ran.nextInt(tamanho-1);

				if(labirinto[dragaoY][dragaoX]==ESPACO)
				{
					labirinto[dragaoY][dragaoX]=DRAGAO;

					break;
				}

			}while(true);
			return;
		}
		dragaoX=1;
		dragaoY=3;
		labirinto[dragaoY][dragaoX]=DRAGAO;


	}

	public boolean morreComDardo(char[][] labirinto,int heroiY,int heroiX){


		if(labirinto[heroiY][heroiX]=='X')
			return false;
		
		if(heroiX==dragaoX)
		{ 
			if(heroiY<dragaoY){
				for(int i= heroiY;i<dragaoY;i++){
					if(labirinto[i][dragaoX]=='X')
						return false;
				}
				morreu=true;
				return true;
			}
			else{
				for(int i= dragaoY;i<heroiY;i++){
					if(labirinto[i][dragaoX]=='X')
						return false;
				}
				morreu=true;
				return true;
			}

		}
		else if(heroiY==dragaoY){
			if(heroiX<dragaoX){
				for(int i= heroiX;i<dragaoX;i++){
					if(labirinto[dragaoY][i]=='X')
						return false;
				}
				morreu=true;
				return true;
			}
			else{
				for(int i= dragaoX;i<heroiX;i++){
					if(labirinto[dragaoY][i]=='X')
						return false;
				}
				morreu=true;
				return true;
			}

		}


		return false;
	}

	public boolean moveDragao(char [][] labirinto,int Y, int X)
	{


		if(anda==1){
			if(labirinto[dragaoY+Y][dragaoX+X]=='P' && !adormecido){
				emCimaEscudo=true;
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='C';
				return true;
			}

			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPADA && !adormecido){
				emCimaEspada=true;
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='F';
				return true;
			}	

			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO && emCimaEspada  ){ 
				labirinto[dragaoY][dragaoX]=ESPADA;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaEspada=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO && emCimaEscudo ){
				labirinto[dragaoY][dragaoX]='P';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaEscudo=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]=='-' && !emCimaDardo ){
				labirinto[dragaoY][dragaoX]=' ';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]='W';
				emCimaDardo=true;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==' ' && emCimaDardo ){
				labirinto[dragaoY][dragaoX]='-';
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				emCimaDardo=false;
				return true;
			}
			else if(labirinto[dragaoY+Y][dragaoX+X]==ESPACO){ 
				labirinto[dragaoY][dragaoX]=ESPACO;
				dragaoY=dragaoY+Y;
				dragaoX=dragaoX+X;
				labirinto[dragaoY][dragaoX]=DRAGAO;
				return true;
			}
		}
		return false;
	}


	public int verificaDragao(boolean armado,boolean escudado,int heroiX,int heroiY,char[][]labirinto){

		if(morreu || adormecido )
			return 0;

		if(labirinto[heroiY][heroiX]=='X'){
			return 0;
		}
		
		
		if(cospe==1){
			if(heroiX==dragaoX)
			{ 
				if(!escudado){

					if(heroiY+3==dragaoY)
						if(labirinto[heroiY+2][heroiX]!='X'&& labirinto[heroiY+1][heroiX]!='X')
							return 1; 
					if(heroiY-3==dragaoY)
						if(labirinto[heroiY-2][heroiX]!='X' && labirinto[heroiY-1][heroiX]!='X')
							return 1;
 
					if(heroiY+2==dragaoY)
						if(labirinto[heroiY+1][heroiX]!='X')
							return 1; 
					if(heroiY-2==dragaoY)
						if(labirinto[heroiY-1][heroiX]!='X' )
							return 1;
				}
				else if(!escudado && armado || !escudado && !armado ||escudado &&!armado) 
					if((heroiY+1)==(dragaoY)||(heroiY-1==dragaoY))
					{
						return 1; 
					}

			}
			else if(heroiY==dragaoY)
			{

				if(!escudado){
					if(heroiX+3==dragaoX)
						if(labirinto[heroiY][heroiX+2]!='X' && labirinto[heroiY][heroiX+1]!='X')
							return 1; 
					if(heroiX-3==dragaoX)
						if(labirinto[heroiY][heroiX-2]!='X' && labirinto[heroiY][heroiX-1]!='X')
							return 1;

					if(heroiX+2==dragaoX)
						if(labirinto[heroiY][heroiX+1]!='X')
							return 1; 
					if(heroiX-2==dragaoX)
						if(labirinto[heroiY][heroiX-1]!='X' )
							return 1;
				}
				else if(!escudado && armado || !escudado && !armado||escudado &&!armado) 
					if((heroiX+1)==(dragaoX)||(heroiX-1==dragaoX))
					{
						return 1; 
					}

			}
		}
		else{
			if(!armado){
				if(heroiY==dragaoY){
					if((heroiX+1)==(dragaoX)||(heroiX-1==dragaoX))
					{
						return 1; 
					}
				}
				else if(heroiX==dragaoX){
					if((heroiY+1)==(dragaoY)||(heroiY-1==dragaoY))
					{
						return 1; 
					}

				}

			}
		}
		return 0;
	}




}
>>>>>>> origin/master
