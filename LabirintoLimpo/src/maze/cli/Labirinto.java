package maze.cli;
import java.util.Scanner;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;

import maze.logic.Jogo;
import maze.logic.Maze;
import maze.logic.MazeBuilder;



public class Labirinto extends JFrame {
	
	
	
	private static  char[][] labirinto;
	private  static int TAMANHO;

	public static  int  perguntaModo(){


		System.out.println("MODO ALEATORIO OU MODO ESTATICO \n(0 ou 1, respetivamente)");
		Scanner s= new Scanner(System.in);
		String resposta= s.nextLine();

		if(resposta.equals("0"))
		{
			return 0;
		}
		else
			return 1;

	}
	public static int perguntaTamanho(){

		System.out.println("INTRODUZA TAMANHO\n(NUMERO IMPAR)");
		Scanner s= new Scanner(System.in);
		int resposta= s.nextInt();
		
		if(resposta%2==0)
			System.out.println("ADICIONADO +1 AO SEU TAMANHO\nPOR SER PAR\n");

		return resposta;

	}
	public static  int perguntaNumDragoes(){

		System.out.println("INTRODUZA NUMERO DE DRAGOES");
		Scanner s= new Scanner(System.in);
		int resposta= s.nextInt();

		return resposta;

	}
	
	
	
	public static int perguntaFogoDragao(){
		
		System.out.println("DRAGAO COSPE FOGO : \n 1 - Sim \n 2 - Nao");
		Scanner s= new Scanner(System.in);
		int resposta= s.nextInt();

		return resposta;
		
	}
	
	public static int perguntaAndamentoDragao(){
		
		System.out.println("DRAGAO ANDA: \n 1 - Sim \n 2 - Nao");
		Scanner s= new Scanner(System.in);
		int resposta= s.nextInt();

		return resposta;
		
	}
	public static int perguntaDragaoDorme(){
		
		System.out.println("DRAGAO DORME: \n 1 - Sim \n 2 - Nao");
		Scanner s= new Scanner(System.in);
		int resposta= s.nextInt();

		return resposta;
		
	}
	
	public static boolean desenhaEstado(int dardos){

		for(int i=0;i<TAMANHO;i++)
		{
			for(int j=0;j<TAMANHO;j++)
			{
				System.out.print(labirinto[i][j]+" ");

			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Numero de dardos disponiveis : "+ dardos);
		return true;

		
	}
	
	

	public static void main(String[] args) {

		int modo=perguntaModo();
		
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		
		
		
		int perguntaFogo= perguntaFogoDragao();
		int perguntaAnda= perguntaAndamentoDragao();
		int perguntaDorme= perguntaDragaoDorme();
		
		if(modo==0)
			gerador.setSize(perguntaTamanho());

		Maze maze = gerador.getMaze();
		int numDragoes= perguntaNumDragoes();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),numDragoes,perguntaFogo,perguntaDorme,perguntaAnda,modo);
		
		TAMANHO=jogo.getTAMANHO();
		
		labirinto = jogo.getLabirinto();
		
		desenhaEstado(jogo.getDardosDisponiveis());
		String direcao;

		
		
		do{
			
			System.out.print("Next move : ");
			Scanner input = new Scanner (System.in);
			direcao = input.nextLine();
			 
		}
		while(jogo.joga(direcao) && desenhaEstado(jogo.getDardosDisponiveis()));
		
		
		desenhaEstado(jogo.getDardosDisponiveis());
		
		if(jogo.getHeroi().isFimJogo())
			System.out.println("YOU WIN!");
		else if(jogo.getHeroi().isMorto())
			System.out.println("THE DRAGON KILLED YOU! GAME OVER");
		
		
		
		
		





	}

}
