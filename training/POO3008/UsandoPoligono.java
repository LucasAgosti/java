import java.util.Scanner;
import static java.lang.System.out;

public class UsandoPoligono{
	public static void main(String[] args){
		
		Poligono p1 = new Poligono();
		Scanner input = new Scanner(System.in);
		
		out.println("Insira o número de lados para saber o nome do polígono");
		int NumLados = input.nextInt();
		
		p1.setNome(NumLados);
		out.println(p1);
		
	}
}
