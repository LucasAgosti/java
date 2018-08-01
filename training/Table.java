import java.util.Scanner;
class Tabuada{
	public static void main(String[] args){
	
		int num, i;
		
		Scanner ler = new
		Scanner(System.in);
		
		System.out.println("Insira o número para fazer a tabuada");
		num = ler.nextInt();
		System.out.print("---- Resultado ---\n");
	
		for(i = 1; i <= 10; i++){
			System.out.printf("| %2d * %d = %2d |\n", i, num, i * num);
		}
	}
}
