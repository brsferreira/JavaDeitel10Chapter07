package deitel.capitulo7;

/*7.14 (Lista de argumento de comprimento vari�vel) Escreva um aplicativo que calcula o produto de uma s�rie de inteiros que s�o passados 
para m�todo product utilizando uma lista de argumentos de comprimento vari�vel. Teste seu m�todo com v�rias chamadas, cada uma 
com um n�mero diferente de argumentos.*/

public class Exercicio7_14 {

	public static void main(String[] args) {
		
		Produto(1,2,3,4,5);
		Produto(1,1,1,1,1,1);

	}//main
	
	public static void Produto(int...numeros) {
		int p = 1;
		for(int x : numeros) {
			p *= x;
		}
		
		System.out.printf("%s%d%n", "produto = ", p);
		System.out.printf("%s%d%n", "Quantidade de parametros: ", numeros.length);
	}

}//class
