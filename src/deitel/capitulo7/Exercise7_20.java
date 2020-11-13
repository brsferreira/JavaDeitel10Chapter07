package deitel.capitulo7;

import java.util.Random;


/*7.20 (Vendas totais) Utilize um array bidimensional para resolver o seguinte problema: uma empresa tem quatro equipes 
* de vendas (1 a 4) que vendem cinco produtos diferentes (1 a 5). Uma vez por dia, cada vendedor passa uma nota de 
* cada tipo de produto diferente vendido. 
Cada nota contém o seguinte:
a)  O número do vendedor
b)  O número do produto
c)  O valor total em reais desse produto vendido nesse dia
Portanto, cada vendedor passa entre 0 e 5 notas de vendas por dia. Suponha que as informações a partir de todas as 
notas durante o último mês estejam disponíveis. Escreva um aplicativo que leia todas essas informações sobre as vendas
do último mês e resuma as vendas totais por vendedor e por produto. Todos os totais devem ser armazenados no array 
bidimensional sales. Depois de processar todas as informações do último mês, exiba os resultados em formato tabular, 
com cada coluna representando um vendedor particular e cada linha representando um produto particular. Some cada linha
para obter o total das vendas de cada produto no último mês. Some cada coluna para obter o total de vendas por vendedor
no último mês. Sua saída tabular deve incluir esses totais cruzados à direita das linhas totalizadas e na 
parte inferior das colunas totalizadas.*/


/**
 * Deitel, Paul
 *Java: como programar / Paul Deitel, Harvey Deitel; tradução Edson  
 *Furmankiewicz; revisão técnica Fabio Lucchini. -- São Paulo: Pearson  
 *Education do Brasil, 2017.
 *Título original: Java: how to program 10. ed. norte-americana.
 *Bibliografia 
 *ISBN  978-85-4301-905-5
 *1. Java (Linguagem de programação para computador) I. Deitel,
 *Harvey. II . Título.
 *16-01233 CDD-005.133
 *
 * @author BSF
 */
public class Exercise7_20 {

	private static final int QTD_PRODUTO = 5;
	private static final int QTD_VENDEDOR = 4;
	private static double[][] sales = new double[QTD_PRODUTO][QTD_VENDEDOR];;  //[m][n]

	public static void main(String[] args) {

		estruturaMatricial();
		simulator();
		venda();
	}//main



	private static void simulator() {
		for (int dia = 0; dia < 25; dia++) {//Vendas no mes.
			//Vendas no dia. No minimo, existe a possibilidade de uma venda para cada vendedor.
			for(int venda = 0; venda < 4; venda++) { 
				Random random = new Random();
				int idVendedor = random.nextInt(4);
				int idProduto = random.nextInt(5);
				double preco = randomPrice();
				sales[idProduto][idVendedor] += preco;
			}
		}
	}

	//Gera o preço aleatório para o produto correspondente ao indice "idProduto".
	private static double randomPrice() {
		double start = 10.0;
		double end = 100.0;
		double random = new Random().nextDouble();
		double x = start + (random * (end - start));
		double xrounded = Math.round(x * 100.0) / 100.0;
		return xrounded;
	}


	private static void venda() {

		//Atribuicao do total de produtos por vendedor. p:produtos(linhas/row); v:vendedores(colunas/column)
		double totalProdutos = 0.0;
		double[] totalVendedor = new double[QTD_VENDEDOR];
		for (int p = 0; p < sales.length; p++) {
			totalProdutos = 0.0;
			for (int v = 0; v < sales[p].length; v++) {
				//Fixa o produto e itera o vendedor; tP = [0][0] + [0][1] + [0][2] + [0][3]
				totalProdutos += sales[p][v]; 
				//Fixa o vendedor e itera os produtos. [0] = [0][0]; [1] = [0][1];...;[3] = [4][3].
				totalVendedor[v] += sales[p][v];
			}
		}

		//Imprime o cabeçalho das colunas
		System.out.printf("%n%s%9s%9s%9s%9s%15s","Vendedor: ","1","2","3","4", "Total/prod.");

		//Imprimir listagem de vendedores e produtos/preços. p:produtos(linhas/row); v:vendedores(colunas/column)
		for (int p = 0; p < sales.length; p++) {
			totalProdutos = 0.0;
			System.out.print("\nproduto" + (p+1) + ":   ");
			for (int v = 0; v < sales[p].length; v++) {
				System.out.printf("%9.2f", sales[p][v]);
				totalProdutos += sales[p][v];
			}
			System.out.printf("%9.2f", totalProdutos);
		}

		//Calcula e imprime total de cada vendedor e o valor total vendido no mes.
		double totalVendido = 0.0;
		System.out.print("\nTotal/vend.:");//pular linha
		for (int i = 0; i < (totalVendedor.length); i++) {// itera de 0 a 4 vendedores (length - 1)
			totalVendido += totalVendedor[i];
			System.out.printf("%9.2f", totalVendedor[i]);
		}
		System.out.printf("%n%n%s%.2f","TOTAL VENDIDO NO MES: R$", totalVendido);
	}

	private static void estruturaMatricial() {// Uso opcional para exibir a estrutura da matriz sales[][].
		System.out.println("\nEstrutura matricial: 5 linhas(m) e 4 colunas(n). matriz[5][4].");
		for (int i = 0; i < sales.length; i++) {
			System.out.println();
			for (int j = 0; j < sales[i].length; j++) {
				System.out.printf("[" + i + "][" + j + "] ");
			}
		}
		System.out.printf("%n%n%s", "matriz[5][4] = { ");
		for (int i = 0; i < sales.length; i++) {
			System.out.print("{");
			for (int j = 0; j < sales[i].length; j++) {
				System.out.print(j);
			}
			System.out.printf("} ");
		}
		System.out.printf("%s%s","}", "\n--------------------------------------------------------\n");
	}
	//BSF
}//class

