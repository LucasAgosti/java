import java.util.Scanner;
	//PROGRAMA PARA SABER QUAL NUMERO É O MAIOR
class Q01{
	public static void main(String[] args){
	
		int n1, n2;
	
		Scanner number1 = new
		Scanner(System.in);
		Scanner number2 = new
		Scanner(System.in);
		
		System.out.println("Digite dois números inteiros para saber qual é o maior");
		n1 = number1.nextInt();
		n2 = number2.nextInt();
	
		if(n1 > n2){
			System.out.printf("O maior número é %d\n", n1);
		}else{
			System.out.printf("O maior número é %d\n", n2);
		}
	}
}
 
