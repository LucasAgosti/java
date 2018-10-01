public class Pessoa{
	
	//ATRIBUTOS
	protected String nome;
	protected String cpf;
	protected String dataNascimento;
	protected String logradouro;
	protected double numero;
	protected String bairro;
	protected String cidade;
	protected String UF;
	
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
	
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}
	public String getLogradouro(){
		return logradouro;
	}
	
	public void setNumero(double numero){
		this.numero = numero;
	}
	public double getNumero(){
		return numero;
	}
		
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
	public String getBairro(){
		return bairro;
	}
		
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public String getCidade(){
		return cidade;
	}
		
	public void setUF(String UF){
		this.UF = UF;
	}
	public String getUF(){
		return UF;
	}
	
	//CONTRUTORES
	public Pessoa(String nome, String cpf, String dataNascimento, String logradouro, double numero, String bairro, String cidade, String UF){
		
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.UF = UF;
	}
	
	public String toString(){
	
		String str = "";
		str += "*------------------------------------------------------*\n";
		str += this.nome +  "\n";
		str += "CPF: " +  this.cpf +  "\n";
		str += "Data de nascimento: " + this.dataNascimento + "\n";
		str += "Logradouro: " + this.logradouro + "\n";
		str += "Número: " + this.numero + "\n";
		str += "Bairro: " + this.bairro + "\n";
		str += "Cidade: " + this.cidade + "\n";
		str += "UF: " + this.UF + "\n";
		str += "*------------------------------------------------------*\n";
		
		return str;
	}	
}
