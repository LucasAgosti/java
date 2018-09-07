import java.util.Scanner;
import static java.lang.System.out;

public class UsandoCartao{
	public static void main(String[] args){
		
		Cartao c1 = new Cartao();
		Scanner input = new Scanner(System.in);
		
		out.println("*----------------------------*");
		out.println("Insira o nome do titular: ");
		String nome1 = input.nextLine();
		
		out.println("Insira o numero do cartão : ");
		String num1 = input.nextLine();
		
		out.println("Insira o código de segurança: ");
		int cod1 = input.nextInt();
		
		out.println("Insira o limite total: ");
		double limTotal1 = input.nextDouble();
		out.println("*----------------------------*");
		
		c1.setNomeTitular(nome1);
		c1.setNumero(num1);
		c1.setCodigoSeguranca(cod1);
		c1.setLimiteTotal(limTotal1);
		
		out.println(c1);
		
		out.println("*----------------------------------------------*");
		out.println("Escolha a operação desejada:");
		out.println("1- Ver limite atual do cartão\n2- Ver limite total do cartão\n3- Compra");
		out.println("4- Paga limite do cartão\n5- Aumenta o limite máximo do cartão");
		out.println("\nDigite \"S\" para sair");
		out.println("*----------------------------------------------*");
		
		input.nextLine();
		char op = input.next().charAt(0);
		while(op != 'S'){
			
			switch(op){
				case '1':
					out.println("*---------------------*");
					out.println(c1.getLimiteAtual());
					out.println("*---------------------*");
					break;
				case '2':
					out.println("*---------------------*");
					out.println(c1.getLimiteTotal());
					out.println("*---------------------*");
				case '3':
					out.println("Digite sua senha");
					int senha = input.nextInt();
					if(senha == c1.getCodigoSeguranca()){
						out.println("Digite o valor do produto");
						double valorA = input.nextDouble(); 
						c1.realizaCompra(valorA);
					}else{
						out.println("Senha não reconhecida!\nTente novamente");
					}
					break;
				case '4':
					out.println("\nSeu limite máximo atual é: R$ " + c1.getLimiteTotal());
					out.println("Seu limite atual é: R$ " + c1.getLimiteAtual());
					out.println("Insira o valor de pagamento desejado");
					double valorB = input.nextDouble();
					c1.realizaPagamento(valorB);
					break;
					
				case '5':
					out.println("Seu limite máximo atual é: R$ " + c1.getLimiteTotal());
					out.println("Insira o valor para aumentar o limite máximo");
					double valorC = input.nextDouble();
					c1.aumentaLimite(valorC);
					break;
				
				default:
					out.println("Opção não reconhecida");
					break;
			}
			
			out.println("Escolha outra opção ou digite \"S\" para sair");
			op = input.next().charAt(0);
			
		}
	}
}
