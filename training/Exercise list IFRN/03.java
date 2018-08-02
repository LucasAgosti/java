	//PROGRAMA PARA MOSTRAR A SOMA DOS ÍMPARES ENTRE 1 E 30 E A MULTIPLICAÇÃO DOS PARES ENTRE 0 E 30.
class Q03{
	public static void main(String[] args){
			
		int i, count_par = 1, count_impar = 0, count_par0 = 0;
		
		for(i = 1; i <= 30; i++){
			if(i % 2 == 0){
				count_impar += i;
			}else{
				count_par *= i;
			}
		}
		
		System.out.print("A soma dos ímpares entre 1 e 30 é = ");
		System.out.println(count_impar);
		System.out.print("A multiplicação dos pares entre 1 e 30 é = ");
		System.out.println(count_par);
	}
}
