public class Funcionario extends Pessoa{

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
	public Funcionario(String nome, String cpf, String dataNascimento, String logradouro, double numero, String bairro, String cidade, String UF, String cargo, double salario){
		
		super(nome, cpf, dataNascimento, logradouro, numero, bairro, cidade, UF);
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
		str += "Logradouro: " + this.logradouro + "\n";
		str += "Número: " + this.numero + "\n";
		str += "Bairro: " + this.bairro + "\n";
		str += "Cidade: " + this.cidade + "\n";
		str += "UF: " + this.UF + "\n";
		str += "Cargo: " + this.cargo + "\n";
		str += "Salario: R$ " + this.salario + "\n";
		str += "*------------------------------------------------------*\n";
	
		return str;
	}

}
