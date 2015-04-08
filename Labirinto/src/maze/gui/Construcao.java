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

	private char[][] labirinto = new char[10][10];
	private int tamanho=10;
	private String conteudo;


	BufferedImage wall;
	BufferedImage hero; 
	BufferedImage grass;
	BufferedImage dragon;
	BufferedImage sword;
	public char[][] getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

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
	
	public int verificaVezes(String nome){
		
		int contador=0;
		for(int i=0;i<tamanho;i++){
			for(int j=0;j<tamanho;j++){
				
				if(nome=="dragao"){
					if(labirinto[i][j]=='D')
						contador++;
				}
				else if(nome=="heroi"){
					if(labirinto[i][j]=='H')
						contador++;
				}
				else if(nome=="espada"){
					if(labirinto[i][j]=='E')
						contador++;
				}
				else if(nome=="escudo"){
					if(labirinto[i][j]=='P')
						contador++;
				}
				else if(nome=="dardo"){
					if(labirinto[i][j]=='-')
						contador++;
				}
				else if(nome=="branco"){
					if(labirinto[i][j]=='1')
						contador++;
				}
				else if(nome=="saida"){
					if(labirinto[i][j]=='S')
						contador++;
				}
		
					
				
		
			}
		}
		return contador;
		
		
		
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

			if(conteudo=="parede")
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='X';
			else if(conteudo=="dragao")
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='D';
			else if(conteudo=="espada" && verificaVezes("espada")==0)
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='E';
			else if(conteudo=="heroi" && verificaVezes("heroi")==0)
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='H';
			else if(conteudo=="escudo"&& verificaVezes("escudo")==0)
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='P';
			else if(conteudo=="dardo")
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='-';
			else if(conteudo=="saida"&& verificaVezes("saida")==0)
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]='S';
			else if(conteudo=="erva")
				labirinto[e.getY()/tamanhoY][e.getX()/tamanhoX]=' ';
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
