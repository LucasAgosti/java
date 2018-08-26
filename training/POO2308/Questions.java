import java.util.Scanner;
import static java.lang.System.out;

public class Aula2308{
	public static void main(String[] args){
	
		Scanner key = new Scanner(System.in);
		
		out.println("*----------------------------------*");
		out.println("\tQual questão deseja ?");
		out.println("*----------------------------------*");
		int op = key.nextInt();
		
		switch(op){
			
			case 1:
				out.println("*----------------------------------------------*");
				out.println("  Insira um inteiro para verificar se é primo");
				out.println("*----------------------------------------------*\n");
				int n1 = key.nextInt();
				Primo(n1);
				break;
			
			case 2:
				out.println("*----------------------------------------------*");
				out.println("\tInsira um inteiro para verificá-lo");
				out.println("*----------------------------------------------*\n");
				int n2 = key.nextInt();
				Pares(n2);
				break;
				
			case 3:
				out.println("*---------------------------------------------------------------*");
				out.println("   Insira um inteiro para ver a sequência fibonacci até ele");
				out.println("*---------------------------------------------------------------*\n");
				int n3 = key.nextInt();

				out.println("\n*----------------------------------------*");
				out.println("\t  A sequência é = " + Fib(n3));
				out.println("*----------------------------------------*\n");
				break;
				
			default:
				out.println("Essa questão não existe");
				break;
		}	
	}
	
	static void Primo(int num){
	//METODO PARA VERIFICAR SE O NUMERO É PRIMO
		int i, count = 0;
		
		for(i = 1; i <= num; i++){
   			if (num % i == 0){ 
			     count++;
			}
		}
		
		if(count == 2){
			out.println("\n\n*------------------------------*");
			out.println("\t" + num + " É primo");
			out.println("*------------------------------*\n");
		}else{
			out.println("\n\n*------------------------------*");
			out.println("\t" + num + " Não é primo");
			out.println("*------------------------------*\n");
		}
	}
	
	static void Pares(int num){
		//METODO PARA MOSTRAR OS PARES MULTIPLOS DE 3 ATÉ N
		
		if(num % 2 == 0){
			if(num % 3 == 0){
				out.println("\n*------------------------------*");
				out.println(num + " É par e múltiplo de 3");
				out.println("*------------------------------*\n");
			}else{
				out.println("\n*------------------------------*");
				out.println(num + " É par mas não é múltiplo de 3");
				out.println("*------------------------------*\n");
			}
		}else{
			out.println("\n*------------------------------*");
			out.println(num + " Não é par");
			out.println("*------------------------------*\n");
		}
	}
	
	static int Fib(int num){
	
		if(num == 1 || num == 2){
			return 1;
		}else{
			return Fib(num - 1) + Fib(num - 2);
		}
	}
}
