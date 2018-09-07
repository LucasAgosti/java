public class Cartao{
	
	private String nomeTitular;
	private String numero;
	private int codigoSeguranca;
	private double limiteTotal;
	private double limiteAtual;
	
	public void setNomeTitular(String nomeTitular){
		this.nomeTitular = nomeTitular;
	}
	public String getNomeTitular(){
		return nomeTitular;
	}
	
	public void setNumero(String numero){
		this.numero = numero;
	}
	public String getNumero(){
		return numero;
	}	
	
	public void setCodigoSeguranca(int codigoSeguranca){
		this.codigoSeguranca = codigoSeguranca;
	}
	public int getCodigoSeguranca(){
		return codigoSeguranca;
	}
	
	public void setLimiteTotal(double limiteTotal){
		this.limiteTotal = limiteTotal;
		this.limiteAtual = this.limiteTotal;
	}
	public double getLimiteTotal(){
		return limiteTotal;
	}
	
	public double getLimiteAtual(){
		return limiteAtual;
	}
	
	public void realizaCompra(double valor){
		if(valor > this.limiteAtual){
			System.out.println("*------------------*");
			System.out.println("Limite excedido");
			System.out.println("*------------------*");
		}else{
			limiteAtual -= valor;
			System.out.println("*-----------------------------------*");
			System.out.println("\nCompra efetuada com sucesso!");
			System.out.println("Seu limite atual é: R$ " + this.limiteAtual + "\n");
			System.out.println("*-----------------------------------*");
		}
	}
	
	public void realizaPagamento(double valor){
		double troco = (this.limiteAtual + valor) - this.limiteTotal;
		if((this.limiteAtual + valor) > this.limiteTotal){
			this.limiteAtual = this.limiteTotal;
			System.out.println("Seu limite atual excede o limite máximo! \nSeu troco: " + troco);
		}else{
			this.limiteAtual += valor;
			System.out.println("Pagamento realizado com sucesso!\n");
			System.out.println("Seu limite atual é: R$ " + this.limiteAtual + "\n");
		}
	}
	
	public void aumentaLimite(double valor){
		limiteTotal += valor;
		System.out.println("Você adicionou "+ valor + " ao seu limite total");
		System.out.println("Seu novo limite máximo é: R$ " + this.limiteTotal + "\n");
	}
	
	public void realizaPagamento(){
		this.limiteAtual = this.limiteTotal;
	}	
	public String toString(){
		String str = "";
		str = str + "*--------------------------------------*\n";
		str = str + "Nome do titular: " + this.nomeTitular + "\n";
		str=  str + "Numero do cartão: " + this.numero + "\n";
		str = str + "Codigo de segurança: " + this.codigoSeguranca + "\n";
		str = str + "Limite: R$ " + this.limiteTotal + "\n";
		str = str + "*--------------------------------------*\n";
		return str;
	}
}
