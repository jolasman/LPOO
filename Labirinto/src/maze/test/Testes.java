package maze.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import maze.logic.Dragao;
import maze.logic.Heroi;
import maze.logic.Jogo;
import maze.logic.Maze;
import maze.logic.MazeBuilder;
import maze.logic.Point;

public class Testes {
	// a) the maze boundaries must have exactly one exit and everything else walls
	// b) the exist cannot be a corner
	private boolean checkBoundaries(Maze m) {
		int countExit = 0;
		int n = m.getTamanho();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
					if (m.getChar(i, j) == 'S')
						if ((i == 0 || i == n-1) && (j == 0 || j == n-1))
							return false;
						else
							countExit++;
					else if (m.getChar(i, j) != 'X')
						return false;
		return countExit == 1;
	}


	// d) there cannot exist 2x2 (or greater) squares with blanks only 
	// e) there cannot exit 2x2 (or greater) squares with blanks in one diagonal and walls in the other
	// d) there cannot exist 3x3 (or greater) squares with walls only
	private boolean hasSquare(Maze maze, char[][] square) {
		char [][] m = maze.getDados();
		for (int i = 0; i < m.length - square.length; i++)
			for (int j = 0; j < m.length - square.length; j++) {
				boolean match = true;
				for (int x = 0; x < square.length; x++)
					for (int y = 0; y < square.length; y++) {
						if (m[i+x][j+y] != square[x][y])
							match = false;
					}
				if (match)
					return true;
			}		
		return false; 
	}

	// c) there must exist a path between any blank cell and the maze exit 
	private boolean checkExitReachable(Maze maze) {
		Point p = maze.getExitPosition();
		char [][] m = deepClone(maze.getDados());
		visit(m, p.getX(), p.getY());

		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m.length; j++)
				if (m[i][j] != 'X' && m[i][j] != 'V')
					return false;

		return true; 
	}

	// auxiliary method used by checkExitReachable
	// marks a cell as visited (V) and proceeds recursively to its neighbors
	private void visit(char[][] m, int i, int j) {
		if (i < 0 || i >= m.length || j < 0 || j >= m.length)
			return;
		if (m[i][j] == 'X' || m[i][j] == 'V')
			return;
		m[i][j] = 'V';
		visit(m, i-1, j);
		visit(m, i+1, j);
		visit(m, i, j-1);
		visit(m, i, j+1);
	}

	// Auxiliary method used by checkExitReachable.
	// Gets a deep clone of a char matrix.
	private char[][] deepClone(char[][] m) {
		char[][] c = m.clone();
		for (int i = 0; i < m.length; i++)
			c[i] = m[i].clone();
		return c;
	}

	// Checks if all the arguments (in the variable arguments list) are not null and distinct
	private <T> boolean notNullAndDistinct(T ... args) {
		for (int i = 0; i < args.length - 1; i++)
			for (int j = i + 1; j < args.length ; j++)
				if (args[i] == null || args[j] == null || args[i].equals(args[j]))
					return false;
		return true;
	}

	@Test
	public void testRandomMazeGenerator() throws Exception {
		int numMazes = 1000;
		int maxSize = 101; // can change to any odd number >= 5

		MazeBuilder builder = new MazeBuilder();
		builder.setMazeType(0);
		char[][] badWalls = {
				{'X', 'X', 'X'},
				{'X', 'X', 'X'},
				{'X', 'X', 'X'}};
		char[][] badSpaces = {
				{' ', ' '},
				{' ', ' '}};
		char[][] badDiag1 = {
				{'X', ' '},
				{' ', 'X'}};
		char[][] badDiag2 = {
				{' ', 'X'},
				{'X', ' '}};
		Random rand = new Random(); 
		for (int i = 0; i < numMazes; i++) {
			int size = maxSize == 5? 5 : 5 + 2 * rand.nextInt((maxSize - 5)/2);


			builder.setSize(size);
			Maze m = builder.getMaze();
			assertTrue("Invalid maze boundaries in maze:\n" + m, checkBoundaries(m));			
			assertTrue("Maze exit not reachable in maze:\n" + m, checkExitReachable(m));			
			assertNotNull("Invalid walls in maze:\n" + m, ! hasSquare(m, badWalls));
			assertNotNull("Invalid spaces in maze:\n" + m, ! hasSquare(m, badSpaces));
			assertNotNull("Invalid diagonals in maze:\n" + m, ! hasSquare(m, badDiag1));
			assertNotNull("Invalid diagonals in maze:\n" + m, ! hasSquare(m, badDiag2));
			assertTrue("Missing or overlapping objects in maze:\n" + m, 
					notNullAndDistinct(m.getExitPosition()));			
		}	
	}

	@Test
	public void test1() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);

		Heroi heroi= jogo.getHeroi();

		jogo.joga("d");
		
		
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		

		assertEquals(2,heroi.getHeroiX());
		assertEquals(1,heroi.getHeroiY());

	}
	@Test
	public void test2() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);

		Heroi heroi= jogo.getHeroi();

		jogo.joga("a");

		assertEquals(1,heroi.getHeroiX());
		assertEquals(1,heroi.getHeroiY());
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());

	}
	@Test
	public void test3() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);

		Heroi heroi= jogo.getHeroi();

		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());

		jogo.joga("d");
		jogo.joga("d");
		jogo.joga("d");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("a");
		jogo.joga("a");
		jogo.joga("a");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");



		

		assertEquals(true,heroi.isArmado());
		assertEquals(true,heroi.isArmado());

	}

	@Test
	public void test4() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);

		Heroi heroi= jogo.getHeroi();
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		
		jogo.joga("s");


		assertEquals(true,heroi.isMorto());
	}
	@Test
	public void test5() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);

		Heroi heroi= jogo.getHeroi();
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		jogo.joga("d");
		jogo.joga("d");
		jogo.joga("d");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("a");
		jogo.joga("a");
		jogo.joga("a");
		jogo.joga("s");
		jogo.joga("s");
		jogo.joga("s");

		assertEquals(true,heroi.isArmado());
		jogo.joga("w");
		jogo.joga("w");
		jogo.joga("w");
		jogo.joga("w");
		jogo.joga("w");

		assertEquals(true,jogo.dragoesMortos());
	}

	@Test
	public void test6() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		Heroi heroi= jogo.getHeroi();

		String caminho[] ={"d","d","d","s","s","s","s","a","a","a","s","s","s","w","w","w","w","w","w","w",
				"d","d","d","d","d","d","d","s","s","s","s","d"};


		for(int i=0;i<caminho.length;i++){
			jogo.joga(caminho[i]);


		}
		assertEquals(true,heroi.isArmado());
		assertEquals(true,jogo.dragoesMortos());
		assertEquals(true,heroi.isFimJogo());


	}
	@Test
	public void test7() {

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		Heroi heroi= jogo.getHeroi();

		String caminho[] ={"d","d","d","d","d","d","d","s","s","s","s","d"};

		for(int i=0;i<caminho.length;i++){
			jogo.joga(caminho[i]);


		}
		assertEquals(false,heroi.isArmado());
		assertEquals(false,jogo.dragoesMortos());
		assertEquals(false,heroi.isFimJogo());


	}

	@SafeVarargs
	public final <T> void testAlt(int minIter, 
			Supplier<T> generator, Function<T, String> errorMessage, Predicate<T> ... predicates) {
		boolean [] tested = new boolean[predicates.length];
		int checked = 0;
		for (int iter = 0; iter < minIter && checked < predicates.length; iter++ ) {
			T x = generator.get();
			boolean found = false;
			for (int i = 0; i < predicates.length; i++)
				if (predicates[i].test(x)) {
					found = true;
					if (!tested[i]) {
						checked++;
						tested[i] = true;
					}
				}
			if (! found)		
				fail(errorMessage.apply(x));
			iter++;
		}
	}
	@Test
	public void testRandomDragon() {

		testAlt(1000,
				() -> {
					int modo=1;
					MazeBuilder gerador= new MazeBuilder();
					gerador.setMazeType(modo);
					Maze maze = gerador.getMaze();
					Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,1,1);
					jogo.moveDragoes();
					return maze;},
					(m) -> "Dragao em posicao invalida: " + m, 
					(m) -> m.getDragaoX()==1 && m.getDragaoY()==3, 
					(m) -> m.getDragaoX()==1 && m.getDragaoY()==2, 
					(m) -> m.getDragaoX()==1 && m.getDragaoY()==4); 



	}
	@Test

	public void verificaFogo(){

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,1,2,2,1);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		Heroi heroi= jogo.getHeroi();
		heroi.setEscudado(true);

		jogo.joga("d");
		
		assertEquals(false, heroi.isMorto());
		assertEquals(true, heroi.isEscudado());

		jogo.joga("a");
		jogo.joga("s");
		jogo.joga("s");

		assertEquals(true, heroi.isMorto());


	}
	@Test
	public void verificaDardo(){

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),1,2,2,2,1);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		Heroi heroi= jogo.getHeroi();
		jogo.setDardosDisponiveis(1);
		assertEquals(false, heroi.isMorto());
		jogo.mataComDardo(0, 0);

		assertEquals(true, jogo.dragoesMortos());
		assertEquals(0, jogo.getDardosDisponiveis());

	} 
	@Test
	public void verificaAdormecido(){

		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),2,2,1,2,1);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());
		assertEquals(false,jogo.dragoesAdormecidos());

		for(int i=0;i<100;i++){
			if(jogo.dragoesAdormecidos())
				break;
			jogo.adormeceDragoes();
		}

		assertEquals(true, jogo.dragoesAdormecidos());
	}
	
	
	@Test
	public void verificaAleatorio(){
		
		int modo=0;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),2,2,2,2,modo);
		
		boolean encontrouDragao=false;
		boolean encontrouHeroi=false;
		boolean encontrouEspada=false;

		for(int i=0;i<maze.getTamanho();i++){
			
			for(int j=0;j<maze.getTamanho();j++){
				
				if(maze.getChar(i, j)=='D')
					encontrouDragao=true;
				else if(maze.getChar(i, j)=='H')
					encontrouHeroi=true;
				else if(maze.getChar(i, j)=='E')
					encontrouEspada=true;
			}
			
		}
		
		assertEquals(true,encontrouDragao);
		assertEquals(true,encontrouEspada);
		assertEquals(true,encontrouHeroi);
		assertFalse(jogo.dragoesEmCimaDardo());
		assertFalse(jogo.dragoesEmCimaEscudo());
		assertFalse(jogo.dragoesEmCimaEspada());

	}
	

	@Test
	public void verificaPosicoesDragao(){
		
		int modo=1;
		MazeBuilder gerador= new MazeBuilder();
		gerador.setMazeType(modo);
		Maze maze = gerador.getMaze();
		Jogo jogo= new Jogo(maze.getDados(),maze.getTamanho(),2,2,2,1,modo);
		
		
		Dragao dragao = jogo.retornaDragao();
		
		jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]='P';
		
		dragao.moveDragao(jogo.getLabirinto(), 1, 0);
		
		assertEquals(true,dragao.isEmCimaEscudo());
		assertEquals('C',jogo.getLabirinto()[dragao.getDragaoY()][dragao.getDragaoX()]);
		
		dragao.moveDragao(jogo.getLabirinto(), -1, 0);
		
		assertEquals(false,dragao.isEmCimaEscudo());
		assertEquals('P',jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]);
		
		jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]='E';
		
		dragao.moveDragao(jogo.getLabirinto(), 1, 0);
		
		assertEquals(true,dragao.isEmCimaEspada());
		assertEquals('F',jogo.getLabirinto()[dragao.getDragaoY()][dragao.getDragaoX()]);
		
		dragao.moveDragao(jogo.getLabirinto(), -1, 0); 
		
		assertEquals(false,dragao.isEmCimaEspada());
		assertEquals('E',jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]);
		
		
	jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]='-';
		
		dragao.moveDragao(jogo.getLabirinto(), 1, 0);
		
		assertEquals(true,dragao.isEmCimaDardo());
		assertEquals('W',jogo.getLabirinto()[dragao.getDragaoY()][dragao.getDragaoX()]);
		
		dragao.moveDragao(jogo.getLabirinto(), -1, 0); 
		
		assertEquals(false,dragao.isEmCimaDardo());
		assertEquals('-',jogo.getLabirinto()[dragao.getDragaoY()+1][dragao.getDragaoX()]);
		
		
			
		
		
		
	}
	
	
	
	


}