package maze.logic;

import java.io.Serializable;

/**
 * class de criacao do labirinto do tipo static
 *
 */
public class StaticMaze extends Maze implements Serializable{
	/**
	 * declaracao do labirinto static.
	 */
	private char[][] labirinto = new char[][] {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};
	
	/**
	 * retorna o labirinto
	 */
	public char getChar(int i, int j) {
		return labirinto[i][j];
	}
	/**
	 * retorna o tamanho do labirinto static
	 */
	public  int getTamanho(){
		return 10;
	}
	
	/**
	 * retorna a posicao do heroi em Y
	 */
	public  int getHeroiY(){
		return 1;
	}
	/**
	 * retorna a posicao do heori em X
	 */
	public  int getHeroiX(){
		return 1;
	}
	/**
	 * retorna os dados do labirinto
	 */
	public  char[][] getDados(){

		return labirinto;
	}
	
	/**
	 * retorna a posicao da saida
	 */
	@Override
	public Point getExitPosition() {
		// TODO Auto-generated method stub
		return new Point(5,9);
	}
	/**
	 * retorna a posicao do dragao em Y
	 */
	@Override
	public int getDragaoY() {
		// TODO Auto-generated method stub
		return 3;
	}
	/**
	 * retorna a posicao do dragao em X
	 */
	@Override
	public int getDragaoX() {
		// TODO Auto-generated method stub
		return 1;
	}
	/**
	 * coloca a espada no sitio recebido como parametro
	 */
	@Override
	public void setEspada(Point p) {
		
		labirinto[8][1]=' ';
		
		labirinto[p.getY()][p.getX()]='E';
		
	}
	/**
	 * coloca o escudo no sitio recebido como parametro
	 */
	@Override
	public void setEscudo(Point p) {
		labirinto[p.getY()][p.getX()]='P';
		
	}
}	
