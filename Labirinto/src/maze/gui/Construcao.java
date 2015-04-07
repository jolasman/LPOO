package maze.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Construcao extends JPanel implements MouseListener, MouseMotionListener  {

	char[][] labirinto = new char[10][10];
	int tamanho=10;

	BufferedImage wall;
	BufferedImage hero; 
	BufferedImage grass;
	BufferedImage dragon;
	BufferedImage sword;
	BufferedImage dardo; //done
	BufferedImage shield; //done
	BufferedImage saidaImpossivel;
	BufferedImage espacoBranco;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Construcao() throws IOException {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		sword =ImageIO.read(new File("espada2.jpg"));
		dardo =ImageIO.read(new File("dardo.jpg"));
		shield=ImageIO.read(new File("escudo.jpg"));
		wall=ImageIO.read(new File("brick.jpg"));
		hero=ImageIO.read(new File("Heroi.jpg"));
		dragon =ImageIO.read(new File("Dragao_normal.jpg"));
		grass=ImageIO.read(new File("grass1p.png"));
		saidaImpossivel=ImageIO.read(new File("saidaImpossivel.jpg"));
		espacoBranco=ImageIO.read(new File("quadradoBranco.jpg"));

		for(int i=0;i<tamanho;i++){
			for(int h=0;h<tamanho;h++){
				labirinto[i][h]='1';
			}
		}


	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa fundo ...		

		int ratioH = getWidth()/tamanho;
		int ratioV = getHeight()/tamanho;

		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){

				if(labirinto[j][i]=='1')
					g.drawImage(espacoBranco, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='X')
					g.drawImage(wall, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='H')
					g.drawImage(hero, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='D')
					g.drawImage(dragon, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='S')
					g.drawImage(saidaImpossivel, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='P')
					g.drawImage(shield, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='-')
					g.drawImage(dardo, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]==' ')
					g.drawImage(grass, i*ratioH, j*ratioV, ratioH,ratioV , null);
				else if(labirinto[j][i]=='E')
					g.drawImage(sword, i*ratioH, j*ratioV, ratioH,ratioV , null);


			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {



	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int tamanhoX=getWidth()/tamanho;
		int tamanhoY=getHeight()/tamanho;

		try{
			labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='X';
		}
		catch(Exception ex){}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


}
