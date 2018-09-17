package EstacaoFerroviaria;
public class Vagao{
	
	private String numeroDeSerie;
	private String tipo;
	private double capacidadeCargaTotal;
	private double capacidadeCargaAtual;
	private double compEntreTesteiras;
	private double compDosEngates;
  
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
	
	
	public void setCompEntreTesteiras(double compEntreTesteiras){
		this.compEntreTesteiras = compEntreTesteiras;
	}
	public double getCompEntreTesteiras(){
		return compEntreTesteiras;
	}
	
	public void setCompDosEngates(double compDosEngates){
		this.compDosEngates = compDosEngates;
	}
	
	public void carregar(double carga){
		if((this.capacidadeAtual - carga) < 0){
			System.out.println("Carga não suportada!");
		}else{
			this.capacidadeAtual -= carga;
		}

	}
	public void descarregar(){
		this.capacidadeAtual = this.capacidadeTotal;
	}
	
	public void descarregar(double carga){
		this.capacidadeAtual += carga;
		if((this.capacidadeAtual + carga) > this.capacidadeTotal){
			System.out.println("Carga desejado ultrapassa a carga limite!\nO vagão foi descarregado!")
		}
	}
	
	public String toString(){
		String str = "";
		str += "Esse vagão tem capacidade de carregar mais" + this.capacidadeAtual + " de " + this.capacidadeTotal + ".\n";
		str +=  "Ele carrega " + this.tipo + " e seu número de série é: " + this.numeroDeSerie + ".";  		
		return str;
	}
}
