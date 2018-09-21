package EstacaoFerroviaria;

public class LinhaFerroviaria{
	
	private String numero;
	private double extensao;
	private String descricao;
	private Trem trem;
	private Vagao vagao;
	private Locomotiva locomotiva;
	
	public void setNumero(String numero){
		this.numero = numero;
	}
	public String getNumero(){
		return numero;
	}
	
	public void setExtensao(double extensao){
		this.extensao = extensao;
	}
	
	public void getExtensao(){
		return this.extensao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public void getDescricao(){
		return this.descricao;
	}
}
