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
	BufferedImage wall;
	BufferedImage hero;
	BufferedImage grass;
	BufferedImage dragon;
	BufferedImage sword;
	BufferedImage porta;
	BufferedImage dardo;
	BufferedImage shield;
	BufferedImage heroiArmado;
	BufferedImage heroiEscudado;
	BufferedImage heroiAmbos; //espada escudo
	BufferedImage dragonSleep;
	BufferedImage dragonEspada;
	BufferedImage dragonEscudo;
	BufferedImage dragonDardo;
	BufferedImage rip;
	
	private int spacing=50;
	
	public mazePanel() throws IOException {
		this.addKeyListener(this);
		
		wall=ImageIO.read(new File("wall.png"));
		grass=ImageIO.read(new File("grass1p.png"));
		hero=ImageIO.read(new File("Hero-icon.png"));
		sword =ImageIO.read(new File("espada.jpg"));
		dragon =ImageIO.read(new File("MapleDragonStore.png"));
		porta =ImageIO.read(new File("portal.gif"));
		dardo =ImageIO.read(new File("dart.png"));
		dragonSleep =ImageIO.read(new File("zzz.png"));
		shield=ImageIO.read(new File("shield.png"));
		rip=ImageIO.read(new File("rip.png"));
		 
		 
		 
		int modo=0;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setSize(12);
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,1,1,1,modo);
		
	
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
