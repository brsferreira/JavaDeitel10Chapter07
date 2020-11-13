package deitel.capitulo7;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*7.18 (Jogo de dados Craps) Escreva um aplicativo que executa 1.000.000 de partidas do jogo de dados craps (Figura 6.8) e responda às seguin-
tes perguntas:
a)  Quantos jogos são ganhos na primeira rolagem, segunda rolagem, …, vigésima rolagem e depois da vigésima rolagem?
b)  Quantos jogos são perdidos na primeira rolagem, segunda rolagem, …, vigésima rolagem e depois da vigésima rolagem?
c)  Quais são as chances de ganhar no jogo de dados? [Observação: você deve descobrir que o craps é um dos jogos mais comuns de cassino. O que você supõe que isso significa?]
d)  Qual é a duração média de um jogo de dados craps?
e)  As chances de ganhar aumentam com a duração do jogo?*/

public class Exercicio7_18 {

	// create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumbers = new SecureRandom();

	// enum type with constants that represent the game status
	private enum Status {CONTINUE, WON, LOST};

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	private static Status[] resultados;
	

	public static void main(String[] args) {
		jogar(100);
		ImprimirResultados();


	}//main --------------------------------


	private static void jogar(int partidas) {
		long start = System.currentTimeMillis();
		resultados = new Status[partidas];
		int i;
		for (i = 0; i < partidas; i++) {
			int myPoint = 0; // point if no win or loss on first roll
			Status gameStatus; // can contain CONTINUE, WON or LOST
			int sumOfDice = rollDice(); // first roll of the dice
			// determine game status and point based on first roll 
			switch (sumOfDice) {
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll           
				gameStatus = Status.WON;
				resultados[i] = gameStatus;
				break;
			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				resultados[i] = gameStatus;
				break;
			default: // did not win or lose, so remember point         
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point
				//System.out.printf("Point is %d%n", myPoint);
				break;
			}
			// while game is not complete
			while (gameStatus == Status.CONTINUE) // not WON or LOST
			{
				sumOfDice = rollDice(); // roll dice again

				// determine game status
				if (sumOfDice == myPoint) { // win by making point
					gameStatus = Status.WON;
					resultados[i] = gameStatus;
				}else if (sumOfDice == SEVEN) { // lose by rolling 7 before point
					gameStatus = Status.LOST;
					resultados[i] = gameStatus;
				}
			}
			// display won or lost message
//			if (gameStatus == Status.WON)
//				System.out.println("Player wins");
//			else
//				System.out.println("Player loses");
			
		}//for
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds\n");
	}
	
	private static void ImprimirResultados() {
		int won = 0;
		int lost = 0;
		for(int i = 0; i < resultados.length; i++) {
			if(resultados[i].equals(Status.WON))
				won++;
				//System.out.printf("%s%s", resultados[i], " ");
			else if(resultados[i].equals(Status.LOST))
				lost++;
				//System.out.println();
		}
		System.out.println("WON  = " + won + "\n" + "LOST = " + lost);
	}

	// roll dice, calculate sum and display results
	private static int rollDice(){
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		//System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum; 
	}

}//class -----------------------------------
