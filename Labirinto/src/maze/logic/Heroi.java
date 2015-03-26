package maze.logic;
import java.util.Random;


public class Heroi {

	private int X;
	private int Y;

	private   boolean armado=false;
	private  boolean escudado=false;
	private  char carater='H';
	private  boolean morto=false;

	private  int modo;
	private  boolean fimJogo=false;




	public  int getModo() {
		return modo;
	}
	public  void setModo(int mod) {
		modo = mod;
	}
	public  boolean isFimJogo() {
		return fimJogo;
	}
	public  void setFimJogo(boolean fimJog) {
		fimJogo = fimJog;
	}
	public  boolean isMorto() {
		return morto;
	}
	public  void setMorto(boolean mort) {
		morto = mort;
	}
	public  boolean isEscudado() {

		return escudado;
	}
	public  void setEscudado(boolean escudad) {

		if(armado)
			carater='K';
		else
			carater='O';

		escudado = escudad;
	}
	public  boolean isArmado() {
		return armado;
	}
	public void setArmado(boolean armad) {

		if(escudado)
			carater='K';
		else
			carater='A';

		armado = armad;
	}
	public  char getCarater() {
		return carater;
	}
	public  void setCarater(char carate) {
		carater = carate;
	}
	public int getHeroiX() {
		return X;
	}
	public void setHeroiX(int heroiX) {
		this.X = heroiX;
	}
	public int getHeroiY() {
		return Y;
	}
	public void setHeroiY(int heroiY) {
		this.Y = heroiY;
	}

	public Heroi(char[][] labirinto,int tamanho,int modo) {

		this.modo=modo;
		if(modo==0){

			Random ran= new Random();
			do {
				X=ran.nextInt(tamanho-1);
				Y=ran.nextInt(tamanho-1);

				if(labirinto[Y][X]==' ')
				{
					labirinto[Y][X]='H';

					break;
				}

			}while(true);
			return;
		}
		X=1;
		Y=1;
		labirinto[Y][X]='H';
		

	}

}
