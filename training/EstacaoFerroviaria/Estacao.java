package EstacaoFerroviaria;
public class Estacao{
	private String sigla;
	private String linha;
	private String descricao;
	
	public void setSigla(String sigla){
		this.sigla = sigla;
	}
	public String getSigla(){
		return sigla;
	}
	
	public void setLinha(String linha){
		this.linha = linha;
	}
	public String getLinha(){
		return linha;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao(){
		return descricao;
	}
	
	public String toString(){
		String str = "";
		str += "Info estação:\n";
		str += "Sigla: " + this.sigla + "\n";
		str += "Linha: " + this.linha + "\n";
		str += "Descrição: " + this.descricao + "\n";
		return str;
	}
}
