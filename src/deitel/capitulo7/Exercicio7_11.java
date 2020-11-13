package deitel.capitulo7;

/*7.11 Escreva instruções que realizam as seguintes operações de um array unidimensional:
a)  Configure os 10 elementos do array de inteiros counts como zeros.
b)  Adicione um a cada um dos 15 elementos do array de inteiros bonus.
c)  Exiba os cinco valores de array de inteiros bestScores em formato de coluna.*/

public class Exercicio7_11 {
	
	static int[] counts = new int[10];
	static int[] bonus  = new int[15];
	static int[] bestScores = new int[5];

	public static void main(String[] args) {
		
		A(counts);
		System.out.println();//pular linha
		B(bonus);
		System.out.println();//pular linha
		C(bestScores);
		
		

	}//main -------------------------------
	
	//a)  Configure os 10 elementos do array de inteiros counts como zeros.
	@SuppressWarnings("unused")
	public static void A(int[] a) {
		for(int i : a) 
			i = 0;
		Imprimir(a);
	}
	
	public static void Imprimir(int[] a) {
		for(int i : a)
			System.out.printf("%d ", i);
	}
	
	//b) Adicione um a cada um dos 15 elementos do array de inteiros bonus.
	public static void B(int[] b) {
		for(int i = 0; i < b.length; i++) {
			b[i] += 1;
		}
		Imprimir(b);
	}
	
	public static void C(int[] a) {
		for(int i : a)
			System.out.printf("%d%n", i);
	}
	
}//class
