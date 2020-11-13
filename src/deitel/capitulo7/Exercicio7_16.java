package deitel.capitulo7;

/*7.16 (Usando a instrução foraprimorada) Escreva um aplicativo que usa uma instrução for aprimorada para somar os valores double
passados pelos argumentos de linha de comando. [Dica: utilize o método staticparseDouble da classe Double para converter uma 
String em um valor double.]*/

/* 	Obs para executar o aplicativo atraves da linha de comando no CMD: D:\ESTUDO\JAVA\Deitei10e\Deitel10e\bin>java deitel.capitulo7.Exercicio7_16
TESTE OK
*/

public class Exercicio7_16 {
	
	public static void main(String[] args) {
		
		double soma = 0;
		for(String s : args) {
			Double d  = Double.parseDouble(s);
			soma += d;
		}
		
		System.out.printf("%n%s%.2f%n", "Soma = ", soma);
	}//main
}//class
