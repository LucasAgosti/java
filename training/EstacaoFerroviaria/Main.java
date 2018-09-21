package EstacaoFerroviaria;
import java.util.Scanner;	

public class Main{
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		BancoDeDados bd = new BancoDeDados();
		
		System.out.println("Escolha uma das opções para criar:");
		System.out.println("1- Criar vagão\n2- Criar locomotiva\n3- Criar Trem");
		int op = input.nextInt();
		
		switch(op){
			case 1:
			
				Vagao v = new Vagao();
				bd.adicionaVagao();
				break;
					
			case 2: 		
				
				Locomotiva l = new Locomotiva();
				bd.adicionaLocomotiva();
				break;
				
		}
			
	System.out.println(bd.vagoes[countVagao - 1]);	
		
	}
}
