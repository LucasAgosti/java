public class VendedorDeConcessionaria extends Funcionario{

	//ATRIBUTOS
	private String cargo;
	private double salario;
	
	//METODOS SET E GET
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
	public String getCargo(){
		return cargo;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}
	public double getSalario(){
		return salario;
	}
	
	//CONSTRUTORES 
	public VendedorDeConcessionaria(String nome, String cpf, String dataNascimento, String cargo, double salario){
		
		super(nome, cpf, dataNascimento, cargo, salario);
	}
	
	public void vender(double valor){
		
		double valorGanho = valor * 0.1;
		System.out.println("O valor de venda foi: R$" + valor);
		System.out.println("O funcionário ganhou: R$" + valorGanho);	
	}
	
	//METODO TOSTRING
	public String toString(){
	
		String str = "";
		str += "*------------------------------------------------------*\n";
		str += "FUNCIONÁRIO: " + this.nome +  "\n";
		str += "CPF: " +  this.cpf +  "\n";
		str += "Data de nascimento: " + this.dataNascimento + "\n";
		str += "Cargo: " + this.cargo + "\n";
		str += "Salario: R$ " + this.salario + "\n";
		str += "*------------------------------------------------------*\n";
	
		return str;
	}
}
