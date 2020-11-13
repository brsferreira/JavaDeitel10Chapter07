package deitel.capitulo7;



/*7.21    (GrÃ¡ficos de tartaruga) A linguagem Logo tornou famoso o conceito de gráficos de tartaruga. Imagine uma tartaruga mecÃ¢nica que 
caminha no lugar sob o controle de um aplicativo Java. A tartaruga segura uma caneta em uma de duas posiÃ§Ãµes, para cima ou para
baixo. Enquanto a caneta estiver para baixo, a tartaruga desenha formas Ã  medida que se move, e enquanto estiver para cima, a tartaruga 
move-se quase livremente sem escrever nada. Neste problema, vocÃª simularÃ¡ a operaÃ§Ã£o da tartaruga e criarÃ¡ um bloco de rascunho com-
putadorizado.
Utilize um array de 20 por 20 floor que Ã© inicializado como zeros. Leia comandos a partir de um array que contenha esses comandos. 
Monitore a posiÃ§Ã£o atual da tartaruga todas as vezes e se a caneta estÃ¡ atualmente para cima ou para baixo. Suponha que a tartaruga sempre 
inicie na posiÃ§Ã£o (0, 0) do chÃ£o com sua caneta para cima. O conjunto de comandos de tartaruga que seu aplicativo deve processar Ã© mostra-
do na Figura 7.29.

1 		Caneta para cima
2  		Caneta para baixo
3  		Vira para a direita
4  		Vira para a esquerda
5,10  	Avance 10 espaÃ§os (substitua 10 por um nÃºmero diferente de espaÃ§os)
6  		Exiba o array 20 por 20
9  		Fim dos dados (sentinela)

Suponha que a tartaruga esteja em algum lugar prÃ³ximo ao centro do chÃ£o. O â€œprogramaâ€� seguinte desenharia e exibiria um quadra-
do de 12 por 12 deixando a caneta na posiÃ§Ã£o levantada:
2    
5,12  
3    
5,12  
3    
5,12  
3    
5,12  
1    
6    
9

Ã€ medida que a tartaruga se move com a caneta por baixo, configure os elementos apropriados do array floor como 1s. Quando o 
comando 6 (exibir o array) for dado, onde quer que haja um 1 no array, exiba um asterisco ou o caractere que vocÃª escolher. Onde quer que 
haja um 0, exiba um espaÃ§o em branco.
Escreva um aplicativo para implementar as capacidades dos grÃ¡ficos de tartaruga discutidas aqui. Escreva vÃ¡rios programas de grÃ¡fico 
de tartaruga para desenhar formas interessantes. Adicione outros comandos para aumentar as capacidades de sua linguagem de grÃ¡fico de 
tartaruga.
 */


public class Exercicio7_21 {

	private static final int iMIN = 0;
	private static final int iMAX = 19;
	private static final int jMIN = 0;
	private static final int jMAX = 19;
	private static int iIndex;
	private static int jIndex;
	private enum directions {LEFT, RIGHT, UP, DOWN}; 
	private static directions Edirection;
	private static boolean pen;
	private static int[] commands;
	private static int[][] floor = new int[iMAX+1][jMAX+1];



	public static void main(String[] args) {

		//Initial position.
		iIndex = 7; 
		jIndex = 7;
		//Initial direction from initial position
		Edirection = directions.RIGHT;
		//Set 1(one) for the initial position
		floor[iIndex][jIndex] = 1;

		int[] c1 = {2,5,12,3,5,12,3,5,12,3,5,12,1,6,9};
		commands = c1;
		instruction(commands);



	}//main

	private static void instruction(int[] commands) {
		for (int i = 0; i < commands.length; i++) {
			if(commands[i] == 1 || commands[i] == 2)
				pen = pen(commands[i]);
			if ((commands[i] == 3) || (commands[i] == 4))
				Direction(commands[i]);
			if(commands[i] == 5)
				advance(commands[i+1]);
			if(commands[i] == 6)
				print();
			if(commands[i] == 9)
				break;
		}
	}

	private static void Direction(int direction) {
		switch (direction) {
		case 3:
			switch (Edirection) 
			{
			case RIGHT:	
				Edirection = directions.DOWN; 	
				System.out.println("the direction has changed down.");
				break;
			case DOWN:  
				Edirection = directions.LEFT; 	
				System.out.println("the direction has changed to the left.");
				break;
			case LEFT:  
				Edirection = directions.UP;   	
				System.out.println("the direction has changed up.");
				break;
			case UP:	
				Edirection = directions.RIGHT; 	
				System.out.println("the direction has changed to the right.");
				break;
			} break;
		case 4:
			switch (Edirection) 
			{
			case LEFT: 	
				Edirection = directions.DOWN; 	
				System.out.println("the direction has changed down.");
				break;
			case DOWN: 	
				Edirection = directions.RIGHT;	
				System.out.println("the direction has changed to the right.");
				break;
			case RIGHT: 
				Edirection = directions.UP; 
				System.out.println("the direction has changed up.");
				break;
			case UP:	
				Edirection = directions.LEFT;	
				System.out.println("the direction has changed to the left.");
				break;
			} break;
		default:
			System.out.println("undefined direction.");
			break;
		}
	}

	private static void advance(int space) {
		space = Math.abs(space);
		int iFinal;
		int jFinal;
		if ((Edirection.equals(directions.UP))) {
			if(iIndex - space >= iMIN) 
				iFinal = (iIndex - space);
			else iFinal = iMIN;
			for (int i = iIndex; i >= iFinal; i--) {
				if (pen == true)
					floor[i][jIndex] = 1;
				else
					floor[i][jIndex] = 0;
				iIndex = i;
			}return;
		}

		if ((Edirection.equals(directions.DOWN))) {
			if (iIndex + space <= iMAX)
				iFinal = (iIndex + space);
			else iFinal = iMAX;
			for (int i = iIndex; i <= iFinal; i++) {
				if (pen == true)
					floor[i][jIndex] = 1;
				else
					floor[i][jIndex] = 0;
				iIndex = i;
			} return;
		} 

		if ((Edirection.equals(directions.RIGHT))) {
			if (jIndex + space <= jMAX)
				jFinal = (jIndex + space);
			else jFinal = jMAX;
			for (int j = jIndex; j <= jFinal; j++) {
				if (pen == true)
					floor[iIndex][j] = 1;
				else
					floor[iIndex][j] = 0;
				jIndex = j;
			} return;
		}

		if ((Edirection.equals(directions.LEFT))) {
			if (jIndex - space >= jMIN)
				jFinal = (jIndex - space);
			else jFinal = jMIN;
			for (int j = jIndex; j >= jFinal; j--) {
				if (pen == true)
					floor[iIndex][j] = 01;
				else
					floor[iIndex][j] = 00;
				jIndex = j;
			} return;
		}		
	}

	private static boolean pen(int position) {
		if(position == 2) {
			System.out.println("Pen down.");
			return pen = true;
		}
		else {
			System.out.println("Pen up.");
			return pen = false;
		}
	}

	private static void print() {
		System.out.println("Print Configuration.");
		//String s = "*";
		System.out.println("Final position: [" + iIndex + "][" + jIndex + "]");
		for (int i = 0; i < floor.length; i++) {
			System.out.println();
			for (int j = 0; j < floor[i].length; j++) {
				if(floor[i][j] == 1)
					System.out.printf("%02d", floor[i][j]);
				else
					System.out.print("  ");
			}
		}
	}

	// OPCIONAL TO SHOW MATRIX STRUCTURE -------------------------------------------------------------
	@SuppressWarnings("unused")
	private static void matrixStructure() {
		System.out.println("\nMatrix structure: 20 rows(m) e 20 columns(n). matrix[20][20].");
		for (int i = 0; i < floor.length; i++) {
			System.out.println();
			for (int j = 0; j < floor[i].length; j++) {
				System.out.printf("%s%02d%s%02d%s","[", i ,"][", j, "] ");
			}
		}
		System.out.printf("%n%n%s", "floor[20][20] = { ");
		for (int i = 0; i < floor.length; i++) {
			System.out.print("{");
			for (int j = 0; j < floor[i].length; j++) {
				System.out.print(j);
			}
			System.out.printf("} ");
		}
		System.out.printf("%s%s","}", "\n--------------------------------------------------------\n");
	}
}//class
