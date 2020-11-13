package deitel.capitulo7;

import java.util.Scanner;

/*7.12 (Eliminação de duplicatas) Utilize um array unidimensional para resolver o seguinte problema: escreva um aplicativo que insere cinco 
números, cada um entre 10 e 100, inclusive. Enquanto cada número é lido, exiba-o somente se ele não tiver uma duplicata de um número 
já lido. Cuide de tratar o “pior caso”, em que todos os cinco números são diferentes. Utilize o menor array possível para resolver esse pro-
blema. Exiba o conjunto completo de valores únicos inseridos depois que o usuário inserir cada valor novo.*/

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
				System.out.printf("%s%d%s", "O número ", num2, " já está na sequência. Por favor, escolha outro valor.\n");
				i--;
			}
		}
	}
	
	public static int verificadorNumerico() {
		//Scanner sc = new Scanner(System.in); // Usando como variável da classe.
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