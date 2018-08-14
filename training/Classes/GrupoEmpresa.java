public class GrupoEmpresa{
	private String presidente;
	private String cnpj;
	private double faturamentoAnual;
	
	public void setPresidente(String presidente){
		this.presidente = presidente;
	}
	public String getPresidente(){
		return this.presidente;
	}
	
	public void setCnpj(String cnpj){
		this.cnpj = cnpj;
	}
	public String getCnpj(){
		return this.cnpj;
	}
	
	public void setFaturamentoAnual(double faturamentoAnual){
		this.faturamentoAnual = faturamentoAnual;
	}
	public double getFaturamentoAnual(){
		return this.faturamentoAnual;
	}

}
