import java.util.Scanner;
import static java.lang.System.out;

public class UsingRet{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		Retangulo rx = new Retangulo();
		
		out.println("Insira o comprimento e a largura do retangulo");
		
		double larg = input.nextDouble();
		
		rx.setComprimento(larg);
		double comp = input.nextDouble();
		rx.setLargura(comp);
		
		out.println(rx);
		out.println("Escolha a operação desejada:");
		out.println("1- Area\n2- Perimetro\nS- Sair");
		out.println();
		
		char op = input.next().charAt(0);;
		while(op != 'S'){ 
			switch(op){
				case '1':
					rx.area();
					break;
				case '2':
					rx.perimetro();
					break;
				default:
					out.println("Opção desconhecida");
					break;
			}
			out.println("Escolha outra opção ou digite \"S\" para sair\n");
			op = input.next().charAt(0);
		}
	}
}
