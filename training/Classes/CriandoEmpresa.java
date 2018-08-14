import static java.lang.System.out;
import java.util.Scanner;

class CriandoEmpresa{
	public static void main(String[] args){
	
		GrupoEmpresa empresa1 = new GrupoEmpresa();
		
		Scanner p1 = new Scanner(System.in);
		Scanner c1 = new Scanner(System.in);
		Scanner f1 = new Scanner(System.in);
		
		out.println("Insira os dados da empresa na seguinte ordem: presidente da empresa - cnpj - faturamento anual");
		
		String presidente1 = p1.nextLine();
		String cnpj1 = c1.nextLine();
		double faturamento1 = f1.nextDouble();
	
		empresa1.setPresidente(presidente1);
		empresa1.setCnpj(cnpj1);
		empresa1.setFaturamentoAnual(faturamento1);
	
		out.println("Nome do presidente: " + empresa1.getPresidente());
		out.println("CNPJ: " + empresa1.getCnpj);
		out.println("Faturamento anual da empresa: " + empresa1.getFaturamentoAnual + " R$");
	
	}
}
