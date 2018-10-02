public class Pessoa{
	
	//ATRIBUTOS
	protected String nome;
	protected String cpf;
	protected String dataNascimento;
	
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
		
	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	//CONTRUTORES
	public Pessoa(String nome, String cpf, String dataNascimento){
		
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//METODO TOSTRING
	public String toString(){
	
		String str = "";
		str += "*------------------------------------------------------*\n";
		str += this.nome +  "\n";
		str += "CPF: " +  this.cpf +  "\n";
		str += "Data de nascimento: " + this.dataNascimento + "\n";
		str += "*------------------------------------------------------*\n";
		
		return str;
	}	
}
