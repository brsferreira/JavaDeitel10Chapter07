package deitel.capitulo7;

import java.util.Scanner;

/*7.12 (Elimina��o de duplicatas) Utilize um array unidimensional para resolver o seguinte problema: escreva um aplicativo que insere cinco 
n�meros, cada um entre 10 e 100, inclusive. Enquanto cada n�mero � lido, exiba-o somente se ele n�o tiver uma duplicata de um n�mero 
j� lido. Cuide de tratar o �pior caso�, em que todos os cinco n�meros s�o diferentes. Utilize o menor array poss�vel para resolver esse pro-
blema. Exiba o conjunto completo de valores �nicos inseridos depois que o usu�rio inserir cada valor novo.*/

public class Exercicio7_12 {
	
	public static int[] numeros = new int[5];
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Entrada(numeros);
		sc.close();
		
		
	}//main --------------------------------
	
	public static void Entrada(int[] a) {
		int num1 = verificadorNumerico();
		a[0] = num1;
		for(int i = 1; i < a.length; i++) {
			int num2 = verificadorNumerico();
			if(num1 != num2) {
				a[i] = num2;
				num1 = num2;
			}else {
				System.out.printf("%s%d%s", "O n�mero ", num2, " j� est� na sequ�ncia. Por favor, escolha outro valor.\n");
				i--;
			}
		}
	}
	
	public static int verificadorNumerico() {
		//Scanner sc = new Scanner(System.in); // Usando como vari�vel da classe.
		System.out.printf("%s", "Informe o valor.\n");
		int n = sc.nextInt();
		while(n < 10 || n > 100) {
			System.out.printf("%s", "O numero digitado deve estar entre 10 e 100, inclusive. Por favor, digite novamente: \n");
			n = sc.nextInt();
		}
		//sc.close();// Problemas para fechar a instancia do Scanner.
		return n;
	}

}//class