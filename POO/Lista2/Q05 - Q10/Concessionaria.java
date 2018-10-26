public class Concessionaria extends Empresa{
	
	public Concessionaria(String razaoSocial, String nomeFantasia, String logradouro, int numero, String bairro, String cidade, String UF){
		super(razaoSocial, nomeFantasia, logradouro, numero, bairro, cidade, UF);
	}
	
	public String toString(){
	
		String str = "";
		str += "*--------------------------------------------*\n";
		str += "\t\tCONCESSIONARIA\n";
		str += "\tRazao Social: " + this.razaoSocial + "\n";
		str += "\tNome de fantasia: " + this.nomeFantasia + "\n";
		str += "\tLogradouro: " + this.logradouro + "\n";
		str += "\tNumero: " + this.numero + "\n";
		str += "\tBairro: " + this.bairro + "\n";
		str += "\tCidade: " + this.cidade + "\n";
		str += "\tUF: " + this.UF + "\n";
		str += "*--------------------------------------------*\n";
		return str;
	}
}
