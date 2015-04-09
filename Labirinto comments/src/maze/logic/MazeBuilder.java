package maze.logic;

import java.io.Serializable;

/**
 * contrutor do labirinto
 * utiliza classes abstratas para contruir cada tipo de labirinto( aleatorio ou estatico)
 * utiliza diversos metodos para obter valoresa necessario para a contrucao do labirinto: tamanho e tipo
 * utiliza tambem metodos para fixar os valores do tamanho e do tipo.
 */
public class MazeBuilder implements Serializable {

	private int opcao;
	private int size=10;

	public MazeBuilder(){};
/**
 * 
 * @return tamanho do labirinto
 */
	public int getSize(){
		return size;
	}
	/**
	 * coloca o valor de s como o valor do tamanho do labirinto
	 * @param s 
	 */
	public void setSize(int s){
		size=s;
	}
/**
 * coloca o valor do parametro como o valor do tipo de labirinto (0 ou 1 para aleatorio e static, respectivamente)
 * @param op passa a ser o valor da opcao
 */
	public void setMazeType( int op){
		opcao=op;	
	}

	/**
	 * dependendo da opcao e gerado um labirinto do tipo aleatorio ou do tipo static
	 * @return labirinto do tipo static ou aleatorio
	 */
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
