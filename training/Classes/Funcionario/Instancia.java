//CODIGO EM ANDAMENTO

import java.util.Scanner;
import static java.lang.System.out;

public class Instancia{
	public static void main(String[] args){
	
		String inicio, fim;
		int tempo;
		String resposta;
		Funcionario f1 = new Funcionario();
		Scanner input = new Scanner(System.in);
		
		out.println("Informe o nome, data de admissão e salário do funcionário");
		
		String nome1 = input.nextLine();
		String dataAdmissao1 = input.nextLine();
		double salario1 = input.nextDouble();
		
		f1.setNome(nome1);
		f1.setDataDeAdmissao(dataAdmissao1);
		f1.setSalario(salario1);
		
		out.println(f1);
		/*out.println("Nome do funcionário: " + f1.getNome() + "\nData de admissão: " + f1.getDataDeAdmissao());
		out.println("Salário: R$ " + f1.getSalario());*/
		
		out.println("Funcionário " + f1.getNome() + " selecione a opção desejada");
		
		out.println("\nA- Tirar férias de 30 dias\nB- Tirar férias de acordo com os dias desejados");
		out.println("C- Sair\n");
		
		char op = input.next().charAt(0);
		
		switch(op){
			case 'A' : case 'a':
				out.println("Insira a data de início das férias");
				inicio = input.nextInt();
				out.println("O início de suas férias será em " + inicio + " e o retorno em ");
				break;
				
			case 'B' : case 'b':
				out.println("Insira a data de início das férias e a quantidade de dias desejados");
				inicio = input.nextLine();
				tempo = input.nextInt();
				out.println("O início de suas férias será em " + inicio + " e o retorno em ");
				break;
				
			case 'C' : case 'c':
				out.println("Deseja sair ?");
				resposta = input.nextLine();
				if(resposta == "Sim" || resposta == "sim"){
					out.println("Ok");
					break;
				}
				break;
			default:
				out.println("Opção desconhecida");
				break;
				
		}
	}
}
