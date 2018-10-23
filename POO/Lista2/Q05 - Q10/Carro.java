public class Carro{
	
	//ATRIBUTOS
	protected String marca;
	protected String modelo;
	protected int fabricacao;
	protected String chassi;
	protected String proprietario;
	protected double velocidade;
	protected double tanque;
	
	//METODOS SET E GET
	public void setMarca(String marca){
		this.marca = marca;
	}
	public String getMarca(){
		return marca;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	public String getModelo(){
		return modelo;
	}
	
	public void setAnoFabricacao(int fabricacao){
		this.fabricacao = fabricacao;
	}
	public int getAnoFabricacao(){
		return fabricacao;
	}
	
	public void setChassi(String chassi){
		this.chassi = chassi;
	}
	public String getChassi(){
		return chassi;
	}
	
	public void setProprietario(String proprietario){
		this.proprietario = proprietario;
	}
	public String getProprietario(){
		return proprietario;
	}
	
	//CONSTRUTORES
	
	public Carro(String marca, String modelo, int fabricacao, String chassi, String proprietario){
		this.marca = marca;
		this.modelo = modelo;
		this.fabricacao = fabricacao;
		this.chassi = chassi;
		this.proprietario = proprietario;
	}
	
	//METODOS DA CLASSE
	public void acelerar(double valor){
		this.velocidade += valor;
		if(tanque > 0){
			System.out.println("Você está acelerando");
			System.out.println("Velocidade: " + valor + " km/h");
		}else{
			System.out.println("O tanque está vazio!");
		}
	}
	
	public void frear(double valor){
		this.velocidade -= valor;
		if(tanque > 0){
			if(velocidade < 0){
				System.out.println("Velocidade: " + valor + " km/h");
				System.out.println("O carro está dando a ré");
			}else{
				System.out.println("Velocidade: " + valor + " km/h");
				System.out.println("O carro freou: " + valor + " km/h");
			}
		}else{
			System.out.println("O tanque está vazio!");
		}
	}
	
	public void abastecer(double valor){
		System.out.println("O carro possuía " + this.tanque + "L");
		this.tanque += valor;
		System.out.println("O possui atualmente " + tanque + "L");
	}
	
	public String toString(){
	
		String str = "";
		str += "*--------------------------------------------*\n";
		str += "\t\tCARRO\n";
		str += "\tMarca: " + this.marca + "\n";
		str += "\tModelo: " + this.modelo + "\n";
		str += "\tAno de fabricação: " + this.fabricacao + "\n";
		str += "\tChassi: " + this.chassi + "\n";
		str += "*--------------------------------------------*\n";
		
		str += "\t\tDONO\n";
		str += "\t" + this.proprietario +  "\n";	
		str += "*--------------------------------------------*\n";		
	
		return str;
	}
}
