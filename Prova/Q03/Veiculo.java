public class Veiculo {
	
	//ATRIBUTOS
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	
	//METODOS SET E GET
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	//CONSTRUTORES
	public Veiculo(String placa, String modelo, String marca, int ano) {

		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
	}
	
	public Veiculo(String modelo, String marca, int ano) {

		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
	}

	public void acelerar() {
		System.out.println("O veículo está acelerando!");
		
	}
	public void frear() {
		System.out.println("O veículo está freando!");
		
	}
	
	
	public String toString() {
		
		String str = "";
		
		return str;	
	}
}
