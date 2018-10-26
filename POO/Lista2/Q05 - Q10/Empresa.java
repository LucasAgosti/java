public class Empresa{

	protected String razaoSocial;
	protected String nomeFantasia;
	protected String logradouro;
	protected int numero;
	protected String bairro;
	protected String cidade;
	protected String UF;
		
	
	//METODOS SET E GET
	public void setRazaoSocial(String razaoSocial){
		this.razaoSocial = razaoSocial;
	}
	public String getRazaoSocial(){
		return razaoSocial;
	}
	
	public void setNomeFantasia(String nomeFantasia){
		this.nomeFantasia = nomeFantasia;
	}
	public String getNomeFantasia(){
		return nomeFantasia;
	}
	
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}
	public String getLogradouro(){
		return logradouro;
	}
	
	public void setNumero(int numero){
		this.numero = numero;
	}
	public int getNumero(){
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
	
	public Empresa(String razaoSocial, String nomeFantasia, String logradouro, int numero, String bairro, String cidade, String UF){
	
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.UF = UF;
	}
}
