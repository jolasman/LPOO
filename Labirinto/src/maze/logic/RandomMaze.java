package maze.logic;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class RandomMaze extends Maze{

	private static final char ESPACO = ' ';
	private static final char PONTO = '.';
	private static final char SAIDA ='S';
	private static final char ESPADA ='E';
	private static final char HEROI ='H';
	static private int TAMANHO;
	static private int TAMANHOaux;

	static private int heroiX;
	static private int heroiY;
	static private int espadaX;
	static private int espadaY;
	static private int saidaX;
	static private int saidaY;

	public  int getHeroiX() {
		return heroiX;
	}

	public  int getHeroiY() {
		return heroiY;
	}

	public  int getEspadaX() {
		return espadaX;
	}

	public  int getEspadaY() {
		return espadaY;
	}

	static private Stack stackX= new Stack();
	static private Stack stackY= new Stack();

	public int getTamanho() {
		return TAMANHO;
	}


	static private int guiaX;
	static private int guiaY;
	static private int guiaXauxiliar;
	static private int guiaYauxiliar;

	private static char[][] auxiliar;
	private static char[][] labirinto ;


	public RandomMaze(int tamanho){
		
		TAMANHO=tamanho;
		TAMANHOaux= (tamanho-1)/2;
		criaLabirinto(tamanho);

	}

	public  char[][] getDados(){
		return labirinto;
	}

	public static boolean deadEnd(){

		String[] cadeia = {"direita","baixo","cima","esquerda"};

		for(int i=0;i<4;i++){
			switch(cadeia[i])
			{
			case "direita":
				if((guiaXauxiliar+1)<TAMANHOaux)
					if(auxiliar[guiaYauxiliar][guiaXauxiliar+1]==PONTO)
						return false;

			case "esquerda":
				if(guiaXauxiliar>0)
					if(auxiliar[guiaYauxiliar][guiaXauxiliar-1]==PONTO)
						return false;

			case "baixo":
				if(guiaYauxiliar+1<TAMANHOaux)
					if(auxiliar[guiaYauxiliar+1][guiaXauxiliar]==PONTO)
						return false;
			case "cima":
				if(guiaYauxiliar>0)
					if(auxiliar[guiaYauxiliar-1][guiaXauxiliar]==PONTO)
						return false;
			}
		}
		return true;

	}

	public static void abreCaminho(){

		Random r= new Random();

		int direcao;

		direcao=r.nextInt(4);

		switch(direcao)
		{

		case 0:// VAI PARA BAIXO
			if(guiaYauxiliar+1<TAMANHOaux){

				if(auxiliar[guiaYauxiliar+1][guiaXauxiliar]==PONTO){
					guiaYauxiliar++;
					labirinto[guiaY][guiaX]=ESPACO;
					labirinto[guiaY+1][guiaX]=ESPACO;
					guiaY=guiaY+2;
					labirinto[guiaY][guiaX]=ESPACO;
					auxiliar[guiaYauxiliar][guiaXauxiliar]='+';
					stackY.push(guiaYauxiliar);
					stackX.push(guiaXauxiliar);
				}

			}
			break;


		case 1: // VAI PARA CIMA
			if(guiaYauxiliar>0){

				if(auxiliar[guiaYauxiliar-1][guiaXauxiliar]==PONTO){
					guiaYauxiliar--;
					labirinto[guiaY][guiaX]=ESPACO;
					labirinto[guiaY-1][guiaX]=ESPACO;
					guiaY=guiaY-2;
					labirinto[guiaY][guiaX]=ESPACO;
					auxiliar[guiaYauxiliar][guiaXauxiliar]='+';
					stackY.push(guiaYauxiliar);
					stackX.push(guiaXauxiliar);
				}

			}
			break;

		case 2: // VAI PARA A DIREITA

			if(guiaXauxiliar+1<TAMANHOaux)

				if(auxiliar[guiaYauxiliar][guiaXauxiliar+1]==PONTO){
					guiaXauxiliar++;
					labirinto[guiaY][guiaX]=ESPACO;
					labirinto[guiaY][guiaX+1]=ESPACO;
					guiaX=guiaX+2;
					labirinto[guiaY][guiaX]=ESPACO;
					auxiliar[guiaYauxiliar][guiaXauxiliar]='+';
					stackY.push(guiaYauxiliar);
					stackX.push(guiaXauxiliar);
				}
			break;

		case 3:
			if(guiaXauxiliar>0)

				if(auxiliar[guiaYauxiliar][guiaXauxiliar-1]==PONTO){
					guiaXauxiliar--;
					labirinto[guiaY][guiaX]=ESPACO;
					labirinto[guiaY][guiaX-1]=ESPACO;
					guiaX=guiaX-2;
					labirinto[guiaY][guiaX]=ESPACO;
					auxiliar[guiaYauxiliar][guiaXauxiliar]='+';
					stackY.push(guiaYauxiliar);
					stackX.push(guiaXauxiliar);
				}




		}
	}


	public static void criaLabirinto(int n){


		labirinto=new char[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i%2!=0 && j%2!=0){
					labirinto[i][j]=ESPACO;
				}
				else
					labirinto[i][j]='X';

			}
		}

		Random r= new Random();
		int lado= r.nextInt(4);
		int posicao;
		do{
			posicao=r.nextInt(n-1);
		}while(posicao%2==0);

		switch(lado){

		case 0:
			labirinto[0][posicao]=SAIDA;
			guiaX=posicao;
			guiaY=1;
			saidaY=0;
			saidaX=posicao;
			break;
		case 1:
			labirinto[n-1][posicao]=SAIDA;
			guiaX=posicao;
			guiaY=n-1-1;
			saidaY=n-1;
			saidaX=posicao;
			break;
		case 2:
			labirinto[posicao][0]=SAIDA;
			guiaX=1;
			guiaY=posicao;
			saidaX=0;
			saidaY=posicao;
			break;
		case 3:
			labirinto[posicao][n-1]=SAIDA;
			guiaX=n-1-1;
			guiaY=posicao;
			saidaX=n-1;
			saidaY=posicao;
			break;

		}
		labirinto[guiaY][guiaX]=ESPACO;


		auxiliar=new char [(n-1)/2][(n-1)/2];

		for(int i=0;i<(n-1)/2;i++)
		{
			for(int j=0;j<(n-1)/2;j++)
			{
				auxiliar[i][j]=PONTO;
			}
		}
		guiaYauxiliar=(guiaY-1)/2;
		guiaXauxiliar=(guiaX-1)/2;
		auxiliar[guiaYauxiliar][guiaXauxiliar]='+';

		stackX.push(guiaXauxiliar);
		stackY.push(guiaYauxiliar);


		do{

			while(deadEnd() && !stackX.empty()){

				guiaXauxiliar=(int)stackX.pop();
				guiaYauxiliar=(int)stackY.pop();
				guiaX=guiaXauxiliar*2+1;
				guiaY=guiaYauxiliar*2+1;

			}
			abreCaminho();


		}while(!stackX.empty());
	}

	@Override
	public char getChar(int i, int j) {
		return labirinto[i][j];
	}

	@Override
	public Point getExitPosition() {
		return new Point(saidaY,saidaX);
	}

	@Override
	public int getDragaoY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDragaoX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEspada(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEscudo(Point p) {
		// TODO Auto-generated method stub
		
	}




}
