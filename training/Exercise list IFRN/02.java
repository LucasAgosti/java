import java.util.Scanner;
	//PROGRAMA PARA IMPRIMIR UM NÚMERO DO TECLADO ATÉ 0
class Q02{
	public static void main(String[] args){
		
		int n, i;
		
		Scanner number = new
		Scanner(System.in);
		
		System.out.println("Insira um número para descrescê-lo até zero");
		
		n = number.nextInt();
		
		for(i = n; i >= 0; i--){
			System.out.println(i);
		}
	}
}
