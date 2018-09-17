package EstacaoFerroviaria;
public class Locomotiva{
	private String numeroDeSerie;
	private double tracao;
	private double comprimento;
	
	public void setNumeroDeSerie(String numeroDeSerie){
		this.numeroDeSerie = numeroDeSerie;
	}
	public String getNumeroDeSerie(){
		return numeroDeSerie
	}
	
	public void setTracao(double tracao){
		this.tracao = tracao;
	}
	public double getTracao(){
		return tracao;
	}
	
	public void setComprimento(double comprimento){
		this.comprimento = comprimento;
	}
	public double getComprimento(){
		return comprimento;
	}
	
	public String toString(){
		String str = "";
		str += "Essa locomotiva tem número de série: " + this.numeroDeSerie + "\n";
		str += "Capacidade: " + this.tracao + "\n";
		str += "Comprimento: " + this.comprimento +"\n";
		return str;
	}
}
