import java.util.Scanner;
import static java.lang.System.out;

public class UsandoAluno{
	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		//Pessoa person1 = new Pessoa();
		//Aluno alu = new Aluno();
	
		out.println("O que deseja criar ?");
		out.println("1- Pessoa\n2- Aluno\n3- Funcionario\nS- Sair");
	
		char op = input.next().charAt(0);;
		while(op != 'S'){
			switch(op){
				case '1':
					out.println("Crie uma pessoa com: nome, cpf, nascimento, logradouro, numero, bairro, cidade e UF");
	
					String name = input.nextLine();
					String c = input.nextLine();
					String data = input.nextLine();
					String logra = input.nextLine();
					double num = input.nextDouble();
					input.next();
					String bai = input.nextLine();
					String city = input.nextLine();
					String uf = input.nextLine();
	
					Pessoa person = new Pessoa(name, c, data, logra, num, bai, city, uf);
					out.println(person);
					break;
	
				case '2':
			
					out.println("Crie um aluno com os atributos de uma pessoa e numero de matricula e instituição de ensino");
					out.println("Um aluno possui: nome, cpf, nascimento, logradouro, numero, bairro, cidade, UF, numero de matrícula e colégio");
	
					String name2 = input.nextLine();
					String c2 = input.nextLine();
					String data2 = input.nextLine();
					String logra2 = input.nextLine();
					double num2 = input.nextDouble();
					String bai2 = input.nextLine();
					String city2 = input.nextLine();
					String uf2 = input.nextLine();
					String mat2 = input.nextLine();
					String escola2 = input.nextLine();
	
					Aluno alu = new Aluno(name2, c2, data2, logra2, num2, bai2, city2, uf2, mat2, escola2);
					out.println(alu);
					break;
				
				case '3':
					out.println("*------------------------------------------------------*");
					out.println("Crie um funcionário com os atributos de uma pessoa, cargo e salário");
					out.println("Um funcionário possui: nome, cpf, nascimento, logradouro, numero, bairro, cidade, UF, cargo e salário");
					out.println("*------------------------------------------------------*");
				
					String name3 = input.nextLine();
					String c3 = input.nextLine();
					String data3 = input.nextLine();
					String logra3 = input.nextLine();
					double num3 = input.nextDouble();
					String bai3 = input.nextLine();
					String city3 = input.nextLine();
					String uf3 = input.nextLine();
					String cargo = input.nextLine();
					double salario = input.nextDouble();
				
					Funcionario func = new Funcionario(name3, c3, data3, logra3, num3, bai3, city3, uf3, cargo, salario);
					out.println(func);
					break;
			
				default:
					out.println("Opção desconhecida, tente novamente.");
					break;
			}
			out.println("Escolha outra opção ou digite \"S\" para sair\n");
			out.println("O que deseja criar ?");
			out.println("1- Pessoa\n2- Aluno\n3- Funcionario\nS- Sair");
			op = input.next().charAt(0);
		}
	}
}
