public class Pessoa{

	private String nome;
	private String endereco;
	private String dataNascimento;
	private String nomePai;
	private String nomeMae;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public String getEndereco(){
		return endereco;
	}
	
	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	public void setNomePai(String nomePai){
		this.nomePai = nomePai;
	}
	public String getNomePai(){
		return nomePai;
	}
			
	public void setNomeMae(String nomeMae){
		this.nomeMae = nomeMae;
	}
	public String getNomeMae(){
		return nomeMae;
	
	}
	//CRIANDO FUNÇÃO PARA CRIAR UM DISPLAY
	public String toString(){
		String str = " ";
		str = str + "Nome: " + this.nome;
		str = str + "Endereço: " + this.endereco;
		str = str + "Data de nascimento: " + this.dataNascimento;
		str = str + "Nome do pai: " + this.nomePai;
		str = str + "Nome da mãe: " + this.nomeMae;
		return str;
	
	
	
	}
}
