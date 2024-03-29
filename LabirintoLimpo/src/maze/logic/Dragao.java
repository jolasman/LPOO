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
