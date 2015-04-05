package maze.logic;
import java.io.Serializable;
import java.util.Random;


public class Jogo implements Serializable{

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


/**
 * retorna o valor do tamanho do labirinto
 * @return tamanho do labirinto
 */
	public  int getTAMANHO() {
		return TAMANHO;
	}

/**
 * coloca o valor do tamanho do labirinto o valor recebido como parametro
 * @param tAMANHO tamanho do labirinto
 */
	public  void setTAMANHO(int tAMANHO) {
		TAMANHO = tAMANHO;
	}

/**
 * retorna o labirinto em execucao
 * @return labirinto
 */
	public char[][] getLabirinto() {
		return labirinto;
	}

/**
 * coloca o novo valor recebido como parametro para o labirinto
 * @param labirinto
 */
	public  void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}

/**
 * retorna o valor da posicao do heroi
 * @return posicao heroi
 */
	public  Heroi getHeroi() {
		return heroi;
	}

/**
 * coloca o valor da posicao do heroi passado por parametro
 * @param heroi posicao do heroi
 */
	public  void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

/**
 * inicializa os dados de jogo de forma a que seja contruido o labirinto com os objectos integrantes do jogo
 * @param labirint mapa do labirinto de jogo
 * @param tamanho do labirinto
 * @param numDrag  numero de dragoes a desenhar no labirinto
 * @param cosp se o dragao cospe fogo ou nao (1 para sim, 2 para nao)
 * @param dorm se dragao dorme ou nao (1 para sim, 2 para nao)
 * @param and se o dragao anda ou nao (1 para sim, 2 para nao)
 * @param mod o modo de jogo (0 para aleatorio, 1 statico)
 */
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

/**
 * faz os movimentos do heroi e dos dragoes
 * @param direcao sitio para onde se move o heroi
 * @return false se o heroi morrer ou se chegar ao fim do jogo , true se os movimentos ocurrerem normalmente
 */
	public  boolean joga(String direcao){

		moveDragoes();
		moveHeroi(direcao);

		if(heroi.isMorto())
			return false;

		if(heroi.isFimJogo())
			return false;

		return true;
	}

/**
 * verifica se todos os dragoes estao adormecidos
 * @return false se algum dragao nao estiver a dormir, true se todos os dragoes estiverem a dormir
 */
	public boolean dragoesAdormecidos(){
		
		for(int i=0;i<numDragoes;i++){
			
			if(!Dragoes[i].isAdormecido())
				return false;
		}
		return true;
	}

	/**
	 * funcao que adormece os dragoes e verifica os casos em que o dragao esta a dormir em cima de objectos do jogo se a opcao adormece estiver ligada
	 * se estiver a dormir em cima do escudo o caracter a aparecer e o 'c'
	 * se estiver a dormir em cima do escudo o caracter a aparecer e o 'f'
	 * se estiver a dormir numa casa vazia o caracter a aparecer e o 'd
	 * 
	 * se nao estiver ligada a opcao adormece:
	 * se estiver  em cima do escudo o caracter a aparecer e o 'C'
	 * se estiver  em cima do escudo o caracter a aparecer e o 'F'
	 * se estiver numa casa vazia o caracter a aparecer e o 'D'
	 */
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


/**
 * coloca a posiccao actual do heroi a branco e coloca o heroi na posicao para onde houve o movimento
 * @param Y posicao Y final do heroi
 * @param X posicao X final do heroi
 */
	public  void desloca(int Y, int X){
		labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=ESPACO;
		heroi.setHeroiY(heroi.getHeroiY()+Y);
		heroi.setHeroiX(heroi.getHeroiX()+X);
		labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=heroi.getCarater();
	}

	/**
	 * acede ao numero de dardos disponiveis para o heroi
	 * @return numero de dados disponiveis
	 */
	public  int getDardosDisponiveis() {
		return dardosDisponiveis;
	}

/**
 * actualiza o valor dos dardos disponiveis com o valor recebido como parametro
 * @param dardosDisponiveis
 */
	public  void setDardosDisponiveis(int dardosDisponiveis) {
		this.dardosDisponiveis = dardosDisponiveis;
	}

/**
 * esta funcao recebe um parametro a indicar a direccao para onde o heroi se vai mover
 * @param s direccao do movimento do heroi
 */
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

/**
 * funcao que verifica o movimento dos dragoes
 * nesta funcao por definicao o dragao adormece e anda aleatoriamente.
 * se estiver a dormir o dragao nao se movimenta, se estiver acordado move-se em cada umas das quatro direccoes
 * @return 0 se o dragao nao se move e morre e 1 se o dragao se move
 */
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

	/**
	 * Se nao houver dardos a funcao retorna true
	 * se houver dardos e visto o numero de dragoes, e morto um caso esteja na mesma coluna ou linha que o heroi sem parede pelo meio
	 * e o numero de dardos decrementado tal como o numero de dragoes
	 * @param X e a posicao em x
	 * @param Y e a posicao em y
	 * @return true quando nao tem mais dardos
	 */
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

/**
 * ve o numero de dragoes e remove dragao caso o heroi o mate
 */
	public  void mataDragao(){

		for(int i=0;i<numDragoes;i++){
			if(Dragoes[i].getDragaoX()==heroi.getHeroiX() && Dragoes[i].getDragaoY()==heroi.getHeroiY()){
				Dragoes[i].setMorreu(true);
			}
		}
	}

	/**
	 * verifica se o dragao matou ou nao o heroi
	 * @param X e a posicao em x
	 * @param Y e a posicao em Y
	 * @return true se o dragao matar o heroi e false se o nao mata o heroi
	 */
	public  boolean verificaDragoes(int X,int Y){

		for(int i=0;i<numDragoes;i++){

			if(Dragoes[i].verificaDragao(heroi.isArmado(),heroi.isEscudado(),heroi.getHeroiX()+X,heroi.getHeroiY()+Y,labirinto)==1)
				return true;
		}

		return false;
	}

	/**
	 * verifica se todos os dragoes estao mortos
	 * @return false se algum dragao estiver vivo e true se estiverem todos mortos
	 */
	public  boolean dragoesMortos(){

		for(int i=0;i<numDragoes;i++){

			if(!Dragoes[i].isMorreu())
				return false;
		}

		return true;
	}
	
	public boolean saidaPossivel(){
		
		return dragoesMortos()&&heroi.isArmado();
	}
	
/**
 * 
 * @param Y
 * @param X
 * @param direcao
 * @return
 */
	
	public  int verificaAtualiza(int Y,int X,String direcao){
		
		
		
		if(verificaDragoes(X,Y)  || verificaDragoes(0,0) )
		{ 

			if(heroi.isMorto())
				return 1;
			andaUm(direcao);
			heroi.setMorto(true);
			return 1;
		}
		mataComDardo(X,Y);
		
		if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==SAIDA && saidaPossivel())
		{
			labirinto[heroi.getHeroiY()][heroi.getHeroiX()]=ESPACO;
			labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=heroi.getCarater();
			heroi.setFimJogo(true);
			return 1;
		}
		else if(labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==ESPACO)
		{
			andaUm(direcao);
		}
		else if (cospe==2 && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]==DRAGAO ||
				cospe==2 && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=='d'
				||cospe==1 && heroi.isArmado() && labirinto[heroi.getHeroiY()+Y][heroi.getHeroiX()+X]=='d'){
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

	/**
	 * verifica se o jogo pode prosseguir e para onde mover o heroi
	 * se o heroi morrer o heroi nao se move e acaba o jogo
	 * se o heroi chegar a saida e o fim do jogo
	 * para cada uma das quatro direcoes o horoi movimenta-se e continua o jogo
	 * @param direcao movimenta para a direita,esquerda,cima ou baixo
	 * @return 0 para acabar o jogo, 1 para continuar o jogo
	 */
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
	
	
	
	public boolean dragoesEmCimaEspada(){
		for(int i=0;i<numDragoes;i++)
			if(Dragoes[i].isEmCimaEspada())
				return true;
		
		return false;
	}
	
	public boolean dragoesEmCimaEscudo(){
		for(int i=0;i<numDragoes;i++)
			if(Dragoes[i].isEmCimaEscudo())
				return true;
		
		return false;
	}
	public boolean dragoesEmCimaDardo(){
		for(int i=0;i<numDragoes;i++)
			if(Dragoes[i].isEmCimaDardo())
				return true;
		
		return false;
	}
	
	public Dragao retornaDragao(){ // para usar em testes
		
		return Dragoes[0];
	}
}
