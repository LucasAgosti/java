import java.util.Scanner;
	//PROGRAMA PARA VERIFICAR SE OS NÚMEROS SÃO IGUAIS
class Q05{
	public static void main(String[] args){
	
		int A, B, aux;
	
		Scanner numA = new Scanner(System.in);
		Scanner numB = new Scanner(System.in);
		System.out.println("Insira dois números int");
		
		A = numA.nextInt();
		B = numB.nextInt();
		
		if(A == B)
			System.out.println("Os valores de A e B são iguais");
		else
			if(A > B)
				System.out.println("Os valores " + A + " e " + B + " são diferentes");
			else
				System.out.println("Os valores " + B + " e " + A + " são diferentes");
	}
}
