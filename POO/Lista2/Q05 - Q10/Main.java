import java.util.Scanner;
import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;


public class UsandoCarro{


	public static int count_veiculos = 0;
	public static Funcionario func;

	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		
		out.println("*--------------------------------*");
		out.println("\tInsira uma opção\n");
		out.println(" 1- Criar pessoa\n 2- Criar carro\n 3- Criar carro de concessionaria\n 4-Verificar a quantidade de carros\n 5- Criar concessionaria\n 6- Criar funcionario\n S- Sair");
		out.println("*--------------------------------*");
		
		char op = input.next().charAt(0);;
		
		while(op != 'S'){
			switch(op){
			
				case '1':
					criaPessoa();
					out.println();
					break;
					
				case '2':
					criaCarro();
					out.println();
					break;
					
				case '3':
					criaCarroC();
					out.println();
					break;
					
				case '4':
					out.println("Existem " + count_veiculos + " carros\n");
					break;
					
				case '5':
					criaConcessionaria();
					out.println();
					break;
				
				case '6':
					criaFuncionario();
					out.println();
					break;
					
				case '7':
					func.vender();
					out.println();
					break;
				
				default:
					out.println("Opção não reconhecida");
					out.println();
					break;
			
			}
			out.println("*--------------------------------*");
			out.println("Insira uma opção");
			out.println("1- Criar pessoa\n2- Criar carro\n3- Criar carro de concessionaria\n4-Verificar a quantidade de carros\nS- Sair");
			out.println("*--------------------------------*");
			
			op = input.next().charAt(0);
		}
	}
	
	public static void criaPessoa(){
	
		Scanner input = new Scanner(System.in);
		
		out.println("Insira os dados da pessoa (nome e cpf)");
		String n = input.nextLine();
		String c = input.nextLine();
		
		Pessoa person = new Pessoa(n, c);
		
		out.println(person);
	}
	
	public static void criaCarro(){
	
		Scanner input = new Scanner(System.in);
		
		out.println("Insira os dados do carro");
		out.println("Marca - modelo - ano de fabricação - chassi - proprietario");
				 
		String marc = input.nextLine();
		String model = input.nextLine();
		
		int ano = input.nextInt();
		input.nextLine();
		String chassi = input.nextLine();
		String prop = input.nextLine();
		
		Carro carros = new Carro(marc, model, ano, chassi, prop);
		out.println(carros);
  		count_veiculos++;
	}
	
	public static void criaCarroC(){
	
		Scanner input = new Scanner(System.in);
	
		out.println("Insira os dados do carro de concessionaria");
		out.println("Marca - modelo - ano de fabricação - chassi - proprietario e valor de venda");
		
		String marc = input.nextLine();
		String model = input.nextLine();
		
		int ano = input.nextInt();
		input.nextLine();
		String chassi = input.nextLine();
		String prop = input.nextLine();
		double valor = input.nextDouble();
	
		CarroConcessionaria carroConc = new CarroConcessionaria(marc, model, ano, chassi, prop, valor);
		
		out.println(carroConc);
		count_veiculos++;
	}
	
	public static void criaConcessionaria(){
		
		Scanner input = new Scanner(System.in);
		
		out.println("Insira os dados da concessionaria");
		
		String razao = input.nextLine();
		String name = input.nextLine();
		String logra = input.nextLine();
		int num = input.nextInt();
		input.nextLine();
		String bair = input.nextLine();
		String city = input.nextLine();
		String uf = input.nextLine();
		
		Concessionaria concessionaria = new Concessionaria(razao, name, logra, num, bair, city, uf);
		
		out.println(concessionaria);
	}
	
	public static void criaFuncionario(){
	
		Scanner input = new Scanner(System.in);
		
		out.println("Insira dos dados do funcionario");
		
		String
	
	
	
	}
}
