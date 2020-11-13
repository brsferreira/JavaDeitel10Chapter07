package deitel.capitulo7;

/*7.15 (Argumentos de linha de comando) Reescreva a Figura 7.2 para que o tamanho do array seja especificado pelo primeiro argumento de 
linha de comando. Se nenhum argumento de linha de comando for fornecido, utilize 10 como o tamanho padrão do array.*/

/* 	Obs para executar o aplicativo atraves da linha de comando no CMD: D:\ESTUDO\JAVA\Deitei10e\Deitel10e\bin>java deitel.capitulo7.Exercicio7_15
	TESTE OK
 */

public class Exercicio7_15 {

	public static void main(String[] args) {
		
		//System.out.println("TESTE OK");

		int size;
		
		if(args.length == 0) {
			System.out.printf("%n >> Definindo para 10 o tamanho do array << %n");
			size = 10;
		}
		else {
			size = Integer.parseInt(args[0]);
			System.out.printf("%n%s%d%n", "Tamanho especificado: ", size);
		}
			
		int[] array = new int[size];
		System.out.printf("%n%s%8s%n", "Index", "Value");
		Imprimir(array);	
		
		
	}//main

	public static void Imprimir(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.printf("%3d%8d%n", i, a[i]);
		}
	}
	
	
}//class
