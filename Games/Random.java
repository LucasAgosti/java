import java.util.Scanner;
import java.util.Random;

class JogoAleatorio{
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite um int entre 0 e 10");
	
		int entrada = teclado.nextInt();
		int random = new Random().nextInt(10) + 1;
		
		if(entrada == random){
			System.out.println("\n*-----------------------*");
			System.out.println("         You won!");
			System.out.println("*-----------------------*");
		}else{
			System.out.println("*-----------------------*");
			System.out.println("        You lose!");
			System.out.println("*-----------------------*");
			System.out.println("\nThe random number was " + random + ".");
		}
		
		System.out.println("\nThanks for playing!\n\n");
	}
}
