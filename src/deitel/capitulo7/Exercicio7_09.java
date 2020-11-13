package deitel.capitulo7;

import java.security.SecureRandom;
import java.util.Scanner;

/*7.9 Considere um array de inteiros dois por três t. (2 linhas(m) e 3 colunas(n))
a)  Escreva uma instrução que declara e cria t.
b)  Quantas linhas tem t? 2
c)  Quantas colunas tem t? 3
d)  Quantos elementos tem t? 6
e)  Escreva expressões de acesso para todos os elementos na linha 1 de t.
f)  Escreva expressões de acesso para todos os elementos na coluna 2 de t.
g)  Escreva uma única instrução que configura o elemento de t na linha 0 e na coluna 1 como zero.
h)  Escreva instruções individuais para inicializar cada elemento de t para zero.
i)  Escreva uma instrução for aninhada que inicializa cada elemento de t como zero.
j)  Escreva uma instrução for aninhada que insere os valores para os elementos de t a partir do usuário.
k)  Escreva uma série de instruções que determina e exibe o valor menor em t.
l)  Escreva uma única instrução printf que exibe os elementos da primeira linha de t.
m)  Escreva uma instrução que soma os elementos da terceira coluna de t. Não utilize repetição.
n)  Escreva uma série de instruções que exibe o conteúdo de t no formato tabular. Liste os índices de coluna como títulos na parte superior e liste os índices de linha à esquerda de cada linha.*/

public class Exercicio7_09 {
	
	//Campos da classe
	static final int LINHAS = 2;
	static final int COLUNAS = 3;
	static int[][] t = new int[LINHAS][COLUNAS];
	
	

	public static void main(String[] args) {
		
		preenche2DArray(t);
		displayArray(t, "Array original: ");
		acessoLinha1(t);
		acessoColuna2(t);
		
		//g)  Escreva uma única instrução que configura o elemento de t na linha 0 e na coluna 1 como zero.
		t[0][1] = 0;
		displayArray(t, "g) Array modificado em t[0][1] = 0: ");
		
		//h)  Escreva instruções individuais para inicializar cada elemento de t para zero.
		t[0][0] = 0;
		t[0][1] = 0;
		t[0][2] = 0;
		t[1][0] = 0;
		t[1][1] = 0;
		t[1][2] = 0;
		displayArray(t, "h) Array modificado(zerado manualmente): ");
		
		//i) Escreva uma instrução for aninhada que inicializa cada elemento de t como zero.
		Allzero(t);
		
		//j)
		entradaValores(t);
		
		//k) 
		menorValor(t);
		
		//l) Escreva uma única instrução printf que exibe os elementos da primeira linha de t.
		System.out.printf("%n%s%d %d %d","l) Elementos da primeira linha: ", t[0][0], t[0][1], t[0][2]);
		
		//m) Escreva uma instrução que soma os elementos da terceira coluna de t. Não utilize repetição.
		int somaColuna3 = t[0][2] + t[1][2];
		System.out.printf("%n%s%d%n", "m) Soma da coluna 3: ", somaColuna3);
		//ou usando FOR.
		SomaColuna3(t);
		
		
	}//main ------------------------------
	
	//Contagem de linhas e colunas
	public static void contaLC(int[][] array) {
		int nLinhas =  0;
		int nColunas = 0;
		for(int l = 0; l < array.length; l++) {
			nLinhas = array.length;
			for(int c = 0; c < array[l].length; c++) {
				nColunas = array[l].length;
			}
		}
		System.out.printf("%s%d%n%s%d", "Número de linhas: ", nLinhas, "Número de colunas: ", nColunas);
	}
	
	//Preencher elementos do array bidimensional
	public static void preenche2DArray(int[][] array) {
		SecureRandom rn = new SecureRandom();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = rn.nextInt(10);
			}
		}
	}
	
	//Imprime os elementos do Array bidimensional
	public static void displayArray(int[][] array, String description){     
		System.out.printf("%n%s%n", description);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.printf("\n");//nova linha apos iterar os elementos de cada linha
		}
	}
	
	//e) Escreva expressões de acesso para todos os elementos na linha 1 de t.
	public static void acessoLinha1(int[][] array) {
		System.out.printf("%s", "e) ");
		for(int i = 0; i < COLUNAS; i++) {
			System.out.printf("%d ", array[0][i]);
		}
	}
	
	//f) Escreva expressões de acesso para todos os elementos na coluna 2 de t.
	public static void acessoColuna2(int[][] array) {
		System.out.printf("%n%s", "f) ");
		for(int j = 0; j < LINHAS; j++) {
			System.out.printf("%d ", array[j][1]);
		}
	}
	
	//i) Escreva uma instrução for aninhada que inicializa cada elemento de t como zero.
	public static void Allzero(int[][] array) {
		for(int m = 0; m < array.length; m++) {
			for(int n = 0; n < array[m].length; n++) {
				t[m][n] = 0;
			}
		}
		displayArray(array, "i) Array zerado por iteração 'for':");
	}
	
	//j) Escreva uma instrução for aninhada que insere os valores para os elementos de t a partir do usuário.
	public static void entradaValores(int[][] a) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%s", "Inserir os dados do array.");
		for(int m = 0; m < a.length; m++) {
			for(int n = 0; n < a[m].length; n++) {
				a[m][n] = sc.nextInt();
			}
			System.out.printf("\n");//nova linha apos iterar os elementos de cada linha
		}
		displayArray(a, "Array de valores inseridos pelo usuario:");
		sc.close();
	}
	
	//k) Escreva uma série de instruções que determina e exibe o valor menor em t.
	public static void menorValor(int[][] a) {
		int menor = a[0][0];
		for(int m = 0; m < a.length; m++) {
			for(int n = 0; n < a[m].length; n++) {
				if(a[m][n] < menor)
					menor = a[m][n];
			}
		}
		System.out.printf("%s%d", "k) Menor valor da matrix: ", menor);
	}
	
	//m) Escreva uma instrução que soma os elementos da terceira coluna de t. Não utilize repetição.
	public static void SomaColuna3(int[][] a) {
		int soma = 0;
		for(int n = 0; n < a.length; n++) {
			soma += a[n][2];
		}
		System.out.printf("%s%d", "   Soma coluna 3 usando 'for': ", soma);
	}
	
}//class
