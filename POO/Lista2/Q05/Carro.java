import java.util.Random;

public class Carro extends Pessoa{
	
	//ATRIBUTOS
	private String marca;
	private String modelo;
	private int fabricacao;
	private String chassi;
	private double velocidade;
	private double tanque;
	
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
	//SETAR O CHASSI COMO RANDOM
	/*public void setChassi(String chassi){
		this.chassi = chassi;
	}
	public String getChassi(){
		return chassi;
	}*/
	
	//CONSTRUTORES
	
	public Carro(String marca, String modelo, int fabricacao, String nome, String cpf, String dataNascimento){
		super(nome, cpf, dataNascimento);
		this.marca = marca;
		this.modelo = modelo;
		this.fabricacao = fabricacao;
	}
	
	//METODOS DA CLASSE
	public void acelerar(double valor){
		this.velocidade += valor;
		if(tanque > 0){
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
			}
		}else{
			System.out.println("O tanque está vazio!");
		}
	}
	
	public void abastecer(double valor){
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
		str += "*--------------------------------------------*\n";
		//str += "Chassi: " + this.chassi + "\n";
		
		str += "\t\tDONO\n";
		str += "\t" + this.nome +  "\n";
		str += "\tCPF: " +  this.cpf +  "\n";
		str += "\tData de nascimento: " + this.dataNascimento + "\n";	
		str += "*--------------------------------------------*\n";		
	
		return str;
	}
}
