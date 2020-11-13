package deitel.capitulo7;

import java.util.Random;

/*7.17 (Jogo de dados) Escreva um aplicativo para simular o lançamento de dois dados. O aplicativo deve utilizar um objeto de classe Random, 
uma vez para lançar o primeiro dado e novamente para lançar o segundo dado. A soma dos dois valores deve então ser calculada. Cada 
dado pode mostrar um valor inteiro de 1 a 6, portanto a soma dos valores irá variar de 2 a 12, com 7 sendo a soma mais frequente e 2 e 12, 
as somas menos frequentes. A Figura 7.28 mostra as 36 possíveis combinações de dois dados. Seu aplicativo deve lançar o dado 36.000.000 
vezes. Utilize um array unidimensional para contar o número de vezes que cada possível soma aparece. Exiba os resultados em formato 
tabular.*/

public class Exercicio7_17 {

	static int nDados;
	static int nFaces;
	static int nLancamentos;
	static int maiorValor;
	static int[][] lancamento;
	static int[] somaDeLancamentos;
	static int[] frequenciaSoma;
	//static int[][] valores;
	//static int[] frequencia;

	public static void main(String[] args) {

		//inicialização das variaveis
		nDados = 2;
		nFaces = 6;
		nLancamentos = 10000;
		lancamento = LancadorDeDados();	
		somaDeLancamentos = SomaValores(lancamento);
		maiorValor = MaiorValorDaSoma(somaDeLancamentos);
		frequenciaSoma = CalcularFrequenciaSoma(somaDeLancamentos);
		ImprimirFrequencias(frequenciaSoma);
		
		
		
		//ImprimirLancamento(lancamento); // CUIDADO !
		
		
		
		
	}//main ---------------------------------

	// Realiza e retorna o lancamento dos dados
	public static int[][] LancadorDeDados() {
		Random rd = new Random();
		int[][] valores  = new int[nDados][nLancamentos + 1]; //Deslocamento para considerar apenas valores[1] a valores[10]. valores[0] não é considerado como lançamento.
		for(int linha = 0; linha < valores.length; linha++) {
			for(int lancamento = 1; lancamento < valores[linha].length; lancamento++){
				int numero = 1 + rd.nextInt(nFaces);
				valores[linha][lancamento] = numero;
			}
		}
		return valores;
	}

	//Calcula a soma dos valores obtidos em cada lancamento ([linha][coluna]). A coluna [0] não é considerada. Portanto coluna > 0.
	// [0][1] + [1][1], [0][2] + [1][2], ...
	public static int[] SomaValores(int[][] lancamentos) {
		int[] arraySoma = new int[nLancamentos + 1]; // O valor correspondente ao indice [0] não é considerado no lancamento. Portanto, não será usado na soma. 
		for(int linha = 1; linha <= nLancamentos; linha++) {
			int soma = 0; // reseta o valor da soma para nova atribuicao.
			for(int coluna  = 0; coluna < lancamentos.length; coluna++) {
				soma += lancamentos[coluna][linha];
				arraySoma[linha] = soma;
			}
		}
		return arraySoma;
	}
	
	//Calcular o maior valor da soma obtida
	public static int MaiorValorDaSoma(int[] soma) {
		int maior = soma[1];
		for(int valor : soma) {
			if(valor > maior)
				maior = valor;
		}
		return maior;
	}


	// DETERMINACAO DAS FREQUENCIAS -----------------------------------------------------------------------------
	
	// Determina a frequencia de lancamento
	public static int[] CalculaFrequencia(int[] array) {
		int[] frequencia = new int[nFaces + 1];
		for(int i = 1; i < array.length; i++) {
			++frequencia[array[i]];
		}
		return frequencia;
	}
	
	// Calcular a frequencia da soma dos valores obtidos
	public static int[] CalcularFrequenciaSoma(int[] array) {
		int size = (2*nFaces) + 1;
		int[] frequenciaSoma = new int[size];// Deslocamento. Indice 0 não considerado na operacao.
		for(int i = 1; i < array.length; i++) {
			++frequenciaSoma[array[i]];
		}
		return frequenciaSoma;
	}

	//EXIBICAO DOS RESULTADOS -----------------------------------------------------------------------------------
	
	public static void ImprimirFrequencias(int[] frequencia) {
		for(int i = 1; i < frequencia.length; i++) {
			System.out.printf("%s%02d%s%04d%8.2f%s%n", "Frequencia do valor ", i, ": = ", frequencia[i], ((float)frequencia[i]/nLancamentos)*100, "%");
		}
	}

	// Imprimir o vetor. CUIDADO COM VALORES ALTOS DE LANÇAMENTOS !!!! OVERFLOW !!!
	public static void ImprimirLancamento(int[][] a) {
		for(int linha = 0; linha < a.length; linha++) {
			System.out.printf("%n%s%d%s", "Dado ", linha+1, ": ");
			for(int coluna = 1; coluna < a[linha].length; coluna++) {
				System.out.printf("%d ", a[linha][coluna]);
			}
		}
	}

}//class
















