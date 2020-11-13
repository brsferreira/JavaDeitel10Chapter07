package deitel.capitulo7;

/*7.3 Realize as seguintes tarefas para um array chamado fractions:
a)  Declare uma constante ARRAY_SIZE que é inicializada como 10.
b)  Declare um array com ARRAY_SIZE elementos do tipo double e os inicialize como 0.
c)  Referencie o elemento 4 do array.
d)  Atribua o valor 1.667 ao elemento 9 do array.
e)  Atribua o valor 3.333 ao elemento 6 do array.
f)  Some todos os elementos do array, utilizando uma instrução for. Declare a variável inteira x como uma variável de controle para o 
loop.*/

public class Exercicio7_03 {

	final static int ARRAY_SIZE = 10;
	static double[] array = new double[ARRAY_SIZE];
	double e4 = array[3];
	
	public static void main(String[] args) {
	
		array[8] = 2.677;
		array[7] = 3.333;
		
		System.out.printf("%s%n", "Array original");
		System.out.printf("%s%8s%n", "Index", "Value"); // títulos de coluna
		for(int x = 0; x < array.length; x++) {
			 System.out.printf("%3d%10.3f%n", x, array[x]);
		}
		
		//Somar os elementos do Array
		double soma = 0;
		for(int x = 0; x < array.length; x++) {
			soma += array[x];
		}
		System.out.printf("%s%.3f%n", "Soma dos elementos do Array: ", soma);
		
	
	}//main
}//class
