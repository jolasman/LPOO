package maze.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.Dardos;
import maze.logic.Dragao;
import maze.logic.Escudo;
import maze.logic.Espada;
import maze.logic.Heroi;
import maze.logic.Jogo;
import maze.logic.Maze;
import maze.logic.MazeBuilder;


public class MazePanel extends JPanel implements KeyListener {

	private Jogo jogo;



	private int keyCima=KeyEvent.VK_UP;
	private int keyBaixo=KeyEvent.VK_DOWN;
	private int keyEsquerda=KeyEvent.VK_LEFT;
	private int keyDireita=KeyEvent.VK_RIGHT;


	BufferedImage wall; //done
	BufferedImage hero; //done
	BufferedImage grass; //done
	BufferedImage dragon; //done
	BufferedImage sword; //done


	BufferedImage saidaPossivel; //done
	BufferedImage saidaImpossivel;


	BufferedImage dardo; //done
	BufferedImage shield; //done
	BufferedImage heroiArmado;  
	BufferedImage heroiEscudado;
	BufferedImage heroiDardo;
	BufferedImage heroiEscudoDardo;
	BufferedImage heroMorto;
	BufferedImage heroiAmbos; //espada escudo
	BufferedImage heroiAmbosDardo;
	BufferedImage heroiEspadaDardo;

	BufferedImage dragonSleep; //done
	BufferedImage dragonEspada;
	BufferedImage dragonEscudo;
	BufferedImage dragonDardo;

	BufferedImage dragonDormirEspada;
	BufferedImage dragonDormirEscudo;
	BufferedImage dragonDormirDardo;

	BufferedImage win;
	BufferedImage lost;

	private int X, Y;
	private boolean acabou=false;

	public void initializeImages() throws IOException{
		wall=ImageIO.read(new File("brick.jpg"));
		grass=ImageIO.read(new File("grass1p.png"));
		saidaImpossivel=ImageIO.read(new File("saidaImpossivel.jpg"));
		saidaPossivel=ImageIO.read(new File("saidaPossivel.jpg"));
		win =ImageIO.read(new File("win.jpg"));

		sword =ImageIO.read(new File("espada2.jpg"));
		dardo =ImageIO.read(new File("dardo.jpg"));
		shield=ImageIO.read(new File("escudo.jpg"));

		hero=ImageIO.read(new File("Heroi.jpg"));
		heroiEscudado=ImageIO.read(new File("Heroi_escudado.jpg")); 
		heroiArmado=ImageIO.read(new File("Heroi_espada.jpg")); 
		heroiDardo=ImageIO.read(new File("Heroi_so_dardo.jpg")); 
		heroiAmbos=ImageIO.read(new File("hero_Armado_escudado.jpg")); 
		heroiEspadaDardo= ImageIO.read(new File("Heroi_dardo.jpg")); 
		heroiAmbosDardo=ImageIO.read(new File("hero_Armado_escudado_dart.jpg")); 
		heroiEscudoDardo=ImageIO.read(new File("Heroi_escudado_dardos.jpg")); 
		heroMorto=ImageIO.read(new File("morto.png")); 


		dragon =ImageIO.read(new File("Dragao_normal.jpg"));
		dragonSleep =ImageIO.read(new File("dragao_dormir.jpg"));
		dragonEspada=ImageIO.read(new File("Dragao_espada.jpg"));
		dragonEscudo=ImageIO.read(new File("dragao_escudo.jpg"));
		dragonDardo=ImageIO.read(new File("Dragao_dardo.jpg"));
		dragonDormirEspada=ImageIO.read(new File("dragao_dormir_espada.jpg"));
		dragonDormirEscudo=ImageIO.read(new File("dragao_dormir_escudo.jpg"));
		dragonDormirDardo=ImageIO.read(new File("dragao_dormir_dardo.jpg"));
	}

	public void newGame(Jogo jogo) throws IOException{
		this.jogo=jogo;
	}
	public MazePanel() throws IOException {
		this.addKeyListener(this);
		initializeImages();
	}

	public void newGameConstruido(char[][] labirint,int tamanho, int numDrag,Dragao[] dragoes,int numDardos,Dardos[] dardos,Escudo escudo,
			Heroi heroi,Espada espada,int cospe,int dorme,int anda){

		jogo= new Jogo(labirint, tamanho,  numDrag, dragoes, numDardos, dardos, escudo,
				heroi, espada, cospe, dorme, anda);



	}

	public void newGame(int modo,int numDragoes,int tamanho, int cospe,int anda,int dorme ) throws IOException {

		MazeBuilder gerador= new MazeBuilder();
		gerador.setSize(tamanho);
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		jogo= new Jogo(maze.getDados(),maze.getTamanho(),numDragoes,cospe,dorme,anda,modo);


	}


	public Jogo getJogo() {
		return jogo;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa fundo ...	
		char[][] labirinto = jogo.getLabirinto();


		int ratioH = getWidth()/jogo.getTAMANHO();
		int ratioV = getHeight()/jogo.getTAMANHO();



		for(int i=0;i<jogo.getTAMANHO();i++)
			for(int j=0;j<jogo.getTAMANHO();j++)	
			{


				if((labirinto[j][i]=='K' || labirinto[j][i]=='O' || labirinto[j][i]=='A'
						|| labirinto[j][i]=='H') && jogo.getHeroi().isMorto())
					g.drawImage(heroMorto, i*ratioH, j*ratioV, ratioH,ratioV , null); 

				else if(labirinto[j][i]=='X')
					g.drawImage(wall, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]==' ')
					g.drawImage(grass, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='H' && jogo.getDardosDisponiveis()==0)
					g.drawImage(hero, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(jogo.getDardosDisponiveis() >0 && labirinto[j][i]=='H' )
					g.drawImage(heroiDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='D')
					g.drawImage(dragon, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='E')
					g.drawImage(sword, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='S' && jogo.saidaPossivel())
					g.drawImage(saidaPossivel, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='S' && !jogo.saidaPossivel())
					g.drawImage(saidaImpossivel, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='-')
					g.drawImage(dardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='d')
					g.drawImage(dragonSleep, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='P')
					g.drawImage(shield, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='C')
					g.drawImage(dragonEscudo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='c')
					g.drawImage(dragonDormirEscudo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='F')
					g.drawImage(dragonEspada, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='f')
					g.drawImage(dragonDormirEspada, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='W')
					g.drawImage(dragonDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='w') 
					g.drawImage(dragonDormirDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);




				else if(jogo.getDardosDisponiveis() >0 && labirinto[j][i]=='H' )
					g.drawImage(heroiDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);

				else if(labirinto[j][i]=='K' && jogo.getDardosDisponiveis() >=1  ) 
					g.drawImage(heroiAmbosDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);

				else if(labirinto[j][i]=='K' && jogo.getDardosDisponiveis() ==0 )
					g.drawImage(heroiAmbos, i*ratioH, j*ratioV, ratioH,ratioV , null); 

				else if(jogo.getDardosDisponiveis() >0 && labirinto[j][i]=='O')
					g.drawImage(heroiEscudoDardo, i*ratioH, j*ratioV, ratioH,ratioV , null); 

				else if(jogo.getDardosDisponiveis() ==0 && labirinto[j][i]=='O')
					g.drawImage(heroiEscudado, i*ratioH, j*ratioV, ratioH,ratioV , null);

				else if(jogo.getDardosDisponiveis() >0 && labirinto[j][i]=='A')
					g.drawImage(heroiEspadaDardo,i*ratioH, j*ratioV, ratioH,ratioV , null); 

				else if(jogo.getDardosDisponiveis() ==0 && labirinto[j][i]=='A')
					g.drawImage(heroiArmado, i*ratioH, j*ratioV, ratioH,ratioV , null); 



			}
		if(jogo.getHeroi().isFimJogo())
			g.drawImage(win, 0, 0, this.getWidth(),this.getHeight() , null); 



	}

	public void setKey(int cima, int esquerda, int direita, int baixo){

		keyCima=cima;
		keyEsquerda=esquerda;
		keyDireita=direita;
		keyBaixo=baixo;

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if(arg0.getKeyCode()==keyCima){
			jogo.joga("w"); 
		}
		else if(arg0.getKeyCode()==keyBaixo){
			jogo.joga("s"); 
		}
		else if(arg0.getKeyCode()==keyDireita){
			jogo.joga("d"); 
		}
		else if(arg0.getKeyCode()==keyEsquerda){
			jogo.joga("a"); 
		}

		repaint();
		if(jogo.getHeroi().isMorto()||jogo.getHeroi().isFimJogo())
			acabou=true;


	}

	public boolean isAcabou() {
		return acabou;
	}

	public void setAcabou(boolean acabou) {
		this.acabou = acabou;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}
