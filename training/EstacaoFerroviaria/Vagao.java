package EstacaoFerroviaria;

public class Vagao{
	
	private String numeroDeSerie;
	private String tipo;
	private double capacidadeCargaTotal;
	private double capacidadeCargaAtual;
	private double compEntreTesteiras;
	private double compDosEngates;
	
	//MÉTODOS SET E GET
	public void setNumSerie(String numeroDeSerie){
		this.numeroDeSerie = numeroDeSerie;
	}
	public String getNumSerie(){
		return numeroDeSerie;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public String getTipo(){
		return tipo;
	}
	
	public void setCapacidadeCargaTotal(double capacidadeCargaTotal){
		this.capacidadeCargaTotal = capacidadeCargaTotal;
		this.capacidadeCargaAtual = capacidadeCargaTotal;
	}
	public double getCapacidadeCargaTotal(){
		return capacidadeCargaTotal;
	}
	
	public double getCapacidadeCargaAtual(){
		return capacidadeCargaAtual;
  }
	
	public void setCompEntreTesteiras(double compEntreTesteiras){
		this.compEntreTesteiras = compEntreTesteiras;
	}
	public double getCompEntreTesteiras(){
		return compEntreTesteiras;
	}
	
	public void setCompDosEngates(double compDosEngates){
		this.compDosEngates = compDosEngates;
	}
	public double getCompDosEngates(){
		return compDosEngates;
	}
	
	//MÉTODOS DO VAGÃO
	
	public void carregar(double carga){
		if((this.capacidadeCargaAtual - carga) < 0){
			System.out.println("Carga não suportada!");
		}else{
			this.capacidadeCargaAtual -= carga;
		}
	}
	
	public void descarregar(){
		this.capacidadeCargaAtual = this.capacidadeCargaTotal;
	}
	
	public void descarregar(double carga){
		this.capacidadeCargaAtual += carga;
		if((this.capacidadeCargaAtual + carga) > this.capacidadeCargaTotal){
			System.out.println("Carga desejado ultrapassa a carga limite!\nO vagão foi descarregado!");
		}
	}
	
	//CONSTRUTORES
	
	public Vagao(String numeroDeSerie, String tipo, double capacidadeCargaTotal, double capacidadeCargaAtual, double compEntreTesteiras, double compDosEngates){
		this.numeroDeSerie = numeroDeSerie;
		this.tipo = tipo;
		this.capacidadeCargaTotal = capacidadeCargaTotal;
		this.capacidadeCargaAtual = capacidadeCargaAtual;
		this.compEntreTesteiras = compEntreTesteiras;
		this.compDosEngates = compDosEngates;
	}
	
	public String toString(){
		String str = "";
		str += "Esse vagão tem capacidade de carregar mais" + this.capacidadeCargaAtual + " de " + this.capacidadeCargaTotal + ".\n";
		str +=  "Ele carrega " + this.tipo + " e seu número de série é: " + this.numeroDeSerie + ".";  		
		return str;
	}
}
