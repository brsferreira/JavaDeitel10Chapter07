package deitel.capitulo7;

import java.security.SecureRandom;

/*7.8 Escreva instruções Java para realizar cada uma das seguintes tarefas:
a)  Exiba o valor do elemento 6 do array f.
b)  Inicialize cada um dos cinco elementos de array de inteiros unidimensional g como 8.
c)  Some os 100 elementos do array de ponto flutuante c.
d)  Copie o array a de 11 elementos para a primeira parte de array b, que contém 34 elementos.
e)  Determine e exiba os maiores e menores valores contidos no array de ponto flutuante w de 99 elementos.*/

public class Exercicio7_08 {

	 static int[] a = new int[11];
	 static int[] b = new int[34];
	 static int[] f = new int[10];
	 static int[] g = {8,8,8,8,8}; //b)
   static float[] c = new float[100];
  static double[] w = new double[99]; 

	public static void main(String[] args) {
		
		//gera numeros aleatorios.
		SecureRandom randomNumbers = new SecureRandom();
		
		//Preenchimento aleatorio dos arrays de inteiros
		addAleatorios(f, randomNumbers);
		addAleatorios(a, randomNumbers);
		addAleatorios(b, randomNumbers);
		//Preenchimento aleatorio dos array de ponto flutuante
		addAleatorios(c, randomNumbers);
		addAleatorios(w, randomNumbers);
		
		//Imprimir os Arrays
		System.out.printf("%n%s%n", "ARRAYS:");
		displayArray(a, "Array a ");
		displayArray(b, "Array b ");
		displayArray(c, "Array c ");
		displayArray(f, "Array f ");
		displayArray(g, "Array g ");
		displayArray(w, "Array w ");
		
		System.out.printf("%n%n%s%n", "Respostas:");
		//chamada de metodos
		A(f);
		C(c);
		D(a,b);
		valorExtremos(w);
		
		

	}//main

	//METODOS 
	public static void A(int[] f) {
		System.out.printf("%n%s%d%n", "a) f[6] : ",f[6]);
	}

	public static void C(float[] c) {
		float soma = (float) 0;
		for(float x : c) {
			soma += x;
		}
		System.out.printf("%s%.2f", "c) Soma : " ,soma);
	}

	//d) Copie o array a de 11 elementos para a primeira parte de array b, que contém 34 elementos.
	public static void D(int[] a, int[] b) {
		System.arraycopy(a, 0, b, 0, a.length);
		displayArray(b, "d) Copia");
	}
	
	//e) Determine e exiba os maiores e menores valores contidos no array de ponto flutuante w de 99 elementos.
	public static void valorExtremos(double[] array) {
		double menor = array[0];
		double maior = array[0];
		for(double x : array) {// verifica o menor valor no array
			if(x < menor)
				menor = x;
		}
		for(double y : array) {// verifica o maior valor no array
			if(y > maior)
				maior = y;
		}
		System.out.printf("%n%s%.2f%n%s%.2f", "e) Menor: ", menor,"   Maior: ", maior);
	}

	// gera saída de valores em cada array de inteiros
	public static void displayArray(int[] array, String description)
	{     
		System.out.printf("%n%s: ", description);
		for (int value : array)
			System.out.printf("%d ", value);
	}
	// gera saída de valores em cada array de float
	public static void displayArray(float[] array, String description)
	{     
		System.out.printf("%n%s: ", description);
		for (float value : array)
			System.out.printf("%.2f ", value);
	}
	// gera saída de valores em cada array de double
	public static void displayArray(double[] array, String description)
	{     
		System.out.printf("%n%s: ", description);
		for (double value : array)
			System.out.printf("%.2f ", value);
	}
	
	//Preenche o array com inteiros aleatorios
	public static void addAleatorios(int[] array, SecureRandom rn) {
		for(int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
	}
	
	//Preenche o array com float aleatorios
	public static void addAleatorios(float[] array, SecureRandom rn) {
		for(int i = 0; i < array.length; i++) {
			array[i] = rn.nextFloat();
		}
	}
	
	//Preenche o array com double aleatorios
		public static void addAleatorios(double[] array, SecureRandom rn) {
			for(int i = 0; i < array.length; i++) {
				array[i] = rn.nextDouble();
			}
		}



}//class
