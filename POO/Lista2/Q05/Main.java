import java.util.Scanner;
import static java.lang.System.out;

public class Main{
	
	public static Carro carros;
	
	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		
		out.println("*--------------------------------*");
		out.println("\tInsira uma opção\n");
		out.println(" 1- Criar carro\n 2- Abastecer\n 3- Acelerar\n 4-Frear\n S- Sair");
		out.println("*--------------------------------*");
		
		char op = input.next().charAt(0);;
		
		while(op != 'S'){
			switch(op){
			
				case '1':
					
					out.println("Insira os dados da pessoa (nome e cpf) e do carro");
					out.println("Marca - modelo - ano de fabricação - chassi");
	
					String n = input.nextLine();
					String c = input.nextLine();
							 
					String marc = input.nextLine();
					String model = input.nextLine();
		
					int ano = input.nextInt();
					input.nextLine();
					String chassi = input.nextLine();
		
					carros = new Carro(n, c, marc, model, ano, chassi);
					out.println(carros);
					break;
					
				case '2':
					out.println("Insira o valor a ser abastecido");
					double valor = input.nextDouble();
					
					carros.abastecer(valor);
					out.println();
					break;
				case '3':
					out.println("Insira o quanto quer acelerar");
					double valor = input.nextDouble();
					
					carros.acelerar(valor);
					out.println();
					break;
				case '4':
					out.println("Insira o quanto quer frear");
					double valor = input.nextDouble();
					carros.frear(valor);
					out.println();
					
					break;
				default:
					out.println("Opção não reconhecida");
					out.println();
					break;
			
			}
			out.println("*--------------------------------*");
			out.println("\tInsira uma opção\n");
			out.println(" 1- Criar carro\n 2- Abastecer\n 3- Acelerar\n 4-Frear\n S- Sair");
			out.println("*--------------------------------*");
			
			op = input.next().charAt(0);
		}
	}
}
