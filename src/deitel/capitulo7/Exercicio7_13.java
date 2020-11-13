package deitel.capitulo7;

/*7.13 Rotule os elementos do array bidimensional três por cinco sales para indicar a ordem em que eles são configurados como zero pelo 
seguinte segmento de programa:

for (int row = 0; row < sales.length; row++)     
{    
for (int col = 0; col < sales[row].length; col++)     
   {  
      sales[row][col] = 0;   
   }  

}*/

public class Exercicio7_13 {

	static int[][] sales = new int[3][5];
	
	public static void main(String[] args) {
		
		rotular();
		
	}//main
	

	public static void rotular() {
		for (int row = 0; row < sales.length; row++)     
		{    
			System.out.println();
			for (int col = 0; col < sales[row].length; col++)     
			{  
				sales[row][col] = 0;   
				System.out.printf("%s%d%s%d%s", "sales[", row, "][", col, "]");
			}
		}
	}

}//class
