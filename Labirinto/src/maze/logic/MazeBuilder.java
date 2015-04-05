package maze.logic;

import java.io.Serializable;

public class MazeBuilder implements Serializable {

	private int opcao;
	private int size=10;

	public MazeBuilder(){};

	public int getSize(){
		return size;
	}
	
	public void setSize(int s){
		size=s;
	}

	public void setMazeType( int op){
		opcao=op;	
	}

	public Maze getMaze(){

		if(opcao==0){
				
			if(size%2==0)
				size=size+1;
			
			return new RandomMaze(size);
		}
		else
			return new StaticMaze();
	}


}
