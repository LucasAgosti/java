import java.util.Scanner;
import static java.lang.System.out;

public class UsandoCarro{
	public static void main(String[] args){
	
		menuCarro();
	
	}
	
	public void menuCarro(){
		
		out.println("Insira uma opção");
		out.println("1- Criar pessoa\n2- Criar carro\n3- Criar carro de concessionaria\n4-Verificar a quantidade de carros\nS- Sair");
		char op = input.next().charAt(0);;
		
		while(op != 'S'){
			switch(op){
			
				case '1':
					criaPessoa();
					break;
				case '2':
					criaCarro();
					break;
				case '3':
					criaCarroC();
					break;
				case '4':
					verQuantidade();
					break;
				default:
					out.println("Opção não reconhecida");
					break;
			
			}
			out.println("Insira uma opção");
			out.println("1- Criar pessoa\n2- Criar carro\n3- Criar carro de concessionaria\n4-Verificar a quantidade de carros\nS- Sair");
			op = input.next().charAt(0);
		}
		
		
	}
	
	public void criaCarro(){
	
		Scanner input = new Scanner(System.in);
		
		out.println("Insira os dados do carro e da pessoa");
		out.println("Marca - modelo - ano de fabricação");
		 
		String marc = input.nextLine();
		String model = input.nextLine();
		int ano = input.nextInt();
		
		input.nextLine();
		String n = input.nextLine();
		String c = input.nextLine();
		String data = input.nextLine();
		
		Carro hilux = new Carro(marc, model, ano, n, c, data);
	
		out.println(hilux);
	}
}
