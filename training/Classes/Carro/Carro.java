public class Carro{
	
	private String placa;
	private String modelo;
	private int ano;
	private double capacidadeCombustivel;
	private double combustivelAtual;
	
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public String getPlaca(){
		return placa;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public void setAno(int Ano){
		this.ano = ano;
	}
	
	public int getAno(){
		return ano;
	}
	
	public void setCapacidadeCombustivel(double capacidadeCombustivel){
		this.capacidadeCombustivel = capacidadeCombustivel;
	}
	
	public double getCapacidadeCombustivel(){
		return capacidadeCombustivel;
	}
	
	public void setCombustivelAtual(double combustivelAtual){
		this.combustivelAtual = combustivelAtual;
	}
	
	public double getCombustivelAtual(){
		return combustivelAtual;
	}
	
	public String toString(){
	
		String str = "";
		str = str + "*------------------------------------------------------------*\n";
		str = str + " Placa do carro: " + this.placa + "\n";
		str = str + " Modelo: " + this.modelo + "\n";
		str = str + " Ano: " + this.ano + "\n";
		str = str + " Capacidade do tanque de combustível: " +  this.capacidadeCombustivel + "L\n");
		str = str + "*------------------------------------------------------------*\n";
		return str;
	
	}
}
