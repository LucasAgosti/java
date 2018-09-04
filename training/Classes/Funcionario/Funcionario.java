//CODIGO EM ANDAMENTO

public class Funcionario{
	private String nome;
	private double salario;
	private String dataDeAdmissao;
	private String dataDeDemissao;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
	
	public double getSalario(){
		return salario;
	}
	
	public void setDataDeAdmissao(String dataDeAdmissao){
		this.dataDeAdmissao = dataDeAdmissao;
	}
	
	public String getDataDeAdmissao(){
		return dataDeAdmissao;
	}
	
	public void setDataDeDemissao(String dataDeDemissao){
		this.dataDeDemissao = dataDeDemissao;
	}
	
	public String getDataDeDemissao(){
		return dataDeDemissao;
	}
	
	public String toString(){
		
		String str = "";
		str = str + "*-----------------------------------------*\n";
		str = str + " Nome do funcionário: " + this.nome + "\n";
		str = str + " Data de admissão: " + this.dataDeAdmissao + "\n";
		str = str + " Salário: R$ " + this.salario + "\n";
		str = str + "*-----------------------------------------*\n";
		return str;
	}
}
