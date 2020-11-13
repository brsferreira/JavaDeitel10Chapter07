package deitel.capitulo7;

/*7.4 Realize as seguintes tarefas para um array chamado table:
a)  Declare e crie o array como um array de inteiros que tem três linhas e três colunas. Suponha que a constante ARRAY_SIZE foi declarada como 3.
b)  Quantos elementos o array contém?
c)  Utilize uma instrução for para inicializar cada elemento do array com a soma de seus índices. Suponha que as variáveis inteiras x e 
y sejam declaradas como variáveis de controle.*/

public class Exercicio7_04 {
	
	final static int ARRAY_SIZE = 3;
	static int[][] table = new int[ARRAY_SIZE][ARRAY_SIZE];

	public static void main(String[] args) {
		
	//b)
		int numeroElementos = 0;
		for(int row = 0; row < table.length; row++) {
			for(int column = 0; column < table[row].length; column++) {
				numeroElementos++;
			}
		}
		System.out.printf("%s%d%n", "Número de elementos de table: ", numeroElementos);
		
		System.out.println("\nc) Utilize uma instrução for para inicializar cada elemento do array com a soma de seus índices. Suponha que as variáveis inteiras x e \r\n" + 
				"y sejam declaradas como variáveis de controle.");
		
		for(int x = 0; x < table.length; x++) {
			for(int y = 0; y < table[x].length; y++) {
				table[x][y] = x + y;
				System.out.printf("%d ", table[x][y]);
			}
			
			System.out.println();
		}
		
		
		
	}//main
}//class
