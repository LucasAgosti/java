public class Pessoa{
	
	//ATRIBUTOS
	protected String nome;
	protected String cpf;
	
	//METODOS SET E GET
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	
	public void setCPF(String cpf){
		this.cpf = cpf;
	}
	public String getCPF(){
		return cpf;
	}
	
	//CONTRUTORES
	public Pessoa(String nome, String cpf){
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	//METODO TOSTRING
	public String toString(){
	
		String str = "";
		str += "*---------------------------------------------------*\n";
		str += this.nome +  "\n";
		str += "CPF: " +  this.cpf +  "\n";
		str += "*---------------------------------------------------*\n";
		
		return str;
	}	
}
