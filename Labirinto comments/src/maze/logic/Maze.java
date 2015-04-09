package maze.logic;

import java.io.Serializable;

/**
 * classe abstrata para obtar valores, posicoes e dados relativos ao labirinto a contruir
  */
public abstract class Maze implements Serializable{

	public abstract int getTamanho();
	
	public abstract int getHeroiY();
	public abstract int getHeroiX();

	public abstract char[][] getDados();

	public abstract char getChar(int i, int j);

	public abstract Point getExitPosition();

	
	public abstract int getDragaoY();
	public abstract int getDragaoX();
	
	
	public abstract void setEspada(Point p);
	public abstract void setEscudo(Point p);
	
	
	
}

