public class Retangulo{
	
	//ATRIBUTOS
	private double comprimento;
	private double largura;
	
	//METODOS SET E GET
	public void setComprimento(double comprimento){
		if(comprimento < 0){
			System.out.println("Não existem retângulos com lados negativos");
		}else{
			this.comprimento = comprimento;
		}
	}
	public double getComprimento(){
		return comprimento;
	}
	
	public void setLargura(double largura){
		if(largura < 0){
			System.out.println("Não existem retângulos com lados negativos");
		}else{
			this.largura = largura;
		}
	}
	public double getLargura(){
		return largura;
	}
	
	//METODOS DE CALCULO
	
	public void area(){
		double area = this.comprimento * this.largura;
		System.out.println("A área do retangulo é: " + area + "cm");
	}
	
	public void perimetro(){
		double perimetro = this.comprimento + this.largura;
		System.out.println("O perímetro do retângulo é: " + perimetro + "cm");
	}

	public String toString(){
	
		String str = "";
		str += "Comprimento: " + this.comprimento + "\n";
		str += "Largura: " + this.largura + "\n";
		return str;
	}	
}
