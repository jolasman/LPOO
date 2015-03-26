package maze.logic;


public class StaticMaze extends Maze{

	

	
	
	
	
	
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
	
	
	public char getChar(int i, int j) {
		return labirinto[i][j];
	}
	public  int getTamanho(){
		return 10;
	}
	
	
	public  int getHeroiY(){
		return 1;
	}
	public  int getHeroiX(){
		return 1;
	}
	
	public  char[][] getDados(){

		return labirinto;


	}
	
	@Override
	public Point getExitPosition() {
		// TODO Auto-generated method stub
		return new Point(5,9);
	}
	@Override
	public int getDragaoY() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public int getDragaoX() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void setEspada(Point p) {
		
		labirinto[8][1]=' ';
		
		labirinto[p.getY()][p.getX()]='E';
		
	}
	@Override
	public void setEscudo(Point p) {
		labirinto[p.getY()][p.getX()]='P';
		
	}
}	
