package maze.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import maze.logic.Jogo;
import maze.logic.Maze;
import maze.logic.MazeBuilder;


public class mazePanel extends JPanel implements KeyListener {

	static Jogo jogo;
	BufferedImage wall; //done
	BufferedImage hero; //done
	BufferedImage grass; //done
	BufferedImage dragon; //done
	BufferedImage sword; //done
	BufferedImage porta; //done
	BufferedImage dardo; //done
	BufferedImage shield; //done
	BufferedImage heroiArmado;  
	BufferedImage heroiEscudado;
	BufferedImage heroiDardo;
	BufferedImage heroiEscudoDardo;
	
	BufferedImage heroiAmbos; //espada escudo
	BufferedImage heroiAmbosDardo;
	
	BufferedImage dragonSleep; //done
	BufferedImage dragonEspada;
	BufferedImage dragonEscudo;
	BufferedImage dragonDardo;
	BufferedImage rip;
	BufferedImage dragonDormirEspada;
	BufferedImage dragonDormirEscudo;
	BufferedImage dragonDormirDardo;
	
	private int X, Y;
	
	private int spacing=50;
	
	public mazePanel() throws IOException {
		this.addKeyListener(this);
		
		wall=ImageIO.read(new File("wall.png"));
		grass=ImageIO.read(new File("grass1p.png"));
		porta =ImageIO.read(new File("portal.gif"));
		
		sword =ImageIO.read(new File("espada2.jpg"));
		dardo =ImageIO.read(new File("dardo.jpg"));
		shield=ImageIO.read(new File("escudo.jpg"));
		rip=ImageIO.read(new File("rip.png"));
		
		hero=ImageIO.read(new File("Heroi.jpg"));
		heroiEscudado=ImageIO.read(new File("Heroi_escudado.jpg")); 
		heroiArmado=ImageIO.read(new File("Heroi_espada.jpg")); 
		heroiDardo=ImageIO.read(new File("Heroi_dardo.jpg")); 
		heroiAmbos=ImageIO.read(new File("hero_Armado_escudado.jpg")); 
		heroiAmbosDardo=ImageIO.read(new File("hero_Armado_escudado_dart.jpg")); 
		heroiEscudoDardo=ImageIO.read(new File("Heroi_escudado_dardos.jpg")); 
		
		
		dragon =ImageIO.read(new File("Dragao_normal.jpg"));
		dragonSleep =ImageIO.read(new File("dragao_dormir.jpg"));
		dragonEspada=ImageIO.read(new File("Dragao_espada.jpg"));
		dragonEscudo=ImageIO.read(new File("dragao_escudo.jpg"));
		dragonDardo=ImageIO.read(new File("Dragao_dardo.jpg"));
		dragonDormirEspada=ImageIO.read(new File("dragao_dormir_espada.jpg"));
		dragonDormirEscudo=ImageIO.read(new File("dragao_dormir_escudo.jpg"));
		dragonDormirDardo=ImageIO.read(new File("dragao_dormir_dardo.jpg"));
		 
		int modo=0;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setSize(12);
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		jogo= new Jogo(maze.getDados(),maze.getTamanho(),5,1,1,1,modo);
		
	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa fundo ...	
		char[][] labirinto = jogo.getLabirinto();
		
		
		int ratioH = getWidth()/jogo.getTAMANHO();
		int ratioV = getHeight()/jogo.getTAMANHO();
		
		
		for(int i=0;i<jogo.getTAMANHO();i++)
			for(int j=0;j<jogo.getTAMANHO();j++)	
			{
				
					if(labirinto[j][i]=='X')
						g.drawImage(wall, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]==' ')
						g.drawImage(grass, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='H')
						g.drawImage(hero, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='D')
						g.drawImage(dragon, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='E')
						g.drawImage(sword, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='S')
						g.drawImage(porta, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='-')
						g.drawImage(dardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='d')
						g.drawImage(dragonSleep, i*ratioH, j*ratioV, ratioH,ratioV , null);
					else if(labirinto[j][i]=='P')
						g.drawImage(shield, i*ratioH, j*ratioV, ratioH,ratioV , null);
					if(labirinto[j][i]=='A')
						g.drawImage(heroiArmado, i*ratioH, j*ratioV, ratioH,ratioV , null);
					
					else if(labirinto[j][i]=='O')
						g.drawImage(heroiEscudado, i*ratioH, j*ratioV, ratioH,ratioV , null);
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
					
					//corrigir
					
					
					if(jogo.getDardosDisponiveis() == 1 && labirinto[j][i]=='-' )//se o heroi apanhar o dardo 
						g.drawImage(heroiDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
					
					if(labirinto[jogo.getHeroi().getHeroiY()+Y][jogo.getHeroi().getHeroiX()+X]== 'E' && labirinto[j][i]=='K') //se estiver escudado e apanha a espada
						g.drawImage(heroiAmbos, i*ratioH, j*ratioV, ratioH,ratioV , null);
					
				/*	if()//se o heroi apanhar o dardo e ja estiver escudado e armado
					g.drawImage(heroiDardo, i*ratioH, j*ratioV, ratioH,ratioV , null); 
					
					if(jogo.getHeroi().isEscudado() && labirinto[jogo.getHeroi().getHeroiY()+Y][jogo.getHeroi().getHeroiX()+X]=='-' )//se o heroi apanhar o dardo e estiver escudado
						g.drawImage(heroiEscudoDardo, i*ratioH, j*ratioV, ratioH,ratioV , null);*/
					
					
					
			}
				
			

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			jogo.joga("a");
			repaint(); 
			break;
			
		case KeyEvent.VK_RIGHT: 
			jogo.joga("d");
			repaint(); 
			break;

		case KeyEvent.VK_UP: 
			jogo.joga("w");
			repaint(); 
			break;

		case KeyEvent.VK_DOWN: 
			jogo.joga("s");
			repaint(); 
			break;
		}
		

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
