package maze.logic;
import java.util.Random;


public class Jogo {

	private static final char ESCUDO = 'P';
	private static final char ESPACO = ' ';
	private static final char SAIDA = 'S';
	private static final String SAIR = "Q";
	private static final char DRAGAO = 'D';
	private static final String CIMA = "w";
	private static final String BAIXO = "s";
	private static final String ESQUERDA = "a";
	private static final String DIREITA = "d";
	private static final char ESPADA = 'E';
	private static final char DARDO = '-';



	private  int numDragoes;
	private  Dragao Dragoes[];

	private  Heroi heroi;
	private  Espada espada;
	 private int TAMANHO;
	private  Escudo escudo;

	private  int numDardos;
	private  Dardos[] dardos;
	private  char[][] labirinto ;
	private  int dardosDisponiveis=0;

	private  int cospe;
	private  int anda;
	private  int modo;
	private  int dorme;



	public  int getTAMANHO() {
		return TAMANHO;
	}


	public  void setTAMANHO(int tAMANHO) {
		TAMANHO = tAMANHO;
	}


	public char[][] getLabirinto() {
		return labirinto;
	}


	public  void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}


	public  Heroi getHeroi() {
		return heroi;
	}


	public  void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}



	public Jogo(char[][] labirint, int tamanho, int numDrag ,int cosp,int dorm, int and,int mod){

		dorme=dorm;
		cospe=cosp;
		anda=and;
		modo=mod;

		labirinto=labirint;
		TAMANHO= tamanho;
		heroi= new Heroi(labirinto,TAMANHO,modo);
		espada= new Espada(labirinto,TAMANHO,modo);


		if(modo==0||cospe==1)
			escudo= new Escudo(labirinto,TAMANHO);

		numDragoes=numDrag;
		Dragoes= new Dragao[numDrag];

		numDardos=numDragoes;

		dardos= new Dardos[numDardos];

		for(int i=0;i<numDrag;i++){
			dardos[i] = new Dardos(labirinto,TAMANHO);
		}

		for(int i =0;i<numDrag;i++){
			Dragoes[i] = new Dragao(labirinto,TAMANHO,cospe,anda,dorme,modo);
		}

	}


	public  boolean joga(String direcao){

		moveDragoes();
		moveHeroi(direcao);

		if(heroi.isMorto())
			return false;

		if(heroi.isFimJogo())
			return false;

		return true;


	}


	public boolean dragoesAdormecidos(){
		
		for(int i=0;i<numDragoes;i++){
			
			if(!Dragoes[i].isAdormecido())
				return false;
		}
		return true;
	}

	
	public  void adormeceDragoes(){

		if(dorme==1){

			Random r=new Random();

			for(int i=0;i<numDragoes;i++){

				int adormece= r.nextInt(3);

				if(!Dragoes[i].isMorreu()){
					if(adormece==2){ // 1/3 probabilidade de adormecer
						Dragoes[i].setAdormecido(true);
						
						if(Dragoes[i].isEmCimaEscudo())
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='c';
						else if(Dragoes[i].isEmCimaEspada())
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='f';
						else
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='d';
					}
					else{
						Dragoes[i].setAdormecido(false);
						if(Dragoes[i].isEmCimaEscudo())
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='C';
						else if(Dragoes[i].isEmCimaEspada())
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='F';
						else
							labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]='D';
					}
				}
			}

		}
	}



	public  void desloca(int Y, int X){
		labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=ESPACO;
		heroi.setHeroiY(heroi.getHeroiY()+Y);
		heroi.setHeroiX(heroi.getHeroiX()+X);
		labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=heroi.getCarater();
	}

	public  int getDardosDisponiveis() {
		return dardosDisponiveis;
	}


	public  void setDardosDisponiveis(int dardosDisponiveis) {
		this.dardosDisponiveis = dardosDisponiveis;
	}


	public  void andaUm(String s)
	{

		if(s.equals(CIMA))
			desloca(-1,0);
		else if (s.equals(BAIXO))
			desloca(1,0);
		else if (s.equals(DIREITA))
			desloca(0,1);
		else if(s.equals(ESQUERDA))
			desloca(0,-1);

	}


	public  int moveDragoes(){


		if(dorme==1)
			adormeceDragoes();

		if(anda==1){

			Random r=new Random();

			for(int i=0;i<numDragoes;i++){

				if(Dragoes[i].verificaDragao(heroi.isArmado(),heroi.isEscudado(),heroi.getHeroiX(),heroi.getHeroiY(),labirinto)==1 )
				{
					heroi.setMorto(true);
					return 0;
				}


				boolean andou=false;


				do{

					int valor =r.nextInt(5);
					if (!Dragoes[i].isMorreu() && !Dragoes[i].isAdormecido()){

						switch (valor)
						{
						case 0:
							andou=Dragoes[i].moveDragao(labirinto, -1, 0);
							break;
						case 1: 
							andou=Dragoes[i].moveDragao(labirinto,1,0);

							break;
						case 2: 
							andou=Dragoes[i].moveDragao(labirinto,0,-1);

							break;

						case 3: 
							andou=Dragoes[i].moveDragao(labirinto,0,1);
							break;

						case 4:
							andou= true;
							break;
						}
					}

				}
				while(!Dragoes[i].isAdormecido()&& !andou && !Dragoes[i].isMorreu());

				if(Dragoes[i].verificaDragao(heroi.isArmado(),heroi.isEscudado(),heroi.getHeroiX(),heroi.getHeroiY(),labirinto)==1)
				{
					heroi.setMorto(true);	
					return 0;
				}


			}
		}
		return 1;

	}

	public  boolean mataComDardo(int X,int Y){

		if(dardosDisponiveis==0)
			return true;

		for(int i=0;i<numDragoes;i++){
			if(Dragoes[i].morreComDardo(labirinto, heroi.getHeroiY()+Y, heroi.getHeroiX()+X)){
				labirinto[Dragoes[i].getDragaoY()][Dragoes[i].getDragaoX()]=' ';
				dardosDisponiveis--;

			}
		}
		return true;

	}



	public  void mataDragao(){

		for(int i=0;i<numDragoes;i++){
			if(Dragoes[i].getDragaoX()==heroi.getHeroiX() && Dragoes[i].getDragaoY()==heroi.getHeroiY()){
				Dragoes[i].setMorreu(true);
			}
		}
	}

	public  boolean verificaDragoes(int X,int Y){

		for(int i=0;i<numDragoes;i++){

			if(Dragoes[i].verificaDragao(heroi.isArmado(),heroi.isEscudado(),heroi.getHeroiX()+X,heroi.getHeroiY()+Y,labirinto)==1)
				return true;
		}

		return false;
	}

	public  boolean dragoesMortos(){


		for(int i=0;i<numDragoes;i++){

			if(!Dragoes[i].isMorreu())
				return false;
		}

		return true;


	}


	public  int verificaAtualiza(int Y,int X,String direcao){

		mataComDardo(X,Y);

		if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==SAIDA && dragoesMortos() && heroi.isArmado())
		{
			labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=ESPACO;
			labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=heroi.getCarater();
			heroi.setFimJogo(true);
			return 1;
		}
		else if(verificaDragoes(X,Y)  || verificaDragoes(0,0) )
		{ 

			if(heroi.isMorto())
				return 1;
			andaUm(direcao);
			heroi.setMorto(true);
			return 1;
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==ESPACO)
		{
			andaUm(direcao);
		}
		else if (cospe==2 && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==DRAGAO ||
				cospe==2 && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=='d'){
			andaUm(direcao);
			mataDragao();
		}
		else if (heroi.isEscudado() && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==DRAGAO ||
				heroi.isEscudado() && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=='d'){
			andaUm(direcao);
			mataDragao();
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==DARDO)
		{
			dardosDisponiveis++;
			andaUm(direcao);
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==ESPACO)
		{
			andaUm(direcao);
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==ESPADA)
		{
			heroi.setArmado(true);
			andaUm(direcao);
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==ESCUDO){
			heroi.setEscudado(true);
			andaUm(direcao);

		}
		return 0;
	}

	public  int moveHeroi(String direcao){

		
		if(heroi.isMorto())
			return 0;
		
		if(direcao.equals(SAIR))
			return 1;

		if(direcao.equals(DIREITA)){
			if(verificaAtualiza(0,1,DIREITA)==1)
				return 1;
		}
		else if(direcao.equals(ESQUERDA)){
			if(verificaAtualiza(0,-1,ESQUERDA)==1)
				return 1;
		}
		else if(direcao.equals(BAIXO)){
			if(verificaAtualiza(1,0,BAIXO)==1)
				return 1;
		}
		else if(direcao.equals(CIMA)){
			if(verificaAtualiza(-1,0,CIMA)==1)
				return 1;
		}

		return 0;

	}








}
