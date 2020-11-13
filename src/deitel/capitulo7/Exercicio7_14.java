package deitel.capitulo7;

/*7.14 (Lista de argumento de comprimento variável) Escreva um aplicativo que calcula o produto de uma série de inteiros que são passados 
para método product utilizando uma lista de argumentos de comprimento variável. Teste seu método com várias chamadas, cada uma 
com um número diferente de argumentos.*/

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
