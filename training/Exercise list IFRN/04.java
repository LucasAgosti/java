import java.util.Scanner;
	//PROGRAMA PARA INVERTER A ORDEM DE DOIS NÚMEROS IMPRESSOS
class Q04{
	public static void main(String[] args){
	
		int A, B, aux;
	
		Scanner numA = new Scanner(System.in);
		Scanner numB = new Scanner(System.in);
		System.out.println("Insira dois números int");
		
		A = numA.nextInt();
		B = numB.nextInt();
		
		aux = A;
		A = B;
		B = aux;
		
		System.out.println("Os novos valores são " + A + " " + B);
	}
}
