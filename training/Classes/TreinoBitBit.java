import java.util.Scanner;
import static java.lang.System.out;

public class TreinoBitBit{
	public static void main(String[] args){
		
		int a, b, c, d, e;
		
		out.println("*---------------------------*\n");
		out.println("Insira um número");
		out.println("\n*---------------------------*\n");
		
		Scanner key = new Scanner(System.in);
		int n1 = key.nextInt();
		
		out.println("O número lido foi " + n1 + ".");
		
		a = n1 >> 1;
		b = n1 << 1;
		
		out.println("Insira outro número para realizar operações \"AND\" \"OR\" e \"XOR\"");
		
		int n2 = key.nextInt();
		
		c = n1 & n2;
		d = n1 | n2;
		e = n1 ^ n2;
		
		out.println("*---------------------------------------------*\n\n");
		out.println("As operações são:");
		out.println("AND: " + c);
		out.println("OR: " + d);
		out.println("XOR: " + e);
		out.println("Deslocamento para a direita: " + a);
		out.println("Deslocamento para a esquerda: " + b);
		out.println("\n\n*---------------------------------------------*\n");
	}
}
