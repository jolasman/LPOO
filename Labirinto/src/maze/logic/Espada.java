package maze.logic;

import java.io.Serializable;
import java.util.Random;

public class Espada implements Serializable{

	private int espadaY;
	private int espadaX;



	public int getEspadaY() {
		return espadaY;
	}



	public void setEspadaY(int espadaY) {
		this.espadaY = espadaY;
	}



	public int getEspadaX() {
		return espadaX;
	}



	public void setEspadaX(int espadaX) {
		this.espadaX = espadaX;
	}

	public Espada(char[][] labirinto,int tamanho,int modo){

		if(modo==0){
			Random ran= new Random();
			do {

				espadaX=ran.nextInt(tamanho-1);
				espadaY=ran.nextInt(tamanho-1);


				if(labirinto[espadaY][espadaX]==' ')
				{
					labirinto[espadaY][espadaX]='E';
					break;
				}


			}while(true);
			return ;
		}
		espadaX=1;
		espadaY=8;
		labirinto[espadaY][espadaX]='E';
	}


}
