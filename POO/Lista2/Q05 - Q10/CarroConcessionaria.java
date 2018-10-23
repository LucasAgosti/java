public class CarroConcessionaria extends Carro{
	
	private double valorVenda;
	
	public CarroConcessionaria(String marca, String modelo, int fabricacao, String chassi, String proprietario,  double valorVenda){
		super(marca, modelo, fabricacao, chassi, proprietario );
		this.valorVenda = valorVenda;
	}
	
	public void setValorVenda(double valorVenda){
		this.valorVenda = valorVenda;
	}
	public double getValorVenda(){
		return valorVenda;
	}
	
	public String toString(){
	
		String str = "";
		str += "*--------------------------------------------*\n";
		str += "\t\tCARRO\n";
		str += "\tMarca: " + this.marca + "\n";
		str += "\tModelo: " + this.modelo + "\n";
		str += "\tAno de fabricação: " + this.fabricacao + "\n";
		str += "\tChassi: " + this.chassi + "\n";
		str += "\tValor de venda: R$ " + this.valorVenda + "\n";
		str += "*--------------------------------------------*\n";
		return str;
	}
}
