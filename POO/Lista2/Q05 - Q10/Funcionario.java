public class Funcionario{

	//ATRIBUTOS
	protected String nome;
	protected String cpf;
	protected String dataNascimento;
	protected String cargo;
	protected double salario;
	
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
	public Funcionario(String nome, String cpf, String dataNascimento, String cargo, double salario){
		
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		this.salario = salario;
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
