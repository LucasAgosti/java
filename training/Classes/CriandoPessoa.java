import static java.lang.System.out;
import java.util.Scanner;

class CriandoPessoa{
	public static void main(String[] args){

		Pessoa pessoa1 = new Pessoa();
		Scanner n1 = new Scanner(System.in);
				
		out.println("Crie sua pessoa citando seu/sua : nome - endereço - data de nascimento - nome do pai e nome da mãe");
		
		String nome1 = n1.nextLine();
		String endereco1 = n1.nextLine();
		String dataNascimento1 = n1.nextLine();
		String pai1 = n1.nextLine();
		String mae1 = n1.nextLine();
		
		pessoa1.setNome(nome1);
		pessoa1.setEndereco(endereco1);	
		pessoa1.setDataNascimento(dataNascimento1);
		pessoa1.setNomePai(pai1);
		pessoa1.setNomeMae(mae1);
		
		out.println(pessoa1);
		
	}
}
